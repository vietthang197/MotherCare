package haui.lethanhha.com.mothercare.model;

public class TenBe {
    private int maTen;

    private String tenBe;

    private String yNghia;

    private String tenKhac;

    private String gioiTinh;

    public TenBe() {
    }

    public TenBe(int maTen, String tenBe, String yNghia, String tenKhac, String gioiTinh) {
        this.maTen = maTen;
        this.tenBe = tenBe;
        this.yNghia = yNghia;
        this.tenKhac = tenKhac;
        this.gioiTinh = gioiTinh;
    }

    public int getMaTen() {
        return maTen;
    }

    public void setMaTen(int maTen) {
        this.maTen = maTen;
    }

    public String getTenBe() {
        return tenBe;
    }

    public void setTenBe(String tenBe) {
        this.tenBe = tenBe;
    }

    public String getyNghia() {
        return yNghia;
    }

    public void setyNghia(String yNghia) {
        this.yNghia = yNghia;
    }

    public String getTenKhac() {
        return tenKhac;
    }

    public void setTenKhac(String tenKhac) {
        this.tenKhac = tenKhac;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
