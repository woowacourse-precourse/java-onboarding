package onboarding;
public class Problem2 {
    public static int index(String cryptogramSubstring) {
        char cryptogramSubchar = cryptogramSubstring.charAt(0);
        for (int i = 1; i < cryptogramSubstring.length(); i++) {
            if (cryptogramSubstring.charAt(i) == cryptogramSubchar) {
                return (i);
            }
        }
        return 0;
    }
    public static String deleteChar(String cryptogram){
        String result = "";
        int lastIndex = cryptogram.length() - 1;
        for (int i = 0; i < lastIndex + 1; i++){
            if (i != lastIndex && cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                i += index(cryptogram.substring(i));
                continue;
            }
            result += cryptogram.charAt(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String deleteString = "";
        while (true) {
            deleteString = deleteChar(answer);
            if (!deleteString.equals(answer)){
                answer = deleteString;
            } else {
                break;
            }
        }
        return answer;
    }
}