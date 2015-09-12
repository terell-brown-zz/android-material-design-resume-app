
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Education {

    @Expose
    private long id;
    @SerializedName("degree_type")
    @Expose
    private String degreeType;
    @Expose
    private String program;
    @Expose
    private String school;
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
    @Expose
    private long gpa;
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

    public Education withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The degreeType
     */
    public String getDegreeType() {
        return degreeType;
    }

    /**
     * 
     * @param degreeType
     *     The degree_type
     */
    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public Education withDegreeType(String degreeType) {
        this.degreeType = degreeType;
        return this;
    }

    /**
     * 
     * @return
     *     The program
     */
    public String getProgram() {
        return program;
    }

    /**
     * 
     * @param program
     *     The program
     */
    public void setProgram(String program) {
        this.program = program;
    }

    public Education withProgram(String program) {
        this.program = program;
        return this;
    }

    /**
     * 
     * @return
     *     The school
     */
    public String getSchool() {
        return school;
    }

    /**
     * 
     * @param school
     *     The school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    public Education withSchool(String school) {
        this.school = school;
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

    public Education withCity(String city) {
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

    public Education withProvince(String province) {
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

    public Education withStartDate(String startDate) {
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

    public Education withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * 
     * @return
     *     The gpa
     */
    public long getGpa() {
        return gpa;
    }

    /**
     * 
     * @param gpa
     *     The gpa
     */
    public void setGpa(long gpa) {
        this.gpa = gpa;
    }

    public Education withGpa(long gpa) {
        this.gpa = gpa;
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

    public Education withResumeId(long resumeId) {
        this.resumeId = resumeId;
        return this;
    }

}
