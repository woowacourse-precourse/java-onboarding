package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        Validator.isValidate(number);


        return answer;
    }


    static class Validator{

        public static boolean isValidate(int num){
            try {
                isCorrectRange(num);
            } catch (Exception error) {
                return false;
            }
            return true;
        }

        private static void isCorrectRange(int num){
            if (num < 1 || num > 10000){
                throw new IllegalArgumentException("is not correct range");
            }
        }
    }
}
