package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String smallAlpha = "abcdefghijklmnopqrstuvwxyz";
        String smallAhpla = "zyxwvutsrqponmlkjihgfedcba";
        String bigAlpha = "ABCDEFGHIJKMLNOPQRSTUVWXYZ";
        String bigAhpla = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);

            int smallResult = smallAlpha.indexOf(now);
            if (smallResult != -1) {
                answer += smallAhpla.charAt(smallResult);
            } else {
                int bigResult = bigAlpha.indexOf(now);

                if (bigResult != -1) {
                    answer += bigAhpla.charAt(bigResult);
                } else {
                    answer += now;
                }
            }
        }

        return answer;
    }
}
