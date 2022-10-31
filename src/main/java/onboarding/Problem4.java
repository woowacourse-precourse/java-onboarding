package onboarding;

public class Problem4 {

    private static char changeChar(char c) {

        final double CENTEROFUPPERCASE = 77.5;
        final double CENTEROFLOWERCASE = 109.5;

        double codifiedCharacter = (double)c;
        double distanceFromCenter = 0;

        if(c >= 'A' && c <= 'Z') { // 대문자라면
            distanceFromCenter = Math.abs(codifiedCharacter - CENTEROFUPPERCASE);

            if(c < CENTEROFUPPERCASE) {
                codifiedCharacter += 2 * distanceFromCenter;
            } else {
                codifiedCharacter -= 2 * distanceFromCenter;
            }

        } else if (c >= 'a' && c <= 'z') { // 소문자라면
            distanceFromCenter = Math.abs(codifiedCharacter - CENTEROFLOWERCASE);

            if(c < CENTEROFLOWERCASE){
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