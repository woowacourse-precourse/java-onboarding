package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char letter;
        for(int i = 0; i < word.length();i++){
            char c = word.charAt(i);
            //대문자일때
            if(c >= 'A' && c <= 'Z')
                letter = 'A';
                //소문자일때
            else if(c >= 'a' && c <= 'z')
                letter = 'a';
                //알파벳 아닐 때
            else{
                answer += c;
                continue;
            }
            //알파벳 반대로 변환
            //25-(c-letter)+letter
            answer += (char)(25-c+2*letter);
        }
        return answer;
    }

}
