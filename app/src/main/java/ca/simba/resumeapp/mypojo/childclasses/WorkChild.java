package ca.simba.resumeapp.mypojo.childclasses;

/**
 * Created by tmast_000 on 9/12/2015.
 */
public class WorkChild {

    private String experience;

    public WorkChild() {
    }

    public WorkChild(String experience, String skills) {

        this.experience = experience;
        this.skills = skills;
    }

    public void setExperience(String experience) {

        this.experience = experience;
    }

    private String skills;

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public String getSkills() {
        return skills;
    }

    public boolean isEmpty() {
        return (this.experience == null) && (this.skills == null);
    }


}
