package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String[] repeats = {
                "aa", "bb", "cc", "dd", "ee", "ff", "gg",
                "hh", "ii", "jj", "kk", "ll", "mm", "nn",
                "oo", "pp", "qq", "rr", "ss", "tt", "uu",
                "vv", "ww", "xx", "yy", "zz"};

        while (cryptogram.length() > 0) {
            boolean replaced = false;
            for (String repeat : repeats) {
                if (cryptogram.contains(repeat)) {
                    cryptogram = cryptogram.replace(repeat, "");
                    replaced = true;
                }
            }
            if (!replaced) break;
        }
        return cryptogram;
    }
}
