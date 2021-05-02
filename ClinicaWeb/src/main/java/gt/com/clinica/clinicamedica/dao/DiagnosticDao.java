package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.DiagnosticEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiagnosticDao implements IDiagnostic{

    /**
     * Consulta ulizida en la operacino CRUD
     */
    final String addClinic = "INSERT INTO Diagnostico(Descripcion,IdMedico,IdMedicamento,ProcedimientoMedico,DPI) VALUES(?,?,?,?,?);";

    /**
     * Agrega un nuevo diagnostico medico a la base de datos
     * @param diagnostic contiene lo datos del diagnostico
     * @return status 1 si la operacion se completa y status 0 si falla
     */
    @Override
    public int addDiagnostic(DiagnosticEntity diagnostic) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(addClinic);
            parametro.setString(1, diagnostic.getDescription());
            parametro.setInt(2, diagnostic.getIdMedic());
            parametro.setInt(3,diagnostic.getIdMedicine());
            parametro.setString(4,diagnostic.getProcedure());
            parametro.setInt(5, Integer.parseInt(diagnostic.getDpi()));
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
     * elimina un diagnostico medico
     * @param id contiene el id del diagnsotico que se debe elimianr
     * @return status 1 si la operacion se completa y status 0 si falla
     */
    @Override
    public int deleteDiagnostic(int id) {
        return 0;
    }
}
