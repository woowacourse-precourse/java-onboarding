package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        //1. answer에  cryptogram 첫문자 넣기
        String answer = Character.toString(cryptogram.charAt(0));


        //2. cryptogram 하나씩 읽어서
        //      - answer 마지막 글자랑 같으면 answer 마지막 글자 삭제
        //      - answer 마지막 글자랑 다르면 answer에 추가
        for(int i=1;i<cryptogram.length();i++){
            if(cryptogram.charAt(i)==answer.charAt(answer.length()-1))answer=answer.substring(0,answer.length()-1);
            else answer+=Character.toString(cryptogram.charAt(i));
        }
        return answer;
    }
}
