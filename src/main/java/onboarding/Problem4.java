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
            int a =divideCase(ch[i]);
            if(a==1) ch[i] = (char)(209 - (int)ch[i]);
            if(a==2) ch[i] = (char)(155 - (int)ch[i]);
        }
        answer=ch.toString();
        return answer;
    }

    public static Integer divideCase(char c){
        if(c>=97 && c<=112) return 1; //소문자
        if(c>=65 && c<=90) return 2;
        return 0;
    }

}
