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
        Deleter deleter;
        PatternDeleteFactory patternDeleteFactory = new PatternDeleteFactory(new DuplicateDetector());

        deleter = patternDeleteFactory.makeDelete();

        answer = deleter.process(cryptogram);

        return answer;
    }
}

interface Detector {
    List<Integer> findPattern(String cryptogram);
}

interface Deleter {
    String process(String cryptogram);
}

class DuplicateDetector implements Detector {

    @Override
    public List<Integer> findPattern(String cryptogram) {
        int endPoint = 0;
        int i;
        for(i = 0 ; i < cryptogram.length()-1 ; i++) {
            endPoint = findEndpoint(i, cryptogram);
            if (endPoint != i) {
                break;
            }
        }
        return List.of(i, endPoint);
    }

    public int findEndpoint(int base, String cryptogram) {
        int result;
        if(cryptogram.length() == base+1){
            return base;
        }
        if(cryptogram.charAt(base) != cryptogram.charAt(base+1)) {
            return base;
        }
        result = findEndpoint(base+1, cryptogram);
        return result;
    }
}

class PatternDeleter implements Deleter {

    Detector detector;

    public PatternDeleter(Detector detector){
        this.detector = detector;
    }

    @Override
    public String process(String cryptogram) {
        StringBuilder result = new StringBuilder(cryptogram);
        List<Integer> position;
        position = detector.findPattern(cryptogram);
        while(position.get(0) < position.get(1)){
            result = delete(result, position);
            cryptogram = result.toString();
            position = detector.findPattern(cryptogram);
        }
        return result.toString();
    }

    public StringBuilder delete(StringBuilder preString, List<Integer> position) {
        for(int i = position.get(0) ; i <= position.get(1) ; i++){
            preString.deleteCharAt(position.get(0));
        }
        return preString;
    }
}

class PatternDeleteFactory {

    Detector detector;

    public PatternDeleteFactory(Detector detector){
        this.detector = detector;
    }

    public Deleter makeDelete(){
        return new PatternDeleter(detector);
    }
}