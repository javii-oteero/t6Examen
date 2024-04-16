package es.iesmz.tests;

public class Money {

    private static final float cambioEurUsd = 1.18798f;
    private static final float cambioUsdEur = 0.841815f;
    private static final float cambioEurGbp = 0.857839f;
    private static final float cambioGbpEur = 1.165826f;

    private static final TipoMoneda[] monedasAceptadas = {TipoMoneda.USD, TipoMoneda.EUR, TipoMoneda.GBP};

    public static float change(TipoMoneda origen, TipoMoneda destino, float money){
        if (money < 0) return -1f;
        else if (comprobarSiMonedaNoEstaAceptada(origen) || comprobarSiMonedaNoEstaAceptada(destino)) return -1f;
        else {
            switch (origen){
                case GBP -> { return cambiarGbp(destino, money); }
                case EUR -> { return cambiarEur(destino, money); }
                case USD -> { return cambiarUsd(destino, money); }
            }
        }
        return -1f;
    }

    private static float cambiarUsd(TipoMoneda destino, float money){
        if (destino.equals(TipoMoneda.EUR)) return (money * cambioUsdEur);
        else if (destino.equals(TipoMoneda.GBP)) return cambiarEur(TipoMoneda.GBP, cambiarUsd(TipoMoneda.EUR, money));
        else return -1f;
    }

    private static float cambiarGbp(TipoMoneda destino, float money){
        if (destino.equals(TipoMoneda.EUR)) return (money * cambioGbpEur);
        else if (destino.equals(TipoMoneda.USD)) return cambiarEur(TipoMoneda.USD, cambiarGbp(TipoMoneda.EUR, money));
        else return -1f;
    }

    private static float cambiarEur(TipoMoneda destino, float money){
        if (destino.equals(TipoMoneda.USD)) return (money * cambioEurUsd);
        else if (destino.equals(TipoMoneda.GBP)) return (money * cambioEurGbp);
        else return -1f;
    }

    private static boolean comprobarSiMonedaNoEstaAceptada(TipoMoneda moneda){
        for (TipoMoneda m : monedasAceptadas) {
            if (m.equals(moneda)) return false;
        }
        return true;
    }
}
