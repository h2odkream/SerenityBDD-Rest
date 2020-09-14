package co.com.bancolombia.certificacion.libranzas.util;

public class FactorSeguroDeVida {

    private FactorSeguroDeVida() {
    }

    public static double gestionarFactorSeguroDeVida(int monto) {

        double factorSeguroDeVida = 0;

        if (monto >= 1000000 && monto <= 19999999) {
            factorSeguroDeVida = 0.00145;
        } else if (monto > 20000000 && monto < 49999999) {
            factorSeguroDeVida = 0.00149;
        } else if (monto > 50000000 && monto < 199999999) {
            factorSeguroDeVida = 0.00151;
        }

        return factorSeguroDeVida;

    }

}
