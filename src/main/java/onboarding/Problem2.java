package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder builder = new StringBuilder(cryptogram);

        while(true){
            int index = duplicateCharacterIndex(builder);
            if(index == -1){
                return builder.toString();
            }else{
                builder.delete(index-1,index+1);
            }
        }
    }
    static int duplicateCharacterIndex(StringBuilder str){
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == str.charAt(i)){
                return i;
            }
        }
        return -1;
    }
}
