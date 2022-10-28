package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getResultInStringRange(word);
    }

    private static String getResultInStringRange(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            String change = toString(word.charAt(i));
            sb.append(change);
        }

        return sb.toString();
    }

    private static String toString(char character, char lastChar, char firstChar) {
        return String.valueOf((char) lastChar - character + firstChar);
    }

    private static class CharDto {
        private char firstChar;
        private char nowChar;
        private char lastChar;

        public CharDto(char firstChar, char nowChar, char lastChar) {
            this.firstChar = firstChar;
            this.nowChar = nowChar;
            this.lastChar = lastChar;
        }
    }
}
