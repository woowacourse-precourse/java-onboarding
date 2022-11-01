package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            int start = -1;
            int end = -1;
            for (int i = 0; i < answer.length() - 1; ++i) {
                if (answer.charAt(i) == answer.charAt(i + 1)) {
                    start = i;
                    end = start + 1;
                    for (int j = start + 1; j < answer.length(); ++j) {
                        if (j + 1 < answer.length() && answer.charAt(j) == answer.charAt(j + 1)) {
                            end = j + 1;
                        } else {
                            if (j + 2 < answer.length() && answer.charAt(j + 1) == answer.charAt(j + 2)) {
                                end = j + 2;
                                ++j;
                            } else {
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            if (start == -1 && end == -1) {
                break;
            }
            answer = answer.substring(0, start) + answer.substring(end + 1);
        }
        return answer;
    }
}