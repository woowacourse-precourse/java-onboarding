import static org.junit.jupiter.api.Assertions.*;
class Problem5Test {
  

    @Test
    void 지폐_바꾸기() {
        assertThat(change(50237,50000)).isEqualTo(1);
    }

    private int change(int input, int change) {
        int answer = 0;
        if(input >= change){
            answer = input / change;
        }
        return answer;
    }

    int leftMoney(int input, int change){
        int answer = input % change;
        return answer;
    }
}