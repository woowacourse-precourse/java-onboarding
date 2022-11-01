package onboarding;


public class Problem2 {
    public static String removeDuplicate(String word){
        if (word.length() <= 1) return word;

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < word.length()-1) {
            if (word.charAt(i) == word.charAt(i + 1))
                i+=2;
            else res.append(word.charAt(i++));
        }

        if (word.charAt(word.length() - 1) != word.charAt(word.length() - 2))
            res.append(word.charAt(word.length() - 1));

        return res.toString();
    }

    public static String solution(String cryptogram) {
        while (! cryptogram.equals(removeDuplicate(cryptogram))) {
            cryptogram = removeDuplicate(cryptogram);
        }
        return cryptogram;
    }
}
