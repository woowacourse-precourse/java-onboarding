package onboarding;

public class Problem3 {
    public static int countClap(int num) {
        int clapCnt = 0;
        String numToString = String.valueOf(num);
        for (int i = 0; i < numToString.length(); i++) {
            if(numToString.charAt(i) == '3' || numToString.charAt(i) == '6' || numToString.charAt(i) == '9') {
                clapCnt++;
            }
        }
        return clapCnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number ; i++) {
            answer += countClap(i);
        }
        return answer;
    }
}
