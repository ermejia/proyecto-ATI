package gt.com.clinica.clinicamedica.dao;
import gt.com.clinica.clinicamedica.entity.*;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RecordDao implements ICudRecord{
    /**
     * Consutlas SQL para las operaciones CRUD
     */
    final String historyApp = "SELECT a.*, b.Nombre FROM CitasMedicas a, Clinica b where a.IdClinica = b.IdClinica and DPI =";
    final String historyDiag = "SELECT a.*,b.Nombre as NombreMedicina, d.Nombre as NombreMedico FROM Diagnostico a, Medicamentos b, Medicos c, Empleados d where b.IdMedicamento = a.IdMedicamento and d.IdEmpleado = c.IdEmpleado and a.IdMedico = c.IdMedico and a.DPI =";
    final String historyPtr = "SELECT a.*,  b.Descripcion as roomD From PacientesHabitacion a, Habitaciones b where a.IdHabitacion = b.IdHabitacion and a.DPI =";
    final String selectById ="SELECT * FROM Pacientes WHERE DPI=";

    @Override
    public int deleteRecord(int id) {
       /* int status = 0;
        Connection conexion = null;

        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deleteRecord+id);
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
        }*/
        return 0;
    }

    /**
     * Retorna el historial del paciente por DPI
     * @param dpi Contiene el dpi del paciente
     * @return Retorna el historial completo
     */
    @Override
    public RecordEntity getRecordbyDpi(int dpi) {
        RecordEntity result = new RecordEntity();
        PersonEntity emp = new PersonEntity();
        AppointmentEntity app = new AppointmentEntity();
        DiagnosticEntity diag = new DiagnosticEntity();
        List<AppointmentEntity> listapp = new LinkedList<>();
        List<DiagnosticEntity> listdiag = new LinkedList<>();
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statementApp= conexion.prepareStatement(historyApp+dpi);
            ResultSet consulta1=statementApp.executeQuery();
            while (consulta1.next()) {
                app = new AppointmentEntity();
                app.setReason(consulta1.getString("MotivoCita"));
                app.setIdClinic(consulta1.getInt("IdClinica"));
                app.setClinic(consulta1.getString("Nombre"));
                app.setDateAppointment(consulta1.getString("FechaCita"));
                app.setReason(consulta1.getString("MotivoCita"));
                listapp.add(app);
            }
            result.setAllAppointments(listapp);
            PreparedStatement statementDiag= conexion.prepareStatement(historyDiag+dpi);
            ResultSet consulta2=statementDiag.executeQuery();
            while (consulta2.next()) {
                diag = new DiagnosticEntity();
                diag.setId(consulta2.getInt("IdDiagnostico"));
                diag.setIdMedic(consulta2.getInt("IdMedico"));
                diag.setIdMedicine(consulta2.getInt("IdMedicamento"));
                diag.setDescription(consulta2.getString("Descripcion"));
                diag.setProcedure(consulta2.getString("ProcedimientoMedico"));
                diag.setMedic(consulta2.getString("NombreMedico"));
                diag.setMedicine(consulta2.getString("NombreMedicina"));
                listdiag.add(diag);
            }
            result.setAllDiagnostics(listdiag);

            PreparedStatement statementPat= conexion.prepareStatement(selectById+dpi);
            ResultSet consulta4=statementPat.executeQuery();
            while (consulta4.next()) {
                emp.setIdPerson(consulta4.getInt("idPaciente"));
                emp.setDpi(consulta4.getString("DPI"));
                emp.setName(consulta4.getString("Nombre"));
                emp.setSurname(consulta4.getString("Apellido"));
                emp.setAddress(consulta4.getString("Direccion"));
                emp.setPhone(consulta4.getInt("Telefono"));
                emp.setBirthdate(consulta4.getString("FechaNacimiento"));
                emp.setContactphone(consulta4.getInt("TelefonoContacto"));
            }
            result.setPatient(emp);
            consulta1.close();
            consulta2.close();
            return result;
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
