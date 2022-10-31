package onboarding;

public class Problem4 {
    // 97 109 a-m
    // 110 122 n-z

    // 65 77 A-M
    // 78 90 N-Z
    public static String solution(String word) {
        StringBuilder sb=new StringBuilder();
        if (validation("word_length",word.length())) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(getFrogDictionary(word.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static char getFrogDictionary(char frog_word){
        if ('A'<=frog_word && frog_word<='Z') return (char) ('Z'-(frog_word-'A'));
        if ('a'<=frog_word && frog_word<='z') return (char) ('z'-(frog_word-'a'));
        return frog_word;
    }

    private static <T> boolean validation(String err_type,T err_param){
        if (err_type.equals("word_length")&&err_param instanceof Integer){
            int word_length = (int) err_param;
            return 0<word_length&&word_length<1001;
        }
        return false;
    }
}
