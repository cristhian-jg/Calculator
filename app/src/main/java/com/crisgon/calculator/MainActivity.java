package com.crisgon.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvPantalla;
    private double resultado;
    private Button btCero, btUno, btDos,
            btTres, btCuatro, btCinco,
            btSeis, btSiete, btOcho, btNueve,
            btSuma, btResta, btMultiplica,
            btDivide, btBorrar, btPunto, btIgual, btMasMenos, btPorcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPantalla = findViewById(R.id.tvPantalla);
        btBorrar = findViewById(R.id.btBorrar);
        btMasMenos = findViewById(R.id.btMasMenos);
        btPorcentaje = findViewById(R.id.btPorcentaje);
        btSuma = findViewById(R.id.btSuma);
        btResta = findViewById(R.id.btResta);
        btMultiplica = findViewById(R.id.btMultiplica);
        btDivide = findViewById(R.id.btDivide);
        btPunto = findViewById(R.id.btPunto);
        btIgual = findViewById(R.id.btIgual);
        btCero = findViewById(R.id.btCero);
        btUno = findViewById(R.id.btUno);
        btDos = findViewById(R.id.btDos);
        btTres = findViewById(R.id.btTres);
        btCuatro = findViewById(R.id.btCuatro);
        btCinco = findViewById(R.id.btCinco);
        btSeis = findViewById(R.id.btSeis);
        btSiete = findViewById(R.id.btSiete);
        btOcho = findViewById(R.id.btOcho);
        btNueve = findViewById(R.id.btNueve);

        View.OnClickListener listener = new View.OnClickListener() {

            private Calculadora calculadora = new Calculadora();
            private StringBuilder numero = new StringBuilder();
            private String operador, auxiliar;

            @Override
            public void onClick(View view) {
                int id = view.getId();

                switch (id) {
                    case R.id.btBorrar:
                        numero = new StringBuilder();
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btMasMenos:
                        if (numero.length() != 0) {
                            String parsedToString = numero.toString();
                            int parsedToInt = Integer.parseInt(parsedToString);

                            numero = new StringBuilder();
                            numero.append(calculadora.cambiarMasMenos(parsedToInt));
                            tvPantalla.setText(numero);
                        }
                        break;
                    case R.id.btPorcentaje:
                        if (numero.length() != 0) {
                            String parsedToString = numero.toString();
                            double parsedToDouble= Double.parseDouble(parsedToString);

                            numero = new StringBuilder();
                            numero.append(calculadora.porcentaje(parsedToDouble));
                            tvPantalla.setText(numero);
                        }
                        break;
                    case R.id.btPunto:
                        numero.append(".");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btCero:
                        numero.append("0");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btUno:
                        numero.append("1");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btDos:
                        numero.append("2");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btTres:
                        numero.append("3");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btCuatro:
                        numero.append("4");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btCinco:
                        numero.append("5");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btSeis:
                        numero.append("6");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btSiete:
                        numero.append("7");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btOcho:
                        numero.append("8");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btNueve:
                        numero.append("9");
                        tvPantalla.setText(numero);
                        break;
                    case R.id.btSuma:
                        auxiliar = numero.toString();
                        operador = "+";
                        tvPantalla.setText("");
                        numero = new StringBuilder();
                        break;
                    case R.id.btResta:
                        auxiliar = numero.toString();
                        operador = "-";
                        tvPantalla.setText("");
                        numero = new StringBuilder();
                        break;
                    case R.id.btMultiplica:
                        auxiliar = numero.toString();
                        operador = "×";
                        tvPantalla.setText("");
                        numero = new StringBuilder();
                        break;
                    case R.id.btDivide:
                        auxiliar = numero.toString();
                        operador = "÷";
                        tvPantalla.setText("");
                        numero = new StringBuilder();
                        break;
                    case R.id.btIgual:
                        //Comprobamos si realmente se ha introducido un numero
                        if (numero.length() != 0) {
                            double auxiliarParser = Double.parseDouble(auxiliar);
                            double numeroParser = Double.parseDouble(numero.toString());

                            switch (operador) {
                                case "+":
                                    resultado = calculadora.suma(auxiliarParser, numeroParser);
                                    tvPantalla.setText(String.valueOf(resultado));
                                    numero = new StringBuilder();
                                    numero.append(resultado);
                                    break;
                                case "-":
                                    resultado = calculadora.resta(auxiliarParser, numeroParser);
                                    tvPantalla.setText(String.valueOf(resultado));
                                    numero = new StringBuilder();
                                    numero.append(resultado);
                                    break;
                                case "×":
                                    resultado = calculadora.multiplica(auxiliarParser, numeroParser);
                                    tvPantalla.setText(String.valueOf(resultado));
                                    numero = new StringBuilder();
                                    numero.append(resultado);
                                    break;
                                case "÷":
                                    resultado = calculadora.divide(auxiliarParser, numeroParser);
                                    tvPantalla.setText(String.valueOf(resultado));
                                    numero = new StringBuilder();
                                    numero.append(resultado);
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        };

        //Acciones
        btBorrar.setOnClickListener(listener);
        btMasMenos.setOnClickListener(listener);
        btPunto.setOnClickListener(listener);

        //Operaciones
        btPorcentaje.setOnClickListener(listener);
        btSuma.setOnClickListener(listener);
        btResta.setOnClickListener(listener);
        btMultiplica.setOnClickListener(listener);
        btDivide.setOnClickListener(listener);
        btIgual.setOnClickListener(listener);

        //Numeros
        btCero.setOnClickListener(listener);
        btUno.setOnClickListener(listener);
        btDos.setOnClickListener(listener);
        btTres.setOnClickListener(listener);
        btCuatro.setOnClickListener(listener);
        btCinco.setOnClickListener(listener);
        btSeis.setOnClickListener(listener);
        btSiete.setOnClickListener(listener);
        btOcho.setOnClickListener(listener);
        btNueve.setOnClickListener(listener);
    }
}
