package onboarding;
/**
어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다. 청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.
엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.

ABCDEFGHIJKLMNOPQRSTUVWXYZ
ZYXWVUTSRQPONMLKJIHGFEDCBA
*/
 public class Problem4 {

    /**
     * 문자를 청개구리 사전에 의해 변환해 주는 메소드
     * */
    public static char getTreeFrogChar(char character) {
        int number = 0;
        if (Character.isUpperCase(character)) {
            number = 155 - (int) character;
        } else if (Character.isLowerCase(character)) {
            number = 219 - (int) character;
        }
        char result = (char) number;
        return result;
    }

    /**
     * 풀이 메서드
     * */
    public static String solution(String word) {
        String answer = "";
        char[] array = word.toCharArray();
        for (int j = 0; j < array.length; j++) {
            array[j] = getTreeFrogChar(array[j]);
            int a = (int) array[j];
            System.out.println(a);
            answer += Character.toString(array[j]);
        }

        return answer.replaceAll("\\u0000", " ");
    }
}
