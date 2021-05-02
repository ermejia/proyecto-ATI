package gt.com.clinica.clinicamedica.controller.patient;

import gt.com.clinica.clinicamedica.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/crudPatients")
public class PatientController extends HttpServlet {
    /**
     * Obtiene los datos para añadir un paciente nuevo
     * @param request Contiene los datos del paciente nuevo
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService pat = new PatientService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(pat.addData(br)!=1){
                out.println("Error");
            }
        }
    }

    /**
     * Retorna una lista con los pacientes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService daopr = new PatientService();
        List<String> json = daopr.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
    }
}
