package onboarding;
/*
 * @version 1.0.0 2022년 11월 1일
 * @author DongWooE
 */
public class Problem4 {

    /* 최종적으로 요구사항에 맞도록 변환된 결과값이 담기는 인스턴스 변수 */
    StringBuilder result = new StringBuilder();
    /*
     * Problem 4의 메인 메소드
     * @param word 계좌에 담긴 돈
     * @return 최종적으로 변환된 결과값
     */
    public static String solution(String word) {
        Problem4 p4 = new Problem4();
        p4.iterate(word);
        return p4.result.toString();
    }
    /*
     * 문자열의 각각을 탐색하며 result 변수에 변환된 값을 넣어주는 메소드
     */
    private void iterate(String word) {
        for(char c : word.toCharArray()){
            if(c > 'a' && c < 'z') result.append((char)('a' + 'z' - c));
            else if(c > 'A' && c < 'Z') result.append((char)('A' + 'Z' - c));
            else result.append(" ");
        }
    }
}
