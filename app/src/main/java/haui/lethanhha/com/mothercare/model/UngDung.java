package haui.lethanhha.com.mothercare.model;

public class UngDung {
    private int maUngDung;

    private String tenUngDung;

    private String iconUngDung;

    private String loaiUngDung;

    private String linkDown;

    public UngDung(int maUngDung, String tenUngDung, String iconUngDung, String loaiUngDung, String linkDown) {
        this.maUngDung = maUngDung;
        this.tenUngDung = tenUngDung;
        this.iconUngDung = iconUngDung;
        this.loaiUngDung = loaiUngDung;
        this.linkDown = linkDown;
    }

    public UngDung() {
    }

    public int getMaUngDung() {
        return maUngDung;
    }

    public void setMaUngDung(int maUngDung) {
        this.maUngDung = maUngDung;
    }

    public String getTenUngDung() {
        return tenUngDung;
    }

    public void setTenUngDung(String tenUngDung) {
        this.tenUngDung = tenUngDung;
    }

    public String getIconUngDung() {
        return iconUngDung;
    }

    public void setIconUngDung(String iconUngDung) {
        this.iconUngDung = iconUngDung;
    }

    public String getLoaiUngDung() {
        return loaiUngDung;
    }

    public void setLoaiUngDung(String loaiUngDung) {
        this.loaiUngDung = loaiUngDung;
    }

    public String getLinkDown() {
        return linkDown;
    }

    public void setLinkDown(String linkDown) {
        this.linkDown = linkDown;
    }
}
