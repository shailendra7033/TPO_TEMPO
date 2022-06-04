package co.tvs.tpo_tempo;

public class Personal {
    String name;
    String regNo;
    String email;
    String course;
    String father;
    String branch;
    String dob;
    String linkedin;
    String skype;
    String address;
    String state;


    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    // constructors


    public Personal(String name, String regNo, String email, String course, String father, String branch, String dob, String linkedin, String skype, String address, String state) {
        this.name = name;
        this.regNo = regNo;
        this.email = email;
        this.course = course;
        this.father = father;
        this.branch = branch;
        this.dob = dob;
        this.linkedin = linkedin;
        this.skype = skype;
        this.address = address;
        this.state = state;
    }

// Empty Constructors
    public Personal() {
    }


    // small constructor for some inputs
    public Personal(String name, String regNo, String dob) {
        this.name = name;
        this.regNo = regNo;
        this.dob = dob;
    }
}
