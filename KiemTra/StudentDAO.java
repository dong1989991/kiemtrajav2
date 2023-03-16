package KiemTra;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {

    public List<Students> getAll() {
        final String sql = "SELECT * FROM `students`";

        List<Students> studentsList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students b = new Students();
                b.setId(rs.getString("id"));
                b.setFull_name(rs.getString("full_name"));
                b.setGender(rs.getString("gender"));
                b.setNgay_sinh(rs.getString("ngay_sinh"));
                b.setDia_chi(rs.getString("dia_chi"));
                b.setSo_dt(rs.getString("so_dt"));
                b.setEmail(rs.getString("email"));
                b.setDiem(rs.getLong("diem"));
                studentsList.add(b);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentsList;
    }
    public Students getById(String id) {
        final String sql = "SELECT * FROM `students` WHERE  `id` = '%s'" + id;
        Students b = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                b = new Students();
                b.setId(rs.getString("id"));
                b.setFull_name(rs.getString("full_name"));
                b.setGender(rs.getString("gender"));
                b.setNgay_sinh(rs.getString("ngay_sinh"));
                b.setDia_chi(rs.getString("dia_chi"));
                b.setSo_dt(rs.getString("so_dt"));
                b.setEmail(rs.getString("email"));
                b.setDiem(rs.getLong("diem"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    public void insert(Students students) {
        final String sql = String.format("INSERT INTO `students` VALUES ('%s','%s','%s','%s','%s','%s','%s','%d')",
                students.getId(),students.getFull_name(),students.getGender(),
                    students.getNgay_sinh(),students.getDia_chi(),students.getSo_dt(),
        students.getEmail(),students.getDiem());
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Students students, String id) {
        Students tmp = getById(id);
        if (tmp == null) {
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("UPDATE `students` SET `full_name` = '%s', `gender`= '%s' ,`ngay_sinh`='%s',`dia_chi`='%s',`so_dt`='%s',`email`='%s',`diem`='%d' WHERE `id`='%s' ",
                students.getFull_name(),
                students.getGender(),
                students.getNgay_sinh(),
                students.getDia_chi(),
                students.getSo_dt(),
                students.getEmail(),
                students.getDiem(),
                id
        );

        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void delete(String id) {
        final String sql =  String.format("DELETE FROM students WHERE id = '%s'", id);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Students> getAllOrderByGpa() {
        List<Students> studentsList = new ArrayList<>();
        // Bước 1: tạo kết nối
        // Bước 2: chuẩn bị câu lệnh
        // Bước 3: thực thi
        // Bước 4: đóng kết nối

        try {
            Connection conn = MyConnection.getConnection();
            final String sql = "SELECT * FROM students order by(diem) asc";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getString("id"));
                students.setFull_name(rs.getString("full_name"));
                students.setGender(rs.getString("gender"));
                students.setNgay_sinh(rs.getString("ngay_sinh"));
                students.setDia_chi(rs.getString("dia_chi"));
                students.setSo_dt(rs.getString("so_dt"));
                students.setEmail(rs.getString("email"));
                students.setDiem(rs.getLong("diem"));
                studentsList.add(students);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }
}
