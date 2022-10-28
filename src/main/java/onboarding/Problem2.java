package onboarding;


public class Problem2 {
    public static String removeDuplicate(String word){
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < word.length()-1) {
            if (word.charAt(i) == word.charAt(i + 1))
                i+=2;
            else res.append(word.charAt(i++));
        }
        if (res.length() > 0) {
            if (word.charAt(word.length() - 1) != res.charAt(res.length() - 1))
                res.append(word.charAt(word.length() - 1));
            else res.replace(res.length() - 1, res.length(), "");
        }
        return res.toString();
    }

    public static String solution(String cryptogram) {
        while (! cryptogram.equals(removeDuplicate(cryptogram))) {
            cryptogram = removeDuplicate(cryptogram);
        }
        return cryptogram;
    }
}
