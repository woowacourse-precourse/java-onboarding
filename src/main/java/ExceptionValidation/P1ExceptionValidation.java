package ExceptionValidation;

import java.util.List;

public class P1ExceptionValidation {

    public static boolean p1ExceptionValidation(List<Integer> list){

        return inputBetweenZeroandTwo(list)
                && pageBetween1and400(list)
                && pageNumberContinuous(list);

    }


    private static boolean inputBetweenZeroandTwo(List<Integer> userInput) {
        if (userInput.size() == 2) {
            return true;
        }
        return false;
    }

    private static boolean pageBetween1and400(List<Integer> userInput) {
        Integer leftPage = userInput.get(0);
        Integer rightPage = userInput.get(1);

        if(leftPage<=2 || rightPage>400){
            return false;
        }
        return true;
    }

    private static boolean pageNumberContinuous(List<Integer> userInput) {
        Integer leftPage = userInput.get(0);
        Integer rightPage = userInput.get(1);

        if(leftPage + 1== rightPage){
            return true;
        }
        return false;
    }



}
