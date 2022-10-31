package onboarding.problem2;

public class Cryptogram {
    public static String decryptCryptogram(String cryptogram) {
        StringBuffer cryptogramSb = new StringBuffer(cryptogram);
        int left = 0;
        int right = left;
        while (left < cryptogramSb.length()) {
            right = findDuplication(cryptogramSb, left);
            if (left != right) {
                cryptogramSb.delete(left, right + 1);
            }
            left += 1;
        }
        if (cryptogramSb.toString().equals(cryptogram)) {
            return cryptogram;
        } else {
            return decryptCryptogram(cryptogramSb.toString());
        }
    }

    private static int findDuplication(StringBuffer sb, int next) {
        while (next < sb.length() - 1 && sb.charAt(next + 1) == sb.charAt(next)) {
            next += 1;
        }
        return next;
    }
}
