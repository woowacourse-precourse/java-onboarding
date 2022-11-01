package onboarding;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 pb2 = new Problem2();
        return pb2.repeatRemoveDuplication(cryptogram);
    }

    public String removeDuplication(String cryptogram) {
        int lastIdx = cryptogram.length() - 1;
        if(lastIdx < 1) return cryptogram;

        int lt = 0;
        int rt = 1;
        List<Character> cryptogramWithoutDuplication = new ArrayList<>();

        while(rt <= lastIdx) {
            char prevChar = cryptogram.charAt(lt);
            char nextChar = cryptogram.charAt(rt);
            // 단어가 중복되지 않을 때
            if(prevChar != nextChar) {
                cryptogramWithoutDuplication.add(prevChar);
                if(rt == lastIdx) {
                    // rt가 마지막 인덱스를 가리키는 경우 바로 추가한다.
                    cryptogramWithoutDuplication.add(nextChar);
                    break;
                }
                lt++;
                rt++;
                continue;
            }

            // 단어가 중복될 때
            while (rt <= lastIdx && prevChar == cryptogram.charAt(rt) ) {
                rt++;
            }
            if(rt == lastIdx) {
                // rt가 마지막 인덱스이고, 이 전의 문자와 같지 않는 경우 바로 추가한다.
                cryptogramWithoutDuplication.add(cryptogram.charAt(rt));
                break;
            }
            lt = rt;
            rt++;
        }
        return listToString(cryptogramWithoutDuplication);
    }

    public String repeatRemoveDuplication(String cryptogram) {
        int prevLength = cryptogram.length();

        String cryptogramWithoutDuplication = removeDuplication(cryptogram);
        int nextLength = cryptogramWithoutDuplication.length();

        while(prevLength != nextLength) {
            prevLength = nextLength;
            String word = cryptogramWithoutDuplication;
            cryptogramWithoutDuplication = removeDuplication(word);
            nextLength = cryptogramWithoutDuplication.length();
        }
        return cryptogramWithoutDuplication;
    }

    public String listToString(List<Character> characters) {
        StringBuilder answer = new StringBuilder();
        for (char c: characters) {
            answer.append(c);
        }
        return answer.toString();
    }
}
