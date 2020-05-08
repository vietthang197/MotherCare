package haui.lethanhha.com.mothercare.model;

public class TiemPhong {
    private String tenTieuDe;
    private String noiDung;

    public TiemPhong(String tenTieuDe, String noiDung) {
        this.tenTieuDe = tenTieuDe;
        this.noiDung = noiDung;
    }

    public TiemPhong() {
    }

    public String getTenTieuDe() {
        return tenTieuDe;
    }

    public void setTenTieuDe(String tenTieuDe) {
        this.tenTieuDe = tenTieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
