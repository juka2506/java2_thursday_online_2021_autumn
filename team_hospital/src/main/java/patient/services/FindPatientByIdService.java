package patient.services;

import database.PatientDatabaseImpl;

public class FindPatientByIdService {
    private final PatientDatabaseImpl database;

    public FindPatientByIdService(PatientDatabaseImpl database) {
        this.database = database;
    }

    public void execute(int id){
       database.findById(id);
    }
}
