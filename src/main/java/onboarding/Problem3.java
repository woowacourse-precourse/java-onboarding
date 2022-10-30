package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static String intToString(int number) {
        return Integer.toString(number);
    }

    public static int count369(String number) {
        return (int) number.chars()
                .map(Character::getNumericValue)
                .filter(num -> num == 3 || num == 6 || num == 9)
                .count();
    }
}
