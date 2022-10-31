package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        char[] chars;
        char prev;
        int k;
        boolean deleteonce = false;

        do {
            answer = cryptogram;
            chars = answer.toCharArray();
            prev = 0;
            k = 0;

            for (char c: chars) {
                if (prev != c) {
                    chars[k++] = c;
                    prev = c;
                    deleteonce = false;
                } else if (!deleteonce) {
                    --k;
                    deleteonce = true;
                }
            }
            cryptogram = new String(chars).substring(0, k);

        } while (!cryptogram.equals(answer));

        return answer;
    }
}
