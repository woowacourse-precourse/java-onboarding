package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        if(checkException(cryptogram)){
            throw new IllegalArgumentException();
        }


        return getDecoding(cryptogram);
    }
    public static String getDecoding(String cryptogram){
        while(true){
            StringBuffer stringBuffer= new StringBuffer();
            for(int i=0; i<cryptogram.length();i++){
                if(i == 0){
                    if(cryptogram.charAt(i) != cryptogram.charAt(i+1)){
                        stringBuffer.append(cryptogram.charAt(i));
                    }

                }else if (i == cryptogram.length()-1){
                    if(cryptogram.charAt(i) != cryptogram.charAt(i-1)){
                        stringBuffer.append(cryptogram.charAt(i));
                    }
                }else{
                    if(cryptogram.charAt(i) != cryptogram.charAt(i+1) && cryptogram.charAt(i) != cryptogram.charAt(i-1) ){
                        stringBuffer.append(cryptogram.charAt(i));
                    }
                }
            }
            if(stringBuffer.toString().equals(cryptogram)){
                break;
            }
            cryptogram=stringBuffer.toString();
        }
        return cryptogram;
    }
    public static boolean checkException(String cryptogram){
        if(checkLength(cryptogram.length())){
            return true;
        }

        return false;
    }
    public static boolean checkLength(int length){
        return length < 1 || length > 1000;
    }

}
