package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] cryptogramArr = cryptogram.toCharArray();

        try{
            validation(cryptogramArr);
        }
        catch (IllegalArgumentException e) {
            e.getMessage();
        }

        String answer = deleteDuplicate(cryptogramArr);
        return answer;
    }

    public static void validation(char[] charArr) {
        int charArrLength = charArr.length;
        if ((charArrLength < 0) && (charArrLength > 1000)) {
            throw new IllegalArgumentException("길이가 1 이상 1000 이하인 문자열만 입력 가능합니다.");
        }
        if (!isAllSmallLetter(charArr)) {
            throw new IllegalArgumentException("문자열은 알파벳 소문자로만 이루어져야 합니다.")
        }
    }

    public static boolean isAllSmallLetter(char[] charArr) {
        int charArrLength = charArr.length;
        for (int i = 0; i < charArrLength; i++) {
            if (((int)charArr[i] < 97) || ((int)charArr[i] > 122) return false;
        }
        return true;
    }

    public static String deleteDuplicate(char[] charArr) {

        return charArr.toString();g
    }
}
