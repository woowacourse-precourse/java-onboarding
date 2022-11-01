package onboarding;

import onboarding.newExceptions.InvalidRestrictionException;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) throws InvalidRestrictionException {
        Problem2 problem = new Problem2();
        if(problem.isViolatedRestrictions(cryptogram)){
            throw new InvalidRestrictionException("제한사항이 지켜지지 않았습니다.");
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
        boolean isReading = false;
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1) && !isReading){
                list.add(i);
                isReading = true;
            }else{
                isReading = false;
            }
        }
        return list.isEmpty() ? null : list;
    }
    static void deleteDuplicateCharacter(StringBuilder builder, ArrayList<Integer> indexList ){
        for(int i = indexList.size() -1 ; i >= 0; i--){
            int index = indexList.get(i);
            deleteDuplicateOneBlock(builder,index);
        }
    }
    static void deleteDuplicateOneBlock(StringBuilder builder, int start){
        int count = 1;
        char character = builder.charAt(start);
        do{
            count++;
        }while(start + count < builder.length() && builder.charAt(start + count) == character);

        builder.delete(start,start + count);
    }
    boolean isViolatedRestrictions(String input){
        boolean isValidStringLength = (input.length() < 1) || (input.length() > 1000);
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

