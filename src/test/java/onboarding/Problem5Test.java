import static org.junit.jupiter.api.Assertions.*;
class Problem5Test {
  

    int leftMoney(int input, int change){
        int answer = input % change;
        return answer;
    }
}