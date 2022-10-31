package onboarding;

public class Problem4 {
    public static char convertAlphabet(char alphabet) {
        int convertAscii = 0;
        int ascii = (int)alphabet;
        if(Character.isUpperCase(alphabet)){
            convertAscii = 155 - ascii;
        } else if (Character.isLowerCase(alphabet)) {
            convertAscii = 219 - ascii;
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
