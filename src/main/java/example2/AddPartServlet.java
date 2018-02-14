package example2;

import example2.dao.PartsDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="AddPart",urlPatterns ="/add-part" )
public class AddPartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String partNumber = req.getParameter("part-number");

        if (title == null || partNumber == null) throw new ServletException("title and partNumber should be provided");
        EntityManager em = ApplicationEnvironment.getInstance().getEmf().createEntityManager();
        try {
            new PartsDAO(em).createPart(title, partNumber);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new ServletException(throwable);
        } finally {
            em.close();
        }
        resp.sendRedirect("/");
    }
}
