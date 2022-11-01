package onboarding;

public class Problem3 {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 10000;

    public static int solution(int number) {
        int answer = 0;
        int digit = 10000;

        validateNumberRange(number);
        int num = number;

        while(digit >= 10){
            int quotient = num / digit;

            for(int i = 0; i <= quotient; i++){
                int rest = num - (i * digit);

                if(rest < 10){
                    if(i % 3 == 0 && i > 0){

                        answer += (rest + 1);
                    }

                    answer += rest / 3;
                    return answer;

                }else{
                    if(quotient > 0) {
                        if (i % 3 == 0 && i > 0) {
                            answer += 10;
                        } else {
                            answer += 3;
                        }
                    }
                }
            }
            num %= digit;
            digit /= 10;
        }

        return answer;
    }

    public static void validateNumberRange(int number){
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException("number 는 " + MIN_NUMBER + " 이상, " +
                    + MAX_NUMBER + "이하인 자연수이어야 한다.");
        }
    }
}
