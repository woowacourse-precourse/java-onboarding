package onboarding;

public class Problem3 {
    public static int countThreeSixNine(int num) {
        int cnt = 0;

        while(num != 0) {
            int x = num % 10;
            if(x == 3 || x == 6 || x == 9){
                cnt += 1;
            }
            num /= 10;
        }

        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i = 3; i <= number; i++) {
            answer += countThreeSixNine(i);
        }

        return answer;
    }
}
