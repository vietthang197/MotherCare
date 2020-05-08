package haui.lethanhha.com.mothercare.model;

public class ThaiKy {
    private int maTuan;

    private String tenTuan;

    private String iconTuan;

    private String hinhAnhTuan;

    private String thongTinBe;

    private String thongTinMe;

    private String meoTuan;

    public ThaiKy() {
    }

    public ThaiKy(int maTuan, String tenTuan, String iconTuan, String hinhAnhTuan, String thongTinBe, String thongTinMe, String meoTuan) {
        this.maTuan = maTuan;
        this.tenTuan = tenTuan;
        this.iconTuan = iconTuan;
        this.hinhAnhTuan = hinhAnhTuan;
        this.thongTinBe = thongTinBe;
        this.thongTinMe = thongTinMe;
        this.meoTuan = meoTuan;
    }

    public int getMaTuan() {
        return maTuan;
    }

    public void setMaTuan(int maTuan) {
        this.maTuan = maTuan;
    }

    public String getTenTuan() {
        return tenTuan;
    }

    public void setTenTuan(String tenTuan) {
        this.tenTuan = tenTuan;
    }

    public String getIconTuan() {
        return iconTuan;
    }

    public void setIconTuan(String iconTuan) {
        this.iconTuan = iconTuan;
    }

    public String getHinhAnhTuan() {
        return hinhAnhTuan;
    }

    public void setHinhAnhTuan(String hinhAnhTuan) {
        this.hinhAnhTuan = hinhAnhTuan;
    }

    public String getThongTinBe() {
        return thongTinBe;
    }

    public void setThongTinBe(String thongTinBe) {
        this.thongTinBe = thongTinBe;
    }

    public String getThongTinMe() {
        return thongTinMe;
    }

    public void setThongTinMe(String thongTinMe) {
        this.thongTinMe = thongTinMe;
    }

    public String getMeoTuan() {
        return meoTuan;
    }

    public void setMeoTuan(String meoTuan) {
        this.meoTuan = meoTuan;
    }
}
