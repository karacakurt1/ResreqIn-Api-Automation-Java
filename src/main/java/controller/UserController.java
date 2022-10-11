package controller;

import org.json.JSONObject;
import serviceBase.GeneralApiController;
import serviceBase.QueryParam;
import serviceBase.ReadableResponse;

import java.util.List;

import static base.Keywords.BASE_URL;

public class UserController extends GeneralApiController {

    public UserController() {
        super(BASE_URL);
    }
    public UserController(String basePath) {
        super(BASE_URL,basePath);
    }
    public ReadableResponse getUser(List<QueryParam> queryParam,String endpoint){
        return getRequest(queryParam,endpoint);
    }
    public ReadableResponse postUser(JSONObject requestBody,String endpoint){
        return postRequest(requestBody,endpoint);
    }
    public ReadableResponse patchUser(JSONObject requestBody,String endpoint){
        return patchRequest(requestBody,endpoint);
    }
    public ReadableResponse deleteUser(List<QueryParam> queryParam,String endpoint){
        return deleteRequest(queryParam,endpoint);
    }
}
