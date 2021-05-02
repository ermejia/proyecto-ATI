package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.AppointmentEntity;

import java.util.List;

public interface ICrudAppointments {
    public List<AppointmentEntity> listAllAppointments();
    public int deleteAppointment(int id);
    public int updateAppointment(AppointmentEntity appo);
    public int addAppointment(AppointmentEntity appo);
    public AppointmentEntity getById (int id);
}
