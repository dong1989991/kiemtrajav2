package KiemTra;

import java.util.List;
import java.util.Scanner;

public class main {
    private static   StudentDAO studentDAO=new StudentDAO();
    private static List<Students> studentsList1 = studentDAO.getAllOrderByGpa();



    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ SINH VIEN ---");
        System.out.println("1. Danh sách sinh viên");
        System.out.println("2. Nhập một sinh viên mới");
        System.out.println("3. Xóa một sinh viên theo mã");
        System.out.println("4. Câp nhật thông tin sinh viên");
        System.out.println("5. Tìm 1 sinh viên theo họ tên hoặc mã");
        System.out.println("6. Sắp xếp sinh viên theo điểm số ");
        System.out.println("7. In ra tất cả sinh viên n ữ ở Hà Nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên, sắp xếp theo bảng chữ cái abc.");

    }
    private static void option1() {
        List<Students> studentsList = studentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã Sinh Viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentsList.size(); i++) {
            Students p = studentsList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s\n", p.getId(), p.getFull_name(), p.getGender(), p.getDia_chi());
        };

}
    private static void option2(Scanner in){
        Students p = new Students();
        System.out.print("\tNhập mã sinh viên: ");
        p.setId(in.nextLine());

        System.out.print("\tNhập full name: ");
        p.setFull_name(in.nextLine());

        System.out.print("\tNhập giới tính: ");
        p.setGender(in.nextLine());

        System.out.print("\tNhập ngày sinh: ");
        p.setNgay_sinh(in.nextLine());

        System.out.print("\tNhập địa chỉ: ");
        p.setDia_chi(in.nextLine());

        System.out.print("\tNhập số điện thoại: ");
        p.setSo_dt(in.nextLine());

        System.out.print("\tNhập email: ");
        p.setEmail(in.nextLine());

        System.out.print("\tNhập điểm: ");
        p.setDiem(Long.parseLong(in.nextLine()));



        studentDAO.insert(p);


    }
    private static void option4(Scanner in){
        Students p = new Students();
        System.out.print("Nhập id product cần cập nhật : ");
        String id = in.nextLine();

        System.out.print("\tNhập full name: ");
        p.setFull_name(in.nextLine());

        System.out.print("\tNhập giới tính: ");
        p.setGender(in.nextLine());

        System.out.print("\tNhập ngày sinh: ");
        p.setNgay_sinh(in.nextLine());

        System.out.print("\tNhập địa chỉ: ");
        p.setDia_chi(in.nextLine());

        System.out.print("\tNhập số điện thoại: ");
        p.setSo_dt(in.nextLine());

        System.out.print("\tNhập email: ");
        p.setEmail(in.nextLine());

        System.out.print("\tNhập điểm: ");
        p.setDiem(Long.parseLong(in.nextLine()));

        studentDAO.update(p, id);
    }
    private static void option6() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "STT","Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ", "Điểm GPA");
        System.out.println();
        for (int i = 0; i < studentsList1.size(); i++) {
            Students stud = studentsList1.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20d\n", (i+1), stud.getId(), stud.getFull_name(), stud.getGender(), stud.getDia_chi(),stud.getDiem());
        };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());

            if (option < 1 || option > 8) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    System.out.println("danh sach truoc khi xoa:");
                    System.out.println(studentDAO.getAll());
                    System.out.println("Nhap ma sinh vien can xoa:");
                    String ma= in.nextLine();
                    studentDAO.delete(ma);
                    System.out.println("danh sach sau xoa:");
                    System.out.println(studentDAO.getAll());
                    break;
                case 4:
                    option4(in);
                    break;
                case 5:
                    System.out.println("nhap id can lay");
                    String ma1= in.nextLine();
                    studentDAO.getById(ma1);
                    break;
                case 6:
                    option6();
                    break;
                case 7:
                    break;
                case 8:
                    break;

            }

        }
        while (option != 0);
        in.close();

    }


}
