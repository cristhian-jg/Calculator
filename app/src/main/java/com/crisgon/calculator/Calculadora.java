package com.crisgon.calculator;

public class Calculadora {

    private int operador1;
    private int operador2;
    private String operando;

    public Calculadora() {
        this.operador1 = 0;
        this.operador2 = 0;
        this.operando = "";
    }

    public double suma(double operador1, double operador2) {
        return operador1 + operador2;
    }

    public double resta(double operador1, double operador2) {
        return operador1 - operador2;
    }

    public double multiplica(double operador1, double operador2) {
        return operador1 * operador2;
    }

    public double divide(double operador1, double operador2) {
        return operador1 / operador2;
    }

    public int cambiarMasMenos(int operador) {
        return  operador * (-1);
    }

    public double porcentaje(double operador) {
        return operador / 100;
    }

    public int getOperador1() {
        return operador1;
    }

    public int getOperador2() {
        return operador2;
    }

    public String getOperando() {
        return operando;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "operador1=" + operador1 +
                ", operador2=" + operador2 +
                ", operando='" + operando + '\'' +
                '}';
    }
}
