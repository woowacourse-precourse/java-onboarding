package onboarding.problem2;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class DecipherCryptogram {
    private String cryptogram;
    private Stack<Character> stack = new Stack<>();

    public DecipherCryptogram(String cryptogram){
        this.cryptogram = cryptogram;
    }

    private void decipherCryptogram() {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (stack.size() == 0) {
                stack.push(cryptogram.charAt(i));
            } else {
                if (stack.peek().equals(cryptogram.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(cryptogram.charAt(i));
                }
            }
        }
    }

    private String stackToString(){
        ArrayList<Character> tempArrayList = new ArrayList<>(stack);
        return tempArrayList.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
