package onboarding;

public class Problem3 {

    private static final int START_NUMBER = 1;

    public static int solution(int number) {
        int answer = 0;

        for (int currentNumber = START_NUMBER; currentNumber <= number; currentNumber++) {
            answer += count369(currentNumber);
        }

        return answer;
    }

    public static int count369(int number) {
        int result = 0;
        String data = String.valueOf(number);

        for (char word : data.toCharArray()) {
            String tmpData = String.valueOf(word);
            int checkNum = Integer.parseInt(tmpData);
            if(is369(checkNum)) {
                result++;
            }
        }

        return result;
    }

    public static boolean is369(int checkNumber) {
        if(checkNumber == 3 || checkNumber == 6 || checkNumber == 9) {
            return true;
        }
        return false;
    }
}
