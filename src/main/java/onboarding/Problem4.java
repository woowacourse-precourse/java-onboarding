package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = getConvertedString(word.toCharArray());
        return answer;
    }

    public static String getConvertedString(char [] word) {
        StringBuilder builder = new StringBuilder();

        for(char letter : word) {
            builder.append(findOppositeLetter(letter));
        }

        return builder.toString();
    }

    public static Character findOppositeLetter(int before) {

        if(before >= 65 && before <= 90)
            return (char) (155 - before);

        else if(before >= 97 && before <= 122)
            return (char) (219 - before);

        return (char) before;
    }
}
