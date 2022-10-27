package onboarding;

/*
##기능 목록

1. 중복 문자가 있는지 확인
2. 중복 제거
3. 중복 문자가 없을 때까지 반복


 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        char[] charArray = cryptogram.toCharArray();
        while(isDuplicate(charArray)){

        }
        return answer;
    }

    public static boolean isDuplicate(char[] charArray) {
        for(int i=1;i<charArray.length;i++){
            if(charArray[i] == charArray[i-1]){
                return true;
            }
        }
        return false;
    }
}
