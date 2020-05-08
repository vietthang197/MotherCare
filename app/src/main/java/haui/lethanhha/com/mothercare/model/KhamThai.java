package haui.lethanhha.com.mothercare.model;

public class KhamThai  {
    private int maKhamThai;

    private String lanKham;

    private String noiDung;

    public KhamThai() {
    }

    public KhamThai(int maKhamThai, String lanKham, String noiDung) {
        this.maKhamThai = maKhamThai;
        this.lanKham = lanKham;
        this.noiDung = noiDung;
    }

    public int getMaKhamThai() {
        return maKhamThai;
    }

    public void setMaKhamThai(int maKhamThai) {
        this.maKhamThai = maKhamThai;
    }

    public String getLanKham() {
        return lanKham;
    }

    public void setLanKham(String lanKham) {
        this.lanKham = lanKham;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
