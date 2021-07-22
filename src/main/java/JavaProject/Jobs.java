/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

/**
 *
 * @author samar
 */
public class Jobs {
    String title;
    String company;
    String location;
    String type;
    String level;
    String yearsExp;
    String country;
    String skills;


    Jobs(String title,String company,String location,String type,String Level, String yearsExp, String country,String skills){
        this.title = title;
        this.company = company;
        this.location = location;
        this.type = type;
        this.level = level;
        this.yearsExp = yearsExp;
        this.country = country;
        this.skills = skills;
;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setYearsExp(String yearsExp) {
        this.yearsExp = yearsExp;
    }

    public String getYearsExp() {
        return yearsExp;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSkills() {
        return skills;
    }

}

