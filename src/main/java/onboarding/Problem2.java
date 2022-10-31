package onboarding;

public class Problem2 {

    /**
     *
     * @param cryptogram
     * @return 중복된 문자가 있다면, 해당 문자의 index, 중복된 문자가 없다면 -1
     *
     */
    public static int checkDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return i;
        }
        return -1;
    }
    public static String solution(String cryptogram) {

        while (true) {
            int idx = checkDuplicate(cryptogram);
            if (idx == -1) break;

            // edge case : 문자열의 길이가 2이면서 중복된 문자가 있는 경우 - 바로 빈 문자열을 return
            if (cryptogram.length() == 2) return "";

            // 1. 중복된 문자가 첫 번째 index에 나온 경우
            if (idx == 0) cryptogram = cryptogram.substring(2);
            // 2. 중복된 문자가 마지막 index에 나온 경우
            else if (idx == cryptogram.length() - 2) cryptogram = cryptogram.substring(0, cryptogram.length() - 2);
            // 3. 그 외 일반적인 경우
            else cryptogram = cryptogram.substring(0, idx) + cryptogram.substring(idx + 2);
        }

        return cryptogram;
    }
}
