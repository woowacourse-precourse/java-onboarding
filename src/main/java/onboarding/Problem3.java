package onboarding;

public class
Problem3 {
    public static int solution(int number) {
        int answer = clapCount(number);
        return answer;
    }

    public static int clapCount(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            String numberToString = "";
            numberToString += i;
            for (int j = 0; j < numberToString.length(); j++) {
                if (numberToString.charAt(j) == '3' ||
                        numberToString.charAt(j) == '6' ||
                        numberToString.charAt(j) == '9') {
                    count++;
                }
            }
        }
        return count;
    }
}
