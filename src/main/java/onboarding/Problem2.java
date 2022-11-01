package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int cnt = 0,i = 0;
        StringBuffer sb = new StringBuffer(cryptogram);

        while(i != sb.length()){
            //지워야 하는 부분이 문자열의 끝에 있을때
            if(i+2 > sb.length()){
                if(cnt != 0) sb.delete(i - cnt, i+1);
                break;
            }

            if(equalCheckNextLetter(sb.substring(i,i+1),(sb.substring(i+1,i+2)))){
                cnt++;
                i++;
            }
            else{
                if(cnt == 0){
                    i++;
                    continue;
                }
                else{
                    sb.delete(i - cnt, i+1);
                    i -= (cnt+1);
                    cnt = 0;
                }
            }
        }
        answer = sb.toString();

        return answer;
    }

    public static boolean equalCheckNextLetter(String origin,String compare){
        if(origin.equals(compare))
            return true;
        else
            return false;
    }
}
