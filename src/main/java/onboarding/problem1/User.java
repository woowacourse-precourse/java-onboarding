package onboarding.problem1;

import java.util.List;

class PageException extends Exception{

}

public class User {
    private List<Integer> pages;

    public User(List<Integer> pages){
        this.pages = pages;
    }

    public void checkPageValidation() throws PageException{
        if(pages.size() !=2){
            throw new PageException();
        }

        if(pages.get(0) != pages.get(1)-1){
            throw new PageException();
        }
    }
}
