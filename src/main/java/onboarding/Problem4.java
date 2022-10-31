package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(word.length()<1||word.length()>1000) return "제한발생, 길이초과or미달";

        //ascii 이용 A = 65 Z=90 이므로 합 155 이용
        for(int i=0; i<word.length();i++){
            char temp =word.charAt(i);
            if (temp==32) answer+= " ";
            else if (temp<91&&temp>64)answer+=(char) (155 - temp);
            else if (temp<123&&temp>96) answer+= (char) (219 - temp);
            else return "제한 발생, 알파벳 이외의 문자입니다";

        }
        return answer;
    }
}
