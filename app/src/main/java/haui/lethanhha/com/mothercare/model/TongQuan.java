package haui.lethanhha.com.mothercare.model;

public class TongQuan {
    private int maTongQuan;

    private String noiDung;

    public TongQuan() {
    }

    public TongQuan(int maTongQuan, String noiDung) {
        this.maTongQuan = maTongQuan;
        this.noiDung = noiDung;
    }

    public int getMaTongQuan() {
        return maTongQuan;
    }

    public void setMaTongQuan(int maTongQuan) {
        this.maTongQuan = maTongQuan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
