package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int sum=0;
        for(int i=1;i<=number;i++)
        {
            for(int tmp=i;tmp>0;tmp/=10){
                if((tmp%10)%3==0 && (tmp%10)!=0){
                    sum++;
                }
            }
        }
//        3, 3*10 + 3*9, (3*10+3*9)*10 + (3*10+3*9)*9
        return sum;
    }
}
