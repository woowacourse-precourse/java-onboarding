package onboarding;

//기능목록
//1.문장의 길이 만큼 반복해서 아스키 코드로 대문자와 소문자 그리고 나머지로 구분
//2.대문자는 A~Z 소문자는 a~z의 아스키코드를 더한 값 각각 대문자 155 소문자 219 각 단어의 아스키 코드를 빼준 값을 추가
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        char[] words = word.toCharArray();
        for (char w : words){
            //대문자
            if(w >= 65 && w <= 90 ){
                answer.append((char) (155 - w));
            //소문자
            } else if (w >= 97 && w <= 122) {
                answer.append((char) (219 - w));
            //공백 그외 잡다한 것들..
            } else {
                answer.append(w);
            }
        }
        return answer.toString();
    }
}
