package haui.lethanhha.com.mothercare.model;

public class AnUong {
    private int maAnUong;

    private String tenAnUong;

    private String icon;

    private String hinhAnh;

    private String noidung;

    private String tenloai;

    private String nenKhongNen;

    public AnUong(int maAnUong, String tenAnUong, String icon, String hinhAnh, String noidung, String tenloai, String nenKhongNen) {
        this.maAnUong = maAnUong;
        this.tenAnUong = tenAnUong;
        this.icon = icon;
        this.hinhAnh = hinhAnh;
        this.noidung = noidung;
        this.tenloai = tenloai;
        this.nenKhongNen = nenKhongNen;
    }

    public AnUong() {
    }

    public int getMaAnUong() {
        return maAnUong;
    }

    public void setMaAnUong(int maAnUong) {
        this.maAnUong = maAnUong;
    }

    public String getTenAnUong() {
        return tenAnUong;
    }

    public void setTenAnUong(String tenAnUong) {
        this.tenAnUong = tenAnUong;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getNenKhongNen() {
        return nenKhongNen;
    }

    public void setNenKhongNen(String nenKhongNen) {
        this.nenKhongNen = nenKhongNen;
    }
}
