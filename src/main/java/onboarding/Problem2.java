package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validation(cryptogram)) return "ERROR";
        String curr = cryptogram;
        while (true) {
            String next = delete(curr);
            if (curr.equals(next)) break;
            curr = next;
        }
        return curr;
    }

    static boolean validation(String cryptogram) {
        int length = cryptogram.length();
        if (length == 0 || length > 1000) return false;
        for (char c : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }

    static String delete(String curr) {
        boolean[] delete = new boolean[curr.length()];
        for (int i = 0; i < curr.length() - 1; i++) {
            if (curr.charAt(i) == curr.charAt(i + 1)) {
                delete[i] = delete[i + 1] = true;
            }
        }
        StringBuilder deleted = new StringBuilder();
        for (int i = 0; i < curr.length(); i++) {
            if (delete[i]) {
                continue;
            }
            deleted.append(curr.charAt(i));
        }
        return deleted.toString();
    }
}
