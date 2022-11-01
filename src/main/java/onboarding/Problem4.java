package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length();i++){
            int asc=(int)word.charAt(i);

            if(asc>96 && asc<123) asc=219-asc;
            else if(asc>64 && asc<91) asc=155-asc;

            char c=(char)asc;
            answer+=c;
        }
        return answer;
    }

}
