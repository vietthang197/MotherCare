package haui.lethanhha.com.mothercare.model;

public class Truyen {
    private int maTruyen;

    private String tenTruyen;

    private String noidung;

    private int maLoai;

    public Truyen(int maTruyen, String tenTruyen, String noidung, int maLoai) {
        this.maTruyen = maTruyen;
        this.tenTruyen = tenTruyen;
        this.noidung = noidung;
        this.maLoai = maLoai;
    }

    public Truyen() {
    }

    public int getMaTruyen() {
        return maTruyen;
    }

    public void setMaTruyen(int maTruyen) {
        this.maTruyen = maTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
}
