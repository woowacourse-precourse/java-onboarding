package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1 ; i <= number ; i ++) {
            int nowNum = i;
            while (nowNum != 0) {
                int thisNum = nowNum % 10;
                if(thisNum % 3 == 0 && thisNum != 0) {
                    answer++;
                }
                nowNum /= 10;
            }
        }
        return answer;
    }
}
