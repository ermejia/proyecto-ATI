package gt.com.clinica.clinicamedica.service;

import gt.com.clinica.clinicamedica.dao.DiagnosticDao;
import gt.com.clinica.clinicamedica.entity.DiagnosticEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DiagnosticService implements ICrudService {
    /**
     * Obtiene los datos del controlador y luego los envia al dao para agregarlos a labase de datos
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        DiagnosticEntity diagnostic = new DiagnosticEntity();
        DiagnosticDao dao = new DiagnosticDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * obtiene cada linea del buffer
         */
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        /**
         * lo convierte a un objeto json
         */
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * agrega los datos al entity
         */
        diagnostic.setDescription((jObj.getString("Description")));
        diagnostic.setIdMedic(jObj.getInt("idMedic"));
        diagnostic.setIdMedicine(jObj.getInt("idMedicine"));
        diagnostic.setProcedure(jObj.getString("Procedure"));
        diagnostic.setDpi(jObj.getString("dpi"));

            return dao.addDiagnostic(diagnostic);

    }

    @Override
    public int deleteData(BufferedReader br) throws IOException {
        return 0;
    }

    @Override
    public int updateData(BufferedReader br) throws IOException {
        return 0;
    }

    @Override
    public List<String> listData() {
        return null;
    }

    @Override
    public List<String> getDatabyId(int id) {
        return null;
    }
}
