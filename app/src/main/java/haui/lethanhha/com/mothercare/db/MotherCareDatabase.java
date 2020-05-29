package haui.lethanhha.com.mothercare.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import haui.lethanhha.com.mothercare.model.AnUong;
import haui.lethanhha.com.mothercare.model.CanMuaCanLam;
import haui.lethanhha.com.mothercare.model.DanhMuc;
import haui.lethanhha.com.mothercare.model.KhamThai;
import haui.lethanhha.com.mothercare.model.LapLich;
import haui.lethanhha.com.mothercare.model.TenBe;
import haui.lethanhha.com.mothercare.model.TiemPhong;
import haui.lethanhha.com.mothercare.model.Truyen;

public class MotherCareDatabase {

    public static final String PATH =
            Environment.getDataDirectory().getAbsolutePath()
                    + "/data/thangducanh.tagroup.com.mothercare/database/";

    public static final String DB_NAME = "mothercaredb.sqlite";

    // table an uong
    public static final String TABLE_AN_UONG = "AnUong";
    public static final String TBL_ANUONG_MaAnUong = "MaAnUong";
    public static final String TBL_ANUONG_TEN = "TenAnUong";
    public static final String TBL_ANUONG_Icon= "Icon";
    public static final String TBL_ANUONG_IMAGE = "HinhAnh";
    public static final String TBL_ANUONG_Noidung = "NoiDung";
    public static final String TBL_ANUONG_TenLoai = "TenLoai";
    public static final String TBL_ANUONG_NenKhongNen = "NenKhongNen";

    // table danh muc
    public static final String TABLE_DANH_MUC = "DanhMuc";
    public static final String TBL_DANHMUC_MaDanhMuc = "MaDanhMuc";
    public static final String TBL_DANHMUC_TenDanhmuc = "TenDanhMuc";
    public static final String TBL_DANHMUC_Tenhinhanh = "TenHinhAnh";

    // table tiem phong
    public static final String TABLE_TIEMPHONG = "TiemPhong";
    public static final String TBL_TIEMPHONG_Matiemphong = "MaTiemPhong";
    public static final String TBL_TIEMPHONG_tentiemphong = "TenTiemPhong";
    public static final String TBL_TIEMPHONG_noidung = "NoiDung";
    public static final String TBL_TIEMPHONG_Nguoitiem = "NguoiTiem";

    // table can mua can lam
    public static final String TABLE_CANMUACANLAM = "CanMuaCanLam";
    public static final String TBL_CANMUACANLAM_Macan= "MaCan";
    public static final String TBL_CANMUACANLAM_Noidung = "NoiDung";

    // table dat ten cho be
    public static final String TABLE_TENBE= "TenBe";
    public static final String TBL_MaTen= "MaTen";
    public static final String TBL_Tenbe= "TenBe";
    public static final String TBL_ynghia= "YNghia";
    public static final String TBL_tenkhac= "TenKhac";
    public static final String TBL_gioitinh= "GioiTinh";

    // table doc truyen
    public static final String TABLE_TRUYEN = "Truyen";
    public static final String TBL_MaTruyen = "MaTruyen";
    public static final String TBL_TenTruyen = "TenTruyen";
    public static final String TBL_NoiDung = "NoiDung";
    public static final String TBL_MaLoai = "MaLoai";

    // table kham thai
    public static final String TABLE_KHAMTHAI = "KhamThai";
    public static final String TBL_Makhamthai = "MaKhamThai";
    public static final String TBL_Lankham= "LanKham";
    public static final String TBL_khamthai_noidung = "NoiDung";

    private Context context;
    private SQLiteDatabase database;

    public MotherCareDatabase(Context context) {
        this.context = context;
        copyDatabaseToProject();
    }

