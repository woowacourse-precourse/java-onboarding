package onboarding.problem2;

public class Cryptogram {
    public static String decryptCryptogram(String s) {
        StringBuffer sb = new StringBuffer(s);
        int left = 0;
        int right = left;
        while (left < sb.length()) {
            right = findDuplication(sb, left);
            if (left != right) {
                sb.delete(left, right + 1);
            }
            left += 1;
        }
        if (sb.toString().equals(s)) {
            return s;
        } else {
            return decryptCryptogram(sb.toString());
        }
    }
}
