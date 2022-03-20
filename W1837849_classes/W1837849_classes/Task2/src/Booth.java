public class Booth {
    private String patientName;
    private int boothNumber ;
    Booth() {}

    public Booth(String patientName, int boothNumber ){
        this.patientName= patientName;
        this.boothNumber= boothNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

}
