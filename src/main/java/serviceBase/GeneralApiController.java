package serviceBase;

import base.Keywords;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
public class GeneralApiController {
    private RequestSpecification spec;

    public GeneralApiController(String baseUrl) {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl).setBasePath("/")
                .setRelaxedHTTPSValidation()
                .build();
    }
    public GeneralApiController(String baseUrl, String basePath) {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath)
                .setRelaxedHTTPSValidation()
                .build();
    }
    protected ReadableResponse getRequest(List<QueryParam> queryParams,String endpoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();

        return new ReadableResponse(response);
    }
    protected ReadableResponse postRequest(JSONObject jsonObject,String endpoint){
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .post(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return new ReadableResponse(response);
    }
    protected ReadableResponse patchRequest(JSONObject jsonObject,String endpoint){
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .patch(endpoint)
                .then()
                .log()
                .all()
                .extract()
                .response();
        return new ReadableResponse(response);
    }
    protected ReadableResponse deleteRequest(List<QueryParam> queryParams,String endpoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
        return new ReadableResponse(response);
    }
}
