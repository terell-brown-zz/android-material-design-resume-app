package ca.simba.resumeapp.pojo;

import java.util.List;

/**
 * Created by tmast_000 on 9/1/2015.
 */
public class User {

    private int userId;
    private String username;
    private List<String> resumes;

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getResumes() {
        return resumes;
    }
}
