package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] cryptoarray = cryptogram.toCharArray();
        int tempLength = cryptoarray.length;
        while(true) {
            for(int i = 0; i < cryptoarray.length-1; i ++){
                if(cryptoarray[i] == cryptoarray[i+1]){
                    cryptoarray[i] = 0;
                    cryptoarray[i+1] = 0;
                    i += 1;
                    tempLength -= 2;
                }
            }
            if(tempLength == cryptoarray.length){
                return String.valueOf(cryptoarray);
            }
            char[] tempCharArray = new char[tempLength];
            int iter = 0;
            for (char c : cryptoarray) {
                if (c != 0) {
                    tempCharArray[iter] = c;
                    iter += 1;
                }
            }
            cryptoarray = tempCharArray;

        }
    }
}