package ca.simba.resumeapp.pojo;

/**
 * Created by tmast_000 on 9/2/2015.
 */
public class Credential {

    private String username;
    private String pass;

    public Credential(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
