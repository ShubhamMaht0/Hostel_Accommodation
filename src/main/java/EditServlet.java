import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<head>");
        out.print("<link rel=\"stylesheet\" href=\"style1.css\">");
        out.print("</head>");
        out.print("body");
        out.print("<div class=\"wrapper\">");
        out.println("<h1>Update Student</h1>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);


        Student e = StudentDao.getStudentById(id);


        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table class=\"input-box\">");
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
        out.print("<tr><td>Number of Bed:</td><td><input type='number' name='number_of_bed' value='" + e.getBed() + "'/></td ></tr>");
        out.print("<tr><td>Room Number:</td><td><input type='number' name='room_number' value='" + e.getRoom() + "'/></td></tr>");
        out.print("<tr class=\"select\"><td>Ac/nonAc:</td><td>");
        out.print("<select name='ac_nonAc' style='width:150px'>");
        out.print("<option>AC</option>");
        out.print("<option>Non-AC</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr class=\"submit\"><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.print("</div>");
        out.print("</body");

        out.close();
    }
}
