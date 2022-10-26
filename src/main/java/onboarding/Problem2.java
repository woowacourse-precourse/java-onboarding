package onboarding;

import java.util.ArrayList;

class validationSamethings{
    public static int validation(ArrayList<String> list){
        String pivot;
        for(int i=0;i<list.size()-1;i++){
            pivot=list.get(i);
            if(pivot.equals(list.get(i+1))){
                return i;
            }
        }
        return -1;
    }
}
class removeSamethings{
    public static String removeSameElement(ArrayList<String> list){
        String strArrayToString;
        String startElement;
        int start = validationSamethings.validation(list);
        if(start!=-1){
            startElement=list.get(start);
            for(int i=start+1;i<list.size();i++){
                if(startElement.equals(list.get(i))){
                    list.remove(i--);
                    continue;
                }
                break;
            }
        }
        strArrayToString=list.toString();
        return strArrayToString;
    }
}
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
