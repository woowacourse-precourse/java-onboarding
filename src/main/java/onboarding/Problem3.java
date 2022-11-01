package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            int divider = 10;
            int tmp = i;
            while(tmp != 0){
                int a = tmp % divider;
                if(a == 3 || a == 6 || a == 9){
                    answer++;
                }
                tmp /= divider;
            }
        }

        return answer;
    }
}
