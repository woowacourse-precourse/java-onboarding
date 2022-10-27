package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);
        boolean findDuplicate = false;
        do {
            findDuplicate = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                char first = sb.charAt(i);
                char second = sb.charAt(i + 1);
                if (first == second) {
                    sb.replace(i, i + 2, "");
                    findDuplicate = true;
                    break;
                }
            }
        } while (findDuplicate);

        return sb.toString();
    }
}
