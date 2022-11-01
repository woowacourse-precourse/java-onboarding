package onboarding;

/**
 * ASCII code 활용
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        // 배열 순회를 위한 자료형 변환
        char[] chars = word.toCharArray();
        // ASCII 코드 활용
        for(int c : chars){
            if(c >= 65 && c <= 90)
                c = 155 - c;
            else if(c >= 97 && c <= 122)
                c = 219 - c;
            //알파벳 외의 문자는 변환하지 않는다.
            sb.append((char) c);
        }
        return sb.toString();
    }
}
