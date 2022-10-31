package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int num;

        for(int i = 1; i <= number; i++){
            num = i;
            while(num>0){
                if(num % 10 == 3 || num % 10 == 6 || num % 10 == 9){
                    answer++;
                }
                num /= 10;
            }
        }
        return answer;
    }
}
