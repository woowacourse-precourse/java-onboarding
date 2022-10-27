package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int tmp = i;
            while(tmp > 0){
                int n = tmp % 10;
                if(n % 3 == 0 && n != 0){
                    answer += 1;
                }
                tmp /= 10;
            }
        }
        return answer;
    }
}
