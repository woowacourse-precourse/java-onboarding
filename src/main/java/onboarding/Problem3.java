package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int getCount(ArrayList<String> array){
        int cnt = 0;
        for(String s: array){
            cnt = cnt + (s.length() - s.replace(String.valueOf('3'), "").length()) + (s.length() - s.replace(String.valueOf('6'), "").length()) + (s.length() - s.replace(String.valueOf('9'), "").length());
        }
        return cnt;
    }
}
