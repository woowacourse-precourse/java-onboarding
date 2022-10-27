package onboarding;

import java.util.List;

/*
*   구현 기능
*   1. 중복 패턴 검사 기능
*   2. 중복 패턴 제거 기능
*/
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

interface Detector {
    List<Integer> findPattern();
}

interface Deleter {
    String deletePattern(String cryptogram);
}

class DuplicateDeleter implements Detector {

    String cryptogram;

    public DuplicateDeleter(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    @Override
    public List<Integer> findPattern() {
        int endPoint = 0;
        int i;
        for(i = 0 ; i < cryptogram.length() ; i++) {
            endPoint = findEndpoint(i);
            if (endPoint != i) {
                break;
            }
        }
        return List.of(i, endPoint);
    }

    public int findEndpoint(int base) {
        int result;
        if(cryptogram.charAt(base) != cryptogram.charAt(base+1)){
            return base;
        }
        result = findEndpoint(base+1);
        return result;
    }
}