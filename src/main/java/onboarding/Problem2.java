package onboarding;

public class Problem2 {
    public static String removeDuplication(String crtpto) {
        String result = "";
        int index = 0;
        int count = 0;
        for (int i = 0; i < crtpto.length() - 1; i++) {
            if (crtpto.charAt(i) == crtpto.charAt(i + 1)) {
                result += crtpto.substring(index, i);
                if (crtpto.length() > i + 2)
                    result += crtpto.substring(i + 2);
                count++;
                break;
            }
        }
        if (count == 0)
            return crtpto;
        return removeDuplication(result);
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = removeDuplication(cryptogram);
        return answer;
    }
}
