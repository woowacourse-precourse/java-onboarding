package onboarding;
import java.util.LinkedList;
import java.util.Deque;
import java.util.List;

public class Problem2 {
    static boolean isFinished = false;
    static final int MAXIDX = 1010;
    //연속된 문자열 찾기
    static Deque<Integer> findRedundant(String cryptogram){
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < cryptogram.length(); i++){
            if(i == cryptogram.length() - 1) break; //뒤에 문자열 없음
            char prevAlp = cryptogram.charAt(i);
            for(int j = i + 1; j< cryptogram.length();){
                char curAlp = cryptogram.charAt(j);
                if(prevAlp == curAlp) {
                    deque.add(i);
                    deque.add(j);
                    j++;
                }

                else
                    break; //뒤에 같은 문자열 더이상 없으면

            }
        }
        if(deque.isEmpty()) isFinished = true;
        return deque;
    }

    //연속된 문자열 제거
    static String removeRedundant(String cryptogram){
        String removedString = cryptogram;
        Deque<Integer> deque = findRedundant(cryptogram);

        if(isFinished) {
            return removedString;
        }

        int firstIdx = deque.peekFirst();
        int lastIdx = deque.peekLast();
        removedString = removedString.substring(0,firstIdx)
                + removedString.substring(lastIdx+1);

        return removedString;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        String modifyCrypto = cryptogram;

        while(true){
            if(isFinished) break;
            modifyCrypto = removeRedundant(modifyCrypto);
        }

        answer = modifyCrypto;
        return answer;
    }
}