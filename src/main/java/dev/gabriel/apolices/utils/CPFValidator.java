package dev.gabriel.apolices.utils;

import java.util.InputMismatchException;

public class CPFValidator {
    public static boolean validate(String cpf) {

        for (int i = 0; i < cpf.length(); i++) {
            if (Character.isLetter(cpf.charAt(i)))
                return false;
        }

        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") ||
                cpf.equals("33333333333") ||
                cpf.equals("44444444444") ||
                cpf.equals("55555555555") ||
                cpf.equals("66666666666") ||
                cpf.equals("77777777777") ||
                cpf.equals("88888888888") ||
                cpf.equals("99999999999") ||
                (cpf.length() != 11)
        ) {
            return false;
        }

        try {
            // 1o. Digito Verificador
            int soma = 0;
            int peso = 11;
            char dig10 = getDigito10(cpf, soma, peso);

            // 2o. Digito Verificador
            peso = 12;
            char dig11 = getDigito11(cpf, soma, peso);
            char d9 = cpf.charAt(9);
            char d10 = cpf.charAt(10);
            return (dig10 == d9) && (dig11 == d10);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private static char getDigito10(String cpf, int soma, int peso) {
        int i;
        for (i = 0; i < 9; i++) {
            int numericValue = Character.getNumericValue(cpf.charAt(i));
            int i1 = peso - (i+1);
            int ci = numericValue * i1;
            soma = soma + ci;
        }

        int resto = getResto(soma);
        return getDigitoFromResto(resto);
    }

    private static char getDigito11(String cpf, int soma, int peso) {
        int i;
        for (i = 0; i < 10; i++) {
            soma = soma + Character.getNumericValue(cpf.charAt(i)) * (peso - (i+1));
        }

        int resto = getResto(soma);
        return getDigitoFromResto(resto);
    }

    private static char getDigitoFromResto(int resto) {
        return (resto == 10) || (resto == 11) ? '0' : (char) (resto + 48);
    }

    private static int getResto(int soma) {
        return (soma * 10) % 11;
    }

}
