package onboarding.problem3;

public class Game {
    //1.생성자
    public Game(){};
    //2.countSnap
    public int countSnap(int number){
        int sum = 0;
        for (int i = 3; i <= number; i++) sum += countThree(i);
        return sum;
    }
    private int countThree(int number){
        int result = 0;
        while (number > 0) {
            int slotNumber = number % 10;
            if (slotNumber > 0 && slotNumber % 3 == 0) result++;
            number /= 10;
        }
        return result;
    }
}
