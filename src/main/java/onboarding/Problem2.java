
package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (hasDuplication(answer)) {
            answer = makeNewWord(answer);
        }

        return answer;
    }

    private static boolean hasDuplication(String word) {
        boolean duplicationValue = false;
        int i = 0;

        while (!duplicationValue && (i < word.length() - 1)) {
            char nowLetter = word.charAt(i);
            char backLetter = word.charAt(i + 1);

            duplicationValue = (nowLetter == backLetter);
            i++;
        }

        return duplicationValue;
    }

    private static String makeNewWord(String answer) {
        StringBuilder sb = new StringBuilder();
        char[] c = answer.toCharArray();

        for (int i = 0; i < c.length - 1; i++) {
            i = moveIndex(c, i);
        }

        for (int i = 0; i < c.length; i++) {
            buildString(sb, c, i);
        }

        return sb.toString();
    }

    private static int moveIndex(char[] c, int index) {
        if (c[index] == c[index + 1]) {
            char nowLetter = c[index];
            index = removeDuplication(c, index, nowLetter);
        }

        return index;
    }

    private static int removeDuplication(char[] c, int index, char nowLetter) {
        while (index < c.length && c[index] == nowLetter) {
            c[index] = '0';
            index++;
        }

        return index;
    }

    private static void buildString(StringBuilder sb, char[] c, int i) {
        if (c[i] != '0') {
            sb.append(c[i]);
        }
    }
}