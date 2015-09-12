
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class User {

    @Expose
    private long id;
    @Expose
    private String username;
    @Expose
    private List<String> resumes = new ArrayList<String>();

    /**
     * 
     * @return
     *     The id
     */
    public long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(long id) {
        this.id = id;
    }

    public User withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * 
     * @return
     *     The resumes
     */
    public List<String> getResumes() {
        return resumes;
    }

    /**
     * 
     * @param resumes
     *     The resumes
     */
    public void setResumes(List<String> resumes) {
        this.resumes = resumes;
    }

    public User withResumes(List<String> resumes) {
        this.resumes = resumes;
        return this;
    }


}
