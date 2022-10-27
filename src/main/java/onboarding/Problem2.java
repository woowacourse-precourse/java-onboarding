package onboarding;


import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer sbCryptogram = new StringBuffer(cryptogram);

        while(isLengthLong(sbCryptogram)){

            if(!hasDuplicate(sbCryptogram)) return sbCryptogram.toString();

            int[] index;
            index = findDuplicateIndex(sbCryptogram);

            int length = sbCryptogram.length();
            String removedCryptogram = removeDuplicate(sbCryptogram,index);
            sbCryptogram.replace(0,length,removedCryptogram);
        }

        return sbCryptogram.toString();
    }

    //문자열 길이가 2 이상인지 체크하는 함수
    public static boolean isLengthLong(StringBuffer cryptogram) {
        int length = cryptogram.length();
        if (length < 2) return false;
        return true;
    }

    //중복 여부를 체크하는 함수
    public static boolean hasDuplicate(StringBuffer cryptogram){
        int length = cryptogram.length();

        for(int i=0;i<length-1;i++){
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1)) return true;
        }

        return false;
    }

    //중복 인덱스를 찾아주는 함수
    public static int[] findDuplicateIndex(StringBuffer cryptogram){
        int length = cryptogram.length();
        boolean isDuplicate = false;

        int start=0;
        int end=1;

        int[] index = new int[2];

        while(end<length){
            if(cryptogram.charAt(start)!=cryptogram.charAt(end)){
                if(isDuplicate){
                    index[0]=start;
                    index[1]=end-1;

                    return index;
                }

                start++;
                end++;
                continue;
            }

            isDuplicate = true;
            end++;
        }

        index[0]=start;
        index[1]=end-1;

        return index;
    }

    //중복 제거하는 함수
    public static String removeDuplicate(StringBuffer cryptogram, int[] index){
        cryptogram.delete(index[0],index[1]+1);
        return cryptogram.toString();
    }


}
