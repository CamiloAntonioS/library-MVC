package vista;

/**
 *
 * @author Renzo
 */
public class ValidacionRut {
//String RutJunto = "";

    private static int verificadorIni = 0;
    private static String VerifiStringIni = "";
    private static int RutC = 0;

    public static boolean IngresoRut(String RutJunto){
        int RutUsuario[] = new int[10];
        String VerificadorFinal = "";

        if (RutJunto.equals("0")) {
            return false;
        }
        SacarVerificador(RutJunto);
        SepararRut(RutUsuario);
        VerificadorFinal = CalcularVerificador(RutUsuario) + "";
        CompararVerifi(VerifiStringIni, VerificadorFinal);
        if (!CompararVerifi(VerifiStringIni, VerificadorFinal)) {
            return false;
        }
        else{
            return true;
        }

    }

    private static void SacarVerificador(String RutS) {
        String[] Spl1 = RutS.split("-");
        RutC = Integer.parseInt(Spl1[0]);
        //verificadorIni = (((((((RutC%10000000)%1000000)%100000)%10000)%1000)%100)%10);
        //RutC -= verificadorIni;
        //RutC /= 10;
        VerifiStringIni = Spl1[1];

    }

    private static void SepararRut(int Array[]) {
        Array[0] = RutC / 10000000;
        Array[1] = (RutC % 10000000) / 1000000;
        Array[2] = ((RutC % 10000000) % 1000000) / 100000;
        Array[3] = (((RutC % 10000000) % 1000000) % 100000) / 10000;
        Array[4] = ((((RutC % 10000000) % 1000000) % 100000) % 10000) / 1000;
        Array[5] = (((((RutC % 10000000) % 1000000) % 100000) % 10000) % 1000) / 100;
        Array[6] = ((((((RutC % 10000000) % 1000000) % 100000) % 10000) % 1000) % 100) / 10;
        Array[7] = (((((((RutC % 10000000) % 1000000) % 100000) % 10000) % 1000) % 100) % 10);

    }

    private static int CalcularVerificador(int Array1[]) {
        int acumulador = 0;
        int Array2[] = new int[10];
        Array2[0] = Array1[7] * 2;
        Array2[1] = Array1[6] * 3;
        Array2[2] = Array1[5] * 4;
        Array2[3] = Array1[4] * 5;
        Array2[4] = Array1[3] * 6;
        Array2[5] = Array1[2] * 7;
        Array2[6] = Array1[1] * 2;
        Array2[7] = Array1[0] * 3;
        for (int i = 0; i <= 7; i++) {
            acumulador += Array2[i];
        }
        acumulador = acumulador % 11;
        if (acumulador == 0) {
            return acumulador;
        }
        acumulador = (11 - acumulador);
        return acumulador;
    }

    private static boolean CompararVerifi(String Inicial, String Obtenido) {
        if (Inicial.equals("10")) {
            Inicial = "k";
        }
        if (Inicial.equals(Obtenido)) {
            return true;
        }
        return false;
    }
}
