package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AppointmentDao implements ICrudAppointments{

    /**
     * Consultas utilizadas en el CRUD
     */
    final String selectAllAppointments = "SELECT IdCitaMedica, C.DPI, P.Nombre, P.Apellido, C.FechaCita, C.MotivoCita\n" +
            "FROM pacientes P, citasmedicas C\n" +
            "where P.DPI = C.DPI;";
    final String selectById ="SELECT * FROM citasmedicas WHERE IdCitaMedica=";
    final String addAppointment = "INSERT INTO citasmedicas(DPI,FechaCita,MotivoCita) VALUES(?,?,?);";
    final String updateAppointment = "UPDATE citasmedicas set DPI=?,FechaCita=?,MotivoCita=? WHERE IdCitaMedica=?;";
    final String delAppointment = "DELETE FROM citasmedicas WHERE IdCitaMedica =";
    /**
     * Lista todas las citas
     * @return Lista completa de las citas
     */
    @Override
    public List<AppointmentEntity> listAllAppointments() {
        List<AppointmentEntity> listAppointment = new LinkedList<>();
        AppointmentEntity appointment ;
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllAppointments);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                appointment = new AppointmentEntity();
                appointment.setIdAppointment(consulta.getInt("IdCitaMedica"));
                appointment.setDpi(consulta.getString("dpi"));
                appointment.setDateAppointment(consulta.getString("FechaCita"));
                appointment.setReason(consulta.getString("MotivoCita"));
                appointment.setName(consulta.getString("Nombre"));
                appointment.setLastName(consulta.getString("Apellido"));
                listAppointment.add(appointment);
            }
            consulta.close();
            return listAppointment;
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
            return null;
        }finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    /**
     * Elimina una cita
     * @param id Contiene el id de la cita medica
     * @return status 0 si falla la operacion y status 1 si se ejecuta con exito
     */
    @Override
    public int deleteAppointment(int id) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(delAppointment+id);
            status = parametro.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;    }
    /**
     * Actualiza una cita
     * @param appo contiene los datos actualizados de la cita
     * @return status 0 si falla la operacion y status 1 si no falla
     */
    @Override
    public int updateAppointment(AppointmentEntity appo) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(updateAppointment);
            parametro.setInt(1,appo.getIdAppointment());
            parametro.setString(2, appo.getDpi());
            parametro.setString(3,appo.getDateAppointment());
            parametro.setString(4,appo.getReason());

            status = parametro.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
    /**
     * Añade una cita a la base de datos
     * @param appo contiene los datos de la nueva cita
     * @return status 0 si falla la consulta y status 1 si no falla
     */
    @Override
    public int addAppointment(AppointmentEntity appo) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(addAppointment);
            parametro.setString(1, appo.getDpi());
            parametro.setString(2,appo.getDateAppointment());
            parametro.setString(3,appo.getReason());
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
    /**
     * obtiene una cita especifica por medio del id
     * @param id contiene el id de la cita
     * @return status 1 si se ejecuta y 0 si falla
     **/
    @Override
    public AppointmentEntity getById(int id) {
        AppointmentEntity app = new AppointmentEntity();
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement= conexion.prepareStatement(selectById+id);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                app = new AppointmentEntity();
                app.setIdAppointment(consulta.getInt("IdCitaMedica"));
                app.setReason(consulta.getString("MotivoCita"));
                app.setDpi(consulta.getString("DPI"));
                app.setDateAppointment(consulta.getString("FechaCita"));
            }
            consulta.close();
            return app;
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
            return null;
        }finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
