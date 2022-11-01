package onboarding;

public class Problem2 {

    // public static void main(String[] args) {
    // String k = "zyelleyz";
    // System.out.println(solution(k));
    // }

    static int ff(String k) {
        int flag = -1;
        for (int i = 0; i < k.length() - 1; i++) {
            if (k.charAt(i) == k.charAt(i + 1)) {
                flag = i;
                return flag;
            }
        }
        return flag;
    }

    static String func(String k) {
        String tmp = k;
        while (ff(tmp) != -1) {
            tmp = tmp.substring(0, ff(tmp)) + tmp.substring(ff(tmp) + 2, tmp.length());
        }
        return tmp;

    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = func(cryptogram);
        return answer;
    }
}
