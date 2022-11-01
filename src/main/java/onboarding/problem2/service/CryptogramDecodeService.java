package onboarding.problem2.service;

import onboarding.problem2.domain.Cryptogram;

public class CryptogramDecodeService {

    public static String decode(String cryptogram) {
        return decode(new Cryptogram(cryptogram));
    }

    public static String decode(Cryptogram cryptogram) {
        Cryptogram decodeCryptogram = cryptogram.deleteConsecutiveCharacter();
        if (decodeCryptogram.equals(cryptogram)) {
            return decodeCryptogram.text();
        }
        return decode(decodeCryptogram);
    }
}
