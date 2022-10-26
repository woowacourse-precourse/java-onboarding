package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        char[] chars = cryptogram.toCharArray();
        boolean hasNotDuplicate = false;
        String answer = "";

        while (!hasNotDuplicate) {
            final StringBuilder newCryptogram = new StringBuilder();
            char duplicateChar = ' ';
            hasNotDuplicate = true;
            for (int i = 0; i < chars.length; i++) {
                final char character = chars[i];
                if (i == 0) {
                    if (chars[i] != chars[i + 1]) {
                        newCryptogram.append(character);
                    }
                    continue;
                }

                if (i == chars.length - 1) {
                    if (character != chars[i - 1] && character != duplicateChar) {
                        newCryptogram.append(character);
                    }
                    continue;
                }

                if (character == chars[i + 1]) {
                    duplicateChar = character;
                    hasNotDuplicate = false;
                    continue;
                }
                if (character != chars[i + 1]) {
                    if (chars[i] != duplicateChar) {
                        newCryptogram.append(character);
                        duplicateChar = ' ';
                    }
                }
            }
            chars = newCryptogram.toString().toCharArray();
            if (hasNotDuplicate) {
                answer = newCryptogram.toString();
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Problem2.solution("zyelleyz");
    }
}
