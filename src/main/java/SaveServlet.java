import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")

public class SaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String name = request.getParameter("name");
        String sbed = request.getParameter("number_of_bed");
        int bed = Integer.parseInt(sbed);
        String sroom = request.getParameter("room_number");
        int room = Integer.parseInt(sroom);
        String ac = request.getParameter("ac_nonAc");

        Student e = new Student();
        e.setName(name);
        e.setBed(bed);
        e.setRoom(room);
        e.setAc(ac);


        int status = StudentDao.save(e);
        if (status > 0) {
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.print("<p>Record saved successfully!</p>");
        } else {
            out.print("<head>");
            out.print("<link rel=\"stylesheet\" href=\"style3.css\">");
            out.print("</head>");

            out.println("<p>Sorry! unable to save record</p>");
        }
        out.close();
    }

}
