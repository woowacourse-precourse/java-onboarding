package onboarding;
import java.util.LinkedList;
import java.util.Deque;
import java.util.List;

public class Problem2 {
    static boolean isFinished = false;
    
    //연속된 문자열 지우기
    static String removeRedundant(String cryptogram){
        String modifyCrypto = cryptogram;
        int removeCnt = 0;
        Character prevChar = ' ';
        boolean isRemoved = false;
        for(int idx = 1; idx < modifyCrypto.length(); idx++){
            if(modifyCrypto.charAt(idx - 1) == modifyCrypto.charAt(idx) && isRemoved != true){
                prevChar = modifyCrypto.charAt(idx);
                modifyCrypto = modifyCrypto.substring(0,idx - 1) + modifyCrypto.substring(idx + 1);
                idx -= 2;
                if(idx == -1) idx++;
                removeCnt++;
                isRemoved = true;
                continue;
            }
            if(prevChar == modifyCrypto.charAt(idx) && isRemoved == true){
                prevChar = modifyCrypto.charAt(idx);
                modifyCrypto = modifyCrypto.substring(0,idx) + modifyCrypto.substring(idx + 1);
                idx -=1;
                removeCnt++;
                continue;
            }
            prevChar = ' ';
            isRemoved = false;
        }
        if(removeCnt == 0) isFinished = true;
        return modifyCrypto;
    }

    //중복된 문자열 없을 때 까지 진행
    static String completelyRemove(String cryptogram){
        String modifyCrypto = removeRedundant(cryptogram);
        while(true){
            if(isFinished) break;
            modifyCrypto = removeRedundant(modifyCrypto);
        }
        return modifyCrypto;
    }

    
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = completelyRemove(cryptogram);
        return answer;
    }
}