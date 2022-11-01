package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 2; i <= number; i ++){
            int units = i % 10;
            int tens = (i % 100 - units) / 10;
            int hundreds = (i % 1000 - tens - units)/100;
            int thousands = (i % 10000 - hundreds - tens - units)/1000;

            if(isInRule(units))
                answer+=1;
            if(isInRule(tens))
                answer+=1;
            if(isInRule(hundreds))
                answer+=1;
            if(isInRule(thousands))
                answer+=1;
        }

        return answer;
    }

    private static boolean isInRule(int x){
        if( x == 3 || x == 6 || x == 9)
            return true;
        return false;
    }
}
