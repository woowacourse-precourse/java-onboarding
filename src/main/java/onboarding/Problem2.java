package onboarding;

import java.util.Stack;

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
 *   -> 시간복잡도 측면에서는 비효율적일지 모르겠지만, 일단 데이터가 1000개이기도하고.. 더 할 수있는 방법을 못찾겟다.(다음주 1주차 토론에서 한번 물어봐야겠다.)
 *
 *   words = "zzzzzzzzzzmmmmmz";
 *   문제를 풀다가 드는 의문점이다
 *   위 문자의 경우 앞에서부터 중복을 체크하면 z가 남고
 *   m부터 체크를하면 z만 남는다. 만약 최소한으로 줄이라면 두번째로 하는게 맞는데 일단... 이 부분도 고려해봐야겠다.
 *
 *   ***로직변경
 *   기존 while문들 돌면서 문자를 재할당하는 형태로 처음부터 돌아가 탐색을 해 주었다.
 *   하지만 이는 조금 비효율적인거같아서 스택의 peek값으로 비교를 해나가는 것으로 하는게 좋을 것 같다
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        validate(cryptogram);
        Stack<String> stack = findOverlapWord(cryptogram);
        String answer = String.join("", stack);
        return answer;
    }

    private static Stack<String> findOverlapWord(String cryptogram) {
        int indexNumber = 0;
        String[] splitWord = cryptogram.split("");
        Stack<String> stack = new Stack<>();
        while (indexNumber < splitWord.length) {
            if (stack.size() == 0) {
                stack.add(splitWord[indexNumber]);
                indexNumber += 1;
                continue;
            }
            if (!stack.peek().equals(splitWord[indexNumber])) {
                stack.add(splitWord[indexNumber]);
                indexNumber += 1;
                continue;
            }
            int erase = getEraseRange(indexNumber, splitWord, stack);

            indexNumber = assignToJumpEraseRange(indexNumber, stack, erase);
        }
        return stack;
    }

    private static int assignToJumpEraseRange(int indexNumber, Stack<String> stack, int erase) {
        if (erase >= 1) stack.pop();
        indexNumber += erase;
        return indexNumber;
    }

    private static int getEraseRange(int indexNumber, String[] splitWord, Stack<String> stack) {
        int erase = 0;
        int overlapCount = indexNumber;
        for (int i = overlapCount; i < splitWord.length; i++) {
            if (!stack.peek().equals(splitWord[i])) {
                break;
            }
            erase += 1;
        }
        return erase;
    }

    private static void validate(String cryptogram) {
        Advice.validate(cryptogram);
    }

    static class Advice{
        private Advice(){}

        public static void validate(final String cryptogram){
            checkCryptogramValidRange(cryptogram.length());
            checkCryptogramIsToLowerCase(cryptogram);
        }
        private static void checkCryptogramValidRange(final int wordLength) {
            if (wordLength < 1 || wordLength > 1000) {
                throw new IllegalArgumentException();
            }
        }

        private static void checkCryptogramIsToLowerCase(final String cryptogram) {
            if (!cryptogram.equals(cryptogram.toLowerCase())) {
                throw new IllegalArgumentException();
            }
        }

    }


    //소문자 체크
}
