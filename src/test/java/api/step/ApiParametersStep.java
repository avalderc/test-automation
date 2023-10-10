package api.step;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import org.json.JSONException;
import org.json.JSONObject;
import com.utils.JSONElement;

import java.util.List;
import java.util.Map;
public class ApiParametersStep {
    private static String bodyRequest;
    public String getBodyRequest() {
        return bodyRequest;
    }

    public void setBodyRequest(String bodyRequest) {
        ApiParametersStep.bodyRequest = bodyRequest;
    }

    @Step("Configurar el body request para enviarlo")
    public void configurarBodyRequest(DataTable dataTable) {
        bodyRequest = "";
        List<Map<String, String>> list = dataTable.entries();
        JSONObject json_obj=new JSONObject();
        for (Map<String, String> valMap : list) {
            String key = valMap.get("key");
            String value = valMap.get("value");
            try {
                expand(json_obj, key, value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        System.out.println(json_obj);
    }

    private void expand(Object parent, String key, Object value) {
        JSONElement element = new JSONElement(parent);
        if (!key.contains(".")) { // End
            element.put(key, value);
            return;
        }
        String innerKey = key.substring(0, key.indexOf("."));
        String remaining = key.substring(key.indexOf(".") + 1);

        if (element.has(innerKey)) {
            expand(element.get(innerKey), remaining, value);
            return;
        }
        Object object = element.newInstance();
        Object put = element.put(innerKey, object);
        expand(put, remaining, value);
    }
}
