package onboarding;

/*
제한사항
word는 길이가 1 이상 1,000 이하인 문자열이다.
알파벳 외의 문자는 변환하지 않는다.
알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
기능 목록
1. 각 문자 청개구리 사전
2. 청개구리 사전에 맞는 단어로 바꿔줌 : 대문자일 경우 청개구리 사전 그대로 사용하기, 소문자일 경우 소문자로 변환 후 바꿔줌
3. 알파벳이 아닌 다른 문자일 경우 그대로 붙여줌
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] dic = new char[26];
        int i;
        for(i = 0;i<26;i++){
            dic[i] = (char)('Z'-i);
        }
        int k;
        for(k = 0;k<word.length();k++){
            if((int)word.charAt(k)>=(int)'A' && (int)word.charAt(k)<=(int)'Z'){
                answer = answer.concat(String.valueOf(dic[(int)(word.charAt(k)-'A')]));
            }else if((int)word.charAt(k)>=(int)'a' && (int)word.charAt(k)<=(int)'z'){
                String s = String.valueOf(dic[(int)(word.charAt(k)-'a')]);
                s = s.toLowerCase();
                answer = answer.concat(s);
            }else{
                answer = answer.concat(String.valueOf(word.charAt(k)));
            }
        }
        return answer;
    }
}
