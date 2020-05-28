package com.example.tugasproject3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class Proses extends AppCompatActivity {

    TextView jenisBangun, hasilBangun;
    TextInputLayout nilai1Inputan, nilai2Inputan, nilai3Inputan;
    ImageView gambarjenisBangun;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses);

        jenisBangun =  findViewById(R.id.jenisBangun);
        hasilBangun =  findViewById(R.id.hasilLuas);
        gambarjenisBangun =  findViewById(R.id.gambarJenisBangun);
        nilai1Inputan =  findViewById(R.id.nilai1Inputan);
        nilai2Inputan =  findViewById(R.id.nilai2Inputan);
        nilai3Inputan =  findViewById(R.id.nilai3Inputan);


        i = getIntent();

        prosesUbahAktifitas(i);
    }

    private void prosesUbahAktifitas(Intent i) {
        switch (i.getStringExtra("Bangun Ruang")){
            case "Kubus":
                getSupportActionBar().setTitle("Hitung Volume Kubus");
                jenisBangun.setText("Kubus");
                gambarjenisBangun.setImageResource(R.drawable.kubus);
                nilai1Inputan.setHint("Sisi");
                break;
            case "Balok":
                getSupportActionBar().setTitle("Hitung Volume Balok");
                jenisBangun.setText("Balok");
                gambarjenisBangun.setImageResource(R.drawable.balok);
                nilai1Inputan.setHint("Panjang");
                nilai2Inputan.setHint("Lebar");
                nilai2Inputan.setVisibility(View.VISIBLE);
                nilai3Inputan.setHint("Tinggi");
                nilai3Inputan.setVisibility(View.VISIBLE);
                break;
            case "Kerucut":
                getSupportActionBar().setTitle("Hitung Volume Limas");
                jenisBangun.setText("Kerucut");
                gambarjenisBangun.setImageResource(R.drawable.limas);
                nilai1Inputan.setHint("Jari - Jari");
                nilai2Inputan.setHint("Tinggi");
                nilai2Inputan.setVisibility(View.VISIBLE);
                break;
            case "Tabung":
                getSupportActionBar().setTitle("Hitung Volume Tabung");
                jenisBangun.setText("Tabung");
                gambarjenisBangun.setImageResource(R.drawable.tabung);
                nilai1Inputan.setHint("Diagonal Satu");
                nilai2Inputan.setHint("Diagonal Dua");
                nilai3Inputan.setHint("Tinggi");
                break;
        }
    }

    public void prosesHitung(View view) {
        double nilai1, nilai2, nilai3;

        String s_nilai1 = nilai1Inputan.getEditText().getText().toString();
        String s_nilai2 = nilai2Inputan.getEditText().getText().toString();
        String s_nilai3 = nilai3Inputan.getEditText().getText().toString();

        if (!s_nilai1.equals("") || !s_nilai2.equals("") || !s_nilai3.equals("")){
            nilai1 = Double.parseDouble(s_nilai1);
            nilai2 = Double.parseDouble(s_nilai2);
            nilai3 = Double.parseDouble(s_nilai3);

            switch (i.getStringExtra("Bangun Ruang")){
                case "Kubus":
                    double hasilk = nilai1*nilai1*nilai1;
                    hasilBangun.setText("Luas Kubus " + hasilk);
                    break;
                case "Balok":
                    double hasilb = nilai1*nilai2*nilai3;
                    hasilBangun.setText("Luas Balok " + hasilb);
                    break;
                case "Kerucut":
                    double hasilkr = (1/3*3.14*nilai1*nilai1)*nilai2;
                    hasilBangun.setText("Luas Limas " + hasilkr);
                    break;
                case "Tabung":
                  //  hasilBangun.setText("Luas Tabung " + hasil);
                    break;
            }
        }else{
            Toast.makeText(Proses.this, "Wajib Isi form!", Toast.LENGTH_SHORT).show();
        }


    }
}
