package onboarding;
// 1. 중복된 알파벳이 있는지 확인: boolean isDupliWord(String cryptogram)
// 2. 중복된 알파벳 제거: String deleteDupli(String cryptogram)
public class Problem2 {
    public static String solution(String cryptogram) {
        while (isDupliWord(cryptogram)) {
            cryptogram = deleteDupli(cryptogram);
        }
        return cryptogram;
    }

    public static boolean isDupliWord(String cryptogram) {
        String[] str = cryptogram.split("");
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].equals(str[i + 1])) {
                return true;
            }
        }
        return false;
    }

    public static String deleteDupli(String cryptogram) {
        String[] strs = cryptogram.split("");
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].equals(strs[i + 1])) {
                strs[i] = "";
                strs[i + 1] = "";
            }
        }
        return String.join("", strs);
    }
}
