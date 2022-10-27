package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String removeDuplication(String str1){
        String returnCryptogram = "";
        for(int i=0;i<str1.length()-1;i++){
            if (compareChar(str1.charAt(i),str1.charAt(i))){
                i = findNextIndex(str1,i);
            } else {
                returnCryptogram +=str1.charAt(i);
            }
        }
        if (!compareChar(str1.charAt((str1.length()-1)),str1.charAt(str1.length()-2))){
            returnCryptogram += str1.charAt((str1.length()-1));
        }
        return returnCryptogram;
    }

    public static int findNextIndex(String cryptogram,int index){
        while(compareChar(cryptogram.charAt(index),cryptogram.charAt(index)) && index < cryptogram.length()){
            index++;
        }
        return index;
    }

    public static boolean compareChar(char cur,char next){
        if (cur == next){
            return false;
        }
        return true;
    }
}
