package onboarding;

public class Problem2 {
    private static final int NO_DUPLICATE = -1;
    public static String solution(String cryptogram) {
        String answer = repeatUntilNoDuplicate(cryptogram);
        return answer;
    }

    private static String repeatUntilNoDuplicate(String str) {
        while(true){
            int duplicateIndex = duplicateIndex(str);
            if(duplicateIndex==NO_DUPLICATE)break;
            str = deleteDuplicate(str, duplicateIndex);
        }
        return str;
    }

    private static int duplicateIndex(String checkDuplicate) {
        for(int index=0;index<checkDuplicate.length()-1;index++){
            if(checkDuplicate.charAt(index)==checkDuplicate.charAt(index+1))return index;
        }
        return NO_DUPLICATE;
    }
    private static String deleteDuplicate(String delete, int index){
        String deleteComplete = delete.substring(0,index)+delete.substring(index+2);
        return deleteComplete;
    }
}
