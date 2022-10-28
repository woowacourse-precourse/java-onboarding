package onboarding.problem2;


import java.util.regex.Pattern;

public class CryptoGame {
    private static char last_removed = Character.MIN_VALUE;
    private static final Pattern pattern = Pattern.compile("^[a-z]+$");
    private static final int MIN = 1;
    private static final int MAX = 1_000;

    public static String start(String cryptogram) {
        checkInput(cryptogram);
        return remove(cryptogram);
    }

    private static void checkInput(String cryptogram) {
        validateMin(cryptogram);
        validateMAX(cryptogram);
        checkSmallLetter(cryptogram);
    }

    private static void checkSmallLetter(String cryptogram) {
        if (!pattern.matcher(cryptogram).matches()) {
            throw new CryptoException("소문자 영어만 입력해주세요.");
        }
    }

    private static void validateMAX(String cryptogram) {
        if (cryptogram.length() > MAX) {
            throw new CryptoException("1000을 초과한 크기를 가진 문자열은 입력할 수 없습니다.");
        }
    }

    private static void validateMin(String cryptogram) {
        if (cryptogram.length() < MIN) {
            throw new CryptoException("최소 한 글자를 입력해주세요.");
        }
    }

    private static String remove(String crypto) {

        if (crypto.length() == 0 || crypto.length() == 1)
            return crypto;
        if (crypto.charAt(0) == crypto.charAt(1)) {
            last_removed = crypto.charAt(0);
            while (crypto.length() > 1 && crypto.charAt(0) == crypto.charAt(1)) {
                crypto = crypto.substring(1);
            }
            crypto = crypto.substring(1);
            return remove(crypto);
        }

        String remCrypto = remove(crypto.substring(1));

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
