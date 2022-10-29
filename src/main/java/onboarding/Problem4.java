package onboarding;

public class Problem4 {
    public static char convertAlphabet(char alphabet) {
        int convertAscii = 0;
        int ascii = 0;
        if(Character.isUpperCase(alphabet)){
            ascii = (int)alphabet;
            convertAscii = Math.abs(155 - ascii);
        } else if (Character.isLowerCase(alphabet)) {
            ascii = (int)alphabet;
            convertAscii = Math.abs(219 - ascii);
        }
        char convert = (char)convertAscii;
        return convert;
    }

    public static String convertWord(String word){
        char[] alphabetArr = word.toCharArray();
        String convertW = "";
        for (char c:alphabetArr) {
            if (c != ' ') {
                c = convertAlphabet(c);
            }
            convertW += c;
        }
        return convertW;
    }

    public static String solution(String word) {
        String answer = convertWord(word);
        return answer;
    }
}
