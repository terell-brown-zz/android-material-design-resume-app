
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Contact {

    @Expose
    private long id;
    @Expose
    private String email;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @Expose
    private String website;
    @Expose
    private String linkedin;
    @Expose
    private String github;
    @SerializedName("resume_id")
    @Expose
    private long resumeId;

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

    public Contact withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * 
     * @return
     *     The phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber
     *     The phone_number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 
     * @param website
     *     The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    public Contact withWebsite(String website) {
        this.website = website;
        return this;
    }

    /**
     * 
     * @return
     *     The linkedin
     */
    public String getLinkedin() {
        return linkedin;
    }

    /**
     * 
     * @param linkedin
     *     The linkedin
     */
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Contact withLinkedin(String linkedin) {
        this.linkedin = linkedin;
        return this;
    }

    /**
     * 
     * @return
     *     The github
     */
    public String getGithub() {
        return github;
    }

    /**
     * 
     * @param github
     *     The github
     */
    public void setGithub(String github) {
        this.github = github;
    }

    public Contact withGithub(String github) {
        this.github = github;
        return this;
    }

    /**
     * 
     * @return
     *     The resumeId
     */
    public long getResumeId() {
        return resumeId;
    }

    /**
     * 
     * @param resumeId
     *     The resume_id
     */
    public void setResumeId(long resumeId) {
        this.resumeId = resumeId;
    }

    public Contact withResumeId(long resumeId) {
        this.resumeId = resumeId;
        return this;
    }


}
