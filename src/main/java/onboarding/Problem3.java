package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int num = 0;

        for(int i=1; i<=number; i++){
            num = i;

            while(num > 0){
                if((num%10)%3==0 && num%10 !=0)
                    answer+=1;
                num = num/10;
            }
        }
        return answer;
    }
}
