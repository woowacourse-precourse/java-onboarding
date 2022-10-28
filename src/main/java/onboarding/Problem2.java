package onboarding;
//1. 연속하는 중복 문자 찾기
//2. 연속하는 중복 문자 제거
//3. 1~2를 연속하는 중복문자가 없을 때 까지 반복
//4. 연속하는 중복 문자들을 삭제한 결과를 return
public class Problem2 {
    public static String solution(String cryptogram) {
        String s = cryptogram;
        String answer;
        int sw;
        while(true)
        {
            answer = "";
            sw = 0;
            for(int i = 0; i < s.length(); i++)
            {
                //1. 연속하는 중복 문자 찾기
                if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1))
                {
                    sw = 1;
                    continue;
                }
                else if(i > 0 && s.charAt(i) == s.charAt(i - 1))
                {
                    sw = 1;
                    continue;
                }

            }
            if(sw == 0)
                break;
        }
        return answer;
    }
}
