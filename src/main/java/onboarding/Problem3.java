package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int digit=0;
        int num=0;
        for(int i=1;i<=number;i++){
            digit=0;
            num=i;
            while(num>0){
                digit=num%10;

                if(digit%3==0&&digit!=0)
                    answer++;
                num/=10;

            }

        }
        return answer;
    }
}
