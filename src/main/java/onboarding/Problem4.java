package onboarding;


/*

- 주어진 문장의 글자를 반대로 변환하여 return 하는 메소드
- 알파벳 Only, 대문자는 대문자, 소문자는 소문자, word의 길이는 1이상 1000이하인 문자열

 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuffer ansb = new StringBuffer((""));

        int leng = word.length();
        for (int i = 0; i < leng; i++) {

            char character = word.charAt(i);
            int numc = (int) character;

            if (numc < 91 && numc > 64) {
                numc = 155 - numc;

            }
            else if ((numc > 96) && (numc < 123)) {
                numc = 219 - numc;
            }
            ansb.append((char) numc);
        }
        answer = ansb.toString();
        return answer;
    }
}
