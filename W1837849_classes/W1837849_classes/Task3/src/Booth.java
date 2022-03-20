public class Booth {
    private Patient patientDetails;
    private Integer boothNumber ;

    Booth() {}

    public Booth(Patient patientDetails, int boothNumber ){
        this.patientDetails= patientDetails;
        this.boothNumber= boothNumber;

    }
    public Patient getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(Patient patientDetails) {
        this.patientDetails = patientDetails;
    }

    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

}
