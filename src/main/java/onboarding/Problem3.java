package onboarding;

public class Problem3 {
    public static int count(int number){
        int cnt = 0;
        for (int i = 1; i <= number; i++) { //1-number까지
            int cur = i;
            while (cur != 0) {
                if (cur % 10 == 3 || cur % 10 == 6 || cur % 10 == 9){ //현재 숫자에 3,6,9가 들어가는지
                    cnt++;
                }
                cur = cur / 10;
            }
        }
        return cnt;
    }
    public static int solution(int number) {
        return count(number);
    }
}
