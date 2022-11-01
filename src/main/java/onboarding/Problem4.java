package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        getConvertString(word, sb);
        answer = sb.toString();
        return answer;
    }

    private static void getConvertString(String word, StringBuilder sb) {
        char charAtNow = '0';
        int intAtNow = 0;
        int intWantParse = 0;
        char charWantParse = 0;

        for (int index = 0; index < word.length(); index++) {
            charAtNow = word.charAt(index);
            if (charAtNow != ' ') {
                intAtNow = (int) charAtNow;
                intWantParse = getIntWantParse(intAtNow);
                charWantParse = (char) intWantParse;
                sb.append(charWantParse);
            } else {
                sb.append(charAtNow);
            }
        }
    }

    private static int getIntWantParse(int intAtNow) {
        int aParseInt = 'a';
        int zParseInt = 'z';
        int AParseInt = 'A';
        int ZParseInt = 'Z';
        if (intAtNow <= 122 && intAtNow >= 97) {
            return zParseInt - (intAtNow - aParseInt);
        } else {
            return ZParseInt - (intAtNow - AParseInt);
        }
    }

}
