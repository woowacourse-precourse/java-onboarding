package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int tmpi = i;
            while(tmpi != 0){
                int tmp = tmpi % 10;
                if(tmp == 3 || tmp == 6 || tmp == 9) answer++;
                tmpi /= 10;
            }
        }
        return answer;
    }
}
