package onboarding.problem1;

public class Game {

    private int result = 0;

    public Game(int left, int right){
        addAll(left);
        addAll(right);
        mulAll(left);
        mulAll(right);
    }

    private void addAll(int n){
        int sum = 0;
        while (n >= 1) {
            sum += n % 10;
            n /= 10;
        }
        result = Math.max(sum, result);
    }

    private void mulAll(int n){
        int mul = 1;
        while (n >= 1) {
            mul *= n % 10;
            n /= 10;
        }
        result = Math.max(mul, result);
    }

    public int getResult(){
        return result;
    }
}
