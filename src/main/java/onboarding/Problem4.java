package onboarding;


/*
* 0. word 내의 모든 char c에 대해서 반복
* 1. c가  알파벳에 해당하는 지 확인
* 1-1. 알파벳이 아니라면, answer에 append()
* 1-2. 알파벳이라면, 뒤집어서 append()
 * */



public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (char c : word.toCharArray()) {
            answer.append(determineReverseOrNot(c));
        }

        return answer.toString();
    }

    private static char determineReverseOrNot(char c) {
        if (c < 65 || (c > 90 && c < 96) || c > 122) return c;
        return reverseCharacter(c);
    }

    private static char reverseCharacter(char c) {
        double distance = c <= 90 ? 77.5 - c : 109.5 - c;

        return (char) (c + (int) (distance*2));
    }
}
