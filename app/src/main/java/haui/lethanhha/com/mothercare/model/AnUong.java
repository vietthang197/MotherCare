package haui.lethanhha.com.mothercare.model;

public class AnUong {
    private int imgMon;

    private int imgAllow;

    private String tenMon;

    private String type;

    public AnUong(int imgMon, int imgAllow, String tenMon, String type) {
        this.imgMon = imgMon;
        this.imgAllow = imgAllow;
        this.tenMon = tenMon;
        this.type = type;
    }

    public AnUong() {
    }

    public int getImgMon() {
        return imgMon;
    }

    public void setImgMon(int imgMon) {
        this.imgMon = imgMon;
    }

    public int getImgAllow() {
        return imgAllow;
    }

    public void setImgAllow(int imgAllow) {
        this.imgAllow = imgAllow;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
