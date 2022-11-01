package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        int dupStartIdx;

        while (true) {
            dupStartIdx = findDupStartIdx(cryptogram);
            if (dupStartIdx == -1)
                break;
            cryptogram = deleteDup(cryptogram, dupStartIdx);
        }
        return cryptogram;
    }

    private static int findDupStartIdx(String str) {
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1))
                return i;
        }
        return -1;
    }

    private static int findDupEndIdx(String str, int dupStartIdx) {
        int i = dupStartIdx;

        while (str.charAt(i) == str.charAt(dupStartIdx)) {
            i++;
        }
        return i;
    }

    private static String deleteDup(String str, int dupStartIdx) {
        int dupEndIndex = findDupEndIdx(str, dupStartIdx);

        return str.substring(0,dupStartIdx) + str.substring(dupEndIndex);
    }

}
