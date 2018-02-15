package example2;

import example2.beans.PartsBean;
import example2.dao.PartsDAO;
import example2.dao.Vendor;
import example2.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PartsController {
private final PartsDAO dao;

@Autowired
public PartsController(PartsDAO dao) {
        this.dao = dao;
    }


@RequestMapping(method = RequestMethod.GET,path = "/")
public String  index (ModelMap model) {

    PartsBean bean = new PartsBean();
    bean.setAllParts(dao.all());

    model.put("bean", bean);

    return "index";
}
@RequestMapping(method = RequestMethod.POST ,path = "/add-part")
        public String addPart(@RequestParam String title,
                              @RequestParam(name = "part-number")String partNumber)throws Throwable{

         dao.createPart(title, partNumber);
   return "index";
    }
}
