package es.iesmz.tests;

public class Money {

    private final float cambioEurUsd = 1.18798f;
    private final float cambioUsdEur = 0.841815f;
    private final float cambioEurGbp = 0.857839f;
    private final float cambioGbpEur = 1.165826f;

    private static TipoMoneda[] monedasAceptadas = {TipoMoneda.USD, TipoMoneda.EUR, TipoMoneda.GBP};

    public static float change(TipoMoneda origen, TipoMoneda destino, float money){
        if (money < 0) return -1f;
        else if (!comprobarSiMonedaEstaAceptada(origen) || !comprobarSiMonedaEstaAceptada(destino)) return -1f;
        return 0f;
    }

    private static boolean comprobarSiMonedaEstaAceptada(TipoMoneda moneda){
        for (TipoMoneda m : monedasAceptadas) {
            if (m.equals(moneda)) return true;
        }
        return false;
    }
}
