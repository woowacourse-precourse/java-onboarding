package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String arr1="abcdefghijklmnopqrstuvwxyz";
        String arr2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0;i<word.length();++i){
            if(word.charAt(i)==' '){
                answer+=word.substring(i,i+1);
            }else{
                char curChar=word.charAt(i);

                int idx=curChar-'a';
                if(idx>=0){

                    answer+=arr1.charAt(25-idx);
                }else{
//                    System.out.print(curChar);
                    int idx2=curChar-'A';
//                    System.out.println(idx);
                    answer+=arr2.charAt(25-idx2);
                }
            }
        }
        return answer;
    }
//    public static void main(String[] args){
//        System.out.println(solution("I love you"));
//    }
}
