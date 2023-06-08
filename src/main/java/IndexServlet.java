import Veterinary_Clinic.Animal;
import Veterinary_Clinic.AnimalDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Animal> animals = AnimalDB.select ();
        request.setAttribute ( "animals", animals );

        getServletContext ().getRequestDispatcher ( "/index.jsp.html" ).forward ( request,response );
    }
}