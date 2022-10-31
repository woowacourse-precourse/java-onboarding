package onboarding;

import java.io.BufferedReader;

public class Problem3 {
    public static int solution(int number) {
        String sNum = String.valueOf(number);
        int clapCount = 0;
        // StringBuffer를 이용해 메모리 관리
        StringBuffer checkNum;
        for (int i = 1; i <= number; i++) {
            checkNum = new StringBuffer(String.valueOf(i));
            for(int j = 0; j < checkNum.length(); j++){
                if(checkNum.charAt(j) == '3' || checkNum.charAt(j) == '6' || checkNum.charAt(j) == '9'){
                    clapCount++;
                }
            }
        }
        int answer = clapCount;
        return answer;
    }
}
