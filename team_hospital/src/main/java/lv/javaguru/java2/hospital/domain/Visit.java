package lv.javaguru.java2.hospital.domain;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Visit {
    private Doctor doctor;
    private Patient patient;
    private Date visitDate;
    private Long visitID;
    private static final AtomicLong count = new AtomicLong(0);

    public Visit(Doctor doctor, Patient patient, Date visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.visitDate = visitDate;
        this.visitID = count.incrementAndGet();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public Long getVisitID() {
        return visitID;
    }

    @Override
    public String toString() {
        return "PatientVisit{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", visitDate=" + visitDate +
                ", visitID=" + visitID +
                '}';
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(doctor, visit.doctor)
                && Objects.equals(patient, visit.patient)
                && Objects.equals(visitDate, visit.visitDate)
                && Objects.equals(visitID, visit.visitID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient, visitDate, visitID);
    }
}