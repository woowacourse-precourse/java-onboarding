package onboarding.problem6;

public final class RabinKarp {

    private static final int POW = 31;

    public static boolean contains(String src, String target) {
        int lengthOfTarget = target.length();
        int lengthOfSrc = src.length();

        if (lengthOfSrc < lengthOfTarget) {
            return false;
        }

        int cachedPow = (int) Math.pow(POW, lengthOfTarget);
        int hashValueOfTarget = getHashValue(target, lengthOfTarget);
        int hashValueOfSrc = getHashValue(src, lengthOfTarget);

        if ((hashValueOfSrc == hashValueOfTarget)
                && isSame(src, 0, target, 0, lengthOfTarget)) {
            return true;
        }

        for (int i = lengthOfTarget; i < lengthOfSrc; i++){
            hashValueOfSrc = hashValueOfSrc * POW + src.charAt(i);
            hashValueOfSrc -= src.charAt(i - lengthOfTarget) * cachedPow;

            if ((hashValueOfSrc == hashValueOfTarget)
                    && isSame(src, i - lengthOfTarget + 1, target, 0, lengthOfTarget)) {
                return true;
            }
        }

        return false;
    }

    private static int getHashValue(String str, int length) {
        int hash = 0;

        for (int  i = 0; i < length; i++) {
            hash = hash * POW + str.charAt(i);
        }

        return hash;
    }

    private static boolean isSame(String src, int srcIdx, String target, int targetIdx, int length) {
        while (length-- > 0) {
            if (src.charAt(srcIdx++) != target.charAt(targetIdx++)) {
                return false;
            }
        }

        return true;
    }

}