package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (true) {
            boolean isDuplicated = false;
            for (int i = 0; i < cryptogram.length(); i++) {
                int duplicateCount = checkDuplicate(cryptogram, i);
                if (duplicateCount == -1 || duplicateCount == 0) {
                    continue;
                } else {
                    cryptogram = deleteDuplicate(cryptogram, i, duplicateCount);
                    isDuplicated = true;
                    break;
                }
            }
            if(!isDuplicated) break;
        }

        return cryptogram;
    }

    private static String deleteDuplicate(String cryptogram, int idx, int count) {
        String c = cryptogram.substring(0, idx);
        c += cryptogram.substring(idx + count + 1, cryptogram.length());

        return c;
    }

    private static int checkDuplicate(String cryptogram, int idx) {
        char c = cryptogram.charAt(idx);
        int cnt = 0;
        for (int i = idx + 1; i < cryptogram.length(); i++) {
            if(c == cryptogram.charAt(i)) cnt += 1;
            else {
                if(i == idx + 1) cnt = -1;
                break;
            }
        }
        return cnt;
    }
}
