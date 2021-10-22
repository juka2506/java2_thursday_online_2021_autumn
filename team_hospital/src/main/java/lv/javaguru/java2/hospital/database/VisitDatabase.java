package lv.javaguru.java2.hospital.database;

import lv.javaguru.java2.hospital.domain.Visit;
import lv.javaguru.java2.hospital.visit.core.requests.EditVisitEnum;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitDatabase {

    void recordVisit(Visit visit);

    boolean deleteVisit(Long id);

    List<Visit> showAllVisits();

    boolean editVisit(Long visitId, EditVisitEnum userInput, String changes);

    List<Visit> findByVisitId(Long id);

    List<Visit> findByDoctorId(Long id);

    List<Visit> findByPatientId(Long id);

    List<Visit> findByDate(LocalDateTime date);

    List<Visit> findByDoctorIdAndPatientId(Long doctorId, Long patientId);

    List<Visit> findByDoctorIdAndDate(Long doctorId, LocalDateTime date);

    List<Visit> findByPatientIdAndDate(Long patientId, LocalDateTime date);

    List<Visit> findByDoctorIdAndPatientIdAndDate(Long doctorId, Long patientId, LocalDateTime date);

}
