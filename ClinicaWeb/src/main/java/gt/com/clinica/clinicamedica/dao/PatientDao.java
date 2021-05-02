package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PatientDao implements ICrudPatient {
    /**
     * Consultas SQL  para las operaciones CRUD
     */
    final String selectAllPatients = "SELECT * FROM pacientes";
    final String selectById ="SELECT * FROM pacientes WHERE IdPaciente=";
    final String deletePatient = "DELETE FROM pacientes WHERE IdPaciente =";
    final String updatePatient = "UPDATE pacientes set DPI=?,Nombre=?,Apellido=?,Direccion=?,Telefono=?,FechaNacimiento=?,TelefonoContacto=? WHERE IdPaciente=?;";
    final String addPatient = "INSERT INTO pacientes(DPI,Nombre,Apellido,Direccion,Telefono,FechaNacimiento,TelefonoContacto) VALUES(?,?,?,?,?,?,?);";

    /**
     * lita los pacientes
     * @return
     */
    @Override
    public List<PersonEntity> listAll() {
        Date date = null;
        List<PersonEntity> listEmployee = new LinkedList<>();
        PersonEntity emp;
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllPatients);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                emp = new PersonEntity();
                emp.setIdPerson(consulta.getInt("idPaciente"));
                emp.setDpi(consulta.getString("DPI"));
                emp.setName(consulta.getString("Nombre"));
                emp.setSurname(consulta.getString("Apellido"));
                emp.setAddress(consulta.getString("Direccion"));
                emp.setPhone(consulta.getInt("Telefono"));
                emp.setBirthdate(consulta.getString("FechaNacimiento"));
                emp.setContactphone(consulta.getInt("TelefonoContacto"));
                listEmployee.add(emp);
            }
            consulta.close();
            return listEmployee;
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
     * Elimina un paciente
     * @param dpi contiene el dpi del paciente que se eliminará
     * @return
     */
    @Override
    public int deletepatient(int dpi) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deletePatient+dpi);
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
     * Actualiza el paciente
     * @param patient contiene los datos del paciente que se actualizara
     * @return
     */
    @Override
    public int updatepatient(PersonEntity patient) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(updatePatient);
            parametro.setString(1, patient.getDpi());
            parametro.setString(2, patient.getName());
            parametro.setString(3, patient.getSurname());
            parametro.setString(4, patient.getAddress());
            parametro.setInt(5, patient.getPhone());
            parametro.setString(6, patient.getBirthdate());
            parametro.setInt(7,patient.getContactphone());
            parametro.setInt(8,patient.getIdPerson());
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
     * Agrega un paciente nuevo
     * @param patient Contiene los datos del paciente nuevo
     * @return
     */
    @Override
    public int addepatient(PersonEntity patient) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(addPatient);
            parametro.setString(1, patient.getDpi());
            parametro.setString(2, patient.getName());
            parametro.setString(3, patient.getSurname());
            parametro.setString(4, patient.getAddress());
            parametro.setInt(5, patient.getPhone());
            parametro.setString(6, patient.getBirthdate());
            parametro.setInt(7,patient.getContactphone());
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
     * Busca un paciente por id
     * @param id contiene le id del paciente
     * @return
     */
    @Override
    public PersonEntity getById(int id) {
        PersonEntity emp = new PersonEntity();
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement= conexion.prepareStatement(selectById+id);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                emp.setIdPerson(consulta.getInt("idPaciente"));
                emp.setDpi(consulta.getString("DPI"));
                emp.setName(consulta.getString("Nombre"));
                emp.setSurname(consulta.getString("Apellido"));
                emp.setAddress(consulta.getString("Direccion"));
                emp.setPhone(consulta.getInt("Telefono"));
                emp.setBirthdate(consulta.getString("FechaNacimiento"));
                emp.setContactphone(consulta.getInt("TelefonoContacto"));
            }
            consulta.close();
            return emp;
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
