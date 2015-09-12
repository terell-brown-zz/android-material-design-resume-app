
package ca.simba.resumeapp.mypojo;

import com.google.gson.annotations.Expose;


import java.util.ArrayList;
import java.util.List;

public class Resume {

    @Expose
    private long id;
    @Expose
    private User user;
    @Expose
    private List<About> about = new ArrayList<About>();
    @Expose
    private List<Contact> contact = new ArrayList<Contact>();
    @Expose
    private List<Education> education = new ArrayList<Education>();
    @Expose
    private List<Skill> skill = new ArrayList<Skill>();
    @Expose
    private List<Work> work = new ArrayList<Work>();
    @Expose
    private String context;

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

    public Resume withId(long id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public Resume withUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * 
     * @return
     *     The about
     */
    public List<About> getAbout() {
        return about;
    }

    /**
     * 
     * @param about
     *     The about
     */
    public void setAbout(List<About> about) {
        this.about = about;
    }

    public Resume withAbout(List<About> about) {
        this.about = about;
        return this;
    }

    /**
     * 
     * @return
     *     The contact
     */
    public List<Contact> getContact() {
        return contact;
    }

    /**
     * 
     * @param contact
     *     The contact
     */
    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public Resume withContact(List<Contact> contact) {
        this.contact = contact;
        return this;
    }

    /**
     * 
     * @return
     *     The education
     */
    public List<Education> getEducation() {
        return education;
    }

    /**
     * 
     * @param education
     *     The education
     */
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public Resume withEducation(List<Education> education) {
        this.education = education;
        return this;
    }

    /**
     * 
     * @return
     *     The skill
     */
    public List<Skill> getSkill() {
        return skill;
    }

    /**
     * 
     * @param skill
     *     The skill
     */
    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public Resume withSkill(List<Skill> skill) {
        this.skill = skill;
        return this;
    }

    /**
     * 
     * @return
     *     The work
     */
    public List<Work> getWork() {
        return work;
    }

    /**
     * 
     * @param work
     *     The work
     */
    public void setWork(List<Work> work) {
        this.work = work;
    }

    public Resume withWork(List<Work> work) {
        this.work = work;
        return this;
    }

    /**
     * 
     * @return
     *     The context
     */
    public String getContext() {
        return context;
    }

    /**
     * 
     * @param context
     *     The context
     */
    public void setContext(String context) {
        this.context = context;
    }

    public Resume withContext(String context) {
        this.context = context;
        return this;
    }

}
