package onboarding;

public class Problem4 {

    public static String solution(String word) {

        String answer = "";
        return answer;
    }

    //알파벳만 반대로 반환
    static char getReverseAlphabet(char word) {

        int ascNum = (int) word;

        if (ascNum >= 65 && ascNum <= 90) {
            ascNum = 155 - ascNum;
            word = (char) ascNum;

        } else if (ascNum >= 97 && ascNum <= 122) {
            ascNum = 219 - ascNum;
            word = (char) ascNum;
        }

        return word;
    }
}
