package haui.lethanhha.com.mothercare.model;

public class TiemPhong {
   private int maTiemPhong;

   private String tenTiemPhong;

   private String noiDung;

   private String nguoiTiem;

    public TiemPhong() {
    }

    public TiemPhong(int maTiemPhong, String tenTiemPhong, String noiDung, String nguoiTiem) {
        this.maTiemPhong = maTiemPhong;
        this.tenTiemPhong = tenTiemPhong;
        this.noiDung = noiDung;
        this.nguoiTiem = nguoiTiem;
    }

    public int getMaTiemPhong() {
        return maTiemPhong;
    }

    public void setMaTiemPhong(int maTiemPhong) {
        this.maTiemPhong = maTiemPhong;
    }

    public String getTenTiemPhong() {
        return tenTiemPhong;
    }

    public void setTenTiemPhong(String tenTiemPhong) {
        this.tenTiemPhong = tenTiemPhong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNguoiTiem() {
        return nguoiTiem;
    }

    public void setNguoiTiem(String nguoiTiem) {
        this.nguoiTiem = nguoiTiem;
    }
}
