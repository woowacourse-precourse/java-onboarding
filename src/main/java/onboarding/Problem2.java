package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String tmp = cryptogram;
        while(true) {
            boolean changed=false;
            int idx=1, start=0;
            char c=tmp.charAt(0);

            while (idx < tmp.length()) {
                if (tmp.charAt(idx) != c) {
                    start = idx;
                    c = tmp.charAt(idx);
                    idx++;
                } else {
                    tmp = tmp.substring(0, start) + tmp.substring(idx + 1);
                    idx = start;
                    changed=true;
                }
            }
            if(!changed) break;
            if(tmp.length()==0) break;
        }
        answer=tmp;

        return answer;
    }
}
