import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<head>");
        out.println("<a href='index.jsp' id=\"topLink\">Add New Student</a>");
        out.print("<link rel=\"stylesheet\" href=\"style2.css\">");
        out.print("</head>");
        out.print("<main class=\"table\">");
        out.print("<section class=\"table_header\">");
        out.println("<h1>Students List</h1>");
        out.print("</section>");

        List<Student> list = StudentDao.getAllStudent();

        out.print("<section class=\"table_body\">");
        out.print("<table>");
        out.print("<thead>");
        out.print("<tr><th>Id</th><th>Name</th><th>Number of Bed</th><th>Room Number</th><th>Ac/nonAc</th><th>Edit</th><th>Delete</th></tr>");
        out.print("</thead>");
        out.print("<tbody>");
        for (Student e : list) {
            out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getBed() + "</td><td>" + e.getRoom() + "</td><td>" + e.getAc() + "</td><td><a href='EditServlet?id=" + e.getId() + "'>edit</a></td><td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
        }
        out.print("</tbody");
        out.print("</table>");
        out.print("</section>");
        out.print("</main>");
        out.close();
    }
}
