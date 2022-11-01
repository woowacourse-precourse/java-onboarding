package onboarding;

public class Problem3 {

    public static int find369(int number) {
        String numberString = Integer.toString(number);
        int count = 0;

        for (int index = 0; index < numberString.length(); index++) {
            if (numberString.charAt(index) == '3' || numberString.charAt(index) == '6' || numberString.charAt(index) == '9') {
                count += 1;
            }
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
