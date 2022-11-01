package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = numberRound(number);;
        return answer;
    }

    public static int numberRound(int number){
        int result =0;
        for(int i=1;i<=number;i++){
            result+=numberCheck(i);
        }
        return result;
    }

    public static int numberCheck(int number){
        int result =0;
        while(number!=0){
            if(number%10==3||number%10==6||number%10==9){
                result+=1;
            }
            number/=10;
        }
        return result;
    }
}
