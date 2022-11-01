package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int len = word.length(), i, j, k;
        char ch, transch;

        for(i=0;i<len;i++){
            ch = word.charAt(i);
            if(ch>='a'&&ch<='z'){ //소문자일때
                k = ch-'a';
                transch='z';
                for(j=0;j<k;j++) {
                    transch--;
                }
                answer = answer + transch;
            }
            else if(ch>='A' && ch<='Z'){ // 대문자일때
                k = ch-'A';
                transch='Z';
                for(j=0;j<k;j++) {
                    transch--;
                }
                answer = answer + transch;
            }
            else{ // 알파벳 외의 문자일 때는 변환 없음
                answer = answer + ch;
            }
        }

        return answer;
    }
}
