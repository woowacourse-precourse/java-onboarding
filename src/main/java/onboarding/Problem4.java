package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(char c: word.toCharArray()) {
            if(checkAlphabet((int)c)) {
                answer.append(changeLetter((int)c));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }

    public static boolean checkAlphabet(int asciiNum) {
        return asciiNum >= 65 && (asciiNum <= 90 || asciiNum >= 97) && asciiNum <= 122;
    }

    public static char changeLetter(int asciiNum) {
        int TOTAL = 0;
        if (asciiNum <= 90) {
            TOTAL = (int)'A' + (int)'Z';
        }
        if(asciiNum >= 97){
            TOTAL = (int)'a' + (int)'z';
        }
        return (char)(TOTAL - asciiNum);
    }
}
