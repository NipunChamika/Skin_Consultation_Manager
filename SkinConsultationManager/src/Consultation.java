import java.io.Serializable;

public class Consultation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Doctor doctor;
    private Patient patient;
    private String date;
    private String timeSlot;
    private double cost;
    private String notes;

    public Consultation(Doctor doctor, Patient patient, String date, String timeSlot, double cost, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.timeSlot = timeSlot;
        this.cost = cost;
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}