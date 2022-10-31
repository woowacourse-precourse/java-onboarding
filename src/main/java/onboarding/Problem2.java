package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        StringBuilder sb = new StringBuilder(cryptogram);
        sb.append(' ');

        for(int i = 0; i < sb.length() - 1; i++){
            if(sb.charAt(i) == sb.charAt(i + 1)){
                sb.delete(i, i + 2);
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
        return answer;
    }

    public static void main(String[] args) {
        solution("browoanoommnaon");
        solution("browoanmmnaon");
    }
}
