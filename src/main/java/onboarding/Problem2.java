package onboarding;


public class Problem2 {

/*

 idea 1) 문자열 -> 배열 변환 후, 같은 두 단어가 연속 될 때 삭제 처리
 idea 2) charAt 함수로 다음 단어랑 같은게 있으면 삭제 처리
 idea 3) indexof 활용해보기?
 
 
 제한사항 반영 하기
 */


    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        sb.append(cryptogram);

        boolean stop = true;
        while (stop) {
            stop = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.replace(i, i + 2, "");
                    stop = true;
                }
            }
        }
        answer = sb.toString();
        return answer;
    }

}