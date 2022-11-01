package onboarding;

public class Problem4 {


    public static String solution(String word) {
        return characterAllConversion(word);
    }

    /**
     * [대소문자 구분]
     * - 입력받은 문자가 대문자인지 소문자인지 구분한다.
     * @return 대문자 -> true / 소문자 -> false
     */
    public static boolean upperCaseDivision(char word) {
        if (Character.isUpperCase(word)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * [하나의 문자 변환]
     * - 입력받은 문자를 청개구리의 방식으로 변환
     * @param str 하나의 문자
     * @param upperCaseWhether 대문자 여부
     * @return 변환된 문자 하나
     */
    public static char characterOneConversion(char str, Boolean upperCaseWhether){
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (upperCaseWhether) {
            return upperCase.charAt(25-upperCase.indexOf(str));
        }else {
            return lowerCase.charAt(25-lowerCase.indexOf(str));
        }

    }


    /**
     * [모든 문자 변환]
     * - 입력받은 모든 문자를 청개구리 방식으로 변환
     * @param word 입력받은 문자
     * @return 변환된 문자
     */
    public static String characterAllConversion(String word){
        char[] words = word.toCharArray();
        String result = "";

        for (char w : words) {
            if (w != " ".charAt(0)) {
                result += characterOneConversion(w,upperCaseDivision(w));
            }else {
                result += " ";
            }

        }
        return result;
    }

}
