package onboarding;

public class Problem2 {
    //중복 문자 있는 지 검사
    public static boolean isOverlap(StringBuffer sb){
        if(sb.length()<=0)
            return false;

        for(int i = 0; i<sb.length()-1; i++){
            if(sb.charAt(i) == sb.charAt(i+1))
                return true;
        }
        return false;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        //나중에 중복 문자 제거 위해 string을 StringBuffer로 변경
        StringBuffer sb = new StringBuffer(answer);


        //중복 제거 후 다시 string으로 변환
        answer = sb.toString();
        return answer;
    }
}
