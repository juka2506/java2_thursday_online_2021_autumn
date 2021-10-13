package lv.javaguru.java2.hospital.patient.core.services.search_criteria;

import lv.javaguru.java2.hospital.database.PatientDatabase;
import lv.javaguru.java2.hospital.database.PatientDatabaseImpl;
import lv.javaguru.java2.hospital.domain.Patient;
import lv.javaguru.java2.hospital.patient.core.requests.SearchPatientsRequest;

import java.util.List;

public class NameSearchCriteria implements PatientsSearchCriteria {
    private final PatientDatabase patientDatabase;

    public NameSearchCriteria(PatientDatabaseImpl patientDatabase) {
        this.patientDatabase = patientDatabase;
    }

    @Override
    public boolean canProcess(SearchPatientsRequest request) {
        return request.isNameProvided()
                && !request.isSurnameProvided()
                && !request.isPersonalCodeProvided();
    }

    @Override
    public List<Patient> process(SearchPatientsRequest request) {
        return patientDatabase.findPatientsByName(request.getName());
    }
}
