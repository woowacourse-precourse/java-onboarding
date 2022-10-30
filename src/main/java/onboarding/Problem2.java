package onboarding;

public class Problem2 {

    static int count = 0;

    public static String solution(String cryptogram) {
        return decrypt(cryptogram, "");
    }

    private static String decrypt(String cryptogram, String removedCryptogram) {
        if (cryptogram.equals(removedCryptogram)) {
            return removedCryptogram;
        }

        removedCryptogram = removeDupChar(cryptogram);

        return decrypt(removedCryptogram, cryptogram);
    }

    private static String removeDupChar(String cryptogram) {

        String[] cryptogramArr = cryptogram.split("");

        for (int i = 1; i < cryptogramArr.length; i++) {
            cryptogramArr = replaceDupChars(cryptogramArr, i);
        }

        String res = String.join("", cryptogramArr);
        res = res.replace("*", "");

        return res;
    }

    private static String[] replaceDupChars(String[] cryptogramArr, int index) {
        if (cryptogramArr[index].equals(cryptogramArr[index - 1])) {
            cryptogramArr[index] = "*";
            cryptogramArr[index - 1] = "*";
        }

        return cryptogramArr;
    }

}
