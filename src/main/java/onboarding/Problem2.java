package onboarding;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Problem2 {
    static void removeOverLap(List data){
        while(true){
            boolean overlap = false;
            for(int i=0; i<data.size() -1; i++){
                if(data.get(i) == data.get(i+1)){
                    data.remove(i);
                    data.remove(i);
                    overlap = true;
                }
            }
            if(overlap == false){
                break;
            }
        }
    }
    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> crypcryptogramList = new ArrayList<>();
        for(int i=0; i<cryptogram.length(); i++){
            char ch = cryptogram.charAt(i);
            crypcryptogramList.add(ch);
        }
        removeOverLap(crypcryptogramList);
        for(char ch : crypcryptogramList){
            answer += ch;
        }
        return answer;
    }
}
