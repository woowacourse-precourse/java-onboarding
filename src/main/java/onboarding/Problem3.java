package onboarding;

public class Problem3 {

    private static int clapCount(int number) {
        int clapCountResult = 0;

        for(int value = 1; value <= number; value++) {

            String numberString = String.valueOf(value);

            for(int i = 0; i < numberString.length(); i++) {
                char tmpValue = numberString.charAt(i);

                if(tmpValue == '3' || tmpValue == '6' || tmpValue == '9') {
                    clapCountResult++;
                }
            }
        }
        return clapCountResult;
    }
    public static int solution(int number) {
        int answer = clapCount(number);
        return answer;
    }
}
