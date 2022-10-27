package onboarding;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - cryptogram은 길이가 1 이상 1000 이하인 문자열
 * - cryptogram은 알파벳 소문자로만 구
 *
 * 1. 접근 방식
 * - removeDuplicate() 메소드에서 한번 연속중복을 제거한 결과 String(resultString)을 다시 removeDuplicate() 메소드로 돌려 재귀함
 *  _ 재귀 매개변수 :  한번 연속중복을 제거한 결과 String(resultString)
 *  _ 재귀 종료 시점 : parameter로 받은 String에서 연속중복된 문자의 수(duplicateCnt) 가 0 일때
 *
 * 2. 연속 중복 제거 방식
 * - cryptogram을 순차 탐색하여 탐색하는 요소와 그 다음 요소를 비교
 * - 요소 비교시
 *  _ 중복되는 값이면 해당 요소 다음다음 요소를 비교하게 함
 *  _ 중복되지 않는 값이면 해당 요소 결과 String(resultString)에 concat
 *  _ 마지막 요소의 경우 요소 결과 String(resultString)에 concat (만약 그전 요소와 중복된 값이 들어왔을 경우 건너뛰어 아예 탐색되지 않는다)
 *
 * */
public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem2 = new Problem2();

        String answer = problem2.removeDuplicate(cryptogram);

        return answer;
    }

    public String removeDuplicate(String targetString){

        char[] targetCharArray = targetString.toCharArray();
        String resultString = "";
        int duplicateCnt = 0;

        for(int i = 0; i < targetCharArray.length; i++){
            if(i == targetCharArray.length-1){
                // (1-1) 미자막 요소일 경우 <- 이때 그전 요소와 중복된 값이 들어왔을 경우 (1-2)에서 i++되어 탐색하지 않는다.
                resultString = resultString.concat(Character.toString(targetCharArray[i]));
            } else if(targetCharArray[i] == targetCharArray[i+1]){
                // (1-2) 다음 요소와 같은값 일 때 다음 텀에 그 다음다음 요소를 비교하게 해준다.
                i++;
                duplicateCnt++;
            } else if(targetCharArray[i] != targetCharArray[i+1]){
                // (1-3) 다음 요소와 다른값 일때 resultString에 추가해준다.
                resultString = resultString.concat(Character.toString(targetCharArray[i]));
            }
        }

        if(duplicateCnt == 0){
            return resultString;
        }

        return removeDuplicate(resultString);

    }



}
