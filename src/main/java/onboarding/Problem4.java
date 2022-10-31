package onboarding;
//1. 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++)
        {
            //현재 위치의 문자가 A ~ Z 사이인지 확인
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
            {
                //문자가 A ~ Z 사이인 경우 아스키코드와 청개구리 사전을 이용해 해당 문자로 변환
                answer += (char)(155 - word.charAt(i));
                continue;
            }
            //현재 위치의 문자가 a ~ z 사이인지 확인
            if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
            {
                //문자가 a ~ z 사이인 경우 아스키코드와 청개구리 사전을 이용해 해당 문자로 변환
                answer += (char)(219 - word.charAt(i));
                continue;
            }
            answer += word.charAt(i);
        }
        return answer;
    }
}
