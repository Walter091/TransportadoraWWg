package br.com.gw_sistemas.transportadorawwg.nucleo.utils.stringUtils;

import java.util.InputMismatchException;

public class Cnpj {
    
    public String removerMascara(String str){ return str.replaceAll("\\D", ""); }

    public boolean isCNPJ(String cnpj) {
        String cnpjFormatado = removerMascara(cnpj);
        if (cnpjFormatado.equals("00000000000000") || cnpjFormatado.equals("11111111111111") ||
            cnpjFormatado.equals("22222222222222") || cnpjFormatado.equals("33333333333333") ||
            cnpjFormatado.equals("44444444444444") || cnpjFormatado.equals("55555555555555") ||
            cnpjFormatado.equals("66666666666666") || cnpjFormatado.equals("77777777777777") ||
            cnpjFormatado.equals("88888888888888") || cnpjFormatado.equals("99999999999999") ||
           (cnpjFormatado.length() != 14))
           return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
          sm = 0;
          peso = 2;
          for (i=11; i>=0; i--) {
            num = (int)(cnpjFormatado.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
               peso = 2;
          }

          r = sm % 11;
          if ((r == 0) || (r == 1))
             dig13 = '0';
          else dig13 = (char)((11-r) + 48);

          sm = 0;
          peso = 2;
          for (i=12; i>=0; i--) {
            num = (int)(cnpjFormatado.charAt(i)- 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
               peso = 2;
          }

          r = sm % 11;
          if ((r == 0) || (r == 1))
             dig14 = '0';
          else dig14 = (char)((11-r) + 48);

          if ((dig13 == cnpjFormatado.charAt(12)) && (dig14 == cnpjFormatado.charAt(13)))
             return(true);
          else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
      }

     public static String imprimeCNPJ(String CNPJ) {
        return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
          CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
          CNPJ.substring(12, 14));
      }
	  
}
