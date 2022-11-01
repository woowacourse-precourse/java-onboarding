package onboarding;

public class Problem2 {
    static int countChar(StringBuffer str, int idx) {
        int count = 0;
        for (int i=idx; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }
    // 문자열에서 중복되는 문자 제거
    static String removeDup(String cryptoString){
        StringBuffer newString = new StringBuffer(cryptoString);
        for (int i=0; i<newString.length()-1; i++){
            if(newString.charAt(i) == newString.charAt(i+1)){
                newString.deleteCharAt(i);
                newString.deleteCharAt(i);
            }
        }
        return String.valueOf(newString);
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        for (int i=0; i<cryptogram.length(); i++){
            answer = removeDup(answer);
        }
        return answer;
    }
}
