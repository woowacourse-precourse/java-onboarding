package onboarding;
//알파벳이 대문자인지 소문자인지 나누고 기준을 M,n 으로잡고 그 차이를 이용하여 바꿔주기
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)>=65&&word.charAt(i)<=90){
                answer += upper(word.charAt(i));
            }
            else if(word.charAt(i)>=97&&word.charAt(i)<=122){
                answer += lower(word.charAt(i));
            } else answer += word.charAt(i);
        }
        return answer;
    }
    public static char upper(char alphabet){//기준을 M으로 잡고 알파벳과 m의 차이를 통해 그만큼 M에 연산을 해줘서 구해줌
        char answer;
        if(alphabet>77){//알파벳이 아스키코드상 M보다 크면
           answer= (char) (77-(alphabet-78));
           return answer;

        } else if(alphabet==77){
            answer=(char)78;
            return answer;
        } else {return answer = (char) (77+(77 - alphabet+1));}
    }
    public static char lower(char alphabet){//기준을 m으로 잡고 알파벳과 m의 차이를 통해 그만큼 m에 연산을 해줘서 구해줌
        char answer;
        if(alphabet>109){//알파벳이 아스키코드상 m보다 크면
            answer= (char) (109-(alphabet-110));
            return answer;

        } else if(alphabet==109){
            answer=(char)110;
            return answer;
        } else {return answer = (char) (109+(110- alphabet));}
    }
}
