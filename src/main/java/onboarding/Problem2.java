package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = "";
        while(true){
            for(int i =0; i<cryptogram.length(); i++){
                try{
                    if(cryptogram.charAt(i-1)!=cryptogram.charAt(i) && cryptogram.charAt(i)!=cryptogram.charAt(i+1) ){
                        result += cryptogram.charAt(i);
                    }
                }
                catch(StringIndexOutOfBoundsException e){
                    if(i==0){
                        if(cryptogram.charAt(i)!=cryptogram.charAt(i+1)){
                            result += cryptogram.charAt(i);
                        }
                    }
                    if(i==cryptogram.length()-1){
                        if(cryptogram.charAt(i-1)!=cryptogram.charAt(i)){
                            result += cryptogram.charAt(i);
                        }
                    }
                }
            }        
            if(result.equals(cryptogram)) {
                break;
            }
            cryptogram = result;
            result = "";
        }
        return cryptogram;
    }
}
