package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer s = new StringBuffer();
        int n = cryptogram.length(), i = 0;
        char ch;

        s.append(cryptogram);
        while(i<n-1){
            if(s.charAt(i)==s.charAt(i+1)){
                ch = s.charAt(i);
                while(s.charAt(i)==ch) {
                    s.deleteCharAt(i);
                    n = s.length();
                    if(i==n){
                        break;
                    }
                }
                i=0;
                continue;
            }
            i++;
        }

        answer = new String(s);

        return answer;
    }
}
