package salsabielac.tubes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePenyewa extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_penyewa);


        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1); //id buku
        text2 = (EditText) findViewById(R.id.editText2); //judul
        text3 = (EditText) findViewById(R.id.editText3); //tanggal
        text4 = (EditText) findViewById(R.id.editText4); //id penerbit
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penyewa WHERE nama_penyewa = '" +
                getIntent().getStringExtra("nama_penyewa") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
        }

        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update penyewa set nama_penyewa='"+
                        text2.getText().toString() +"', tgl='" +
                        text3.getText().toString()+"', id_buku='"+
                        text4.getText().toString() + "' where id='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil",
                        Toast.LENGTH_LONG).show();
                Penyewa.pe.RefreshList();
                finish();
            }
        });
    }
}
