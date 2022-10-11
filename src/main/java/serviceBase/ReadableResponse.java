package serviceBase;

import io.restassured.response.Response;
import org.json.JSONObject;

public class ReadableResponse {
    private int statusCode;
    private String statusLine;
    private Response response;

    private String body;

    public ReadableResponse(Response response) {
        this.response = response;
        this.statusCode = response.getStatusCode();
        this.statusLine = response.getStatusLine();
    }

    public String getBodyPrint() {
        return response.getBody().asString();
    }
}