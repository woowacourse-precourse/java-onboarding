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

    //중복 문자 제거하는 method
    public static StringBuffer deleteOverlap(StringBuffer sb){

        //문자열 전체 길이 -1만큼 반복해 중복 문자 찾기
        for(int i = 0; i<sb.length()-1; i++){
            int count = 0;

            //만약 중복되는 문자가 있으면..
            if(sb.charAt(i) == sb.charAt(i+1)){
                //연속된 중복 문자열의 마지막 index 구하기
                for(int j = i+1; j<sb.length(); j++){
                    if(sb.charAt(i) == sb.charAt(j))
                        count++;
                    else // 중복이 아닐 경우 빠져나옴
                        break;
                }
                sb.delete(i, (i+1+count));
            }
        }
        return sb;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        
        //나중에 중복 문자 제거 위해 string을 StringBuffer로 변경
        StringBuffer sb = new StringBuffer(answer);

        while(isOverlap(sb)){
            deleteOverlap(sb);
        }

        //중복 제거 후 다시 string으로 변환
        answer = sb.toString();
        return answer;
    }
}
