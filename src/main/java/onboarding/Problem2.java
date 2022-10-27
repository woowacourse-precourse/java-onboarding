package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    public static String removeDuplication(String cryptogram){
        String returnCryptogram = "";
        for(int i=0;i<cryptogram.length()-1;i++){
            if (compareChar(cryptogram.charAt(i),cryptogram.charAt(i))){
                i = findNextIndex(cryptogram,i);
            }
        }
        return "";
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
