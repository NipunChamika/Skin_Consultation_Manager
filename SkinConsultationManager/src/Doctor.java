public class Doctor extends Person{
    private static final long serialVersionUID = 1L;

    private String medicalLicenceNumber;
    private String specialization;

    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, String medicalLicenceNumber, String specialization) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialization = specialization;
    }

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
