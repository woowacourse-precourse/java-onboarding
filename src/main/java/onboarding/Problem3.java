package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int tens = 0;
        int ones = 0;
        for(int i = 1; i <= number; i++){
            tens = i / 10;
            ones = i % 10;
            if(tens == 3 || tens == 6 || tens == 9){
                answer += 1;
            }
            if(ones == 3 || ones == 6 || ones ==9){
                answer += 1;
            }
        }
        return answer;
    }
}
