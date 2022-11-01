package onboarding;

public class Problem3 {
    private static boolean is369Number(int num) {
        return num == 3 || num == 6 || num == 9;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; ++i) {
            int currNum = i;
            while(currNum > 0) {
                if(is369Number(currNum % 10)) ++answer;
                currNum = currNum / 10;
            }
        }
        return answer;
    }
}
