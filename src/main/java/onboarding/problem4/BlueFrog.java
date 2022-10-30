package onboarding.problem4;

public class BlueFrog {

    public static String sayBlueFrog(String s) {
        Word.validate(s);
        return reverseWord(s);
    }

    // 문자 하나를 반대로 변환하는 메서드
    // 알파벳 외의 문자는 변환하지 않는다.
    // 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
    public static char reverseLetter(char letter) {

        char reverseLetter = letter;

        if (Character.isUpperCase(letter)){
            reverseLetter = (char)('Z' - (letter - 'A'));
        }
        else if (Character.isLowerCase(letter)) {
            reverseLetter = (char)('z' - (letter - 'a'));
        }
        return reverseLetter;
    }

    // 문자열 전체를 반대로 변환하는 메서드
    public static String reverseWord(String s){

        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            charArray[i] = reverseLetter(charArray[i]);
        }
        return String.valueOf(charArray);
    }

}
