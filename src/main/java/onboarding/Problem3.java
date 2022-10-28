package onboarding;
/**
 * 1. 유효범위 숫자 확인
 * 2. 숫자를 String으로 변환 후 각 자리수 별로 나누기
 */
public class Problem3 {

    public static final String SPLIT_POINT = "";
    public static int solution(int number) {
        checkValidRange(number);
        int answer = 0;
        int result = 0;
        for(int i = 1; i <= number ; i ++ ){
            String[] check369 = String.valueOf(i).split(SPLIT_POINT);
            for (String step : check369) {
                if (step.equals("3") || step.equals("6") || step.equals("9")) {
                    result += 1;
                }
            }
        }

        answer = result;
        return answer;
    }

    private static void checkValidRange(final int number) {
        if (number > 10000 || number <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
