package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.PersonEntity;

import java.util.List;

public interface ICrudPatient {
    public List<PersonEntity> listAll();
    public int deletepatient(int dpi);
    public int updatepatient(PersonEntity patient);
    public int addepatient(PersonEntity patient);
    public PersonEntity getById (int id);
}
