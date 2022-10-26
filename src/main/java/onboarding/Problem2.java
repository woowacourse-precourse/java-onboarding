package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        int index = checkDuplicated(answer);
        while (index != -1) {
            answer = removeDuplicated(answer, index);
            index = checkDuplicated(answer);
        }
        return answer;
    }

    private static int checkDuplicated(String string) {
        String[] strings = string.split("");
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].equals(strings[i + 1])) {
                return i;
            }
        }
        return -1;
    }

    private static String removeDuplicated(String string, Integer index) {
        if (index == 0) {
            return string.substring(2);
        }

        String frontString = string.substring(0, index);
        String backString = string.substring(index + 2);
        return frontString + backString;
    }
}
