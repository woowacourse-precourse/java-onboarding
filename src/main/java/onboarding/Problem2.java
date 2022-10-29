package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        int dupIdx;

        while (true) {
            dupIdx = dupIndex(cryptogram);
            if (dupIdx == -1)
                break;
            cryptogram = deleteDup(cryptogram, dupIdx);
        }
        return cryptogram;
    }
    private static int dupIndex(String str) {
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1))
                return i;
        }
        return -1;
    }

    private static String deleteDup(String str, int dupIdx) {
        return str.substring(0,dupIdx) + str.substring(dupIdx+2);
    }

}
