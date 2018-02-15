package example2.dao;
import example2.model.Part;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Vendor {
    List<Part> getAllParts();
}
@Service
class MyVendor implements Vendor {
    public List<Part> getAllParts (){
        return null;
    }
}
