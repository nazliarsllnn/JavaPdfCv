package com.cv;

import java.util.List;

public class Resume {

    private PersonalInfo personalInfo;
    private Education education;
    private List<WorkExperience> workExperiences;

    public Resume(PersonalInfo personalInfo,
                  Education education,
                  List<WorkExperience> workExperiences) {
        this.personalInfo = personalInfo;
        this.education = education;
        this.workExperiences = workExperiences;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public Education getEducation() {
        return education;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }
}