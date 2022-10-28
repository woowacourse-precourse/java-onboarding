package onboarding;

import java.util.ArrayList;
import java.util.List;
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
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        checkValidRange(cryptogram.length());
        String answer = getZipWord(cryptogram);

        return answer;
    }

    private static String getZipWord(String cryptogram) {
        String answer = "answer";
        Stack<String> stack = new Stack<>();

        int indexNumber = 0;
        while (true) {
            boolean checkChanged = false;
            String[] splitWord = cryptogram.split("");
            if (String.join("", stack).trim().equals(String.join("", splitWord).trim())) {
                break; // 종료조건 1번 (스택에 들어가 있는 데이터의 조합과 원본 데이터의 조합이 같을때. 즉, 중복이 발생하지않고 모두 돌았을 때
            }
            if (stack.size() == 0 ) {
                stack.add(splitWord[indexNumber]);
                indexNumber += 1;
                continue;
            }
            if (!stack.peek().equals(splitWord[indexNumber])) {
                stack.add(splitWord[indexNumber]);
                indexNumber += 1;
                continue;
            }

            checkChanged = isCheckChanged(stack, indexNumber, checkChanged, splitWord);
            String changedWord = String.join("", splitWord).trim();
            cryptogram = changedWord;
            indexNumber = 0;
            stack.clear();

            if (!checkChanged) {
                break;
            }
            if (cryptogram.length() == 0) {
                break;
            }
        }
        answer = cryptogram;
        return answer;
    }

    private static boolean isCheckChanged(
        final Stack<String> stack, final int indexNumber, boolean checkChanged, String[] splitWord) {
        if (stack.peek().equals(splitWord[indexNumber])) {
            List<Integer> eraseList = getEraseList(indexNumber, splitWord);
            checkChanged = doEraseAndCheckChanged(checkChanged, splitWord, eraseList);
        }
        return checkChanged;
    }

    private static boolean doEraseAndCheckChanged(
        boolean checkChanged, final String[] splitWord, final List<Integer> eraseList) {
        for (Integer eraseIndex : eraseList) {
            splitWord[eraseIndex] = "";
            checkChanged = true;
        }
        return checkChanged;
    }

    private static List<Integer> getEraseList(final int indexNumber, final String[] splitWord) {
        int samePoint = indexNumber - 1;
        if (samePoint < 0) samePoint = 0;
        List<Integer> eraseList = new ArrayList<>();
        for (int i = samePoint; i < splitWord.length; i++) {
            if (!splitWord[samePoint].equals(splitWord[i])) {
                break;
            }
            eraseList.add(i);
        }
        return eraseList;
    }

    private static void checkValidRange(final int wordLength) {
        if (wordLength < 1 || wordLength > 1000) {
            throw new IllegalArgumentException();
        }
    }
}
