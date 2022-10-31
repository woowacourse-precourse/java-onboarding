package onboarding;

/**
 * a->z, A->Z로 변해야 함.
 * a와 z의 아스키 코드 값의 합은 219, A와 Z의 아스키 코드 값의 합은 155임을 이용
 * 즉 219에서 a의 아스키 코드 값을 빼면 z가 나온다.
 *
 * 대문자/소문자일 경우를 구분하여 각각 219(소문자의 경우), 155(대문자의 경우)에서 입력받은 문자의 아스키 코드 값을 빼준 후
 * 다시 문자로 변환해주면 문자가 요구사항과 같이 바뀌게 된다.
 */
public class Problem4 {
    public static char change(char input){
        int code = input;
        char output='a';
        if(input == ' '){
            return ' ';
        }else{
            if(code>90){
                output = (char) (219-code);
            }else{

                output=(char)(155-code);
            }
            return output;
        }

    }

    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i<word.length();i++){
            answer+=change(word.charAt(i));
        }
        return answer;
    }
}
