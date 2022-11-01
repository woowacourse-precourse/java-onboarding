package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // return 값 초기화 하기
        String answer = "";

        // 매개변수 word를 TOCHARARRAY 배열로 바꿔주기 ex) char[] str = { i, , l, o, v, e, , y, o, u } 배열 생성
        char[] str = word.toCharArray();

        /*
        ASCII (Integer > String)
        ex) int num = 97; char ch = (char)num; System.out.println(ch);
        a
        ASCII (String > Integer)
        ex) char ch = 'A'; int num = (int)ch; System.out.println(num);
        ex) char ch = 'A'; System.out.println(Integer.valueOf(ch));
        65
        */

        // 반복문을 통해서 각각 공백, 대문자, 소문자 구분 >> ASCII(STRING -> INTEGER)값으로 변환 해주고 반대되는 값 산출!
        for (int i = 0; i < str.length; i++) {
            // ASCII값 초기값 세팅
            int ASCI_NUM = 0;
            // 공백이면 공백 그대로
            if (str[i] == ' '){
                ASCI_NUM = ' ';
            // 소문자를 체크 > 현재 위치에서의 반대순서를 선택하는 식( 97 + 122 - 해당알파벳의 아스키값 = 반대순서의 아스키값)
            } else if (str[i] >= 97) {
                ASCI_NUM = 'a' + 'z' - str[i];
            // 대문자를 체크 > 현재 위체에서의 반대순서를 선택하는 식( 65 + 90 - 해당알파벳의 아스키값 = 반대순서의 아스키값 )
            } else if (65 <= str[i]) {
                ASCI_NUM = 'A' + 'Z' - str[i];
            }

            // 아스키(INTEGER > STRING)해주고, 초기화된 answer에 넣어주기
            answer += (char)ASCI_NUM;
        }
        // solution method의 return 값을 answer로 반환(반환형태는 STRING)
        return answer;
    }
}
