package haui.lethanhha.com.mothercare.model;

public class DanhMuc {

    private int maDanhMuc;

    private String tenDanhMuc;

    private String tenHinhAnh;

    public DanhMuc() {
    }

    public DanhMuc(int maDanhMuc, String tenDanhMuc, String tenHinhAnh) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.tenHinhAnh = tenHinhAnh;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
}
