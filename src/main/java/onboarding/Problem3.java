package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int tmp;
        for(int i=1;i<=number;i++){
            tmp = i;
            int units;
            while(tmp>0){
                units = tmp%10;
                tmp /= 10;
                if(units == 3 || units == 6 || units == 9){
                    answer++;
                }
            }
        }
        return answer;
    }
}
