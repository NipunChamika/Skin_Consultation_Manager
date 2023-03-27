public class Patient extends Person {
    private static final long serialVersionUID = 1L;

    private String patientId;

    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, String patientId) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}