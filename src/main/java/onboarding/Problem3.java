package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            if(number < 10){
                if(number % 3 == 0){
                    answer++;
                }
            }
            else if(number >= 10 && number < 100){
                if((number % 10) % 3 == 0){
                    answer++;
                }
                if((number / 10) % 3 == 0){
                    answer++;
                }
            }
            else if(number >= 100 && number < 1000){
                if ((number / 100) % 3 == 0) {
                    answer++;
                }
                if(((number / 10)% 10) % 3 == 0){
                    answer++;
                }
                if((number % 10) % 3 == 0){
                    answer++;
                }
            }
            else if(number >= 1000 && number < 10000){
                if((number / 1000) % 3 == 0){
                    answer++;
                }
                if(((number / 100) % 10) % 3 == 0){
                    answer++;
                }
                if(((number / 10) % 10) % 3 == 0) {
                    answer++;
                }
                if((number % 10) % 3 == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
