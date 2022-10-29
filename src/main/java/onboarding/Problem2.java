package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        //문자열의 처음부터 끝까지 검사하는 것을 여러번 반복
        while(true){
            String removedCryptogram = removeRepeatedCharacters(cryptogram);
            if(removedCryptogram.equals(cryptogram)){
                //제거된 문자가 없으므로 반복문 탈출
                answer = cryptogram; //반환값 설정
                break;
            }else{
                //숫자로 대체된 문자들을 한번에 삭제하고 다시 반복
                cryptogram = removedCryptogram;
            }
        }
        return answer;
    }

    private static String removeRepeatedCharacters(String inputStr){
        char a = ' ';
        if(inputStr.length()> 0){
            a = inputStr.charAt(0); //초기 세팅
        }
        int count = 0; //중복 문자를 처리했을 경우 증가
        //문자열의 처음부터 끝까지 검사하여 연속되는 중복문자들은 1로 대체(문제 조건이 입력은 알파벳 소문자만 주어진다 하였으므로)
        StringBuffer str = new StringBuffer(inputStr);
        for(int i = 1; i < inputStr.length(); i++){
            char b = inputStr.charAt(i);
            if(a == b) {
                //겹치는 문자를 1로 대체
                str.setCharAt(i-1, '1');
                str.setCharAt(i, '1');
                count++;
            }
            a = b;
        }
        String outputStr = str.toString().replaceAll("1", "");

        return outputStr;
    }

}
