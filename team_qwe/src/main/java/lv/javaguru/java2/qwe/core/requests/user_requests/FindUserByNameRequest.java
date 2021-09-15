package lv.javaguru.java2.qwe.core.requests.user_requests;

public class FindUserByNameRequest {

    private final String userName;

    public FindUserByNameRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

}