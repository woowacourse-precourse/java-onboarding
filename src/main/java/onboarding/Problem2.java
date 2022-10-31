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
        int idx = 0;
        int nextIdx = 0;

        for(idx = 1 ; idx < cryptogram.length() ; idx++ ){

            //앞뒤문자가 동일하지않은경우
            //결과에 추가해준다.
            if(tempResult[idx-1] != tempResult[idx]){
                tempResult[nextIdx++] = tempResult[idx-1];
            }else{
                //앞뒤문자가 동일한경우 인접한 모든 중복문자 제거
                while(idx < cryptogram.length() && tempResult[idx-1] == tempResult[idx]){
                    idx++;
                }
            }
        }

        tempResult[nextIdx] = tempResult[idx-1];

        return new String(tempResult).substring(0,nextIdx+1);
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
