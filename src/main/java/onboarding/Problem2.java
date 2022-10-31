package onboarding;

/**
 * >> 기능 요구 사항 정리
 * 0. 기본 조건
 * - cryptogram은 길이가 1 이상 1000 이하인 문자열
 * - cryptogram은 알파벳 소문자로만 구
 *
 * 1. 접근 방식
 * - removeDuplicate() 메소드에서 한번 연속중복을 제거한 결과 String(resultString)을 다시 removeDuplicate() 메소드로 돌려 재귀함
 *  _ 재귀 매개변수 : 한번 연속중복을 제거한 결과 String(resultString)
 *  _ 재귀 종료 시점 : parameter로 받은 String에서 연속중복된 문자의 수(duplicateCnt) 가 0 일때
 *
 * 2. 연속 중복 제거 방식
 * - cryptogram을 순차 탐색하여 탐색하는 요소와 그 다음 요소를 비교
 * - 요소 비교시
 *  _ 중복되는 값이면 해당 요소의 다음다음 요소를 다음 탐색으로 비교하게 함
 *  _ 중복되지 않는 값이면 해당 요소 결과 String(resultString)에 concat
 *  _ 마지막 요소의 경우 요소 결과 String(resultString)에 concat
 *      (만약 그전 요소와 중복된 값이 들어왔을 경우 건너뛰어 아예 탐색되지 않는다. 즉, 별도 조건없이 concat하여도 무방하다.)
 *
 * */
public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 problem2 = new Problem2();

        return problem2.removeDuplicate(cryptogram);
    }

    public String removeDuplicate(String targetString){
        char[] targetCharArray = targetString.toCharArray();    // String을 순차 탐색을 진행할 수 있게 char형 배열로 변환
        String resultString = "";       // 결과 문자들 concat을 진행할 결과 String
        int duplicateCnt = 0;       // 재귀 종료 시점 확인을 위한 변수

        // 해독 목표 문자 배열 순차 탐색
        for(int i = 0; i < targetCharArray.length; i++){
            if(i == targetCharArray.length-1){      // (1-1) 미자막 요소일 경우 별도 조건없이 concat한다.
                resultString = concatResultString(resultString,targetCharArray[i]);
            } else if(targetCharArray[i] != targetCharArray[i+1]){      // (1-2) 다음 요소와 다른값 일때 resultString에 concat한다.
                resultString = concatResultString(resultString,targetCharArray[i]);
            } else if(targetCharArray[i] == targetCharArray[i+1]){      // (1-3) 다음 요소와 같은값 일 때 다음 탐색에 그 다음다음 요소를 비교하게 해준다.
                i++;
                duplicateCnt++;
            }
        }

        // 중복된 문자가 없다면 결과 문자열을 반환한다.
        if(duplicateCnt == 0){
            return resultString;
        }

        // 메소드 결과값을 가지고 재귀 호출
        return removeDuplicate(resultString);
    }

    // resultString에 중복되지 않는 문자 concat
    public String concatResultString(String resultString ,char targetChar){
        return resultString.concat(Character.toString(targetChar));
    }

}
