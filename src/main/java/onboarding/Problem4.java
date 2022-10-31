package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c > 64 && c < 91){
                buffer.append((char)(155-c));
            } else if(c > 96 && c < 123){
                buffer.append((char)(219-c));
            } else{
                buffer.append(c);
            }
        }
        answer = buffer.toString();
        return answer;
    }
}
