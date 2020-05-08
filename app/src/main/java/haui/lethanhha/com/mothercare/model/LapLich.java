package haui.lethanhha.com.mothercare.model;

public class LapLich {
    private int maLapLich;

    private String ngayNhacNho;

    private String ghiChu;

    private String tenLoai;

    private int trangThai;

    public LapLich() {
    }

    public LapLich(int maLapLich, String ngayNhacNho, String ghiChu, String tenLoai, int trangThai) {
        this.maLapLich = maLapLich;
        this.ngayNhacNho = ngayNhacNho;
        this.ghiChu = ghiChu;
        this.tenLoai = tenLoai;
        this.trangThai = trangThai;
    }

    public int getMaLapLich() {
        return maLapLich;
    }

    public void setMaLapLich(int maLapLich) {
        this.maLapLich = maLapLich;
    }

    public String getNgayNhacNho() {
        return ngayNhacNho;
    }

    public void setNgayNhacNho(String ngayNhacNho) {
        this.ngayNhacNho = ngayNhacNho;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
