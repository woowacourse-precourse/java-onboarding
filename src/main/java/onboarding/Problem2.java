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
        return newstring;
    }
}
