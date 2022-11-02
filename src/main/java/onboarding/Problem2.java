package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean isExistDuplication;
        do {
            isExistDuplication = removeDuplicationWords(sb);
        }
        while (isExistDuplication);
        answer = sb.toString();
        return answer;
    }

    private static boolean removeDuplicationWords(StringBuilder sb) {
        boolean isExistDuplication = false;
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                int duplicateCnt = 1;
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(i) == sb.charAt(j)) duplicateCnt++;
                    else break;
                }
                sb.delete(i, i + duplicateCnt);
                isExistDuplication = true;
                i--;
            }
        }
        return isExistDuplication;
    }
}
