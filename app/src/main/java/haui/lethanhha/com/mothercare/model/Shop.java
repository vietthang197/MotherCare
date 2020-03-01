package haui.lethanhha.com.mothercare.model;

public class Shop {
    private int id;

    private int anhShop;

    private String title;

    private String money;

    private String urlWeb;

    public Shop() {
    }

    public Shop(int id, int anhShop, String title, String money, String urlWeb) {
        this.id = id;
        this.anhShop = anhShop;
        this.title = title;
        this.money = money;
        this.urlWeb = urlWeb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getAnhShop() {
        return anhShop;
    }

    public void setAnhShop(int anhShop) {
        this.anhShop = anhShop;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }
}
