package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if(!checkValidation(number)){
            return -1;
        }
        answer=getAmountOfClap(number);
        return answer;
    }

    private static boolean checkValidation(int number){
        if(1<number && number<10000){
            return true;
        }
        return false;
    }

    private static int getAmountOfClap(int number){
        int totalClap = 0;
        for(int i=1; i<number+1; i++){
            totalClap+=getClapOfNumber(i);
        }
    }

}
