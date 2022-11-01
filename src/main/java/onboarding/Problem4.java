package onboarding;

public class Problem4 {
     public static String solution(String word) {
        String answer = convertWord(word);
        return answer;
    }

    private static String convertWord(String string) {
        StringBuffer buffer = new StringBuffer(string);
        StringBuffer convertBuffer = new StringBuffer();

        for(int i = 0 ; i < buffer.length(); ++i) {

            if((int)buffer.charAt(i) >= 'A' && (int)buffer.charAt(i) <= 'Z') {
                convertBuffer.append(convertUppercase(buffer.charAt(i)));
                continue;
            }

            if((int)buffer.charAt(i) >= 'a' && (int)buffer.charAt(i) <= 'z') {
                convertBuffer.append(convertLowercase(buffer.charAt(i)));
                continue;
            }

            convertBuffer.append(buffer.charAt(i));
        }
        return  convertBuffer.toString().trim();
    }

    private static char convertUppercase(char upper) {
        int convertStandard = 'A' + 'Z';

        char converChar = (char)(convertStandard - (int)upper);

        return converChar;

    }
    private static char convertLowercase(char lower) {
        int convertStandard = 'a' + 'z';

        char converChar = (char)(convertStandard - (int)lower);

        return converChar;
    }
}