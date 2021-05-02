package gt.com.clinica.clinicamedica.entity;

import java.util.List;

public class RecordEntity {
    private int idRecord;
    private PersonEntity patient;
    private List<AppointmentEntity> allAppointments;
    private List<DiagnosticEntity> allDiagnostics;

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public PersonEntity getPatient() {
        return patient;
    }

    public void setPatient(PersonEntity patient) {
        this.patient = patient;
    }

    public List<AppointmentEntity> getAllAppointments() {
        return allAppointments;
    }

    public void setAllAppointments(List<AppointmentEntity> allAppointments) {
        this.allAppointments = allAppointments;
    }

    public List<DiagnosticEntity> getAllDiagnostics() {
        return allDiagnostics;
    }

    public void setAllDiagnostics(List<DiagnosticEntity> allDiagnostics) {
        this.allDiagnostics = allDiagnostics;
    }


}
