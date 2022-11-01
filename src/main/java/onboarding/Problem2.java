package onboarding;

public class Problem2 {
    public static String deduplication(String s) {
        String transform_string="";
        if(s.length()==0) return "";
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                transform_string = s.substring(0, i) + s.substring(i + 2);
                return deduplication(transform_string);
            }
        }
        return s;
    }
    public static String solution(String cryptogram) {
        String answer = deduplication(cryptogram);
        return answer;
    }
}