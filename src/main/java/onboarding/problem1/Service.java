package onboarding.problem1;

public class Service {


    public Integer sumPage(Integer page) {
        Integer result = 0;
        while (page == 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

}
