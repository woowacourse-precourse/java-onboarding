package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        int tmp=0;
        int n=0;
        for(int i=0;i<=number;i++){
            n=i;

            while(n!=0){
                tmp=n%10;
                if(tmp==3||tmp==6||tmp==9){
                    answer++;
                }
                n/=10;

            }
        }
        return answer;
    }
}
