package KiemTra;

import com.sun.source.tree.ReturnTree;

public class Students {
    private  String id;
    private  String full_name;
    private  String gender;
    private  String ngay_sinh;
    private  String dia_chi;
    private  String so_dt;
    private  String email;
    private  long diem;

    public Students() {
    }

    public Students(String id, String full_name, String gender, String ngay_sinh, String dia_chi, String so_dt, String email, long diem) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.so_dt = so_dt;
        this.email = email;
        this.diem = diem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSo_dt() {
        return so_dt;
    }

    public void setSo_dt(String so_dt) {
        this.so_dt = so_dt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDiem() {
        return diem;
    }

    public void setDiem(long diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender='" + gender + '\'' +
                ", ngay_sinh='" + ngay_sinh + '\'' +
                ", dia_chi='" + dia_chi + '\'' +
                ", so_dt='" + so_dt + '\'' +
                ", email='" + email + '\'' +
                ", diem=" + diem +"\n"+
                '}';
    }



//    @Override
//    public int compareTo(Students o) {
//        long diem1=this.getDiem();
//        long diem2=o.getDiem();
//        return diem1.com
//    }
}
