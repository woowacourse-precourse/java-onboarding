package onboarding.problem1;

import java.util.List;

public class Service {

    public User createUser(List<Integer> pages, String userName) {
        User user = new User(userName, pages.get(0), pages.get(1));

        return user;
    }

    public User getHigherUser(User userA, User userB) {
        if (userA.getScore() > userB.getScore()) {
            return userA;
        } else {
            return userB;
        }
    }

    public void setScore(User user) {
        Integer leftPage = user.getLeftPage();
        Integer rightPage = user.getRightPage();

        Integer maxSumPage = sumPage(leftPage) > sumPage(rightPage) ? sumPage(leftPage) : sumPage(rightPage);
        Integer maxMulPage = mulPage(leftPage) > mulPage(rightPage) ? mulPage(leftPage) : mulPage(rightPage);

        user.setScore(maxSumPage > maxMulPage ? maxSumPage : maxMulPage);
    }

    public Integer sumPage(Integer page) {
        Integer result = 0;
        while (page == 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    public Integer mulPage(Integer page) {
        Integer result = 1;
        while (page == 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }
}
