package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    public static int getRepetitionStartPoint(String target) {
        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) == target.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    public static int getRepetitionEndPoint(String target, int startPoint) {
        char targetCharacter = target.charAt(startPoint);

        int endPoint = startPoint + 1;

        while (endPoint < target.length() && targetCharacter == target.charAt(endPoint)) {
            endPoint++;
        }

        return endPoint;
    }

    public static String cutRepetitionPart(String cryptogram, int startPoint, int endPoint) {
        return cryptogram.substring(0, startPoint) + cryptogram.substring(endPoint);
    }
}
