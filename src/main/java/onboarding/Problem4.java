package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character,Character> map = makeHashMap();
        for(char data : word.toCharArray()){
           if(map.containsKey(data) == true){
               answer += map.get(data);
           }
           else{
               answer += data;
           }
        }
        return answer;
    }

    public static HashMap<Character,Character> makeHashMap(){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        char upperBackCh = 'Z';
        char lowerBackCh = 'z';

        for(char upperFrontCh = 'A'; upperFrontCh <= 'Z'; upperFrontCh++){
            map.put(upperFrontCh, upperBackCh);
            upperBackCh = (char) (upperBackCh-1);
        }

        for(char lowerFrontCh = 'a'; lowerFrontCh < 'z'; lowerFrontCh++){
            map.put(lowerFrontCh, lowerBackCh);
            lowerBackCh = (char) (lowerBackCh-1);
        }
        return map;
    }

}
