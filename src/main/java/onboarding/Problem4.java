package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb=new StringBuilder();
        int a=0;
        for(int i=0;i<word.length();i++){
            if('a'<=word.charAt(i)&&word.charAt(i)<='z') {
                a=(int)('z'-word.charAt(i));
                sb.append((char)((int)'a'+a));
            }
            else if('A'<=word.charAt(i)&&word.charAt(i)<='Z'){
                a=(int)('Z'-word.charAt(i));
                sb.append((char)((int)'A'+a));
            }
            else
                sb.append(word.charAt(i));
        }
        String answer =sb.toString();
        return answer;
    }
}
