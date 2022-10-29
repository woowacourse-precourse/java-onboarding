package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static char [] stringToList(String word) {
        return word.toCharArray();
    }

    public static Character findOppositeLetter(int before) {

        if(before >= 65 && before <= 90)
            return (char) (155 - before);

        else if(before >= 97 && before <= 122)
            return (char) (219 - before);

        return (char) before;
    }
}
