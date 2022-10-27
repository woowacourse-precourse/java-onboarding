package onboarding;

public class Problem2 {
    public static int findIndexRedundancy(String str, int i) {
        int end = i + 1;
        char std = str.charAt(i);

        while (end < str.length()) {
            if (std != str.charAt(end)) {
                break;
            }
            end += 1;
        }

        return end - 1;
    }

    public static String removeRedundancyChar(String str, int start, int end) {
        String ret = str.substring(0, start) + str.substring(end+1);
        return ret;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
