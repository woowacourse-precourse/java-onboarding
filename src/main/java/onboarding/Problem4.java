package onboarding;

public class Problem4 {

    public static String change(char[] chars) {
        String answer = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {
                answer += " ";
            }
            if (Character.isUpperCase(chars[i])) {
                int temp = chars[i] - 65;
                int reverse = (65 + 25) - temp;
                answer += String.valueOf((char) reverse);
            }
            if(Character.isLowerCase(chars[i])){
                int temp = chars[i] - 97;
                int reverse = (97 + 25) - temp;
                answer += String.valueOf((char) reverse);
            }
        }
        return answer;
    }

    public static String solution(String word) {
        char[] arr = word.toCharArray();
        return change(arr);
    }
}
