package haui.lethanhha.com.mothercare.model;

public class HoiDap {
    private int maCauHoi;

    private String cauHoi;

    private String noiDung;

    public HoiDap() {
    }

    public HoiDap(int maCauHoi, String cauHoi, String noiDung) {
        this.maCauHoi = maCauHoi;
        this.cauHoi = cauHoi;
        this.noiDung = noiDung;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
