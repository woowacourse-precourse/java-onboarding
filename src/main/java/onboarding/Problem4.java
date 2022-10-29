package onboarding;

/*
*  기능구현
* 1. char형의 배열을 표에 맞게 변환하는 기능
* */
public class Problem4 {
    public static String solution(String word) {
        return String.valueOf(translation(word));
    }

    static char[] translation(String word) {
        char[] charList = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if((word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'))
                charList[i] = (char)('Z' - (word.charAt(i) - 'A'));
            else if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
                charList[i] = (char)('z' - (word.charAt(i) - 'a'));
            else
                charList[i] = word.charAt(i);
        }
        return charList;
    }
}
