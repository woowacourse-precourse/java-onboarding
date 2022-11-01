package onboarding;

public class Problem4 {
    // 기능 구현 목록
    // 1. 예외처리 (word의 길이가 1 이상 10,000이하가 아닌 경우)
    // 2. 청개구리 사전에따라 입력된 문자열을 변환
    public static String solution(String word) {
        String result = "";

        // 예외처리
        // 1. word의 길이가 1 이상 10,000이하가 아니라면
        if (!(1 <= word.length()) && (10000 >= word.length())){
            result = "exceed the range";
            return result;
        }

        // 청개구리 사전에따라 입력된 문자열을 변환
        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) >='A' && word.charAt(i) <= 'Z'){ // 해당 문자가 알파벳 대문자라면

                String replace_string = String.valueOf((char) (90 - ((int) word.charAt(i) - 65))); // 변경 문자 계산
                //System.out.printf("변경할 문자 : %s, %c \n", replace_string, word.charAt(i));

                StringBuffer temp_word = new StringBuffer(word); // 문자를 바꾸기 위한 replace메서드를 사용하기 위한 StringBuffer 변수 선언
                temp_word = temp_word.replace(i,i+1, replace_string); // 문자 변경

                //System.out.printf("변경된 문자로 업데이트된 문자열 : %s \n", temp_word);

                word = temp_word.toString(); // 변경된 문자열로 업데이트

            }
            else if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') { // 해당 문자가 알파벳 소문자라면

                String replace_string = String.valueOf((char) (122 - ((int) word.charAt(i) - 97))); // 변경 문자 계산
                //System.out.printf("변경할 문자 : %s, %c \n", replace_string, word.charAt(i));

                StringBuffer temp_word = new StringBuffer(word); // 문자를 바꾸기 위한 replace 메서드를 사용하기 위한 StringBuffer 변수 선언
                temp_word = temp_word.replace(i,i+1, replace_string); // 문자 변경
                //System.out.printf("변경된 문자로 업데이트된 문자열 : %s \n", temp_word);

                word = temp_word.toString(); // 변경된 문자열로 업데이트


            }
        }
        String answer = word;
        return answer;
    }
}
