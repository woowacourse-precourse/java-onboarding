package onboarding;

/*
    요구사항 분석
    제한사항
    1. word는 길이가 1 이상 1,000 이하인 문자열이다.
    2. 알파벳 외의 문자는 변환하지 않는다. (구현필요)
    3. 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다. (구현필요)

    알파벳 변환은 알파벳상 대칭되는 문자와 매칭된다
    변환해야할 알파벳을 c라했을떄
    'z' - ( c - 'a')  혹은 'Z' - (c - 'A') 로 변환하면 된다

    또한 제한사항 2,3은 꼭 확인해서 구현해야한다
    + 띄어쓰기 구현해야한다

 */

public class Problem4 {
    public static String solution(String word) {

        char c;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                answer.append((char)('z' - (c - 'a')));
            } else if (c >= 'A' && c <= 'Z') {
                answer.append((char)('Z' - (c - 'A')));
            } else if (c == ' ') {
                answer.append(' ');
            }
        }
        return answer.toString();
    }
}
