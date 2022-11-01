package ExceptionValidation;

import java.util.List;

public class P1ExceptionValidation {

    public static boolean p1ExceptionValidation(List<Integer> list){

        return inputBetweenZeroandTwo(list);

    }


    private static boolean inputBetweenZeroandTwo(List<Integer> userInput) {
        if (userInput.size() == 2) {
            return true;
        }
        return false;
    }

}
