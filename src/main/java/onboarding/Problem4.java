package onboarding;

/**
 * 기능목록 <br>
 * 1. 소문자 알파벳을 반대로 바꿔주는 메서드 <br>
 * 2. 대문자 알파벳을 반대로 바꿔주는 메서드 <br>
 * 3. 전체 문자열에 대해 알파벳이라면 바꿔주고 문자가 아니면 바꾸지 않도록 구현 <br>
 */

public class Problem4 {
    public static String solution(String word) {
        StringBuilder changedStr = new StringBuilder();

        // 전체 문자열에 대해 알파벳이라면 바꿔주고 문자가 아니면 바꾸지 않도록 한다.
        for (char c : word.toCharArray()) {
            char changedAlphabet = getCharacter(c);
            changedStr.append(changedAlphabet);
        }

        return changedStr.toString();
    }

    private static Character getCharacter(char c) {
        char changedChar = c;

        //소문자라면
        if (Character.isLowerCase(c)) {
            changedChar = getLowerCaseCharacter(c);
        }
        //대문자라면
        else if (Character.isUpperCase(c)) {
            changedChar = getUpperCaseCharacter(c);
        }

        return changedChar;
    }


    //소문자 알파벳을 반대로 바꿔준다.
    private static Character getLowerCaseCharacter(char c) {
        int dif = c - 'a';
        return (char) ('z' - dif);
    }

    //대문자 알파벳을 반대로 바꿔준다.
    private static Character getUpperCaseCharacter(char c) {
        int dif = c - 'A';
        return (char) ('Z' - dif);
    }


}
