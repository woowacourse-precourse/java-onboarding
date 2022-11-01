package onboarding;

public class Problem4 {

    public static String reverseAlphabet(String str) {
        int tmp;
        StringBuilder reverse = new StringBuilder();
        for (int i =0; i< str.length(); i++) {
            tmp = str.charAt(i);
            if((65 <= tmp)&&(tmp <=90)){
                reverse.append((char) (155 - tmp));
            }else if((97 <= tmp)&&(tmp<=122)){
                reverse.append((char) (219 - tmp));
            }else{
                reverse.append((char) tmp);
            }
        }return reverse.toString();
    }
    public static String solution(String word) {

        String answer = "";
        answer = reverseAlphabet(word);
        return answer;
    }
}
