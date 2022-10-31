package onboarding;

public class Problem3 {
    public static int solution(int number) {
        checkList(number);



    }

    public static void checkList(int number) throws IllegalArgumentException{
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("number는 1 미만 10,000 초과인 자연수 입니다.");
        }
    }


}
