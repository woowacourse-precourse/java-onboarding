package onboarding;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        int length = word.length();
        if(length > 1000 || length < 1) System.exit(1);
        char[] character = word.toCharArray();
        String answer = "";
        int temp;
        for (char x : character) {
            temp = (int) x;
            if (temp >= 65 && temp <= 90) temp = big(temp);
            else if(temp >= 97 && temp <=122) temp = small(temp);
            else {answer += x; continue;}
            answer += (char) temp;
        }
        return answer;
    }
    public static Integer big(Integer c) {
        int new_c = 155-c;
        return new_c;
    }
    public static Integer small(Integer c) {
        int new_c = 219-c;
        return new_c;
    }

}
