package onboarding;

import java.util.List;

public class Problem2 {
    public static StringBuilder deleteCrypt = new StringBuilder("");

    public static void chkDeleteCrypt(int cryptFirst) {
        if (deleteCrypt.charAt(deleteCrypt.length() - 1) == cryptFirst) {
            deleteCrypt.delete(deleteCrypt.length() - 1, deleteCrypt.length());
        }
    }

    public static void deleteChar(char cryptFirst, char cryptSecond){
        if (cryptFirst == cryptSecond) {
            chkDeleteCrypt(cryptFirst);
            return;
        }
        deleteCrypt.append(cryptSecond);
    }


    public static void deleteRepeation(String crypt) {
        if (crypt.equals("")) {
            return;
        }
        deleteCrypt.delete(0,deleteCrypt.length());
        deleteCrypt.append(crypt.charAt(0));
        for (int i = 0; i < crypt.length() - 1; i++) {
            deleteChar(crypt.charAt(i),crypt.charAt(i + 1));
        }

    }


    public static String solution(String cryptogram) {
        String answer;
        deleteRepeation(cryptogram);
        while (!deleteCrypt.toString().equals(cryptogram)) {
            cryptogram = deleteCrypt.toString();
            deleteRepeation(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }


}
