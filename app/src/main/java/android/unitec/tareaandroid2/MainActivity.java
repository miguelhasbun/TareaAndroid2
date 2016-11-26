package android.unitec.tareaandroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etmonto, etaños ;
    final static String TYPE = "tipo";
    final static String AMOUNT = "monto";
    final static String YEAR = "año";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etmonto = (EditText) findViewById(R.id.etmonto);
        etaños = (EditText) findViewById(R.id.etaños);
    }

        private boolean validarMonto() {
            double monto = 0;
            int años = 0;
            monto = Double.parseDouble(etmonto.getText().toString());
            años = Integer.parseInt(etaños.getText().toString());
    //LA CONDICIÓN ESTÁ BIEN PERO POR ALGUNA RAZÓN TIRA CANTIDAD NO ADMITIDAS Y EL OTRO MSJ DE ABAJO REVISAR
            if (monto<5000 || años<=0){
                Toast.makeText(this, "Años deben ser mayor que 0 y monto mayor que 5000", Toast.LENGTH_LONG).show();
                return false;
            }else{
                return true;
            }
        }

        public void btnCar(View view){
            if (validarMonto()) {
                double monto = 0;
                int años = 0;
                try {
                    monto = Double.parseDouble(etmonto.getText().toString());
                    años = Integer.parseInt(etaños.getText().toString());
                } catch(RuntimeException e) {
                    Toast.makeText(this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(this, INFORMATIONACTIVITY.class);
                i.putExtra(TYPE, "Auto");
                i.putExtra(AMOUNT, monto);
                i.putExtra(YEAR, años);
                startActivity(i);
                Toast.makeText(this, "Prestamo Auto calculado en "+años+" años", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "No se le pudo brindar el préstamo solicitado", Toast.LENGTH_SHORT).show();
            }

        public void btnVivienda (View view){
            if (validarMonto()) {
                double monto = 0;
                int años = 0;
                try {
                    monto = Double.parseDouble(etmonto.getText().toString());
                    años = Integer.parseInt(etaños.getText().toString());
                } catch(RuntimeException e) {
                    Toast.makeText(this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(this, INFORMATIONACTIVITY.class);
                i.putExtra(TYPE, "Vivienda");
                i.putExtra(AMOUNT, monto);
                i.putExtra(YEAR, años);
                startActivity(i);
                Toast.makeText(this, "Prestamo Vivienda calculado en "+años+" años", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "No se le pudo brindar el préstamo solicitado", Toast.LENGTH_SHORT).show();
        }

        public void btnPersonal(View view){

            if (validarMonto()) {
                double monto = 0;
                int años = 0;
                try {
                    monto = Double.parseDouble(etmonto.getText().toString());
                    años = Integer.parseInt(etaños.getText().toString());
                } catch(RuntimeException e) {
                    Toast.makeText(this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(this, INFORMATIONACTIVITY.class);
                i.putExtra(TYPE, "Personal");
                i.putExtra(AMOUNT, monto);
                i.putExtra(YEAR, años);
                startActivity(i);
                Toast.makeText(this, "Prestamo Personal calculado en "+años+" años", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "No se le pudo brindar el préstamo solicitado", Toast.LENGTH_SHORT).show();
        }





}








