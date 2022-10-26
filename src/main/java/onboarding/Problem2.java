package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        boolean isOK = true;
        while(isOK){
            int length = cryptogram.length();
            for(int i=0; i< cryptogram.length()-1; i++) {

                if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                    String tempStr = cryptogram.charAt(i)+"";
                    tempStr += cryptogram.charAt(i)+"";
                    cryptogram=cryptogram.replace(tempStr,"");  // 같은 문자 나왔을 때 없애줌
                    i -= 1;     // 없애줬으니 1칸 뒤로
                    break;
                }
            }
            if(length == cryptogram.length()) break;            // 처음 문자와 길이가 같다 => 변화가 없다 => 암호 해독 끝났다
        }

        answer = cryptogram;
        return answer;
    }
}
