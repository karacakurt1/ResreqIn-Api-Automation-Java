package controller.controllerHelper;

import controller.UserController;
import org.json.JSONObject;
import serviceBase.QueryParam;
import serviceBase.ReadableResponse;

import java.util.List;


public class UserControllerHelper {
    public ReadableResponse findUser(List<QueryParam> queryParam){
        UserController userController=new UserController("api/users?page=2");
        return userController.getUser(queryParam,"api/users?page=2");
    }
    public ReadableResponse createUser(JSONObject requestBody){
        UserController userController = new UserController("api/users?page=2");
        return userController.postUser(requestBody,"api/users");
    }
    public ReadableResponse updateUser(JSONObject requestBody){
        UserController userController = new UserController("api/users/2");
        return userController.patchUser(requestBody,"api/users/2");
    }
    public ReadableResponse deleteUser(List<QueryParam> queryParam){
        UserController userController=new UserController("api/users?page=2");
        return userController.deleteUser(queryParam,"api/users?page=2");
    }
}
