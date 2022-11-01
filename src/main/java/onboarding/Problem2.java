package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        StringBuffer sb=new StringBuffer();
        sb.append(cryptogram);
        char st;
        int cp;
        for (int i=0;i<sb.length()-1;i++){
            st=sb.charAt(i);
            cp=i+1;
            while (st==sb.charAt(cp)){
                //cryptogram=cryptogram.replace(String.valueOf(i),"");
                sb.deleteCharAt(i);
                sb.deleteCharAt(cp-1);
                if (i>0) {
                    i -= 1;
                    st = sb.charAt(i);
                    cp = i + 1;
                }
                else{
                    break;
                }
            }
        }
        answer= String.valueOf(sb);
        return answer;
    }
}