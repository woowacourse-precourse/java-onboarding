package onboarding;

import java.util.Locale;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = new String(cryptogram);
        int idx = 0;

        try {
            Validator.isValidate(answer);
        } catch (Exception error){
            System.out.println("[ERROR] : " + error);
        }

        while (answer.length() > 0){
            idx = getRemoveIdx(answer);
            if (idx < 0){
                break;
            }
            answer = removeString(answer, idx);
        }
        return answer;
    }

    private static int getRemoveIdx(String cryptogram){
        char check = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            if (check == cryptogram.charAt(i)){
                return i;
            }
            check = cryptogram.charAt(i);
        }
        return -1;
    }

    private static String removeString(String cryptogram, int idx){
        String result = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            if (i == idx - 1 || i == idx){
                continue;
            }
            result += String.valueOf(cryptogram.charAt(i));
        }
        return result;
    }

    static class Validator{

        public static boolean isValidate(String cryptogram){
            try {
                isCorrectSize(cryptogram);
                isOnlyLowerCase(cryptogram);
            } catch (Exception error) {
                return false;
            }
            return true;
        }

        private static void isCorrectSize(String str){
            if (str.length() < 1 || str.length() > 1000){
                throw new IllegalArgumentException("is not correct size");
            }
        }

        private static void isOnlyLowerCase(String str){
            String diff = str.toLowerCase();
            if (!str.equals(diff)){
                throw new IllegalArgumentException("is not only lower case");
            }
        }
    }
}

