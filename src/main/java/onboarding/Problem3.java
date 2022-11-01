package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int tmp;
        for (int i=1;i<=number;i++){
            int c = i;
            while(c!=0){
                tmp = c%10;
                if(tmp ==3 || tmp ==6|| tmp==9)
                    answer++;
                c/=10;
            }
        }
        return answer;
    }
}
