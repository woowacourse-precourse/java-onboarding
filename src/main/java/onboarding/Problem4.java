package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] tmpword = word.toCharArray();
        for(int i=0; i<word.length(); i++){
            if(tmpword[i]==' ') continue;
            else if(tmpword[i] < 96){
                tmpword[i] = (char)('A'+'Z'-tmpword[i]);
            } else if(tmpword[i] >= 97){
                tmpword[i] = (char)('a'+'z' - tmpword[i]);
            }
        }
        answer = String.valueOf(tmpword);

        return answer;
    }
}
