package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1;i<= number;i++){
            int tmp=i;
            while(tmp>0){
                int one = tmp%10;
                if(one == 3 || one==6||one==9){
                    answer++;
                }
                tmp/=10;
            }
        }
        return answer;
    }
}
