package onboarding.problem2;


public class CryptoGame {
    public static char last_removed = Character.MIN_VALUE;

    public static String remove(String crypto) {
        return removeUl(crypto);
    }

    public static String removeUl(String crypto) {
        if (crypto.length() == 0 || crypto.length() == 1)
            return crypto;
        if (crypto.charAt(0) == crypto.charAt(1)) {
            last_removed = crypto.charAt(0);
            while (crypto.length() > 1 && crypto.charAt(0) == crypto.charAt(1)) {
                crypto = crypto.substring(1);
            }
            crypto = crypto.substring(1);
            return removeUl(crypto);
        }

        String remCrypto = removeUl(crypto.substring(1));

        if (remCrypto.length() != 0 && remCrypto.charAt(0) == crypto.charAt(0)) {
            last_removed = crypto.charAt(0);

            return remCrypto.substring(1);
        }
        if (remCrypto.length() == 0 && last_removed == crypto.charAt(0)) {
            return remCrypto;
        }
        return crypto.charAt(0) + remCrypto;
    }
}
