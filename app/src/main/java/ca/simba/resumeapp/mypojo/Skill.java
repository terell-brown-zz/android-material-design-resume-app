
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Skill {

    @Expose
    private long id;
    @Expose
    private String name;
    @SerializedName("skill_type")
    @Expose
    private String skillType;
    @Expose
    private long proficiency;
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

    public Skill withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Skill withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The skillType
     */
    public String getSkillType() {
        return skillType;
    }

    /**
     * 
     * @param skillType
     *     The skill_type
     */
    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public Skill withSkillType(String skillType) {
        this.skillType = skillType;
        return this;
    }

    /**
     * 
     * @return
     *     The proficiency
     */
    public long getProficiency() {
        return proficiency;
    }

    /**
     * 
     * @param proficiency
     *     The proficiency
     */
    public void setProficiency(long proficiency) {
        this.proficiency = proficiency;
    }

    public Skill withProficiency(long proficiency) {
        this.proficiency = proficiency;
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

    public Skill withResumeId(long resumeId) {
        this.resumeId = resumeId;
        return this;
    }


}
