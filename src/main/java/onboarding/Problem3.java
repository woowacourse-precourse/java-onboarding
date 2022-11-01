package onboarding;

public class Problem3 {
    private int getNumOfThreeSixNineDigit(int num){
        int ret = 0;
        int units = num % 10;
        int tens = num % 100 / 10;
        int hundreds = num % 1000 / 100;
        int thousands = num % 10000 / 1000;
        if(units == 3 || units == 6 || units == 9)
            ++ret;
        if(tens == 3 || tens == 6 || tens == 9)
            ++ret;
        if(hundreds == 3 || hundreds == 6 || hundreds == 9)
            ++ret;
        if(thousands == 3 || thousands == 6 || thousands == 9)
            ++ret;
        return ret;
    }
    public static int solution(int number) {
        int answer = 0;
        Problem3 p3 = new Problem3();
        for(int i = 1; i <= number; ++i)
            answer += p3.getNumOfThreeSixNineDigit(i);
        return answer;
    }
}
