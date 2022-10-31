package onboarding;

//문제 2번 기능 요구사항
//1. String이 들어오면 반복되는 것을 줄여서 반환해주는 함수
//2. 반복해서 함수 넣기 전과 후가 같은지 체크해서 같으면 종료 다르면 다시 반복

public class Problem2 {

    //기능 1
    public static String cutSameWord(String str) {
        for(int i=0;i<str.length()-1;i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                str=str.substring(0,i)+str.substring(i+2);
                break;
            }
        }
        return str;
    }

    //기능 2
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(true) {
            String newAnswer=cutSameWord(cryptogram);
            if(cryptogram.equals(newAnswer)) {
                answer=cryptogram;
                break;
            }
            else {
                cryptogram=newAnswer;
            }
        }
        return answer;
    }
}
