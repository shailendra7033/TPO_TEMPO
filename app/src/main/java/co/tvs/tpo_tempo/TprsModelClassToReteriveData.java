package co.tvs.tpo_tempo;

public class TprsModelClassToReteriveData {

    String name;
    String phone;
    String branch;
    String linkedin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }


    public TprsModelClassToReteriveData(String name, String phone, String branch, String linkedin) {
        this.name = name;
        this.phone = phone;
        this.branch = branch;
        this.linkedin = linkedin;
    }

    public TprsModelClassToReteriveData() {
    }
}
