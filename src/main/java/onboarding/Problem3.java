package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            int tmp = i;
            while(tmp != 0) { // 자리수를 구하여 3,6,9 일때 카운트 증가
                int remainder = tmp % 10;
                if(remainder == 3 || remainder == 6 || remainder == 9) {
                    answer++;
                }
                tmp /= 10;
            }
        }
        return answer;
    }
}
