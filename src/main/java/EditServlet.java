import Veterinary_Clinic.Animal;
import Veterinary_Clinic.AnimalDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { try { int id=Integer.parseInt ( request.getParameter ( "id" ) );
                Animal animal=AnimalDB.selectOne ( id );
                if (animal != null) {
                    request.setAttribute ( "animal", animal );
                    getServletContext ( ).getRequestDispatcher ( "/edit.jsp" ).forward ( request, response );
                }
                else {
                    getServletContext ( ).getRequestDispatcher ( "/notfound.jsp" ).forward ( request, response );
                }
            }
            catch (Exception ex) {
                getServletContext ( ).getRequestDispatcher ( "/notfound.jsp" ).forward ( request, response );
            }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id=Integer.parseInt ( request.getParameter ( "id" ) );
            String name=request.getParameter ( "name" );
            int age=Integer.parseInt ( request.getParameter ( "age" ) );
            Animal animal = new Animal ( id, name, age );
            AnimalDB.update ( animal );
            response.sendRedirect ( request.getContextPath ( )+ "/index" );
        }
        catch (Exception ex) {
            getServletContext ( ).getRequestDispatcher ( "/notfound.jsp" ).forward ( request, response );
        }
    }
}