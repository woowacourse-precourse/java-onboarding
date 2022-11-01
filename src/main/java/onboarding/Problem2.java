package onboarding;

public class Problem2 {
    public static int findIndexRedundancy(String str, int i) {
        int end = i + 1;
        char std = str.charAt(i);

        while (end < str.length()) {
            if (std != str.charAt(end)) {
                break;
            }
            end += 1;
        }
        return end - 1;
    }

    public static String removeRedundancyChar(String str, int start, int end) {
        String ret = str.substring(0, start) + str.substring(end+1);
        return ret;
    }

    public static String removeRedundancyChars(String str) {
        // i = 중복확인할 인덱스, end = 중복된 마지막 인덱스값
        int i = 0, end;

        while (i < str.length()) {
            end = findIndexRedundancy(str, i);

            // 중복되는 문자가 한개라면
            if (i == end) {
                i += 1;
                continue;
            }
            str = removeRedundancyChar(str, i, end);
        }
        return str;
    }

    public static String solution(String cryptogram) {
        while (true) {
            String newCryptogram = removeRedundancyChars(cryptogram);
            if (newCryptogram.equals(cryptogram)) {
                break;
            }
            cryptogram = newCryptogram;
        }

        return cryptogram;
    }
}
