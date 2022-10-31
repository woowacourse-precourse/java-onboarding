package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = translate(cryptogram);
        return answer;
    }
    //문자열 중복 체크 함수
    private static boolean checkDup(String cryptogram){
        for(int i=0; i<cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                return true;
        }
        return false;
    }
    //해독 함수
    private static String translate(String cryptogram){
        String result= cryptogram;
        int count=0;

        //중복문자가 없을때 까지 반복
        while(checkDup(cryptogram)){
            int dupNum=1;
            int lastIndex=cryptogram.length();

            if(cryptogram.charAt(count)==cryptogram.charAt(count+1)) {
                //중복되는 문자열 계속해서 찾는 부분
                for (int i = count; i < lastIndex-1; i++) {
                    char charDup = cryptogram.charAt(count);
                    if (charDup == cryptogram.charAt(i + 1)) {
                        dupNum++;
                    }
                    else{
                        break;
                    }
                }
                //중복 문자 부분을 제외한 부분
                cryptogram = cryptogram.substring(0, count) + cryptogram.substring(count + dupNum, lastIndex);
                result = cryptogram;
                count--;
            }
            count++;

            //중복 문자가 있으면서 끝까지 탐색했을 경우
            lastIndex=cryptogram.length()-1;
            if(checkDup(cryptogram)==true && lastIndex==count){
                count=0;
            }
        }
        return result;
    }
}

