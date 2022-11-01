package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.equals("")) return "";

        int duplicateStart;
        for (duplicateStart = 0; duplicateStart < cryptogram.length() - 1; duplicateStart++) {
            if (cryptogram.charAt(duplicateStart) == cryptogram.charAt(duplicateStart + 1)) break;
        }

        if (duplicateStart == cryptogram.length() - 1) return cryptogram; // no duplicate

        int duplicateEnd;
        for (duplicateEnd = duplicateStart; duplicateEnd < cryptogram.length() - 1; duplicateEnd++) {
            if (cryptogram.charAt(duplicateEnd) != cryptogram.charAt(duplicateEnd + 1)) break;
        }

        return solution(cryptogram.substring(0, duplicateStart)
                + cryptogram.substring(duplicateEnd + 1));
    }
}
