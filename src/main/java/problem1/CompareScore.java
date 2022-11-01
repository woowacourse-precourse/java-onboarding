package problem1;

public class CompareScore {

    public CompareScore() {
    }

    public int compare(int pobiScore, int crongScore) {
        if (pobiScore > crongScore)
            return 1;
        if (pobiScore < crongScore)
            return 2;
        return 0;
    }
}
