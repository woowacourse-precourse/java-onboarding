package onboarding;

public class Problem3 {
    static int getCount(int num){
        int sum = 0;
        while(num != 0){
            int tmp = num % 10;
            if(tmp == 3 || tmp == 6 || tmp == 9){
                sum += 1;
            }
            num /= 10;
        }
        return sum;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            answer += getCount(i);
        }
        return answer;
    }
}
