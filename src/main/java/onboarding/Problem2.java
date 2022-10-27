package onboarding;

public class Problem2 {
    private static final int NO_DUPLICATE = -1;
    public static String solution(String cryptogram) {
        while(true){
            int deleteIndex = findDuplicateIndex(cryptogram);
            if(deleteIndex == NO_DUPLICATE) {
                break;
            }
            cryptogram = deleteDuplicate(cryptogram, deleteIndex);
        }

        return cryptogram;
    }

    public static int findDuplicateIndex(String str){
        for(int index=0; index<str.length()-1; index++){
            if(str.charAt(index)==str.charAt(index+1)){
                return index;
            }
        }
        return NO_DUPLICATE;
    }

    public static String deleteDuplicate(String str, int index){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0,index)).append(str.substring(index+2));
        return sb.toString();
    }
}
