package task.valdemarc.ibanvalitator.service;


import task.valdemarc.ibanvalitator.model.Iban;

import java.math.BigInteger;

public class IbanValidationServices {

    public Iban separateIban(String iban){
        String countryCodeSubstring = iban.substring(0,2);
        String checkDigitSubstring = iban.substring(2,4);
        String basicBankAccountNumSubstring = iban.substring(4);

        Iban ibanSeparated = new Iban(countryCodeSubstring, checkDigitSubstring, basicBankAccountNumSubstring, iban.length());


        return ibanSeparated;
    }

    public boolean isIbanFromSeb(Iban iban){
        if (iban.getBban().substring(0,5).equals("70440")) return true;
        return false;
    }


    public boolean validateIban(Iban iban){

        if(InitializeValidLenghtOfIBAN.validLengthsAndCountryCodes.containsKey(iban.getCountryCode()) && iban.getLength()==InitializeValidLenghtOfIBAN.validLengthsAndCountryCodes.get(iban.getCountryCode())){

            String replacedIban = iban.getBban() + iban.getCountryCode() + iban.getCheckDigits();
            String transformedIban = "";

            for (int i: replacedIban.toCharArray()){
                if(i>=65 && i <=90){
                    i = i-55;
                    transformedIban += Integer.toString(i);
                }
                else {
                    transformedIban += (char) i;
                }
            }

            BigInteger ibanAsBigInt = new BigInteger(transformedIban);

            int modResult = ibanAsBigInt.mod(new BigInteger("97")).intValue();

            if(modResult == 1) return true;
        }

        return false;
    }
}
