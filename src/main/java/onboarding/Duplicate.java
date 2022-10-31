package onboarding;

import java.util.Stack;

class Duplicate {
    String cryptogram;

    public Duplicate(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    int exception() {
        if((cryptogram.length() < 1) || (cryptogram.length() > 1000)) {
            return -1;
        }

        for(int i = 0; i < cryptogram.length(); i++) {
            if(!((cryptogram.charAt(i) >= 'a') && (cryptogram.charAt(i) >= 'z'))) {
                return -1;
            }
        }

        return 0;
    }

    String duplicate() {
        Stack<Character> stack = new Stack<>();

        stack.push(cryptogram.charAt(0));
        for(int i = 1; i < cryptogram.length(); i++) {
            if (stack.peek().equals(cryptogram.charAt(i))) {
                stack.pop();
            } else {
                stack.push(cryptogram.charAt(i));
            }
        }

        cryptogram = "";
        for(int i = 0; i < stack.size(); i++) {
            cryptogram = cryptogram.concat(String.valueOf(stack.pop()));
        }

        return cryptogram;
    }
}
