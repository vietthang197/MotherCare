package haui.lethanhha.com.mothercare.model;

public class ChuanBiSinh {
    private int maChuanBi;

    private String noiDung;

    private String nguoiCan;

    private String trangThai;

    public ChuanBiSinh(int maChuanBi, String noiDung, String nguoiCan, String trangThai) {
        this.maChuanBi = maChuanBi;
        this.noiDung = noiDung;
        this.nguoiCan = nguoiCan;
        this.trangThai = trangThai;
    }

    public ChuanBiSinh() {
    }

    public int getMaChuanBi() {
        return maChuanBi;
    }

    public void setMaChuanBi(int maChuanBi) {
        this.maChuanBi = maChuanBi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNguoiCan() {
        return nguoiCan;
    }

    public void setNguoiCan(String nguoiCan) {
        this.nguoiCan = nguoiCan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