    private void copyDatabaseToProject() {
        System.out.println(PATH);
        try {
            File file = new File(PATH + DB_NAME);
            if (file.exists()) {
                return;
            }
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = context.getAssets().open(DB_NAME);
            byte[] b = new byte[1024];
            int count = inputStream.read(b);
            while (count!=-1){
                outputStream.write(b,0,count);
                count = inputStream.read(b);
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void openDatabase(){
        database = context.openOrCreateDatabase(PATH + DB_NAME,Context.MODE_PRIVATE,null);
    }
    public void closeDatabase(){
        database.close();
    }

    public List<AnUong> getListAnUong(String type) {
        List<AnUong> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_AN_UONG + " WHERE TenLoai = ?",new String[]{type});
        int indexId =  cursor.getColumnIndex(TBL_ANUONG_MaAnUong);
        int indexTen =  cursor.getColumnIndex(TBL_ANUONG_TEN);
        int indexIcon=  cursor.getColumnIndex(TBL_ANUONG_Icon);
        int indexImage=  cursor.getColumnIndex(TBL_ANUONG_IMAGE);
        int indexNoiDung = cursor.getColumnIndex(TBL_ANUONG_Noidung);
        int indexTenLoai = cursor.getColumnIndex(TBL_ANUONG_TenLoai);
        int indexNenKhongNen = cursor.getColumnIndex(TBL_ANUONG_NenKhongNen);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(indexId);
            String ten = cursor.getString(indexTen);
            String icon = cursor.getString(indexNoiDung);
            String image = cursor.getString(indexImage);
            String noiDung = cursor.getString(indexNoiDung);
            String tenLoai = cursor.getString(indexTenLoai);
            String nenKhongNen = cursor.getString(indexNenKhongNen);

            AnUong tc = new AnUong(id, ten, icon, image, noiDung, tenLoai, nenKhongNen);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

    public List<DanhMuc> getListDanhMuc() {
        List<DanhMuc> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_DANH_MUC, new String[]{});
        int indexId =  cursor.getColumnIndex(TBL_DANHMUC_MaDanhMuc);
        int indexTenDanhMuc =  cursor.getColumnIndex(TBL_DANHMUC_TenDanhmuc);
        int indexTenhinhanh =  cursor.getColumnIndex(TBL_DANHMUC_Tenhinhanh);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(indexId);
            String ten = cursor.getString(indexTenDanhMuc);
            String image = cursor.getString(indexTenhinhanh);

            DanhMuc tc = new DanhMuc(id, ten, image);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

    public List<TiemPhong> getListTiemPhong(String nguoitiem) {
        List<TiemPhong> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_TIEMPHONG + " WHERE NguoiTiem = ?", new String[]{nguoitiem});
        int indexId =  cursor.getColumnIndex(TBL_TIEMPHONG_Matiemphong);
        int indexTenTiemPhong =  cursor.getColumnIndex(TBL_TIEMPHONG_tentiemphong);
        int indexNoiDung =  cursor.getColumnIndex(TBL_TIEMPHONG_noidung);
        int indexNguoiTiem =  cursor.getColumnIndex(TBL_TIEMPHONG_Nguoitiem);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(indexId);
            String ten = cursor.getString(indexTenTiemPhong);
            String noidung = cursor.getString(indexNoiDung);
            String nguoitiems = cursor.getString(indexNguoiTiem);

            TiemPhong tc = new TiemPhong(id, ten, noidung, nguoitiems);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }


    public List<CanMuaCanLam> getListCanMuaCanLam() {
        List<CanMuaCanLam> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_CANMUACANLAM , new String[]{});
        int indexId =  cursor.getColumnIndex(TBL_CANMUACANLAM_Macan);
        int idxNoiDung =  cursor.getColumnIndex(TBL_CANMUACANLAM_Noidung);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(indexId);
            String noidung = cursor.getString(idxNoiDung);

            CanMuaCanLam tc = new CanMuaCanLam(id, noidung);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

    public List<TenBe> getListTenbe(String type) {
        List<TenBe> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_TENBE + " WHERE GioiTinh = ?", new String[]{type});
        int indexId =  cursor.getColumnIndex(TBL_MaTen);
        int idTenbe =  cursor.getColumnIndex(TBL_Tenbe);
        int idYnghia =  cursor.getColumnIndex(TBL_ynghia);
        int idTenkhac =  cursor.getColumnIndex(TBL_tenkhac);
        int idGioitinh =  cursor.getColumnIndex(TBL_gioitinh);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(indexId);
            String ten = cursor.getString(idTenbe);
            String ynghia = cursor.getString(idYnghia);
            String tenkhac = cursor.getString(idTenkhac);
            String gioitinh = cursor.getString(idGioitinh);

            TenBe tc = new TenBe(id, ten, ynghia, tenkhac, gioitinh);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

    public List<Truyen> getListTruyen() {
        List<Truyen> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_TRUYEN , new String[]{});
        int idxId =  cursor.getColumnIndex(TBL_MaTruyen);
        int idTen =  cursor.getColumnIndex(TBL_TenTruyen);
        int idNoiDung =  cursor.getColumnIndex(TBL_NoiDung);
        int idMaLoai =  cursor.getColumnIndex(TBL_MaLoai);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(idxId);
            String ten = cursor.getString(idTen);
            String noidung = cursor.getString(idNoiDung);
            int maloai = cursor.getInt(idMaLoai);

            Truyen tc = new Truyen(id, ten, noidung, maloai);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

    public List<KhamThai> getListKhamThai() {
        List<KhamThai> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_KHAMTHAI , new String[]{});
        int idxId =  cursor.getColumnIndex(TBL_Makhamthai);
        int idLanKham =  cursor.getColumnIndex(TBL_Lankham);
        int idNoiDung =  cursor.getColumnIndex(TBL_khamthai_noidung);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(idxId);
            String lanKham = cursor.getString(idLanKham);
            String noidung = cursor.getString(idNoiDung);

            KhamThai tc = new KhamThai(id, lanKham, noidung);
            arr.add(tc);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

    public int themLapLich(LapLich lapLich) {
        try {
            openDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("NgayNhacNho", lapLich.getNgayNhacNho());
            contentValues.put("GioNhacNho", lapLich.getGioNhacNho());
            contentValues.put("GhiChu", lapLich.getGhiChu());
            contentValues.put("TenLoai", lapLich.getTenLoai());
            contentValues.put("TrangThai", lapLich.getTrangThai());
            int idInserted = (int)database.insert("LapLich", null, contentValues);
//            database.execSQL("INSERT INTO LapLich(NgayNhacNho, GioNhacNho, GhiChu, TenLoai, TrangThai) VALUES(?,?,?,?,?)", new String[]{lapLich.getNgayNhacNho(),
//            lapLich.getGioNhacNho(), lapLich.getGhiChu(), lapLich.getTenLoai(), lapLich.getTrangThai() + ""});
            return idInserted;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeDatabase();
        }
    }

    public boolean deleteLapLich(int maLapLich) {
       try {
           openDatabase();
           database.execSQL("DELETE FROM LapLich Where MaLapLich = ?", new String[]{maLapLich + ""});
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       } finally {
           closeDatabase();
       }
    }

    public List<LapLich> getListLapLich() {
        List<LapLich> arr = new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM LapLich", new String[]{});
        int idxId =  cursor.getColumnIndex("MaLapLich");
        int idNgayNhacNho =  cursor.getColumnIndex("NgayNhacNho");
        int idGioNhacNho =  cursor.getColumnIndex("GioNhacNho");
        int idGhiChu = cursor.getColumnIndex("GhiChu");
        int idTenLoai = cursor.getColumnIndex("TenLoai");
        int idTrangThai = cursor.getColumnIndex("TrangThai");

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(idxId);
            String ngayNhacNho = cursor.getString(idNgayNhacNho);
            String gioNhacNho = cursor.getString(idGioNhacNho);
            String ghiChu = cursor.getString(idGhiChu);
            String tenLoai = cursor.getString(idTenLoai);
            int trangThai = cursor.getInt(idTrangThai);

           LapLich lapLich = new LapLich(id, ngayNhacNho, gioNhacNho, ghiChu, tenLoai, trangThai);
           arr.add(lapLich);
            cursor.moveToNext();
        }
        closeDatabase();
        return arr;
    }

//
//    public boolean insertContactChanged(String phoneId, String name, String newPhone, String oldPhone) {
//        try {
//            String query = "INSERT INTO " + TABLE_NAME +
//                    "(" +PHONE_ID + ", " + NAME + ", " + NEW_PHONE + ", " + OLD_PHONE + ") VALUES("
//                    + " '" + phoneId +"' , '" + name + "' , '" + newPhone +"', '" + oldPhone + "')";
//            Log.d("query", query);
//            database.execSQL(query);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
