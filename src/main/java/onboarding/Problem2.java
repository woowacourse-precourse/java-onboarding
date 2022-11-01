package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (checkString(cryptogram)) {
            cryptogram = deleteSameCharacters(cryptogram);
        }
        return cryptogram;
    }


    public static String deleteSameCharacters(String cryptogram) {
        int n = cryptogram.length();
        char[] chars = cryptogram.toCharArray();

        //중복 문자는 X로 변환
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) {
                chars[i - 1] = 'X';
                for (int j = i+1; j < n; j++) {
                    if (chars[i] != chars[j]) break;
                    if (chars[i] == chars[j]) chars[j] = 'X';
                }
                chars[i] = 'X';
            }
        }

        //중복 문자 제거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] != 'X') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /*
    중복 문자가 있으면 true
    없으면 false 반환
     */
    public static boolean checkString(String cryptogram) {
        int n = cryptogram.length();
        for (int i = 0; i < n-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
