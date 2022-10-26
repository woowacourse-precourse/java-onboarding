package onboarding;

import java.util.Locale;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        try {
            Validator.isValidate(cryptogram);
        } catch (Exception error){
            System.out.println("[ERROR] : " + error);
        }

        return answer;
    }

    private void

    static class Validator{

        public static void isValidate(String cryptogram){
            isCorrectSize(cryptogram);
            isOnlyLowerCase(cryptogram);
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

