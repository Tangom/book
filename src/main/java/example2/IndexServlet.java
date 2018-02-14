package example2;

import example2.dao.PartsDAO;
import example2.model.Part;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "index",urlPatterns = "/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = ApplicationEnvironment.getInstance().getEmf().createEntityManager();
        List<Part> allParts;
        try {
            allParts = new PartsDAO(em).all();
        } finally {
            em.close();
        }
    }
}
