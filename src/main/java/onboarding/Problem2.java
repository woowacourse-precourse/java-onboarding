package onboarding;

/**
 * 연속된 문자를 지우고, 나머지 문자열을 합친 뒤 다시 맨 앞에서부터 연속된 문자를 찾아나가는 연산을 반복.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        for(int i=0;i<cryptogram.length()-1;i++){
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                cryptogram=cryptogram.substring(0,i)+cryptogram.substring(i+2);
                i=0;
            }
            if(cryptogram.length()==2){
                if(cryptogram.charAt(0)==cryptogram.charAt(1)){
                    cryptogram="";
                }
            }
        }
        String answer = cryptogram;
        return answer;
    }
}
