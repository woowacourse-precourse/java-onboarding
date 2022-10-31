package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        int Ascii_Num=0;
        int sub_num=0;

        for(int i=0; i<word.length(); i++) {
            Ascii_Num=word.charAt(i);
            if(32==Ascii_Num) answer+=" ";

            if(Ascii_Num>64 && Ascii_Num<91) {
                sub_num = 90 - word.charAt(i);
                answer += (char) (65 + sub_num);
            }

            if(Ascii_Num>96 && Ascii_Num<123) {
                sub_num=122 - word.charAt(i);
                answer += (char)(97+sub_num);
            }
        }

        return answer;
    }
}