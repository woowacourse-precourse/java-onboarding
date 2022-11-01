package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = TheeSixNineGame.countAllClapping(number);

        return answer;
    }
}

class TheeSixNineGame {

    public static int countAllClapping(int lastNumber){

        int allCount = 0;

        for (int i = 1; i <= lastNumber; i++) {
            allCount += countClapping(i);
        }

        return allCount;
    }

    private static int  countClapping(int number) {

        int count = 0;
        String str = Integer.toString(number);
        String[] arrayDigit = str.split("");

        for (String a : arrayDigit) {
            count += addClapping(a);
        }

        return count;
    }

    private static int addClapping(String number) {

        if (number.equals("3") || number.equals("6") || number.equals("9")) {
            return 1;
        }

        return 0;
    }

}