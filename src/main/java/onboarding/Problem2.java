package onboarding;

public class Problem2 {

    private static final int CRYPTOGRAM_MIN_LENGTH = 1;
    private static final int CRYPTOGRAM_MAX_LENGTH = 1000;

    public static String solution(String cryptogram) {
        if(!(checkCryptogramLength(cryptogram) || checkCryptogramConsistOfLowercase(cryptogram))){
            throw new IllegalStateException("[error] 잘못된 암호문이 입력되었습니다.");
        }
        String answer = deleteContinuedSameCharUntilNotOverlap(cryptogram);
        return answer;
    }

    public static boolean checkCryptogramLength(String cryptogram) {
        return CRYPTOGRAM_MIN_LENGTH <= cryptogram.length()
            && cryptogram.length() <= CRYPTOGRAM_MAX_LENGTH;
    }

    public static boolean checkCryptogramConsistOfLowercase(String cryptogram) {
        for (char cryptogramChar : cryptogram.toCharArray()) {
            if (Character.isUpperCase(cryptogramChar)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCryptogramOverlap(String cryptogram) {
        char preText = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            if (preText == cryptogram.charAt(i)) {
                return true;
            }
            preText = cryptogram.charAt(i);
        }
        return false;
    }

    public static String deleteContinuedSameChar(String cryptogram) {
        String deletedCrytogram = "";
        boolean checkOverlap = false;
        for (int i = 0; i < cryptogram.length(); i++) {
            String checkText = Character.toString(cryptogram.charAt(i));
            if (i + 1 == cryptogram.length()) {
                break;
            }
            String nextText = Character.toString(cryptogram.charAt(i + 1));
            if (checkText.equals(nextText)) {
                checkOverlap = true;
                continue;
            }
            if (checkOverlap) {
                checkOverlap = false;
                continue;
            }
            deletedCrytogram += checkText;
        }
        // 문자열 중 마지막 문자처리
        if (!checkOverlap) {
            deletedCrytogram += Character.toString(cryptogram.charAt(cryptogram.length() - 1));
        }
        return deletedCrytogram;
    }

    public static String deleteContinuedSameCharUntilNotOverlap(String cryptogram) {
        boolean checkOverlap = checkCryptogramOverlap(cryptogram);
        String result = "";
        while (checkOverlap) {
            result = deleteContinuedSameChar(cryptogram);
            cryptogram = result;
            if (cryptogram.equals("")) {
                break;
            }
            checkOverlap = checkCryptogramOverlap(cryptogram);
        }
        return result;
    }
}
