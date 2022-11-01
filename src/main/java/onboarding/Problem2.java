package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        while (true) {
            String med = "";
            boolean[] duplicate = check(cryptogram);
            med = delete(duplicate, cryptogram);
            if (cryptogram.equals(med) || cryptogram.equals("")) break;
            cryptogram = med;
        }
        answer = cryptogram;

        return answer;
    }
    // 리펙토링
    static boolean[] check(String s) {
        boolean[] a = new boolean[s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                a[i] = a[i+1] = true;
            }
        }
        return a;
    }

    static String delete(boolean[] a, String s) {
        String medium = "";
        for (int i = 0; i < a.length; i++) {
            if (!a[i]) {
                medium += s.charAt(i);
            }
        }
        return medium;
    }

}
