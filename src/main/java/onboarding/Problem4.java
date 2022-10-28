package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int ascii;
        int reverse;

        for(char tempWord : word.toCharArray()){
            if(Character.isUpperCase(tempWord)){ // 대문자 이면 ascii코드 시작은 65
                ascii = 65;
            } else if (Character.isLowerCase(tempWord)) { //소문자 이면 ascii코드 시작은 97
                ascii = 97;
            } else{ //대문자와 소문자 이외의 문자이면 그대로 (공백 또는 숫자 또는 특수 문자)
                answer += tempWord;
                continue;
            }

            // 알파벳 개수가 26개 이므로 a에서 25를 더해 z를 만든 후 현재 알파벳과 a의 차이만큼 빼서 반대로 변환한다.
            reverse = (ascii + 25) - Math.abs(ascii - (int)tempWord);
            answer += (char)reverse;
        }

        return answer;
    }
}
