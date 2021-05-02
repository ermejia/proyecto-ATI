package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class PatientService implements ICrudService {
    /**
     * Obtiene los datos enviados por el controlador y los envia al dao para agregarlo a la base de datos
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        PersonEntity pat = new PersonEntity();
        PatientDao dao = new PatientDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        pat.setDpi((jObj.getString("dpi")));
        pat.setName(jObj.getString("name"));
        pat.setSurname(jObj.getString("surname"));
        pat.setAddress(jObj.getString("address"));
        pat.setPhone(jObj.getInt("phone"));
        pat.setBirthdate(jObj.getString("birthdate"));
        pat.setContactphone(jObj.getInt("contactphone"));
          return  dao.addepatient(pat);
    }

    /**
     * Obtiene los datos que se enviaran al dao para eliminarlo de la bse de datos
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        PersonEntity pat = new PersonEntity();
        PatientDao dao = new PatientDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        pat.setIdPerson(jObj.getInt("idPerson"));
        return dao.deletepatient(pat.getIdPerson());

        }

    /**
     * Obtiene los datos enviados por el controlador para luego enviarlo al dao ya ctualizar el paciente
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        PersonEntity pat = new PersonEntity();
        PatientDao dao = new PatientDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        pat.setIdPerson((jObj.getInt("idPerson")));
        pat.setAddress(((jObj.getString("address"))));
        pat.setBirthdate((jObj.getString("birthdate")));
        pat.setContactphone((jObj.getInt("contactphone")));
        pat.setDpi((jObj.getString("dpi")));
        pat.setName(((jObj.getString("name"))));
        pat.setPhone((jObj.getInt("phone")));
        pat.setSurname(((jObj.getString("surname"))));

           return dao.updatepatient(pat);
    }

    /**
     * Retorna una lista con los pacientes
     * @return
     */
    @Override
    public List<String> listData() {
        PatientDao daopr = new PatientDao();
        List<PersonEntity> listPatie = daopr.listAll();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
            if (listPatie != null) {
                for (PersonEntity patie : listPatie) {
                    json.add(gson.toJson(patie));
                }
                return (json);
            } else {
               return null;
            }
        }

    /**
     * obtiene le id enviado por el controlador y retorna los datos solicitados
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        PatientDao dao = new PatientDao();
        PersonEntity patient = dao.getById(id);
            if (patient != null) {
                json.add(gson.toJson(patient));
                return (json);
            } else {
                return null;
            }
        }
}
