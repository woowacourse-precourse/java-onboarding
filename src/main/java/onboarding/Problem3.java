package onboarding;
/*
369게임
1<=number<=9,999
각 자릿수에 3 or 6 or 9 가 들어가면 result+=1
*/

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=0;i<=number;i++){
            int n=i;
            while(n!=0){
                if(n%10==3 || n%10 ==6 || n%10==9)
                    answer++;
                n/=10;
            }
        }
        return answer;
    }
}
