package onboarding;

// 길이가 1 이상 1000 이하인 문자열이 주어진다.
// 문자열은 알파벳 소문자로만 이루어져 있다.
// 연속하는 중복 문자들을 삭제한 결과를 return 해야함

// todo
// 1. 연속하는 중복 문자들을 확인 할 로직 생각하기.
// 1-1. 반복문으로 각각의 문자들을 확인하며 다음 문자(i+1)와 같은지 확인하면..
//      마지막 문자에서 문자열의 범위초과 오류가 뜬다. 다른 방법은??
// 1-2. 현재 문자를 저장했다가 다음 문자가 같은지 비교하는건?
// 2. 연속하는 중복 문자들을 제거 할 로직 생각해보기
// 2-1. 자바에서 스트링속성은 불변. replace가 안된다..
// 2-2. 연속하는 중복 문자들은 제외하고 새로운 문자열에 넣기
// 3. 연속하는 중복 문자들이 없을때까지 위의 과정을 반복해야함
// 3-1. 연속하는 중복 문자들이 있는지 없는지 검사하고, 있으면 반복, 없으면 값을 return 해야함




public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = "";
        char presentLetter = '1';

        for (int i = 0; i < cryptogram.length(); i++) {
            if (presentLetter != cryptogram.charAt(i)){
                answer += cryptogram.charAt(i);
            }else{
                answer = answer.substring(0, answer.length() - 1);
            }
            presentLetter = cryptogram.charAt(i);
        }

        return answer;
    }
}
