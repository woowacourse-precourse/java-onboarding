package onboarding;

import onboarding.newExceptions.InvalidStringException;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) throws InvalidStringException {
        Problem2 problem = new Problem2();
        if(problem.isViolatedRestrictions(cryptogram)){
            throw new InvalidStringException("제한사항이 지켜지지 않았습니다.");
        }

        StringBuilder builder = new StringBuilder(cryptogram);

        while(true){
            ArrayList<Integer> indexList = duplicateCharacterIndex(builder);
            if(indexList == null){
                return builder.toString();
            }else{
                deleteDuplicateCharacter(builder,indexList);
            }
        }
    }
    static ArrayList<Integer> duplicateCharacterIndex(StringBuilder str){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                list.add(i);
            }
        }
        return list.isEmpty() ? null : list;
    }
    static void deleteDuplicateCharacter(StringBuilder builder, ArrayList<Integer> indexList ){

    }
    boolean isViolatedRestrictions(String input){
        boolean isValidStringLength = (1 <= input.length()) && (input.length() <= 1000);
        boolean isStringHaveOnlySmallLetter = onlyHaveSmallLetter(input);

        return isValidStringLength && isStringHaveOnlySmallLetter;
    }
    boolean onlyHaveSmallLetter(String input){
        for(int i = 0; i < input.length(); i++){
            int asciiCode = (byte)input.charAt(i);
            if(!(97 <= asciiCode && asciiCode <= 122)){
                return false;
            }
        }
        return true;
    }

}

