package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (number < 1 || number > 10000) {
            return 0;
        }
        int answer = 0;
        for (int i = 1; i < number + 1; i++) {
            answer += check3Mul(numberToCharArray(i));
        }
        return answer;
    }

    public static char[] numberToCharArray(int number) {
        return String.valueOf(number).toCharArray();
    }

    public static int check3Mul(char[] numbers) {
        int count = 0;
        for (char charNumber : numbers) {
            int number = Integer.parseInt(String.valueOf(charNumber));
            if (number % 3 == 0 && number > 0) {
                count++;
            }
        }

        return count;
    }
}
