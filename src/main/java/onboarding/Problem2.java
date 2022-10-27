package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = delete(cryptogram);

        return answer;
    }


    public static String delete(String str) {
        if (str.equals("")) {
            return str;
        }

        int N = str.length();
        String newStr = "";

        char prev = str.charAt(0);
        for (int i = 1; i < N; i++) {
            char curr = str.charAt(i);
            if (prev == curr) {
                prev = ' ';
            } else {
                if (prev != ' ') {
                    newStr += prev;
                }
                prev = curr;
            }
            if (i == N-1) {
                newStr += prev;
            }
        }
        if (N == newStr.length()) {
            return newStr;
        } else {
            return delete(newStr);
        }
    }
}
