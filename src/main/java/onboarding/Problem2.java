package onboarding;

public class Problem2 {
    public static String removeDup(String s){
        if(s == null) return null;
        char prev = 0;
        int idx = 0;
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if (prev != c) {
                chars[idx++] = c;
                prev = c;
            }
            else idx--;
        }
        return new String(chars).substring(0,idx);
    }
    public static String solution(String cryptogram) {
        while(true){
            String rm_dup = removeDup(cryptogram);
            if(rm_dup.equals(cryptogram)) break;
            cryptogram = rm_dup;
        }
        return cryptogram;
    }
}
