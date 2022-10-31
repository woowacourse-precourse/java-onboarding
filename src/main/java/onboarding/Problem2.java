package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer sb=new StringBuffer(cryptogram);
        int length=sb.length()-2;
        for (int i = 0; i < length; i++) {
            char pre;
            char nxt;
            pre=sb.charAt(i);
            nxt=sb.charAt(i+1);
            if(pre==nxt){
                sb.delete(i,i+2);//같은 값을 모두 삭제
                length-=2;//삭제한만큼 stringbuffer size 줄이기.
                i-=2;//인덱스값도 삭제한 만큼 줄이기.->해당 인덱스의 앞에서부터 재검사.

            }

        }
        if(sb.length()==2){
            if(sb.charAt(0)==sb.charAt(1)){
                sb.delete(0,2);
            }
        }
        answer=sb.toString();
        return answer;
    }
}
