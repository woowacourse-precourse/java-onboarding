package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        StringBuilder sb = new StringBuilder(cryptogram);

        while (true) {
            for (int i = 0; i < sb.length() - 1; i++) { //문자열을 한바퀴돌면서 중복된요소들 제거
                int k = i;
                while (k < sb.length() - 1 && sb.charAt(k) == sb.charAt(k + 1)) {
                    k++;
                } //빠져 나온시점에서 i보다 k가 크다면 i~k까지 중복된값이다
                if (i < k) {
                    sb.delete(i, k + 1);
                }
            }

            if (sb.length() == cryptogram.length()) {//중복된것이 없었다는뜻이니까 반복문탈출
                break;
            }
            cryptogram = sb.toString();
        }

        return cryptogram;
    }

}