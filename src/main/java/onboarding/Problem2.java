package onboarding;

public class Problem2 {
    private static final char EXTERNAL='E';

    public static String solution(String cryptogram) {
        if(input_exception(cryptogram)) return "input error";

        return decoding(cryptogram);
    }

    private static String decoding(String cryptogram){
        char[] char_cryptogram=cryptogram.toCharArray();
        int cryptogram_len=cryptogram.length();
        int next_cryptogram_len=cryptogram_len;
        boolean progress=true;
        String result="";

        while(progress){
            int i,j;
            progress=false;
            for(i=0;i<cryptogram_len-1;i++){
                boolean isOverlap=false;
                while(i<cryptogram_len-1&&char_cryptogram[i]==char_cryptogram[i+1]){
                    char_cryptogram[i]=EXTERNAL;
                    isOverlap=true;
                    next_cryptogram_len--;
                    i++;
                }
                if(isOverlap) {
                    next_cryptogram_len--;
                    char_cryptogram[i] = EXTERNAL;
                    progress=true;
                }
            }
            j=0;
            for(i=0;i<next_cryptogram_len;i++){
                while(j<cryptogram_len&&char_cryptogram[j]==EXTERNAL) j++;
                char_cryptogram[i]=char_cryptogram[j];
                j++;
            }
            cryptogram_len=next_cryptogram_len;
        }
        for(int i=0;i<cryptogram_len;i++){
            result+=Character.toString(char_cryptogram[i]);
        }

        return result;
    }

    private static boolean input_exception(String input){
        //true is 'exception excution'
        char[] char_input=input.toCharArray();
        if(input.length()<1||input.length()>1000) return true;
        for(int i=0;i<char_input.length;i++){
            if(Character.isUpperCase(char_input[i]))
                return true;
        }
        return false;
    }
}
