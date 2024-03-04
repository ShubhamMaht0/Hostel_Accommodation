import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String sbed = request.getParameter("number_of_bed");
        int bed = Integer.parseInt(sbed);
        String sroom = request.getParameter("room_number");
        int room = Integer.parseInt(sroom);
        String ac = request.getParameter("ac_nonAc");

        Student e = new Student();
        e.setId(id);
        e.setName(name);
        e.setBed(bed);
        e.setRoom(room);
        e.setAc(ac);

        int status = StudentDao.update(e);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}
