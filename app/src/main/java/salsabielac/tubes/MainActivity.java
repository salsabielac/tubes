package salsabielac.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ton1 = (Button) findViewById(R.id.list_penyewa);
        Button ton2 = (Button) findViewById(R.id.lihat_buku);
        Button ton3 = (Button) findViewById(R.id.lihat_penerbit);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                Intent inte = new Intent(MainActivity.this, Penyewa.class);
                startActivity(inte);
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                Intent inte2 = new Intent(MainActivity.this, Buku.class);
                startActivity(inte2);
            }
        });
        ton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                Intent inte3 = new Intent(MainActivity.this, Penerbit.class);
                startActivity(inte3);
            }
        });
    }
}
