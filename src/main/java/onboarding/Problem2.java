package onboarding;

/*
<내가 생각하는 문제 푸는 알고리즘>
1. while문으로 완전한 문장이 될 때까지 돌린다.
: 반복의 횟수를 모를 때에는 for문이 아닌 while문을 사용하기 때문.

2. 중복되는 문자가 존재한다면, 그 문자를 삭제한다.
: 삭제할 때에는 StringBuilder의 delete를 사용한다.

3. 마지막에 String으로 바꾸어서 다시 while문에 돌린다.
: 요구하는 returnType이 String이기 때문이다.
 */

public class Problem2 {
    
    // 
    private static boolean isNeedFix(StringBuilder sb) {
        for (int i = 1; i < sb.length(); i++) {
            if(sb.charAt(i) == sb.charAt(i-1)) {
                return true;
            }
        }
        return false;
    }

    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        while (isNeedFix(sb)) { // 중복되는 문자가 존재한다면
            for (int i = 1; i < sb.length(); i++) {
                if(sb.charAt(i) == sb.charAt(i-1)) {
                    sb.delete(i-1,i+1); // 그 문자를 삭제한다.
                }
            }
        }
        return sb.toString();
    }
}
