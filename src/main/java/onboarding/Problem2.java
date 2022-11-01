package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram; //"answer";

        while(true){
            int index = getIndex(answer);   // 중복된 문자의 인덱스 리턴

            if(index == -1)   // 더 이상 문자가 없거나 회문이 없는 경우
                break;
            answer = deletePalindrome(answer, index);     // 회문 제거
        }

        //System.out.println("answer: "+answer);

        return answer;
    }

    static int getIndex(String palindrome){
        // 중복된 문자가 있는 인덱스
        for(int i=0; i<palindrome.length()-1; i++) {
            if (palindrome.charAt(i) == palindrome.charAt(i+1))
                return i;
        }
        return -1;    // 중복된 문자가 없으면 -1
    }
    static String deletePalindrome(String palindrome, int index){
        // 중복 문자를 제외한 문자열 리턴
        return palindrome.substring(0, index) + palindrome.substring(index+2);
    }
}
