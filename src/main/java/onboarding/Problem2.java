package onboarding;

import java.util.Objects;
import java.util.Stack;

public class Problem2 {


    public static String solution(String cryptogram) {
        String result = "";
        //제한사항 처리
        cryptogram = cryptogram.toLowerCase();
        validateCase(cryptogram);

        while(!cryptogram.isEmpty()){
            String[] cryptograms = cryptogram.split("");
            Stack<String> stack = new Stack<>();

            for(int i=0 ; i < cryptogram.length() ; i++) {
                if (stack.isEmpty() || !Objects.equals(stack.peek(), cryptograms[i])) {
                    stack.add(cryptograms[i]);
                } else if (!stack.isEmpty() && stack.peek().equals(cryptograms[i])) {
                    stack.pop();
                }
            }

            if(stack.size() == cryptograms.length){
                break;
            }

            for(String letter : stack){
                result = result.concat(letter);
            }
            cryptogram = result;
        }

        return cryptogram;
    }

    public static void validateCase(String cryptogram){
        if( cryptogram.length() <= 1 || cryptogram.length() > 1000){
            throw new RuntimeException("암호문의 길이가 적합하지 않습니다.");
        }
    }
}
