package haui.lethanhha.com.mothercare.model;

public class MuaLam {
    private String tenTieuDe;
    private String noiDung;

    public MuaLam(String tenTieuDe, String noiDung) {
        this.tenTieuDe = tenTieuDe;
        this.noiDung = noiDung;
    }

    public MuaLam() {
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
