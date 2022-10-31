package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);
        return answer;
    }

    public static String decrypt(String cryptogram){
        //빈 문자열, 문자 하나인 경우 중복 제거 처리를 하지 않는다.
        while(cryptogram.length()>1){
            String decryptStr = "";

            for(int i=0;i<cryptogram.length()-1;i++){
                Character curChar = cryptogram.charAt(i);
                Character nextChar = cryptogram.charAt(i+1);

                if(curChar == nextChar){
                    if(cryptogram.length()==2) return decryptStr;
                    //3개 이상 연속 중복되는 경우 인덱스 처리
                    while(i+2<cryptogram.length() && curChar == cryptogram.charAt(i+2)) i++;
                    i++;
                }else{
                    decryptStr += curChar;
                }

            }

            //암호문의 마지막 문자 처리
            if(cryptogram.charAt(cryptogram.length()-2) != cryptogram.charAt(cryptogram.length()-1))
                decryptStr += cryptogram.charAt(cryptogram.length()-1);

            //암호문을 중복제거 처리하여도 그대로인 경우
            if(cryptogram.length() == decryptStr.length()) return decryptStr;

            cryptogram = decryptStr;
        }
        return cryptogram;
    }
}
