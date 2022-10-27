package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        return answer;
    }

    public static long countChar(String numberStr, char threeSixNine) {
        return numberStr.chars()
                .filter(character -> character == threeSixNine)
                .count();
    }
}
