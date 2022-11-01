package onboarding;
/*
아스키코드 숫자를 이용!
65-90 : A-Z
97-122: a-z
숫자가 아니면 변환X
 */
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<word.length();i++){
            char w=word.charAt(i);
            int iw=(int)w;
            if(iw>=65 && iw<=90){
                if(iw<78)
                    iw=77+(78-iw);
                else
                    iw=78-(iw-77);
            } else if (iw>97 && iw<122) {
                if(iw<110)
                    iw=109+(110-iw);
                else
                    iw=110-(iw-109);
            }
            w=(char)iw;
            answer.append(w);
        }
        return answer.toString();
    }
}
