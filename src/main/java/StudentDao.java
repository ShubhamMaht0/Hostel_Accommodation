import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Shubham@0");
            if (con != null) {
                System.out.println("Connected to the Oracle database!");

            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }


    public static int save(Student e) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into Shubham.HostelAccommodationSystem (name,bed,room,ac) values(?,?,?,?)"
            );
            ps.setString(1, e.getName());
            ps.setInt(2, e.getBed());
            ps.setInt(3, e.getRoom());
            ps.setString(4, e.getAc());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Student e) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update Shubham.HostelAccommodationSystem set name=?,bed=?,room=?,ac=? where id = ?"
            );
            ps.setString(1, e.getName());
            ps.setInt(2, e.getBed());
            ps.setInt(3, e.getRoom());
            ps.setString(4, e.getAc());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "delete from Shubham.HostelAccommodationSystem where id=?"
            );
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Student getStudentById(int id) {
        Student e = new Student();

        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from Shubham.HostelAccommodationSystem where id=?"
            );

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setBed(rs.getInt(3));
                e.setRoom(rs.getInt(4));
                e.setAc(rs.getString(5));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public static List<Student> getAllStudent() {
        List<Student> list = new ArrayList<Student>();

        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from Shubham.HostelAccommodationSystem"
            );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student e = new Student();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setBed(rs.getInt(3));
                e.setRoom(rs.getInt(4));
                e.setAc(rs.getString(5));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
