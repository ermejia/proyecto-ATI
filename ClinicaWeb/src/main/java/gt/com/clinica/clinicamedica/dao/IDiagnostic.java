package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.DiagnosticEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.entity.RecordEntity;

public interface IDiagnostic {
    public int addDiagnostic(DiagnosticEntity diagnostic);
    public int deleteDiagnostic(int id);
}
