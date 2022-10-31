package onboarding.problem4;

public class ReverseGenerator {
    private StringBuilder result;

    public ReverseGenerator(){
        result = new StringBuilder();
    }

    //한글자씩 변환하는 함수
    private char getReverseChar(char c) {
        if (c == ' ') return c;
        if (Character.isLowerCase(c)) return (char) ('z' - (c - 'a'));
        return (char) ('Z' - (c - 'A'));

    }
    //reverse 함수, 문자열 입력받아서 한글자씩 변환 하여 result에 추가한 후 반환
    public String reverse(String word) {
        for (int i = 0; i < word.length(); i++) {
            result.append(getReverseChar(word.charAt(i)));
        }
        return result.toString();
    }

}
