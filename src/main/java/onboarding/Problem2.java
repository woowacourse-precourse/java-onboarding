package onboarding;

public class Problem2 {
    public static String decrypt(String crypto){
        String key = "";
        if(crypto.length()<=1){
            key = crypto;
        }else{
            if(crypto.charAt(0) != crypto.charAt(1)){
                key += crypto.charAt(0);
            }
            for (int i = 1; i < crypto.length()-1; i++) {
                if(crypto.charAt(i)!=crypto.charAt(i+1)
                        && crypto.charAt(i)!=crypto.charAt(i-1)
                ){
                    key += crypto.charAt(i);
                }
            }
            if(crypto.charAt(crypto.length()-1)!=crypto.charAt(crypto.length()-2)){
                key += crypto.charAt(crypto.length()-1);
            }
        }
        return key;
    }

    public static boolean repeat(String key){
        if(key.length()==0){
            return false;
        }

        int count = 0;
        for(int i=0; i<key.length()-1; i++){
            if(key.charAt(i)!=key.charAt(i+1)){
                count += 1;
            }
        }

        if(count == key.length()-1){
            return false;
        } else {
            count = 0;
            return true;
        }
    }
    public static String solution(String cryptogram) {
        String answer = "";

        //예외처리
        if(cryptogram.length() < 1 || cryptogram.length() > 1000
                || cryptogram.matches("[^a-z]")
        ){
            answer = "올바른 문자열을 입력해 주세요";
        }

        //decrypt
        answer = decrypt(cryptogram);

        //반복여부 검사 및 반복
        while (true) {
            if(!repeat(answer)){
                break;
            }
            else{
                answer=decrypt(answer);
            }
        }
        return answer;
    }
}
