import controller.controllerHelper.UserControllerHelper;
import controller.controllerRequestData.UserControllerData;
import models.User;
import org.json.JSONObject;
import org.testng.annotations.Test;
import serviceBase.QueryParam;
import serviceBase.ReadableResponse;

import java.util.List;

public class RestAssuredTest {
    UserControllerHelper userControllerHelper = new UserControllerHelper();
    UserControllerData userControllerData = new UserControllerData();

    @Test
    void findUser(){
        List<QueryParam> queryParams = userControllerData.prepareSearchData("1","lindsay.ferguson@reqres.in","Lindsay","Ferguson","https://reqres.in/img/faces/8-image.jpg");
        ReadableResponse response = userControllerHelper.findUser(queryParams);
    }
    @Test
    void createUser(){
        User userProces= User.userProces("Mert","Testing");
        JSONObject requestBody = userControllerData.prepareUserData(userProces);
        ReadableResponse response = userControllerHelper.createUser(requestBody);
    }
    @Test
    void UpdateUser(){
        User userProces= User.userProces("Ahmet","Analyst");
        JSONObject requestBody = userControllerData.prepareUserData(userProces);
        ReadableResponse response = userControllerHelper.updateUser(requestBody);
        System.out.println(response.getBodyPrint());
    }
    @Test
    void DeleteUser(){
        List<QueryParam> queryParams = userControllerData.prepareSearchData("1","lindsay.ferguson@reqres.in","Lindsay","Ferguson","https://reqres.in/img/faces/8-image.jpg");
        ReadableResponse response = userControllerHelper.deleteUser(queryParams);
    }
}