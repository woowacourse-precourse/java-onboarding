package onboarding;

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
        StringBuilder answer= new StringBuilder();
        for(int i=0;i<cryptogram.length()-1;i++){
            if(!duplicate(cryptogram,i))
                add(answer,cryptogram,i);
            if(duplicate(cryptogram,i))
                i++;
            if(i==cryptogram.length()-2){
                answer.append(cryptogram.charAt(i+1));
            }
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
