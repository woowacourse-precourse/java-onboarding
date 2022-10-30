package onboarding;

public class Problem4 {

    private static char changeChar(char c) {

        double codifiedCharacter = (double)c;
        double distanceFromCenter = 0;

        if(c >= 65 && c <= 90) { // 대문자라면
            distanceFromCenter = Math.abs(codifiedCharacter - 77.5);

            if(c < 77.5) {
                codifiedCharacter += 2 * distanceFromCenter;
            } else {
                codifiedCharacter -= 2 * distanceFromCenter;
            }

        } else if (c >= 97 && c <= 122) { // 소문자라면
            distanceFromCenter = Math.abs(codifiedCharacter - 109.5);

            if(c < 109.5){
                codifiedCharacter += 2 * distanceFromCenter;
            } else {
                codifiedCharacter -= 2 * distanceFromCenter;
            }
        }
        return (char) codifiedCharacter;
    }

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word.length());

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char changedChar = changeChar(c);
            sb.append(changedChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}