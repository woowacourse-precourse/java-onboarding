package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";


        for(int k=0;k < cryptogram.length();k++){
            char curr = cryptogram.charAt(0);
            boolean check =true;
            int check2 =0;
            for(int i = 1; i< cryptogram.length(); i++){
                if(!check){
                    cryptogram = cryptogram.substring(0,i-1 -(check2-2))+cryptogram.substring(i-(check2-2),cryptogram.length());
                    curr=cryptogram.charAt(i-1);
                    check =true;
                }else if(cryptogram.charAt(i)==curr){
                    check=false;
                    check2++;
                    cryptogram = cryptogram.substring(0,i)+cryptogram.substring(i+1,cryptogram.length());
                    continue;
                }else{
                    curr = cryptogram.charAt(i);
                }
            }
        }

        answer = cryptogram;

        return answer;
    }
}
