package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean quit = false;
        String crypto_before = cryptogram;
        while (!quit) {
            char[] crypto_arr = crypto_before.toCharArray();
            char before = crypto_arr[0];
            int before_cnt = 1;
            String dummy = "";
            int crpyto_len = crypto_arr.length;
            for (int i = 1; i < crpyto_len; i++) {
                char cur = crypto_arr[i];
                if (crypto_arr[i] != before) {
                    if (before_cnt == 1) {
                        dummy += before;
                    }
                    before_cnt = 1;
                }
                else {
                    before_cnt += 1;
                }
                before = cur;
            }
            if (before_cnt == 1)
                dummy += before;

            quit = (dummy.equals(crypto_before)) || (dummy.length() == 0);
            crypto_before = dummy;
        }
        String answer = crypto_before;
        return answer;
    }
}
