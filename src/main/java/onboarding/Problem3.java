package onboarding;

public class Problem3 {

    static final String THREE = "3";
    static final String SIX = "6";
    static final String NINE = "9";

    public static int solution(int number) {
        return calculateResult(number);
    }

    private static int calculateResult(int number){
        int answer = 0;
        for(int i=1; i<=number; i++){
            answer += addClapCount(Integer.toString(i));
        }
        return answer;
    }

    private static int addClapCount(String counted_number){
        int totalClapCount = 0;
        for(String each_number : counted_number.split("")){
            totalClapCount += countClaps(each_number);
        }
        return totalClapCount;
    }


    private static int countClaps(String each_number){
        if(each_number.equals(THREE)) return 1;
        if(each_number.equals(SIX)) return 1;
        if(each_number.equals(NINE)) return 1;
        return 0;
    }
}
