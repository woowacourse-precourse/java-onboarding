package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<=number; i++) {
            char[] numberElements = Integer.toString(i).toCharArray();
            for (char element : numberElements) {
                if (isThree(element) || isSix(element) || isNine(element))
                    answer++;
            }
        }
        return answer;
    }

    public static boolean isThree(Character element) {
        return element == '3';
    }

    public static boolean isSix(Character element) {
        return element == '6';
    }

    public static boolean isNine(Character element) {
        return element == '9';
    }
}
