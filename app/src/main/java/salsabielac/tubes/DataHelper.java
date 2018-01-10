package salsabielac.tubes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by salsabiela on 1/10/2018.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "perpustakaan.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        String sql = "create table buku(id_buku integer primary key,judul text null, harga text null,id_penerbit integer not null ,foreign key(id_penerbit) references penerbit(id_penerbit));";
        Log.d("Data Buku", "onCreate: " + sql);
        db.execSQL(sql);

        String sql2 = "create table penerbit(id_penerbit integer primary key,nama_penerbit text);";
        Log.d("Data Buku", "onCreate: " + sql);
        db.execSQL(sql2);

        String sql5 ="create table penyewa(id integer primary key autoincrement, nama_penyewa text, tgl text null, id_buku integer not null, foreign key(id_buku) references buku(id_buku));";
        Log.d("Data Peminjam","onCreate" + sql5);
        db.execSQL(sql5);

        String sql3 = "INSERT INTO penerbit(id_penerbit, nama_penerbit)VALUES ('1', 'erlangga'),('2', 'gramedia');";
        db.execSQL(sql3);
        String sql4 = "INSERT INTO buku(id_buku,judul,harga,id_penerbit)VALUES ('1', 'koala kumal','221222','1'),('2', 'kambing hitam','121212','2');";
        db.execSQL(sql4);

        String sql6 = "INSERT INTO penyewa(id,nama_penyewa,tgl,id_buku)VALUES ('1', 'noviadhini','221222','1'),('2', 'Anggi','121212','2'),('3', 'Ivan Ngganteng','212','3');";
        db.execSQL(sql6);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)
    {
// TODO Auto-generated method stub
    }
}
