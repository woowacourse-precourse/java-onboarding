package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] chars = word.toCharArray();
        int gap = 0;

        for(int i = 0; i < chars.length; i++) { // 65 ~ 90
            if(chars[i] >= 65 && chars[i] <= 77) {
                gap = chars[i] - 65;
                chars[i] = (char) (90 - gap);
            }else if(chars[i] >= 78 && chars[i] <= 90) {
                gap = 90 - chars[i];
                chars[i] = (char) (65 + gap);
            }else if(chars[i] >= 97 && chars[i] <= 109) { // 97 ~ 122
                gap = chars[i] - 97;
                chars[i] = (char) (122 - gap);
            }else if(chars[i] >= 110 && chars[i] <= 122) {
                gap = 122 - chars[i];
                chars[i] = (char) (97 + gap);
            }
        }

        answer = String.valueOf(chars);

        return answer;
    }
}
