package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String decode(String cryptogram) {
        String str = decodeOneCycle(cryptogram);
        while(str != null){
            cryptogram = str;
            str = decodeOneCycle(cryptogram);
        }

        return cryptogram;
    }

    public static String decodeOneCycle(String cryptogram){
        int length = cryptogram.length();
        String result = null;

        for(int i = 0; i < length - 1; i++){
            char c = cryptogram.charAt(i);
            String substring = cryptogram.substring(i);

            if(isContinuitySubstring(substring)){
                String fixedSubstring = removeContinuity(substring, c);
                cryptogram = cryptogram.substring(0, i) + fixedSubstring;
                length = cryptogram.length();
                result = cryptogram;
            }
        }

        return result;
    }

    public static boolean isContinuitySubstring(String substring) {
        return substring.charAt(0) == substring.charAt(1);
    }

    public static String removeContinuity(String subString, char c){
        int index = subString.indexOf(c);
        while(index == 0){
            subString = subString.substring(1);
            index = subString.indexOf(c);
        }
        return subString;
    }
}
