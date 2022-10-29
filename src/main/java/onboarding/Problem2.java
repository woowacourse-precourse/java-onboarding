package onboarding;

/**
 * 기능 목록
 * 1. 현재 중복된 문자들만 제거
 * 2. 1의 과정에서 변화가 없을때까지 반복
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static StringBuilder deleteOverlab(StringBuilder code){
        StringBuilder result = new StringBuilder();
        boolean overlapChar = false;

        code.append(" ");
        for(int i =0; i<code.length()-1; i++){
            if(code.charAt(i) == code.charAt(i+1)){
                overlapChar= true;
                continue;
            }
            if(overlapChar){
                overlapChar= false;
                continue;
            }
            result.append(code.charAt(i));
        }
        return result;
    }
}
