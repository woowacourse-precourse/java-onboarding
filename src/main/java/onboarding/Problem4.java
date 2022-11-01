package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int len = word.length(), i, j, k;
        char ch, transch;

        for(i=0;i<len;i++){
            ch = word.charAt(i);
            if(ch==' '){
                answer = answer + ' ';
            }
            else if(ch>='a'&&ch<='z'){
                k = ch-'a';
                transch='z';
                for(j=0;j<k;j++) {
                    transch--;
                }
                answer = answer + transch;
            }
            else{
                k = ch-'A';
                transch='Z';
                for(j=0;j<k;j++) {
                    transch--;
                }
                answer = answer + transch;
            }
        }

        return answer;
    }
}
