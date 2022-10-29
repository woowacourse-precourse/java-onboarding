package onboarding;
import java.util.Stack;

class DeleteDuplicateWord{
    public String[] stringToArray(String str){
        return str.split("");
    }

    public Stack<String> deleteDuplicate(String[] strArray){
        Stack<String> stk = new Stack<>();
        for(int i=0;i< strArray.length;i++){
            if(stk.empty() || !stk.peek().equals(strArray[i])){
                stk.push(strArray[i]);
            } else{
                stk.pop();
            }
        }
        return stk;
    }

    public String stackToString(Stack<String> stk){
        StringBuilder result = new StringBuilder();
        while(!stk.empty()){
            String popWord = stk.pop();
            result.append(popWord);
        }
        return result.reverse().toString();
    }

    public String getResult(String gram){
        String[] strArray = stringToArray(gram);
        Stack<String> stk = deleteDuplicate(strArray);

        return stackToString(stk);
    }
}

public class Problem2 {
    private final static DeleteDuplicateWord deleteDuplicateWord = new DeleteDuplicateWord();

    public static String solution(String cryptogram) {
        return deleteDuplicateWord.getResult(cryptogram);
    }
}
