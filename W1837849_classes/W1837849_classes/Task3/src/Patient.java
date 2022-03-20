public class Patient extends Booth { //Inheritance
    private String name;
    private int age;
    private String city;
    private long NIC_or_Pspt_no;
    private String vaccination_name;


    public Patient(String name,  int age, String city, long NIC_or_Pspt_no, String vaccination_name) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.NIC_or_Pspt_no = NIC_or_Pspt_no;
        this.vaccination_name = vaccination_name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getNIC_or_Pspt_no() {
        return NIC_or_Pspt_no;
    }

    public void setNIC_or_Pspt_no(int NIC_or_Pspt_no) {
        this.NIC_or_Pspt_no = NIC_or_Pspt_no;
    }

    public String getVaccination_name() {
        return vaccination_name;
    }

    public void setVaccination_name(String vaccination_name) {
        this.vaccination_name = vaccination_name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
