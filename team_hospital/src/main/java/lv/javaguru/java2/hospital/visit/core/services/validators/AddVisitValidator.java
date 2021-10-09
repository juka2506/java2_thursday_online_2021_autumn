package lv.javaguru.java2.hospital.visit.core.services.validators;

import lv.javaguru.java2.hospital.database.DoctorDatabaseImpl;
import lv.javaguru.java2.hospital.database.PatientDatabaseImpl;
import lv.javaguru.java2.hospital.domain.Doctor;
import lv.javaguru.java2.hospital.domain.Patient;
import lv.javaguru.java2.hospital.visit.core.requests.AddVisitRequest;
import lv.javaguru.java2.hospital.visit.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddVisitValidator {

    private final PatientDatabaseImpl patientDatabase;
    private final DoctorDatabaseImpl doctorDatabase;

    public AddVisitValidator(PatientDatabaseImpl patientDatabase, DoctorDatabaseImpl doctorDatabase) {
        this.patientDatabase = patientDatabase;
        this.doctorDatabase = doctorDatabase;
    }

    public List<CoreError> validate(AddVisitRequest patientVisitRequest) {
        List<CoreError> errors = new ArrayList<>();
        validatePatientsPersonalCode(patientVisitRequest).ifPresent(errors::add);
        validateDoctorsName(patientVisitRequest).ifPresent(errors::add);
        validateDoctorsSurname(patientVisitRequest).ifPresent(errors::add);
        validateVisitDate(patientVisitRequest).ifPresent(errors::add);
        validatePatientExistence(patientVisitRequest).ifPresent(errors::add);
        validateDoctorExistence(patientVisitRequest).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePatientsPersonalCode(AddVisitRequest request) {
        return (request.getPatientsPersonalCode() == null || request.getPatientsPersonalCode().isEmpty())
                ? Optional.of(new CoreError("Patient personal code", "must not be empty!")) : Optional.empty();
    }

    private Optional<CoreError> validateDoctorsName(AddVisitRequest request) {
        return (request.getDoctorsName() == null || request.getDoctorsName().isEmpty())
                ? Optional.of(new CoreError("Doctor name", "must not be empty!")) : Optional.empty();
    }

    private Optional<CoreError> validateDoctorsSurname(AddVisitRequest request) {
        return (request.getDoctorsSurname() == null || request.getDoctorsSurname().isEmpty())
                ? Optional.of(new CoreError("Doctor surname", "must not be empty!")) : Optional.empty();
    }

    private Optional<CoreError> validateVisitDate(AddVisitRequest request) {
        return (request.getVisitDate() == null || request.getVisitDate().isEmpty())
                ? Optional.of(new CoreError("Visit date", "must not be empty!")) : Optional.empty();
    }

    private Optional<CoreError> validatePatientExistence(AddVisitRequest request) {
        List<Patient> patient = patientDatabase.findPatientsByPersonalCode(request.getPatientsPersonalCode());
        return patient.isEmpty() ?
                Optional.of(new CoreError("Patient", "does not exist!")) : Optional.empty();
    }

    private Optional<CoreError> validateDoctorExistence(AddVisitRequest request) {
        List<Doctor> doctor = doctorDatabase.findByNameAndSurname(request.getDoctorsName(), request.getDoctorsSurname());
        return doctor.isEmpty() ?
                Optional.of(new CoreError("Doctor", "does not exist!")) : Optional.empty();
    }
}