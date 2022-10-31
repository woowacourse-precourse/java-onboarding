package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1 ; i <= number ; i++){
            int cur =  i;
            while(cur > 0){
                int tmp = cur % 10;
                if(tmp == 3 || tmp == 6 || tmp == 9) answer++;
                cur /= 10;
            }
        }
        return answer;
    }
}
