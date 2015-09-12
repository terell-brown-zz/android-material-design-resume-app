
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class About {

    @Expose
    private long id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @Expose
    private String career;
    @SerializedName("about_me")
    @Expose
    private String aboutMe;
    @Expose
    private Object photo;
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

    public About withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public About withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public About withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * 
     * @return
     *     The career
     */
    public String getCareer() {
        return career;
    }

    /**
     * 
     * @param career
     *     The career
     */
    public void setCareer(String career) {
        this.career = career;
    }

    public About withCareer(String career) {
        this.career = career;
        return this;
    }

    /**
     * 
     * @return
     *     The aboutMe
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * 
     * @param aboutMe
     *     The about_me
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public About withAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    /**
     * 
     * @return
     *     The photo
     */
    public Object getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo
     *     The photo
     */
    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public About withPhoto(Object photo) {
        this.photo = photo;
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

    public About withResumeId(long resumeId) {
        this.resumeId = resumeId;
        return this;
    }


}
