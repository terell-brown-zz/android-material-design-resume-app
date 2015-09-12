
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class Experience {

    @Expose
    private long id;
    @Expose
    private String description;
    @SerializedName("work_id")
    @Expose
    private long workId;
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

    public Experience withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Experience withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The workId
     */
    public long getWorkId() {
        return workId;
    }

    /**
     * 
     * @param workId
     *     The work_id
     */
    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public Experience withWorkId(long workId) {
        this.workId = workId;
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

    public Experience withResumeId(long resumeId) {
        this.resumeId = resumeId;
        return this;
    }


}
