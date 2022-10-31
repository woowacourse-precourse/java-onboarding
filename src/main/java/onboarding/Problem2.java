package onboarding;

public class Problem2 {
    public static String getNonduplicateString(String target) {
        StringBuilder result = new StringBuilder(); // 연속 중복 문자열이 없도록 target에서 문자를 하나씩 옮긴다.

        // result의 마지막과 target 현재 부분이 같을 경우 체크해놓고 넘기고, 나중에 result에서 마지막 한 칸을 제거한다.
        boolean isDuplicated = false;
        for (int i = 0; i < target.length(); i++) {
            if (result.length() == 0) { // result가 비어있으면 target 현재 부분을 그대로 추가하면 된다.
                result.append(target.charAt(i));
                continue;
            }

            // 아래 코드에서는 result에 원소가 있음을 보장한다.

            // result의 마지막과 target의 현재 문자가 같은 경우 result에 옮기지 않은 채 넘긴다.
            if (result.charAt(result.length() - 1) == target.charAt(i)) {
                isDuplicated = true;
                continue;
            }
            // 이후 result 마지막 한 칸을 제거하고, 같은 i에 대해서 다시 한 번 중복 여부를 체크해준다.
            if (isDuplicated) {
                result.deleteCharAt(result.length() - 1);
                isDuplicated = false;
                i--;
                continue;
            }
            result.append(target.charAt(i));
        }
        if (isDuplicated && result.length() > 0) { // aaaa와 같이 마지막 중복처리가 끝나지 않은 채 for문이 끝나는 경우 위함
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }

    public static String solution(String cryptogram) {
        return getNonduplicateString(cryptogram);
    }
}
