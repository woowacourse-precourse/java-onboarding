package onboarding;

public class Problem2 {
    // 암호 해독
    static String decryption(String cryptogram){
        String result = "";
        char prev = ' ';// 현재 문자 전 문자
        for (int i = 0 ; i < cryptogram.length() - 1; i++){
            char curStr = cryptogram.charAt(i); // 현재 비교하는 문자
            char nextStr = cryptogram.charAt(i + 1); // 현재 문자 다음 문자
            if (curStr == nextStr || curStr == prev){
                prev = curStr;
            }else{
                result = new StringBuilder(result).append(curStr).toString();
                prev = curStr;
            }
            if(i == cryptogram.length() - 2 && curStr != nextStr){
                result = new StringBuilder(result).append(nextStr).toString();
            }
        }
        return result;
    }
    //
    public static String solution(String cryptogram) {
        String answer = "";
        while(true){
            answer = decryption(cryptogram);
            if (answer.isEmpty()){ // 문자가 비어 있는 경우 바로 리턴
                return answer;
            }
            if (answer.equals(cryptogram)){ // 암호 해독을 했는데 전 문자와 같은 문자가 나오는 경우 바로 리턴
                return answer;
            }else{ // 다른 문자가 나오는 경우 cryptogram 갱신 후 다시 해독 함수에 넣어줌
                cryptogram = answer;
            }
        }
    }
}
