package br.com.gw_sistemas.transportadorawwg.nucleo.utils.stringUtils;


public class Cpf {

    private final int[] PESO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
    
    public String removerMascara(String str){ return str.replaceAll("\\D", ""); }
    
    public boolean isValidCpf(String cpf) {
            cpf = removerMascara(cpf);	
            String cpfSomenteDigitos = cpf.replaceAll("\\D", "");

            if ((cpfSomenteDigitos == null) || (cpfSomenteDigitos.length() != 11) || cpfSomenteDigitos.equals("00000000000")
                            || cpfSomenteDigitos.equals("11111111111") || cpfSomenteDigitos.equals("22222222222")
                            || cpfSomenteDigitos.equals("33333333333") || cpfSomenteDigitos.equals("44444444444")
                            || cpfSomenteDigitos.equals("55555555555") || cpfSomenteDigitos.equals("66666666666")
                            || cpfSomenteDigitos.equals("77777777777") || cpfSomenteDigitos.equals("88888888888")
                            || cpfSomenteDigitos.equals("99999999999")) {
                    return false;
            }

            Integer digito1 = calcularDigitoCpf(cpfSomenteDigitos.substring(0, 9), PESO_CPF);
            Integer digito2 = calcularDigitoCpf(cpfSomenteDigitos.substring(0, 9) + digito1, PESO_CPF);

            return cpfSomenteDigitos.equals(cpfSomenteDigitos.substring(0, 9) + digito1.toString() + digito2.toString());
    }
		
    private int calcularDigitoCpf(String str, int[] peso) {
            int soma = 0;
            for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
                    digito = Integer.parseInt(str.substring(indice, indice + 1));
                    soma += digito * peso[peso.length - str.length() + indice];
            }
            soma = 11 - soma % 11;
            return soma > 9 ? 0 : soma;
    }

    public static String formatCPF(String cpf) {
            Cpf vl = new Cpf();
            cpf = vl.removerMascara(cpf);
            String cpfFormatado = cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
            return cpfFormatado;
    }
}
