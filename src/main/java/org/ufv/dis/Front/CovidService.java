package org.ufv.dis.Front;
import org.ufv.dis.Back.*;
import java.io.Serializable;
import org.springframework.stereotype.Service;

@Service
public class CovidService implements Serializable {
    public String leeDatoCovid(String tipoPeticion) {
        return "Hello " + tipoPeticion;
    }
}
