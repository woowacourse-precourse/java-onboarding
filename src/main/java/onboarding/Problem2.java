package onboarding;

public class Problem2 {
    // 문자열에서 중복되는 문자 제거 (3개 이상의 문자 중복 포함)
    static String removeDup(String cryptoString){
        StringBuffer newString = new StringBuffer(cryptoString);
        for (int i=0; i<newString.length()-1; i++){
            if(newString.charAt(i) == newString.charAt(i+1)){
                // 3개 이상의 문자 중복 체크
                while(newString.charAt(i) == newString.charAt(i+1)){
                    newString.deleteCharAt(i);
                }
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
