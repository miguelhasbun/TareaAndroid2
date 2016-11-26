package android.unitec.tareaandroid2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class INFORMATIONACTIVITY extends AppCompatActivity {
    private TextView tvmonto, tvaño, tvprestamo, tvMontoAjustado, tvIntereses, tvTotal, tvCuota, tvFecha;
    private String prestamo;
    public double tasa= 0.35;
    private double monto, ajustado, intereses, montotota, cuota;
    private static Calendar fecha=Calendar.getInstance();;
    private int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationactivity);
        //FALTA QUE APAREZCA EL TOAST QUE DICE EL TIPO Y LA CANTIDAD DE AÑOS.
        tvprestamo = (TextView)findViewById(R.id.tvPrestamo);
        tvmonto = (TextView)findViewById(R.id.tvmonto);
        tvaño = (TextView)findViewById(R.id.tvaño);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvMontoAjustado = (TextView)findViewById(R.id.tvMontoAjustado);
        tvIntereses = (TextView)findViewById(R.id.tvIntereses);
        tvTotal = (TextView)findViewById(R.id.tvTotal);
        tvCuota = (TextView)findViewById(R.id.tvCuota);


        Intent i = getIntent();
        prestamo = i.getStringExtra(MainActivity.TYPE);
        monto = i.getDoubleExtra(MainActivity.AMOUNT, 0.0);
        year = i.getIntExtra(MainActivity.YEAR, 0);

        if (prestamo.equals("Auto")) {
            ajustado = monto * 1.3;
            tasa = 0.25;
        } else if (prestamo.equals("Vivienda")) {
            ajustado = monto + 30000;
            tasa = 0.1;
        }
        intereses = tasa * monto * year;
        montotota = monto + ajustado + intereses;
        cuota = montotota / (12*year);
        fecha.set(Calendar.YEAR, +year);

        tvprestamo.setText(prestamo);
        tvmonto.setText("Lps. " + monto);
        tvaño.setText(year + " años");
        tvMontoAjustado.setText("Lps. " + ajustado);
        tvIntereses.setText("Lps. " + intereses);
        tvTotal.setText("Lps. " + montotota);
        tvCuota.setText("Lps. " + cuota);
    //FALTA IMPRIMIR LA FECHA FIN DE PAGO.
    }

    public void COTIZAR(View view){
        Intent URL = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.banpais.hn/"));
        startActivity(URL);
    }
}
