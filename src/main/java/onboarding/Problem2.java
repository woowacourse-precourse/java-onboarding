package onboarding;

/**
 * 1. 문자 입력 범위 확인
 * 2. 조건 : 연속하는 중복 문자들을 삭제
 *   -> 연속하는 중복 문자?
 *   -> 예제에서는 두 번 연속되는 문자를 제거하였지만
 *   -> aaabbbccc 같은 3개 이상의 연속되는 문자가 오면 어떻게 될까?
 *   -> 생각했던 방법 1. 스택사용 2. 투포인터 사용
 *   -> 처음에는 스택을 사용하여 변경감지와 동시에 앞에 중복데이터를 삭제하는 형식으로 로직을 구성하였다.
 *   -> 제일 끝 데이터를 처리하는 과정에서 오류가 발생 / 홀수개 중복 데이터 입력시 한 개씩 남는 현상 발생
 *   -> 그래서 생각했던 방법이 투포인터 + 스택이었다.
 *   -> 시간복잡도 측면에서는 비효율적일지 모르겠지만, 일단 데이터가 1000개이기도하고.. 더 할 수있는 방법을 못찾겟다.
 *
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        checkValidRange(cryptogram.length());
        String answer = "answer";
        return answer;
    }

    private static void checkValidRange(int wordLength) {
        if (wordLength < 1 || wordLength > 1000) {
            throw new IllegalArgumentException();
        }
    }
}
