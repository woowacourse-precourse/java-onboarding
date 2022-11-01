package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] upper = new char[26];
        char[] lower = new char[26];
        for(int i=25, j=0; i>=0; i--,j++){
            upper[i] = (char)('A'+j);
            lower[i] = (char)('a'+j);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char cur = word.charAt(i);
            if(('a'<= cur && cur <= 'z') || ('A'<=cur && cur <= 'Z')){
                if(Character.isUpperCase(cur)){
                    sb.append(upper[cur-'A']);
                }
                else{
                    sb.append(lower[cur-'a']);
                }
            }else{
                sb.append(cur);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
