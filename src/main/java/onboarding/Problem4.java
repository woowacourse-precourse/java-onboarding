package onboarding;

public class Problem4 {
    public static char getCvtChar(char ch) {
        if(ch>='a' && ch<='z') return (char)('a'+('z'-ch));
        if(ch>='A' && ch<='Z') return (char)('A'+('Z'-ch));
        return ch;
    }

    public static String getCvtWord(String word) {
        char[] wordArr = word.toCharArray();
        for(int i=0; i<wordArr.length; i++) {
            wordArr[i] = getCvtChar(wordArr[i]);
        }
        word = new String(wordArr);
        return word;
    }

    public static String solution(String word) {
        return getCvtWord(word);
    }
}
