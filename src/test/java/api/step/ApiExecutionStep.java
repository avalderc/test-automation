package api.step;

import com.builder.ApiConfig;
import com.utils.UtilSession;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;
import java.util.Map;

import static com.builder.ApiBuilder.apiBuilder;

public class ApiExecutionStep {
    @Steps
    private ApiHeaderStep apiHeaderStep;
    @Steps
    private ApiParametersStep apiParametersStep;
    private static Response response;
    private String getValueFromDataTable(DataTable dataTable, String title) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        return (String) ((Map)list.get(0)).get(title);
    }
    private void ejecutarApiBuilder(ApiConfig apiConfig) {
        response = apiConfig.getReqSpec().when().request(apiConfig.getMethod(), apiConfig.getApiUrl());
    }
    private ApiConfig apiConfig(String url, String metodo) {
        return apiBuilder()
                .withApiURL(url)
                .withMethod(metodo)
                .withHeaders(apiHeaderStep.getHeaders())
                .withBody(apiParametersStep.getBodyRequest())
                .build();
    }
    private void cleanAllConfiguration(){
        apiHeaderStep.setHeaders(null);
        apiParametersStep.setBodyRequest(StringUtils.EMPTY);
    }
    @Step("Ejecutar Api y obtener la respuesta")
    public void ejecutarAPI(DataTable dataTable) {
        String url = getValueFromDataTable(dataTable, "url");
        String metodo = getValueFromDataTable(dataTable, "metodo");

        ejecutarApiBuilder( apiConfig(url, metodo) );
        System.out.println(response.prettyPrint());
        cleanAllConfiguration();
        Scenario scenario =  UtilSession.getVariableOnSession("scenario");
        final byte[] jsonText = response.asByteArray();
        scenario.attach(jsonText, "text/json", scenario.getName());
    }

    @Step("Validar el código de respuesta")
    public int obtenerCodigoRespuesta(int codigoRespuesta) {
        return response.statusCode();
    }
    @Step("Obtener valor del nodo de la respuesta")
    public String obtenerNodoRespuesta(String nodo) {
        Object valorNodoJson = response.getBody().jsonPath().getJsonObject(nodo);
        return String.valueOf(valorNodoJson).trim();
    }
}
