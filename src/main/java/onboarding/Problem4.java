package onboarding;
/*
알파벳 변환
1. 조건 확인 - > 알파벳만 변환. 즉 문자 c의 범위는 65 <= c <= 90 || 97 <= c <= 112
2. A+Z - Z  = A임을 기억하며 문자열 순회. 문자 변경
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] ch = word.toCharArray();
        for(int i=0;i<ch.length;i++){
            int a = divideCase(ch[i]);
            if(a==1) {
                answer = answer + (char)(219 - ch[i]);
                continue;
            }
            if(a==2) {
                answer = answer + (char)(155 - ch[i]);
                continue;
            }
            answer+=ch[i];
        }
        return answer;
    }

    public static Integer divideCase(char c){
        if(c>=97 && c<=122) return 1; //소문자
        if(c>=65 && c<=90) return 2; //대문자
        return 0;
    }

}
