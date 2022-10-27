package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        return  decoder.decode();
    }
}

class Decoder {
    private List<Character> cryptogram;

    Decoder(String cryptogram){
        this.cryptogram = cryptogram.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.toList());
    }

    String decode(){
        while(deleteOverlappingChar()){continue;}

        return cryptogram.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    boolean deleteOverlappingChar(){

        if (cryptogram.size() <= 1){ return false; }

        List<Character> tempCryptogram = new ArrayList<>();
        Stack<Character> charStack = new Stack<>();
        charStack.push(cryptogram.get(0));

        for (int i=1; i<cryptogram.size(); i++){
            if (charStack.peek() != cryptogram.get(i) & charStack.size() == 1){
                tempCryptogram.add(charStack.pop());
            } else if (charStack.peek() != cryptogram.get(i)) {
                charStack = new Stack<>();
            }

            charStack.push(cryptogram.get(i));
        }

        if (charStack.size() == 1){
            tempCryptogram.add(charStack.pop());
        }

        boolean isDeleted = cryptogram.size() != tempCryptogram.size();
        cryptogram = tempCryptogram;

        return isDeleted;
    }
}
