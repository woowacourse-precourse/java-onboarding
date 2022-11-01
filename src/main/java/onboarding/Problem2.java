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
        int cryptoLength = cryptogram.length();
        if(cryptoLength <= 1) return cryptogram;

        int lt = 0;
        int rt = 1;
        List<Character> cryptogramWithoutDuplication = new ArrayList<>();

        while(rt < cryptoLength) {
            char prevChar = cryptogram.charAt(lt);
            char nextChar = cryptogram.charAt(rt);
            if(prevChar != nextChar) {
                // 단어가 중복되지 않을 때
                cryptogramWithoutDuplication.add(prevChar);
                if(rt == cryptoLength - 1) {
                    cryptogramWithoutDuplication.add(nextChar);
                    break;
                }
                lt++;
                rt++;
                continue;
            }

            while (rt < cryptoLength && prevChar == cryptogram.charAt(rt) ) {
                rt++;
            }
            if(rt == cryptoLength - 1) {
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
