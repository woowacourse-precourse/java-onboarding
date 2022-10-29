package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='A'&&c<='Z')
                c=(char)('Z'-c+'A');
            else if(c>='a'&&c<='z')
                c=(char)('z'-c+'a');
            answer+=c;
        }
        return answer;
    }
}
