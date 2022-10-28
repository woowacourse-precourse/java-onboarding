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
        //3. 1~2를 연속하는 중복문자가 없을 때 까지 반복
        while(true)
        {
            answer = "";
            sw = 0;
            //1. 연속하는 중복 문자 찾기
            for(int i = 0; i < s.length(); i++)
            {
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
                //2. 연속하는 중복 문자 제거
                answer += s.charAt(i);
            }
            s = answer;

            //3. 1~2를 연속하는 중복문자가 없을 때 까지 반복
            if(sw == 0)
                break;
        }
        //4. 연속하는 중복 문자들을 삭제한 결과를 return
        return answer;
    }
}
