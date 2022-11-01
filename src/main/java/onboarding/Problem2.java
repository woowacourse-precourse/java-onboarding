package onboarding;



public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (!answer.equals(cryptogram)) {
            answer = cryptogram;
            cryptogram = deduplicate(cryptogram);
        }
        return answer;
    }

    static boolean isDuplicate(String str, int idx) {
        if (idx > 0 && str.charAt(idx) == str.charAt(idx - 1)) {
            return true;
        } else return idx < str.length() - 1 && str.charAt(idx) == str.charAt(idx + 1);
    }

    static String deduplicate(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!isDuplicate(str, i)) {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
