package onboarding;

public class Problem2 {
    static int getIdx(String str) {
        char first = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == first) {
                return i;
            }
        }
        return 0;
    }
    static String deleteChar(String crypt){
        String result = "";
        int last = crypt.length() - 1;

        for (int i = 0; i < last + 1; i++){
            if ( i != last && crypt.charAt(i) == crypt.charAt(i+1)) {
                i += getIdx(crypt.substring(i));
                continue;
            }
            result += crypt.charAt(i);
        }
        return result;
    }
    static String solution(String cryptogram) {
        String answer = cryptogram;
        String deleteStr = "";

        while (true) {
            deleteStr = deleteChar(answer);
            if (!deleteStr.equals(answer)){
                answer = deleteStr;
                continue;
            }
            break;
        }
        return answer;
    }
}