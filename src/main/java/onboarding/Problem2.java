package onboarding;

public class Problem2 {
    public static boolean isConsecutiveOverlapExisted(String str){
        if(str.equals("")) return false;

        boolean result = false;
        char cur = str.charAt(0);
        for(int i=1; i<str.length(); i++){
            if(cur == str.charAt(i)) return true;
            cur = str.charAt(i);
        }
        return result;
    }
    public static int advanceIndex(int idx, String str){
        char ch = str.charAt(idx);
        while(idx < str.length() && str.charAt(idx) == ch){
            idx += 1;
        }
        return idx-1;
    }
    public static String deleteOverlapCharacter(String str){
        StringBuilder buf = new StringBuilder("");
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) != str.charAt(i+1)) buf.append(str.charAt(i));
            else i = advanceIndex(i, str);
        }
        if(str.charAt(str.length()-1) != str.charAt(str.length()-2)) buf.append(str.charAt(str.length()-1));
        return buf.toString();
    }
    public static String solution(String cryptogram) {
        String str = cryptogram;
        while(isConsecutiveOverlapExisted(str)){
            str = deleteOverlapCharacter(str);
        }
        return str;
    }
}
