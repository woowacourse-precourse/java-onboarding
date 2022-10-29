package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = "";
        result = checkString(cryptogram);
        return result;
    }
    static String checkString(String str) {
        String answer = "";
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                str = splitString(str, i);
                i = -1;
            }
        }
        return str;
    }
    static String splitString(String str, int index) {
        String newstring = "";
        for(int i=0; i<str.length()-1; i++) {
            if(i==index || i==index+1) continue;
            newstring += str.charAt(i);
        }
        if(index!=str.length()-2) newstring += str.charAt(str.length()-1);
        return newstring;
    }
}
