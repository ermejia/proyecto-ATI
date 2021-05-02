package gt.com.clinica.clinicamedica.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface ICrudService {
    public int addData(BufferedReader br) throws IOException;
    public int deleteData(BufferedReader br) throws IOException;
    public int updateData(BufferedReader br) throws IOException;
    public List<String> listData();
    public List<String> getDatabyId(int id);

}
