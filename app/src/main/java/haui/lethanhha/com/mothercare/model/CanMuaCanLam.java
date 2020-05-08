package haui.lethanhha.com.mothercare.model;

public class CanMuaCanLam {
    private int maCan;

    private String noiDung;

    public CanMuaCanLam() {
    }

    public CanMuaCanLam(int maCan, String noiDung) {
        this.maCan = maCan;
        this.noiDung = noiDung;
    }

    public int getMaCan() {
        return maCan;
    }

    public void setMaCan(int maCan) {
        this.maCan = maCan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
