package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] cryptogramArray = cryptogram.toCharArray();
        while(true) {
            if(!isDoubleOrMore(cryptogramArray)) break;
            int startIdx = Integer.MAX_VALUE; int lastIdx = 0;
            for(int i = 1,  j = 0 ; i < cryptogramArray.length ; i += 1) {
                if (cryptogramArray[i - 1] == cryptogramArray[i]) {
                    if(startIdx == Integer.MAX_VALUE) startIdx = i - 1;
                    lastIdx = i;
                }
            }
            char[] cloneArray = new char[cryptogramArray.length - (lastIdx - startIdx + 1)];
            for(int i = 0, j = 0 ; i < cryptogramArray.length ; i += 1) {
                if(i >= startIdx && i <= lastIdx) continue;
                cloneArray[j++] = cryptogramArray[i];
            }
            if (cloneArray.length == 0) return "";
            else if(cloneArray[cloneArray.length - 1] == '\u0000') cloneArray[cloneArray.length - 1] = cryptogramArray[cryptogramArray.length - 1];
            cryptogramArray = cloneArray;
        }
        return new String(cryptogramArray);
    }
    public static boolean isDoubleOrMore(char[] arr) {
        for(int i = 1 ; i < arr.length ; i += 1) {
            if (arr[i - 1] == arr[i]) return true;
        }
        return false;
    }
}
