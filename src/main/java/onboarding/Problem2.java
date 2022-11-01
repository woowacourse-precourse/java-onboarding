package onboarding;


public class Problem2 {
//    암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다.
//    예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
//            1. "browoanoommnaon"
//            2. "browoannaon"
//            3. "browoaaon"
//            4. "browoon"
//            5. "brown"
//    임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
//    제한사항
//	• cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
//            • cryptogram은 알파벳 소문자로만 이루어져 있다.

//    --- 요약 ---
//      1. 연달아 중복되는 문자열을 삭제, 반복하여 연속중복문자가 없을때까지 삭제해나가자.
//      2. 문자열 길이 1~1000 사이
//      3. 모두 소문자.


    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = deduplication(cryptogram);
        return answer;
    }

    public static String deduplication(String words) {
        char[] word = words.toCharArray(); // String >> char 배열로 변환

        int i;
        int indexNew = 0;

        for (i = 1; i < word.length; i++) {
            if (word[i - 1] != word[i]) {   // 반복) 문자 n번째, n+1번째 서로 다른값이면 참
                word[indexNew] = word[i - 1];  // 새로 채울 word에 비교값 대입
                indexNew++;
            }
            else {  //n, n+1번째가 서로 같다면
                while (i < word.length && word[i - 1] == word[i]) { // n, n+1 이 다른값일때까지 반영안하고 스킵
                    i++;
                }
            }
        }
        if (i <= word.length) {
            word[indexNew] = word[i - 1];  // 마지막 자리 채우기
            indexNew++;
        }


        String revisionWords = new String(word).substring(0, indexNew); // 중복제거된 문자, 뒷 나머지 쓰레기값 없애고 문자열로 변환
        if (indexNew != word.length) {  // 결과문자와 기준문자 길이 다르다면, 중복제거작업이 있었으므로 다시 확인
            return deduplication(revisionWords);    // 합쳐진 결과값 앞부분 재검토 필요, 앞순서부터 다시 연속 없을떄까지 재귀 반복
        }
        return revisionWords;
    }
}

