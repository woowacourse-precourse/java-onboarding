package onboarding;

public class Problem4 {
    // 97 109 a-m
    // 110 122 n-z

    // 65 77 A-M
    // 78 90 N-Z
    public static String solution(String word) {
        StringBuilder sb=new StringBuilder();
        try {
            checkWordLength(word);

            for (int i=0;i<word.length();i++){
                sb.append(getFrogDictionary(word.charAt(i)));
            }
            return sb.toString();
        }catch (Exception e){
            return "";
        }
    }

    public static char getFrogDictionary(char frog_word){
        if ('A'<=frog_word && frog_word<='Z') return (char) ('Z'-(frog_word-'A'));
        if ('a'<=frog_word && frog_word<='z') return (char) ('z'-(frog_word-'a'));
        return frog_word;
    }

    public static void checkWordLength(String word) throws Exception {
        int length = word.length();
        if (length<1||length>1000) throw new Exception("문자열 길이 제한 초과입니다");
    }

}
