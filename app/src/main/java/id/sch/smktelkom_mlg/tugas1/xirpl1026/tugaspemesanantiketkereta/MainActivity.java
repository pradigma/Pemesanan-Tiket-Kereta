package id.sch.smktelkom_mlg.tugas1.xirpl1026.tugaspemesanantiketkereta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText etNama, etTahun, etAsal, etTujuan, etTanggal, etPukul;
    // RadioButton rbLk,rbPr;
    RadioGroup rgStatus;
    Spinner sppnp;
    Button bOK;
    CheckBox cbEk, cbEks, cbBs;
    TextView tvHasil;
    String nama;
    int tahun;
    int usia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        etAsal = (EditText) findViewById(R.id.editTextAsal);
        etTujuan = (EditText) findViewById(R.id.editTextTujuan);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        etPukul = (EditText) findViewById(R.id.editTextPukul);
        /*rbLk = (RadioButton) findViewById(R.id.radioButtonLaki);
        rbPr = (RadioButton) findViewById(R.id.radioButtonPr);*/
        rgStatus = (RadioGroup) findViewById(R.id.RadioGroupJK);
        cbEk = (CheckBox) findViewById(R.id.checkBoxEk);
        cbEks = (CheckBox) findViewById(R.id.checkBoxEks);
        cbBs = (CheckBox) findViewById(R.id.checkBoxBs);
        cbEks.setOnCheckedChangeListener(this);
        cbEk.setOnCheckedChangeListener(this);
        cbBs.setOnCheckedChangeListener(this);
        sppnp = (Spinner) findViewById(R.id.spinnerpnp);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);


        bOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
            }

        });



    }

    private void doClick() {
        String hasil = "";
        String jsn = "";

        if (cbEk.isChecked()) jsn += cbEk.getText() + "\n";
        if (cbEks.isChecked()) jsn += cbEks.getText() + "\n";
        if (cbBs.isChecked()) jsn += cbBs.getText() + "\n";


        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        /*if(rbLk.isChecked()){
            hasil = rbLk.getText().toString();
        }
        else if(rbPr.isChecked()){
            hasil = rbPr.getText().toString();
        }*/

        if (hasil == "") {
            tvHasil.setText("Belum memilih jenis kelamin");
        } else {
            tvHasil.setText("Nama anda : " + nama + "\nDengan umur : " + usia + "\nJenis Kelamin anda : " + hasil + "\nKelas yang anda pilih : " + "\n" + jsn +
                    "Penumpang :" + sppnp.getSelectedItem().toString() + "\nAsal Keberangkatan : " + etAsal.getText().toString() + "\nTujuan Kota : " + etTujuan.getText().toString()
                    + "\nWaktu Keberangkatan : " + etTanggal.getText().toString() + " " + etPukul.getText().toString() + "WIB");
        }
    }

    private void doProcess() {
        if (isValid()) {

            nama = etNama.getText().toString();
            tahun = Integer.parseInt(etTahun.getText().toString());
            usia = 2016 - tahun;
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String asal = etAsal.getText().toString();
        String tujuan = etTujuan.getText().toString();
        String tanggal = etTanggal.getText().toString();
        String pukul = etPukul.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Kelahiran belum diisi");
        }

        if (asal.isEmpty()) {
            etAsal.setError("Asal Keberangkatan belum diisi");
        }

        if (tujuan.isEmpty()) {
            etTujuan.setError("Tujuan belum diisi");
        }

        if (tanggal.isEmpty()) {
            etTanggal.setError("Tanggal belum diisi");
        }

        if (pukul.isEmpty()) {
            etPukul.setError("Pukul atau jam keberangkatan belum diisi");
        }

        return valid;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
