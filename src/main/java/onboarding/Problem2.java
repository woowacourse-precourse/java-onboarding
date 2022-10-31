package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while(true){
            answer = cryptogram;
            cryptogram = remove_repeatChar(cryptogram);
            if (answer.equals(cryptogram)) break;
        }

        return answer;
    }

    public static String remove_repeatChar(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.append(' ');

        for(int i = 0; i < sb.length() - 1; i++){
            if(sb.charAt(i) == sb.charAt(i + 1)){
                sb.delete(i, i + 2);
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }
}
