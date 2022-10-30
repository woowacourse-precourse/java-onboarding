package onboarding;

//아스키코드로 반대?
public class Problem4 {
    public static String solution(String word) {
        return change(word);
    }
    static String change(String word){
        String[] strings=word.split(" ");
        StringBuffer bf = null;
        for(String str: strings){
            for(int i=0;i<str.length();i++){
                char chr=str.charAt(i);
                if(65<=(int)chr && (int)chr<=90){
                    bf.append((char)(65+90-(int)chr));
                }
                bf.append(" ");
            }
        }
        return bf.toString();
    }
}
