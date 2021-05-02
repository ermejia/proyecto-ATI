package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.RecordEntity;

public interface ICudRecord {
    public int deleteRecord(int id);
    public RecordEntity getRecordbyDpi(int dpi);

}
