package onboarding;


/**
 * 기능목록
 * 1. 동일 문자 있는지 확인하는 메서드 구현, 동일 문자열가 있었다면 true를 리턴, 없었다면 false를 리턴
 * 2. 동일 문자를 지우는 메서드 구현
 * 3. 동일 문자를 반복해서 지우고 만약 없다면 answer 반환 구현
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = " ";

        return answer;
    }

    //기능1 동일 문자 있는지 확인하는 메서드 구현, 동일 문자열가 있었다면 true를 리턴, 없었다면 false를 리턴
    private boolean checkDuplicate(String input){
        char[] inputArr = input.toCharArray();
        for(int i=0;i<inputArr.length-1;i++){
            if(inputArr[i] == inputArr[i+1]) return true;
        }
        return false;
    }

}
