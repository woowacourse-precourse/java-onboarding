package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = eliminateDuplicateChars(cryptogram,0,Character.MIN_VALUE, false);

        return answer;
    }

    private static String eliminateDuplicateChars(String cryptogram, int index, char before, boolean duplicateFoundInSequence){
        if(index + 1 > cryptogram.length()){
            if(duplicateFoundInSequence==true) {
                // Back to initial sequence
                return eliminateDuplicateChars(cryptogram,0, Character.MIN_VALUE, false);
            }
            else return cryptogram;
        }
        else{
            char current = cryptogram.charAt(index);

            if(before == current){
                String part1 = cryptogram.substring(0, index-1);
                String part2 = cryptogram.substring(index+1);
                return eliminateDuplicateChars(part1+part2, index-1, current, true);
            }
            else
                return eliminateDuplicateChars(cryptogram, index+1, current, duplicateFoundInSequence);
        }
    }
}
