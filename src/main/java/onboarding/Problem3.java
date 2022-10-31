package onboarding;

public class Problem3 {

    static final String THREE = "3";
    static final String SIX = "6";
    static final String NINE = "9";
    static final int INPUT_MINIMUM_VALUE = 1;
    static final int INPUT_MAXIMUM_VALUE = 10000;
    static final String INPUT_TOO_SMALL_EXCEPTION = "입력한 값이 1보다 작습니다. ";
    static final String INPUT_TOO_BIG_EXCEPTION = "입력한 값이 10000보다 큽니다. ";

    public static int solution(int number) {
        checkInput(number);
        return calculateResult(number);
    }

    private static void checkInput(int number){
        if(number < INPUT_MINIMUM_VALUE) inputTooSmallException();
        if(number > INPUT_MAXIMUM_VALUE) inputTooBigException();
    }

    private static void inputTooSmallException(){
        throw new IllegalArgumentException(INPUT_TOO_SMALL_EXCEPTION);
    }

    private static void inputTooBigException(){
        throw new IllegalArgumentException(INPUT_TOO_BIG_EXCEPTION);
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
