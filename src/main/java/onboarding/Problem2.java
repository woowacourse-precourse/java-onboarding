package onboarding;

/*

[기능 목록]
1. 중복 검사를 수행하는 메서드 (중복을 제거해야하는 인덱스를 뽑아 한 번에 제거하기)
2. 중복된 문자열을 삭제하는 메서드
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    // 문자열 내 중복을 확인하는 메서드
    public static List<String> overlapChecker(String cryptogram) {

        // 스택에 문자열을 하나씩 삽입하고 그 다음 문자열과 하나씩 비교하기 위함
        Stack<String> stack = new Stack<>();
        // 중복 대상 리스트로 스택에서 참조하여 넣는다.
        List<String> overlapTargetList = new ArrayList<>();
        // 스택에서 참조한 값을 이어붙이기 위한 StringBuilder
        StringBuilder deleteTargetElement = new StringBuilder();

        // 문자열 길이만큼 반복한다. (단, 인덱스 + 1 비교하는 구문이 있으므로 문자열 길이의 -1 까지 비교한다.)
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            // 현재 순회중인 값
            String currentValue = cryptogram.substring(i, i + 1);
            // 다음 순회할 값
            String nextValue = cryptogram.substring(i + 1, i + 2);

            // 입력 문자열 길이가 2이고, 서로 같은 문자라면 빈 List 반환
            if (cryptogram.length() == 2 && currentValue.equals(nextValue)) {
                return overlapTargetList;
            }
            
            // 현재 순회중인 값 스택에 삽입
            stack.push(currentValue);

            // 스택 크기가 0이 아니고, 스택의 맨 위 문자가 다음 순회할 값과 같으면 스택 pop 후, 그 결과 값을 deleteTargetElement 에삽입
            if (stack.size() != 0 && stack.peek().equals(nextValue)) {
                deleteTargetElement.append(stack.pop());
            }
            // 스택 크기가 0이 아니고, 스택의 맨 위 문자가 다음 순회할 값과 다르면 현재 스택에 있는 값을 deleteTargetElement 에 삽입
            // 중복 대상 리스트에 중복된 문자열을 이어붙인 deleteTargetElement 를 삽입 후 초기화
            else if (stack.size() != 0 && !stack.peek().equals(nextValue)) {
                deleteTargetElement.append(stack.pop());
                overlapTargetList.add(deleteTargetElement.toString());
                deleteTargetElement = new StringBuilder();
            }
        }

        overlapTargetList.add(deleteTargetElement.toString());
        return overlapTargetList;
    }


    // 실제로 중복된 문자열을 제거하는 메서드
    public static String overlapRemover(String cryptogram, List<String> overlapTargetList) {

        // 중복 대상 문자열을 담은 리스트가 비어있다면 중복 된 값이 없는 것이므로 입력값 재반환
        if (overlapTargetList.size() < 1) {
            return cryptogram;
        }

        String result = cryptogram;

        // 중복 대상 리스트를 순회하며 그 길이가 1이 넘지 않는다면 중복이다.
        // 따라서 그 문자열을 지워준다. (replace 로 대체함)
        for (String target : overlapTargetList) {
            if (target.length() != 1) {
                result = result.replace(target, "");
            }
        }

        return result;
    }

    public static String operateOverlapCheckerAndRemover(String cryptogram) {
        String overlapDeletedCryptogram = cryptogram;

        while (true) {
            List<String> overlapTarget = overlapChecker(overlapDeletedCryptogram);
            if (overlapTarget.size() == 0) {
                return "";
            }
            else if (overlapRemover(overlapDeletedCryptogram, overlapTarget).equals(overlapDeletedCryptogram)) {
                break;
            }
            overlapDeletedCryptogram = overlapRemover(overlapDeletedCryptogram, overlapTarget);
        }


        return overlapDeletedCryptogram;
    }

    public static String solution(String cryptogram) {

        return operateOverlapCheckerAndRemover(cryptogram);
    }
}