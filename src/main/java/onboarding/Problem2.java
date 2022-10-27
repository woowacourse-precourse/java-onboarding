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
        
        return answer;
    }



}
