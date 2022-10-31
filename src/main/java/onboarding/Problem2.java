package onboarding;

/**
 * 1. 중복문자 존재하는지 확인
 * 2. 중복문자 존재시 중복문자 제거
 * 3. 중복문자가 존재하지 않는 결과값 반환
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        //중복문자가 존재할시 while문 반복
        while(isDuplicate(answer)){
            //중복문자가 존재할시 중복문자 제거
            answer = removeDuplicate(answer);
        }

        return answer;
    }

    //인접한 중복문자 제거함수
    public static String removeDuplicate(String cryptogram){
        char[] tempResult = cryptogram.toCharArray();
        int i = 0;
        char prev = 0;

        for (char c : tempResult) {
            /*
            인접한 문자가 같지않으면 임시문자열에 더해준다.
             */
            if(prev != c){
                tempResult[i++] = c;
                prev = c;
            }else{
                i -= 1;
            }
        }

        return new String(tempResult).substring(0,i);
    }


    //중복문자 존재하는지 구별하는 함수
    //중복문자가 존재할시 true를 반환해준다.
    public static boolean isDuplicate(String cryptogram){
        for(int i = 1 ; i < cryptogram.length() ; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)){
                return true;
            }
        }
        return false;
    }
}
