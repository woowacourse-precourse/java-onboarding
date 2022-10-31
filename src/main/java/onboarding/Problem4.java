package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0;i<word.length();i++){
            char now=word.charAt(i);
            if(now>='A'&& now<='z'){
                char a=' ';
                if(Character.isUpperCase(now)){
                    a=(char)(now+('M'-now)*2+1);
                }else {
                    a = (char) (now + ('m' - now) * 2 + 1);
                }


            }
        }
        return answer;
    }
}
