package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram, "");
    }

    /**
     * 암호화된 문자열을 받아 복호화된 문자열을 반환한다.
     * 
     * @param cryptogram
     * @param removedCryptogram
     * @return 복호화된 문자열
     */
    private static String decrypt(String cryptogram, String removedCryptogram) {
        if (cryptogram.equals(removedCryptogram)) {
            return removedCryptogram;
        }

        removedCryptogram = removeDupChar(cryptogram);

        return decrypt(removedCryptogram, cryptogram);
    }

    /**
     * 문자열을 입력받아 중복되게 나열된 문자를 삭제한다.
     * 
     * @param cryptogram
     * @return 중복 문자를 지운 문자열
     */
    private static String removeDupChar(String cryptogram) {

        String[] cryptogramArr = cryptogram.split("");

        for (int i = 1; i < cryptogramArr.length; i++) {
            cryptogramArr = replaceDupChars(cryptogramArr, i);
        }

        String res = String.join("", cryptogramArr);
        res = res.replace("*", "");

        return res;
    }

    /**
     * 중복된 문자의 나열을 * 로 치환한다.
     * 
     * @param cryptogramArr
     * @param index
     * @return 치환된 문자열
     */
    private static String[] replaceDupChars(String[] cryptogramArr, int index) {
        if (cryptogramArr[index].equals(cryptogramArr[index - 1])) {
            cryptogramArr[index] = "*";
            cryptogramArr[index - 1] = "*";
        }

        return cryptogramArr;
    }
}
