package esxola.sla;

import java.util.Scanner;

public class Trabaio {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "1. Decimal -> Binário\n" +
                "2. Decimal -> Octal\n" +
                "3. Decimal -> Hexadecimal\n" +
                "4. Binário -> Decimal\n" +
                "5. Octal -> Decimal\n" +
                "6. Hexadecimal -> Decimal\n"
        );

        System.out.println(
                "7. Decimal -> Base 100\n" +
                "8. Base 100 -> Decimal\n"
        );

        System.out.print("\nEscolha uma opção: ");
        int escolha = scanner.nextInt();

        System.out.print("Digite o número para ser convertido: ");
        String n = scanner.next();
        System.out.print("\n");


        switch (escolha) {
            case 1:
                System.out.println("Em binário: " + Trabaio.decimalPara(Integer.parseInt(n), 2));
                break;
            case 2:
                System.out.println("Em octal: " + Trabaio.decimalPara(Integer.parseInt(n), 8));
                break;
            case 3:
                System.out.println("Em hexadecimal: " + Trabaio.decimalPara(Integer.parseInt(n), 16));
                break;
            case 4:
                System.out.println("Em decimal: " + Trabaio.paraDecimal(n, 2));
                break;
            case 5:
                System.out.println("Em decimal: " + Trabaio.paraDecimal(n, 8));
                break;
            case 6:
                System.out.println("Em decimal: " + Trabaio.paraDecimal(n, 16));
                break;
            case 7:
                System.out.println("Em base 100: " + Trabaio.decimalPara(Integer.parseInt(n), 100));
                break;
            case 8:
                System.out.println("Em decimal: " + Trabaio.paraDecimal(n, 100));
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public static String caracteres = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!'#$%¨&*()~[]´/\\=_<>;:{}?*+-|.,@éÉáÁóÓ";

    public static int paraDecimal(String valor, int base) {
        int decimal = 0;

        for (int i = 0; i < valor.length(); i++) {
            String c = String.valueOf(valor.charAt(i));
            decimal += Math.pow(base, valor.length()-i-1) * caracteres.indexOf(c);
        }

        return decimal;
    }


    public static String decimalPara(int decimal, int base) {
        String resultado = "";

        while (decimal > 0) {
            int resto = decimal%base;
            resultado = caracteres.charAt(resto) + resultado;
            decimal = (int)((double)decimal/base);
        }

        return resultado;
    }
}
