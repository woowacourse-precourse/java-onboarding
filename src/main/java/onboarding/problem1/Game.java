package onboarding.problem1;

public class Game {

    private int numAdd;
    private int numMul;

    private int result;

    public Game(int n1, int n2){
        numAdd = n1;
        numMul = n2;
        int result1 = addAll();
        int result2 = mulAll();
        result = Math.max(result1, result2);
    }

    private int addAll(){
        int sum = 0;
        while (numAdd >= 1) {
            sum += numAdd % 10;
            numAdd /= 10;
        }
        return sum;
    }

    private int mulAll(){return -1;}

    public int getResult(){
        return result;
    }
}
