package onboarding;

public class Problem2 {
    /**
     * 요구사항
     * 스트링 문자열에서 연속하는 중복문자를 삭제하라.
     * 1 <= cryptogram <= 1000
     * 알파벳 소문자만 사용
     */
    public static String solution(String cryptogram) {
        String answer = deleteChar(cryptogram);
        return answer;
    }

    /**
     * deleteChar : 연속하는 문자를 삭제하는 재귀 메서드
     * 탈출 조건 : 연속하는 문자가 없을 경우
     */
    public static String deleteChar(String cry){
        String result = "";
        String delChar = "";
        for(int i = 0 ; i < cry.length() ; i++){
            //첫번째 인덱스가 아니면서 연속하는 두 문자가 같을때
            if(i != 0 && cry.charAt(i-1) == cry.charAt(i)) {
                delChar += cry.charAt(i);
                continue;
            }
            // 마지막 인덱스가 아니면서 연속하는 두 문자가 같을때
            if(i != cry.length()-1 && cry.charAt(i) == cry.charAt(i + 1)) {
                delChar += cry.charAt(i);
                continue;
            }
            // 그 외는 result에 저장한다.
            result += cry.charAt(i);
        }
        //재귀 탈출 조건 : 연속하는 인덱스가 나오지 않을경우 result 리턴(삭제된 문자가 없을경우)
        if (delChar == "") return result;
        return deleteChar(result);
    }
}
