package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        int duplicate=1;
        int i=0;

        while(duplicate!=0){
            String tmp="";
            duplicate=0;
            int last_dup_index=-1;

            for(i=0;i<cryptogram.length()-1;i++){
                if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                    duplicate++;
                    i++;
                    last_dup_index=i;
                }
                else{
                    tmp+=cryptogram.charAt(i);
                }
            }
            if(last_dup_index!=cryptogram.length()-1)
                tmp+=cryptogram.charAt(cryptogram.length()-1);    //insert last index
            cryptogram=new String(tmp);
        }
        answer=cryptogram;
        return answer;
    }
}
