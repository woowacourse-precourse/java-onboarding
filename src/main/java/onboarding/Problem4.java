package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length(); i++){
            int ascii = (int)word.charAt(i);
            char ch;
            //대문자
            if(ascii > 65 && ascii < 90){
                ch = (char)(155 - ascii);
            //소문자
            }else if(ascii > 97 && ascii < 122){
                ch = (char)(219 - ascii);
            //공백
            }else{
                ch = (char)32;
            }
            answer += (char)ch;
        }
        return answer;
    }
}
