package api.step;

import io.cucumber.datatable.DataTable;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import net.serenitybdd.annotations.Step;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ApiHeaderStep {
    private static Headers headers;
    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        ApiHeaderStep.headers = headers;
    }
    private Headers configurerHeaders(DataTable dataTable) {
        List<Header> headerList = new LinkedList<>();
        List<Map<String, String>> listCabeceras = dataTable.entries();
        Iterator<Map<String, String>> var4 = listCabeceras.iterator();
        while(var4.hasNext()) {
            Map<String, String> stringStringMap = var4.next();
            String cabecera = stringStringMap.get("header");
            String valor = stringStringMap.get("value");
            Header header = new Header(cabecera, valor);
            headerList.add(header);
        }
        System.out.println("Headers configurados: ");
        System.out.println(headerList);
        return new Headers(headerList);
    }
    @Step("que configuro las cabeceras")
    public void configurarCabeceras(DataTable dataTable) {
        headers = configurerHeaders(dataTable);
    }
}
