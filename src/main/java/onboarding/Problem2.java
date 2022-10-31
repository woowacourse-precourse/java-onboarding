package onboarding;

import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (cryptogram.length()>1){
            int temp=cryptogram.length();
            cryptogram=DuplicateRemover(cryptogram);
            if(temp==cryptogram.length())
                return cryptogram;
        }
        return cryptogram;
    }
    public static String DuplicateRemover(String cryptogram){
        HashSet<Integer> removeIndex=new HashSet<>();
        for(int i=0;i<cryptogram.length()-1;i++){
            if(duplicate(cryptogram,i)){
                removeIndex.add(i);
                removeIndex.add(i+1);
            }
        }
        return stringBuild(cryptogram,removeIndex);
    }
    public static String stringBuild(String cryptogram,HashSet<Integer> removeIndex){
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<cryptogram.length();i++){
            if(!removeIndex.contains(i))
                answer.append(cryptogram.charAt(i));
        }
        return answer.toString();
    }
    public static void add(StringBuilder answer,String cryptogram,int index){
        answer.append(cryptogram.charAt(index));
    }
    public static boolean duplicate(String cryptogram,int index){
        return cryptogram.charAt(index) == cryptogram.charAt(index + 1);
    }
}
