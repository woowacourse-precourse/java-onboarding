package onboarding;

public class Problem4 {

    private static CharDto charDto;

    public static String solution(String word) {
        return getResultInStringRange(word);
    }

    private static String getResultInStringRange(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++) {
            isUpperCase(word.charAt(i));
            sb.append(toString(charDto));
        }

        return sb.toString();
    }

    private static void isUpperCase(char character) {
        if('A' <= character && character <= 'Z') {
            charDto = new CharDto('A', character, 'Z');
        }
        else {
            charDto = new CharDto('a', character, 'z');
        }
    }

    private static String toString(CharDto charDto) {
        return String.valueOf((char) (charDto.lastChar - charDto.nowChar + charDto.firstChar));
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
