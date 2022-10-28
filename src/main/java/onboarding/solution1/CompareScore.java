package onboarding.solution1;

public class CompareScore {
    public static int compareRes(int pobi, int crong){
        if (pobi > crong)
            return 1;
        else if (pobi < crong)
            return 2;
        return 0;
    }
}
