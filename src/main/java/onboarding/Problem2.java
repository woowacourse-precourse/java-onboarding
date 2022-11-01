package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = Decryption(cryptogram);
        return answer;
    }

    public static String Decryption(String cryptogram) {
        StringBuffer cryptogramBuffer = new StringBuffer(cryptogram);
        boolean isDone = false; //더 이상 중복이 없는지 체크
        while(!isDone){
            isDone = true;
            if(cryptogramBuffer.length() == 0) {
                return "";
            }
            for(int i = 0; i < cryptogramBuffer.length() - 1; i ++ ){
                if(cryptogramBuffer.charAt(i) == cryptogramBuffer.charAt(i+1)){ // 중복 인접한 문자가 있을 경우
                    isDone = false;
                    cryptogramBuffer.deleteCharAt((i));
                    cryptogramBuffer.deleteCharAt((i)); // i+1로 해놓고 왜 계속 안되는지 굉장히 헤맨 부분...
                }
            }
        }
        return cryptogramBuffer.toString();
    }
}