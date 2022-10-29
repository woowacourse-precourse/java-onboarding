package onboarding;

public class Problem2 {
    public static boolean isDuplicate(String cryptogram, int sIdx, int eIdx) {
        if(cryptogram.charAt(sIdx) == cryptogram.charAt(eIdx)) {
            return true;
        }
        return false;
    }

    public static String decrypt(String cryptogram) {
        String decrpyto = cryptogram;
        int len = decrpyto.length();
        int idx = 0;

        while (idx < len - 1) {
            if (decrpyto.charAt(idx) == decrpyto.charAt(idx+1)) {   // 중복 문자일 경우 삭제
                decrpyto = decrpyto.substring(0, idx) + decrpyto.substring(idx+2);

                len = decrpyto.length();
            }
            else {  // 아닐 경우 계속 진행
                idx ++;
            }
        }

        return decrpyto;
    }

    public static String solveCrypto(String cryptogram) {
        String decryptogram = decrypt(cryptogram);

        while(!decryptogram.equals(cryptogram)) {
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
