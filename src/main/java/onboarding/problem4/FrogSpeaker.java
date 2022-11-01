package onboarding.problem4;

public class FrogSpeaker {
    private static final char UPPER_CASE_START_CHAR = 'A';
    private static final char UPPER_CASE_END_CHER = 'Z';
    private static final char LOWER_CASE_START_CHAR = 'a';
    private static final char LOWER_CASE_END_CHAR = 'z';
    private static final char NON_BREAKING_SPACE = ' ';

    private final MessageValidator messageValidator = new MessageValidator();
    public String speak(String message) {
        messageValidator.validate(message);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            if (isAlphabet(messageChar)) {
                messageChar = getReverseChar(messageChar);
            }

            stringBuilder.append(messageChar);
        }

        return stringBuilder.toString();
    }

    private char getReverseChar(char c) {
        if(isUpperCase(c)) {
            return transToUpperCase(c);
        }

        return transToLowerCase(c);
    }
    private boolean isAlphabet(char c) {
        String s = String.valueOf(c);
        final String REGEX = "^[a-zA-Z]*$";

        return s.matches(REGEX);
    }

    private char transToLowerCase(char c) {
        return (char) (LOWER_CASE_END_CHAR - c + LOWER_CASE_START_CHAR);
    }

    private char transToUpperCase(char c) {
        return (char) (UPPER_CASE_END_CHER - c + UPPER_CASE_START_CHAR);
    }

    private boolean isUpperCase(char c) {
        return (UPPER_CASE_START_CHAR <= c && c <= UPPER_CASE_END_CHER);
    }

}
