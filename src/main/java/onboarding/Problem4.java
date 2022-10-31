package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuffer f=new StringBuffer();
        for(char c:word.toCharArray()){
            int d;
            if(c<33)d=c;
            else if(c<91)d=90-(c-65);
            else d=122-(c-97);
            f.append((char)d);
        }
        return f.toString();
    }
}
