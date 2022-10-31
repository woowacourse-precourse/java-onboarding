package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;

        for (var i = 1; i <= number; i++) {
            count += countChar(i + "", '3');
            count += countChar(i + "", '6');
            count += countChar(i + "", '9');
        }

        return count;
    }

    public static int countChar(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }
}
