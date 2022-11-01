package onboarding;

public class Problem2 {

    public static String answer;
    public static String solution(String cryptogram) {
        answer = cryptogram;

        searchDuplicateWords();
        return answer;
    }

    //문자열이 주어지면 문자열의 길이만큼 반복하며 중복되는 문자가 있는지 찾는다
    public static void searchDuplicateWords(){

        for(int i=0;i<answer.length();i++){
            char c = answer.charAt(i);
            String tmp = answer;
            answer = answer.replaceAll("["+c+"]{2,}","");

            if(tmp.length() > answer.length()) {
                searchDuplicateWords();
                return;
            }
        }
    }
}
