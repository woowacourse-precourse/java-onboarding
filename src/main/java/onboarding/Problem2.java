package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int idx;
        while ((idx = getDuplicateIdx(cryptogram)) != -1) {
            String prefix = idx == 0 ? "" : cryptogram.substring(0, idx);
            String suffix = cryptogram.substring(idx + 2);
            cryptogram = prefix + suffix;
        }

        return cryptogram;
    }

    // 중복되는 문자의 위치 정보를 반환 i와 i+1이 중복됨, 없으면 -1
    public static int getDuplicateIdx(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                return i;
        }
        return -1;
    }
}
