package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String upper_dic = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lower_dic = "zyxwvutsrqponmlkjihgfedcba";

        for (int i=0 ; i<word.length() ; i++) {
            char ch = word.charAt(i);
            if (65 <= (int)ch && (int)ch <= 90) {
                answer += upper_dic.charAt((int)ch-65);
            } else if (97 <= (int)ch && (int)ch <= 122) {
                answer += lower_dic.charAt((int)ch-97);
            } else {
                answer += ch;
            }

        }

        return answer;
    }
}
