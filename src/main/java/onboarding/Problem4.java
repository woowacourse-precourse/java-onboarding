package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] chars = word.toCharArray();
        int reverse, tmp, ascii = 0 ;

        for (int i= 0; i < chars.length; i++) {
            if(Character.isUpperCase(chars[i])) {
                ascii = 65;
            } else if (Character.isLowerCase(chars[i])) {
                ascii = 97;
            } else {
                answer = answer + ' ';
                continue;
            }
            tmp = Math.abs(ascii - chars[i]);
            reverse = (ascii + 25) - tmp;
            answer = answer + ((char) reverse);
        }

        return answer;
    }
}
