package onboarding;

public class Problem2 {
    /*  기능구현
        1. 중복된 변수를 삭제하기 위해 param을 StringBulider(sb)에 담아준다.
        2. for문을 돌며 sb를 i, i + 1을 반복해서 비교 (중복비교)
        3. 맞으면 문자 두개(중복된 문자) 제거 후 인덱스 감소
        4. sb를 answer 옮김
     */
    public static String solution(String cryptogram) {
        String answer = "answer";

        StringBuilder sb = new StringBuilder(cryptogram);

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                if (i != 0) i -= 2;
            }
        }
        answer = sb.toString();

        return answer;
    }
}