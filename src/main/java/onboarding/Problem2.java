package onboarding;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Problem2 pb2 = new Problem2();
        List<Character> cryptogramWithoutDuplication = pb2.removeDuplication(cryptogram);
        return pb2.getStringByStack(cryptogramWithoutDuplication);
    }

    public List<Character> removeDuplication(String cryptogram) {
        int lt = 0;
        int rt = 1;
        List<Character> cryptogramWithoutDuplication = new ArrayList<>();
        while(lt < rt && rt < cryptogram.length()) {
            char character1 = cryptogram.charAt(lt);
            char character2 = cryptogram.charAt(rt);
            if(character1 != character2) {
                // 단어가 중복되지 않을 때
                cryptogramWithoutDuplication.add(character1);
                lt++;
                rt++;
                continue;
            }

            while (character1 == cryptogram.charAt(rt)) {
                rt++;
            }

            lt = rt;
            rt++;
        }
        return cryptogramWithoutDuplication;
    }

    public String getStringByStack (Stack<Character> cryptoStack) {
        StringBuilder answer = new StringBuilder();
        while(!cryptoStack.isEmpty()) {
            answer.insert(0, cryptoStack.pop());
        }
        return answer.toString();
    }
}
