package onboarding;

public class Problem2 {
    /*
    같은 문자가 2번 이상 나오면 그 문자열을 삭제하는 것이 목적입니다.
    주어진 cryptogram 문자열을 순회하면서 만약 이전과는 다른 문자가 나타났고, 이전 문자가 연속해서 나왔었다면, 그 문자는 제외되는 로직을 사용했습니다.
    */
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
                    if (before_cnt == 1)
                        dummy += before;
                    before_cnt = 1;
                } else
                    before_cnt += 1;

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
