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
            return sb.toString();
        }catch (Exception e){
            return "";
        }
    }

    public static void checkWordLength(String word) throws Exception {
        int length = word.length();
        if (length<1||length>1000) throw new Exception("문자열 길이 제한 초과입니다");
    }

}
