package id.sch.smktelkom_mlg.tugas1.xirpl1026.tugaspemesanantiketkereta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etTahun, etAsal, etTujuan, etTanggal, etPukul;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTujuan = (EditText) findViewById(R.id.editTextTujuan);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        etPukul = (EditText) findViewById(R.id.editTextPukul);
        bOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                doProcess();

            }

        });
        tvHasil = (TextView) findViewById(R.id.textViewHasil);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void doProcess() {
        if (isValid()) {

            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2016 - tahun;
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Kelahiran belum diisi");
        }
        return valid;
    }


}
