package onboarding;

/*기능 요구 사항*/
/* 1. word가 매개변수로 주어질 때 반대로 변환함.
 * 2. 알파벳 외의 문자는 변환하지 않는다.
 <solution>
 *  - 알파벳 범위를 파악한 후, 반대로 변환하여 answer에 더해준다.
 *  - 범위가 아닌경우, answer에 그대로 더해준다.
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)>=65 && word.charAt(i) <=90){
                int dis = word.charAt(i) - 65;
                answer += (char)  ('A' +25 -dis);

            }else if (word.charAt(i)>=97 && word.charAt(i) <=122){
                int dis = word.charAt(i) - 97;
                answer += (char) ('a'+25 -dis);
            }
            else answer+=word.charAt(i);
        }
        return answer;
    }
}
