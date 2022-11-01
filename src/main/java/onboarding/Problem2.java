package onboarding;



public class Problem2 {
    public static boolean isDuplicate(String cryptogram, int sIdx, int eIdx) {
        if (cryptogram.charAt(sIdx) == cryptogram.charAt(eIdx)) {
            return true;
        }
        return false;
    }

    public static int getDupIdx(String crpytogram, int sIdx) {
        int eIdx = sIdx + 1;
        while (eIdx < crpytogram.length() && isDuplicate(crpytogram, sIdx, eIdx)) {
            eIdx ++;
        }

        return eIdx;
    }

    public static String decrypt(String cryptogram) {
        String decrpyto = cryptogram;
        int len = decrpyto.length();
        int sIdx = 0;
        int eIdx = 0;

        while (sIdx < len - 1) {
            if (isDuplicate(decrpyto, sIdx, sIdx + 1)) {
                eIdx = getDupIdx(decrpyto, sIdx);
                decrpyto = decrpyto.substring(0, sIdx) + decrpyto.substring(eIdx);

                len = decrpyto.length();
            } else {  // 아닐 경우 계속 진행
                sIdx ++;
            }
        }

        return decrpyto;
    }

    public static String solveCrypto(String cryptogram) {
        String decryptogram = decrypt(cryptogram);

        while (!decryptogram.equals(cryptogram)) {
            cryptogram = decryptogram;
            decryptogram = decrypt(cryptogram);
        }

        return decryptogram;
    }


    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = solveCrypto(cryptogram);

        return answer;
    }
}
