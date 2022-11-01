package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int tmp =0;
        while(number>0){
            if(number>9){
                tmp = number;
                while(tmp>0){
                    if(tmp%10 == 3 || tmp%10 == 6 || tmp%10 ==9) answer ++;
                    tmp/=10;
                }
            }
            else {
                if(number%10 == 3 || number%10 == 6 || number%10 ==9) answer ++;
            }
            number--;
        }
        return answer;
    }
}
