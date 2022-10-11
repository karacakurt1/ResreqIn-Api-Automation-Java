package models;

import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String name;
    private String job;
    public static User user(String id, String email,String first_name,String last_name,String avatar) {
        User user=new User();
        user.setId(id);
        user.setEmail(email);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setAvatar(avatar);
        return user;
    }
    public static User userProces(String name, String job) {
        User userProces=new User();
        userProces.setName(name);
        userProces.setJob(job);
        return userProces;
    }
}
