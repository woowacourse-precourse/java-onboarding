package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        int A_Num=0;
        int t=0;

        for(int i=0; i<word.length(); i++)
        {
            A_Num=word.charAt(i);
            if(32==A_Num) answer+=" ";

            if(A_Num>64 && A_Num<91)
            {
                t = 90 - word.charAt(i);
                answer += (char) (65 + t);
            }

            if(A_Num>96 && A_Num<123)
            {
                t=122 - word.charAt(i);
                answer += (char)(97+t);
            }
        }

        return answer;
    }
}