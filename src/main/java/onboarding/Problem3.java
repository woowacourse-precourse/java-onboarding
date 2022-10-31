package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1 ; i <= number; i++){
            answer += count369(i);
        }

        return answer;
    }

    public static int count369(int number){
        int cnt = 0;
        while(number != 0){
            int units = number % 10;
            if(units == 3){
                cnt += 1;
            }else if(units == 6){
                cnt += 1;
            } else if (units == 9) {
                cnt += 1;
            }
            number /= 10;
        }
        return cnt;
    }
}


