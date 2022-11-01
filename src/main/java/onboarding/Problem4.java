package onboarding;

public class Problem4 {

    static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String lower = "abcdefghijklmnopqrstuvwxyz";

    /*
    * 청개구리 사전을 참고해 문자를 반대로 변환하는 메서드
    * parameter : char (변환하고자 하는 문자)
    * return : char (변환된 문자)
    * */
    public static char translate(char a) {
        char result = a;
        if (Character.isLowerCase(a)) {
            result = lower.charAt(25 - a + 'a');
        }else if (Character.isUpperCase(a)) {
            result = upper.charAt(25 - a + 'A');
        }
        return result;
    }

    /*
    * String 을 문자 하나씩 for 문을 돌리면서 반대로 변환하여 return 한다.
    * parameter : String (변환하고자 하는 문자열)
    * return : String (변환된 문자열)
    * */
    public static String solution(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            result.append(translate(word.charAt(i)));
        }

        return result.toString();
    }
}
