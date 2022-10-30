package problem1;

public class PlusPage implements CalPage{

    @Override
    public Integer calPage(Integer page) {
        Integer sum = 0;

        while(page > 0) {
            sum += page%10;
            page/=10;
        }

        return sum;
    }

}
