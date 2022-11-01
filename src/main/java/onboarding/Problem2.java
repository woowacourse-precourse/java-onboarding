package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer=cryptogram;
        String prevCryptogram = "";

        while(!answer.isBlank()){
            prevCryptogram=removeDuplicates(answer);
            if(!isDuplicated(prevCryptogram,answer)){
                break;
            }
            answer=prevCryptogram;
        }

        return answer;
    }

    private static String removeDuplicates(final String cryptogram){
        String result="";
        char prevCharacter=cryptogram.charAt(0);
        boolean checkDuplication=false;

        for(int i=1;i<cryptogram.length();i++){
            if(prevCharacter != cryptogram.charAt(i)){
                if(!checkDuplication){
                    result+=String.valueOf(prevCharacter);
                }

                prevCharacter=cryptogram.charAt(i);
                checkDuplication=false;
            }else{
                checkDuplication=true;
            }
        }

        if(!checkDuplication){
            result+=cryptogram.charAt(cryptogram.length()-1);
        }
        return result;
    }

    private static boolean isDuplicated(final String prevCryptogram, final String cryptogram){
        if(prevCryptogram.length()==cryptogram.length()){
            return false;
        }
        return true;
    }
}
