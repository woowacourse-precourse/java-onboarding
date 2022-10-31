package onboarding;

public class Problem3 {
    public static int countHandclapByNumber(int number){
        int handclapCount=0;
        while(number>0){
            int eachDigitOfNumber=number%10;
            if(eachDigitOfNumber!=0 && eachDigitOfNumber%3==0){
                handclapCount++;
            }
            number/=10;
        }
        return handclapCount;
    }
    public static int solution(int number) {
        int answer = 0;

        return answer;
    }
}
