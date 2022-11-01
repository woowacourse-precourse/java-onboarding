package onboarding;
import java.util.ArrayList;
public class Problem2 {
    public static String solution(String cryptogram) {
//        String crypto = cryptogram;
//        String answer = "answer";
//        int[] index = new int[crypto.length()];
//        char[] arr = crypto.toCharArray();
//        String[] encrypt = new String[crypto.length()];
//        String temp="temp";
//        int count=1;

        ArrayList<Character> characters = new ArrayList<Character>();

        for( char c : cryptogram.toCharArray()){
            characters.add(c);
        }
        int length = cryptogram.length();
        int n = 1;
        while(n < length){
            if( characters.get(n) == characters.get(n-1)){
                characters.remove(n);
                characters.remove(n-1);
                n = 1;
                length -= 2;
            }
            else {
                n += 1;
            }
        }

        String answer = "";

        for(char c : characters){
            answer += c;
        }
//
//        while(count!=0){
//            for (int i = 0; i < crypto.length(); i++) {
//                index = new int[crypto.length()];
//                index[i] = 0;
//            }
//            for (int i = 0; i < crypto.length()-1; i++) {
//                if(arr[i]==arr[i+1]){
//                    index[i]=1;
//                    index[i+1]=1;
//                }
//            }
//            count=0;
//            int j=0;
//            for (int i = crypto.length()-1; i >=0; i--) {
//               if(index[i]==1){
//                   count++;
//                   encrypt[j]="";
//               }else{
//                   encrypt[j]=String.valueOf(arr[i]);
//                           j++;
//               }
//            }
//            temp=String.join(",", encrypt);
//            if(count==0){
//                return answer;
//            }
//        }

        return answer;
    }
}
