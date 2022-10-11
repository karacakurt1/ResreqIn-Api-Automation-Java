package controller.controllerRequestData;

import models.User;
import org.json.JSONObject;
import serviceBase.QueryParam;

import java.util.ArrayList;
import java.util.List;

public class UserControllerData {
    public JSONObject prepareUserData(User userProces){
        return new JSONObject()
                .put("name", userProces.getName())
                .put("job",userProces.getJob());
    }
    public List<QueryParam> prepareSearchData(String id, String email,String first_name,String last_name,String avatar) {
        List<QueryParam> queryParams = new ArrayList<>();
        queryParams.add(new QueryParam("data.id", id));
        queryParams.add(new QueryParam("data.email", email));
        queryParams.add(new QueryParam("data.first_name", first_name));
        queryParams.add(new QueryParam("data.last_name", last_name));
        queryParams.add(new QueryParam("data.avatar", avatar));
        return queryParams;
    }
}
