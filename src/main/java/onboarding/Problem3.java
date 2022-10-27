package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int[] toInts(String value) {
        int[] numbers = new int[value.length()];
        for(int i = 0; i < value.length(); i++) {
            numbers[i] = value.charAt(i) - '0';
        }
        return numbers;
    }
}
