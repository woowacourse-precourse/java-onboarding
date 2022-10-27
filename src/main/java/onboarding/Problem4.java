package onboarding;

public class Problem4 {

    //기능 1.
    public static String solution(String word) {
        String answer = word;
        char[] chars = answer.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c: chars) {
            if(c >= 65 &&  c <= 90){
                c = (char) (155 - c);
                sb.append(c);
            }else if(c >= 97 &&  c <= 122){
                c = (char) (219 - c);
                sb.append(c);
            }else {
                sb.append(c);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
