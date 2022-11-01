package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int temp, answer = 0;
        for(int i = 1; i <= number; i++){
            temp = i;
            while(temp > 0){
                int k = temp % 10;
                if(k == 3 || k == 6 || k == 9)
                    answer += 1;
                temp /= 10;
            }
        }
        return answer;
    }
}
