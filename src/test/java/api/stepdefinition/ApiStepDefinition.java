package api.stepdefinition;

import api.step.ApiExecutionStep;
import api.step.ApiHeaderStep;
import api.step.ApiParametersStep;
import com.utils.Util;
import com.utils.UtilSession;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApiStepDefinition {
    @Steps
    private ApiHeaderStep apiHeaderStep;
    @Steps
    private ApiParametersStep apiParametersStep;
    @Steps
    private ApiExecutionStep apiExecutionStep;
    @Before
    public void beforeScenario (Scenario scenario)
    {
        UtilSession.saveVariableOnSession("scenario", scenario);
    }
    @Dado("(?i)^(?>que )?configuro (?>e?l[ao]?s? )?(?>header|cabeceras)s?$")
    public void queConfiguroLasCabeceras(DataTable dataTable) {
        apiHeaderStep.configurarCabeceras(dataTable);
    }
    @Dado("(?i)^(?>que )?configuro el body request$")
    public void configuroBodyRequest(DataTable dataTable) {
        apiParametersStep.configurarBodyRequest(dataTable);
    }
    /** ********************** EJECUCIÓN ********************** */
    @Cuando("(?i)^(?>que )?ejecuto el api$")
    public void ejecutoApi(DataTable dataTable) {
        apiExecutionStep.ejecutarAPI(dataTable);
    }
    /** ********************** VALIDACIONES ********************** */
    @Entonces("(?i)^valido (?>si|que)? ?el c[oó]digo de respuesta (?>es|sea)? ?\"?([^\"]*)\"?$")
    public void validoCodigoRespuesta(int codigoRespuesta) {
        int statusCode = apiExecutionStep.obtenerCodigoRespuesta(codigoRespuesta);
        Assert.assertEquals(codigoRespuesta, statusCode);
    }
    @Entonces("^valido los siguientes resultados en el json de respuesta$")
    public void validarResultadoJsonRespuesta(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps();
        for (Map<String, String> stringStringMap : list) {
            String nodo = stringStringMap.get("nodo");
            String valor = stringStringMap.get("valor");
            if(Util.isNumeric(valor)){
                Assert.assertEquals(Double.parseDouble(valor), Double.parseDouble(apiExecutionStep.obtenerNodoRespuesta(nodo)),0.0001);
            }else {
                Assert.assertTrue(Util.matchCI(valor, apiExecutionStep.obtenerNodoRespuesta(nodo)));
            }
        }
    }
}
