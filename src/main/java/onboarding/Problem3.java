package onboarding;


public class Problem3 {
    static int result;
    public static int solution(int number) {
        result =0;
        for(int i=1; i<=number; i++){
            validateType(i);
        }
        return result;
    }


    private static void validateType(int i) {
        String number = String.valueOf(i);

        for(int j=0; j<number.length(); j++){
            checkScore(number.charAt(j));
        }
    }

    private static int checkScore(char number) {
        if(number == '3' || number == '6' || number == '9'){
            result++;
        }
        return result;
    }
}