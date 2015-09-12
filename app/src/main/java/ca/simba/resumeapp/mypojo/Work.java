
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;

public class Work {

    @Expose
    private long id;
    @Expose
    private List<Experience> experience = new ArrayList<Experience>();
    @SerializedName("work_type")
    @Expose
    private String workType;
    @Expose
    private String organization;
    @Expose
    private String position;
    @Expose
    private String city;
    @Expose
    private String province;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("skills_used")
    @Expose
    private String skillsUsed;
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

    public Work withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The experience
     */
    public List<Experience> getExperience() {
        return experience;
    }

    /**
     * 
     * @param experience
     *     The experience
     */
    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public Work withExperience(List<Experience> experience) {
        this.experience = experience;
        return this;
    }

    /**
     * 
     * @return
     *     The workType
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * 
     * @param workType
     *     The work_type
     */
    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Work withWorkType(String workType) {
        this.workType = workType;
        return this;
    }

    /**
     * 
     * @return
     *     The organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * 
     * @param organization
     *     The organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Work withOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    /**
     * 
     * @return
     *     The position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    public Work withPosition(String position) {
        this.position = position;
        return this;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    public Work withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * @return
     *     The province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 
     * @param province
     *     The province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    public Work withProvince(String province) {
        this.province = province;
        return this;
    }

    /**
     * 
     * @return
     *     The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The start_date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Work withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The end_date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Work withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * 
     * @return
     *     The skillsUsed
     */
    public String getSkillsUsed() {
        return skillsUsed;
    }

    /**
     * 
     * @param skillsUsed
     *     The skills_used
     */
    public void setSkillsUsed(String skillsUsed) {
        this.skillsUsed = skillsUsed;
    }

    public Work withSkillsUsed(String skillsUsed) {
        this.skillsUsed = skillsUsed;
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

    public Work withResumeId(long resumeId) {
        this.resumeId = resumeId;
        return this;
    }


}
