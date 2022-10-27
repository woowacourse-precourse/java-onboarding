package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(String.valueOf(cryptogram.charAt(0)));
        String[] wordArr = cryptogram.split("");

        for(int i=1;i<wordArr.length;i++){
            String lastword = String.valueOf(answer.charAt(answer.length()-1));
            if(lastword.equals(wordArr[i])){
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
                continue;
            }
            answer.append(wordArr[i]);
        }
        return answer.toString();
    }

    public static void main(String[] args){
        System.out.println(solution("browoanoommnaon"));// "brown"

    }
}
