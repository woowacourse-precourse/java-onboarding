package problem1;

public class MulPage implements CalPage{

    @Override
    public Integer calPage(Integer page) {
        Integer result = 1;

        while(page > 0) {
            result *= page%10;
            page/=10;
        }

        return result;
    }
}
