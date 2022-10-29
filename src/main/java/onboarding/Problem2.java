package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String before = cryptogram;

        while (true) {
            String after = makeNewCryptogram(before);
            if (before.equals(after)) {
                answer = after;
                break;
            }
            before = after;
        }
        return answer;
    }

    private static String makeNewCryptogram(String before) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < before.length() - 1; i++) {
            if (before.charAt(i) == before.charAt(i + 1)) {
                i++;
            } else {
                sb.append(before.charAt(i));
            }
        }
        if(before.charAt(before.length() -1) != before.charAt(before.length()-2)){
            sb.append(before.charAt(before.length() - 1));
        }
        return new String(sb);
    }
}