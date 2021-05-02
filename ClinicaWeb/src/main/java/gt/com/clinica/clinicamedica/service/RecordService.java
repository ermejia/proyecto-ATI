package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.RecordDao;
import gt.com.clinica.clinicamedica.entity.RecordEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class RecordService implements ICrudService{
    /**
     * obtenemos el id del controlador y retornamos los datos del historial
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        Gson gson = new Gson();
        RecordDao daor = new RecordDao();
        List<String> json = new LinkedList<>();
        List<RecordEntity> listRecords = new LinkedList<>();
        /**
         * obtenemos los datos del dao
         */
        listRecords.add(daor.getRecordbyDpi(id));
        if (listRecords != null) {
            /**
             * recorremos el array y lo convertimos a Json
             */
            for (RecordEntity rec : listRecords) {
                json.add(gson.toJson(rec));
            }
            return (json);
        } else {
            return null;
        }
    }

    /**
     * Obtenemos los datos del controlador para eliminar el historial
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        RecordEntity rec = new RecordEntity();
        RecordDao dao = new RecordDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        rec.setIdRecord(jObj.getInt("idRecord"));
         return dao.deleteRecord(rec.getIdRecord());
        }

    @Override
    public int addData(BufferedReader br) throws IOException {
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
}
