package haui.lethanhha.com.mothercare.model;

public class DanhMuc {

    private int anhDanhMuc;

    private String tenDanhMuc;

    private int id;

    public DanhMuc() {
    }

    public DanhMuc(int id, int anhDanhMuc, String tenDanhMuc) {
        this.id = id;
        this.anhDanhMuc = anhDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getAnhDanhMuc() {
        return anhDanhMuc;
    }

    public void setAnhDanhMuc(int anhDanhMuc) {
        this.anhDanhMuc = anhDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
