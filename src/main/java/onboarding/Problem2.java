package onboarding;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Problem2 {
    static void removeOverLap(List data){
        for(int i=0; i<data.size(); i++){
            int count = 0;
            char ch = (char)data.get(i);
            for(int j=i; j<data.size(); j++){
                if(ch != (char)data.get(j)){
                    break;
                }
                count +=1;
            }
            if(count >1) {
                for (int k = 0; k < count; k++) {
                    data.remove(i);
                }
            }
        }
    }
    static boolean checkOverLap(List data){
        for(int i=0; i<data.size()-1; i++){
            if(data.get(i) == data.get(i+1)){
                return true;
            }
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "";
        List<Character> crypcryptogramList = new ArrayList<>();
        for(int i=0; i<cryptogram.length(); i++){
            char ch = cryptogram.charAt(i);
            crypcryptogramList.add(ch);
        }

        while(true){
            if(checkOverLap(crypcryptogramList) == false){
                break;
            }
            removeOverLap(crypcryptogramList);
        }

        for(char ch : crypcryptogramList){
            answer += ch;
        }
        return answer;
    }
}
