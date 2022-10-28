package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (true) {
            int[] duplicateIndex = checkDuplicate(cryptogram);
            if (duplicateIndex[0] == -1) break;
            cryptogram = deleteDuplicate(cryptogram, duplicateIndex);

        }
        return cryptogram;
    }

    private static String deleteDuplicate(String cryptogram, int[] idxAndCount) {
        String c = cryptogram.substring(0, idxAndCount[0]);
        c += cryptogram.substring(idxAndCount[0] + idxAndCount[1] + 1, cryptogram.length());

        return c;
    }

    private static int[] checkDuplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            int duplicateCount = countDuplicate(cryptogram, i);
            if (duplicateCount == -1 || duplicateCount == 0) continue;
            return new int[]{i, duplicateCount};
        }
        return new int[]{-1,-1};
    }

    private static int countDuplicate(String cryptogram, int idx) {
        char c = cryptogram.charAt(idx);
        int cnt = 0;
        for (int i = idx + 1; i < cryptogram.length(); i++) {
            if (c == cryptogram.charAt(i)) cnt += 1;
            else {
                if (i == idx + 1) cnt = -1;
                break;
            }
        }
        return cnt;
    }
}
