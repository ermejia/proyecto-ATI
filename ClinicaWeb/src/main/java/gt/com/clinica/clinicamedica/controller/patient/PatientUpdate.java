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

@WebServlet("/updatePatient")
public class PatientUpdate extends HttpServlet {
    /**
     * Obtiene los datos del paciente enviados por el frontend
     * @param request contiene los datos del paciente
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService pat = new PatientService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(pat.updateData(br)!=1){
                out.println("error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
