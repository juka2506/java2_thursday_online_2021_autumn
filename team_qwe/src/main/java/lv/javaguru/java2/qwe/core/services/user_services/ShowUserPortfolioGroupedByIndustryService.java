package lv.javaguru.java2.qwe.core.services.user_services;

import lv.javaguru.java2.qwe.User;
import lv.javaguru.java2.qwe.core.database.UserData;

public class ShowUserPortfolioGroupedByIndustryService {

    private final UserData userData;

    public ShowUserPortfolioGroupedByIndustryService(UserData userData) {
        this.userData = userData;
    }

    public UserData getUserData() {
        return userData;
    }

    public void execute(User user) {
        userData.showUserPortfolioGroupedByIndustry(user);
    }

}