package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int threeSixNineCount(int number){
        int count  = 0;
        int nowDigit = 0;
        while(number > 0){
            nowDigit = number % 10;
            if(nowDigit == 3 || nowDigit == 6 || nowDigit == 9){
                count++;
            }
        }
        return count;
    }
}
