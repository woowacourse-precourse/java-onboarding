package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {StringBuilder sb=new StringBuilder();
        sb.append(cryptogram);
        String answer =sb.toString();
        int changed=1;
        int j=1;
        int i=0;
        while(changed==1) {
            changed = 0;
            sb=new StringBuilder();
            i=0;
            while(i<answer.length()) {
                j=1;
                if(i<answer.length()-1){
                    while(answer.charAt(i)==answer.charAt(i+j)&&(i+j)<answer.length())
                        j++;
                }
                if(j==1) {
                    sb.append(answer.charAt(i));
                    i=i+j;
                }
                else {
                    i=i+j;
                    changed=1;
                }
            }
            answer=sb.toString();
        }
        return answer;
    }
}
