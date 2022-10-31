package onboarding;

public class Problem2 {
    public static String erase(String s) {
        String t_s="";
        if(s.length()==0) return "";
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                t_s = s.substring(0, i) + s.substring(i + 2);
                return erase(t_s);
            }
        }
        return s;
    }

    public static String solution(String cryptogram) {
        String answer = erase(cryptogram);
        return answer;
    }
}