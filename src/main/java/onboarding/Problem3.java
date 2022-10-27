package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int res = isValidNumber(i);
            if(res != 0){
                answer += res;
            }
        }
        return answer;
    }

    public static int isValidNumber(int number){
        int count = 0;
        int tmp = number;
        while(tmp > 0){
            int digit = tmp % 10;
            if(digit == 3 || digit == 6 || digit == 9){
                count++;
            }
            tmp /= 10;
        }
        return count;
    }

}
