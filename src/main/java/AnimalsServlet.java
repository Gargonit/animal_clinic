import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/animals")
public class AnimalsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try{
            String url = "jdbc:mysql://localhost:3306/animals";
            String username = "root";
            String password = "54535251x";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                writer.println("Connection to AnimalDB succesfull!");
            }
        }
        catch(Exception ex){
            writer.println("Connection failed..."); writer.println(ex);
        } finally {
            writer.close();
        }
    }
}