package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //1. 1~number loop
        //  2. 숫자를 10으로 나눈 나머지가 3,6,9 중 하나이면 answere+=1
        //     숫자를 10으로 나눈 몫으로 계속 반복
        for(int i=1;i<=number;i++){
            int num=i;
            while(num>0){
                if(num%10==3||num%10==6||num%10==9)answer+=1;
                num/=10;
            }
        }
        return answer;
    }
}
