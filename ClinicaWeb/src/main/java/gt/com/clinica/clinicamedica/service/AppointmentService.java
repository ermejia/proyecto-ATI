package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AppointmentService implements ICrudService{
    /**
     * Obtiene los datos del controlador y los envia al dao
     * @param br es un buffer que contiene los datos del appointment
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        AppointmentEntity app = new AppointmentEntity();
        AppointmentDao dao = new AppointmentDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * Se almacenan los nuevos datos
         */
        app.setDateAppointment(jObj.getString("dateAppointment"));
        app.setDpi(jObj.getString("dpi"));
        app.setReason(jObj.getString("reason"));

           return dao.addAppointment(app);
    }

    /**
     * Obtiene los datos del controlador y los envia al dao para eliminarlos
     * @param br buffer que contiene los datos necesarios para eliminar
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        AppointmentEntity appointment = new AppointmentEntity();
        AppointmentDao dao = new AppointmentDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * Se obtienen los datos del buffer y se almacenan en un json
         */
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        appointment.setIdAppointment(jObj.getInt("idAppointment"));
        return dao.deleteAppointment(appointment.getIdAppointment());
    }

    /**
     * Obtitne los datos del controlador para actualizar el appointment
     * @param br Contiene los datos para actualizar
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        AppointmentEntity appointment = new AppointmentEntity();
        AppointmentDao dao = new AppointmentDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * obtiene cada linea del buffer
         */
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        /**
         * convierte los datos a un objeto json
         */
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * agrega los datos al entity
         */
        appointment.setIdAppointment(jObj.getInt("idAppointment"));
        appointment.setDateAppointment((jObj.getString("dateAppointment")));
        appointment.setIdClinic(jObj.getInt("idClinic"));
        appointment.setDpi(jObj.getString("dpi"));
        appointment.setReason(jObj.getString("reason"));
            return dao.updateAppointment(appointment);
    }

    /**
     * Retorna al controlador la lista de appointments
     * @return
     */
    @Override
    public List<String> listData() {
        AppointmentDao daoa = new AppointmentDao();
        /**
         * obtiene la lista de appointment del dao
         */
        List<AppointmentEntity> listAppointment = daoa.listAllAppointments();
        List<String> json = new LinkedList<>();
        /**
         * convierte los datos a JSON
         */
        Gson gson = new Gson();
        if (listAppointment != null) {
            for (AppointmentEntity appo : listAppointment) {
                json.add(gson.toJson(appo));
            }
            return (json);
        } else {
            return null;
        }
    }

    /**
     * Obtiene el id del controladro y retorna la informacion del appointment solicitado
     * @param id Es el id del appointment que se buscara en la base de datos
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        AppointmentDao dao = new AppointmentDao();
        /**
         * obtiene los datos del dao
         */
        AppointmentEntity listEm = dao.getById(id);
        if (listEm != null) {
            /**
             * convierte los datos a JSON y los retorna al controlador
             */
            json.add(gson.toJson(listEm));
            return (json);
        } else {
            return null;
        }
    }
}
