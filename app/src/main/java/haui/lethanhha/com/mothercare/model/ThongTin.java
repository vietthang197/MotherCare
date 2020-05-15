package haui.lethanhha.com.mothercare.model;

public class ThongTin {
    private String tenMe;
    private float chieuCao;
    private float canNang;
    private float chieuCaoTuCung;
    private float chuViVongBung;
    private float canNangBe;

    public ThongTin() {
    }

    public ThongTin(String tenMe, float chieuCao, float canNang, float chieuCaoTuCung, float chuViVongBung, float canNangBe) {
        this.tenMe = tenMe;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.chieuCaoTuCung = chieuCaoTuCung;
        this.chuViVongBung = chuViVongBung;
        this.canNangBe = canNangBe;
    }

    public String getTenMe() {
        return tenMe;
    }

    public void setTenMe(String tenMe) {
        this.tenMe = tenMe;
    }

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public float getCanNang() {
        return canNang;
    }

    public void setCanNang(float canNang) {
        this.canNang = canNang;
    }

    public float getChieuCaoTuCung() {
        return chieuCaoTuCung;
    }

    public void setChieuCaoTuCung(float chieuCaoTuCung) {
        this.chieuCaoTuCung = chieuCaoTuCung;
    }

    public float getChuViVongBung() {
        return chuViVongBung;
    }

    public void setChuViVongBung(float chuViVongBung) {
        this.chuViVongBung = chuViVongBung;
    }

    public float getCanNangBe() {
        return canNangBe;
    }

    public void setCanNangBe(float canNangBe) {
        this.canNangBe = ((this.chieuCaoTuCung+chuViVongBung)*100)/4;
    }
}
