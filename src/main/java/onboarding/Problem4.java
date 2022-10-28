package onboarding;

public class Problem4 {
    private static final int space = ' ';
    private static final int upperA = 'A';
    private static final int upperZ = 'Z';
    private static final int lowerA = 'a';
    private static final int lowerZ = 'z';

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < word.length(); i++){
            int asciiCode = word.charAt(i);
            append(asciiCode, answer);
        }
        return answer.toString();
    }

    public static void append(int asciiCode, StringBuilder answer){
        if (asciiCode == space){
            answer.append((char) space);
            return;
        }
        if (asciiCode >= lowerA && asciiCode <= lowerZ){
            answer.append((char) (lowerZ - (asciiCode - lowerA)));
            return;
        }
        if (asciiCode >= upperA && asciiCode <= upperZ){
            answer.append((char) (upperZ - (asciiCode - upperA)));
        }
    }
}
