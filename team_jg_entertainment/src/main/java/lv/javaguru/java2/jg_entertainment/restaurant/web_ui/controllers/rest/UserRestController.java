package lv.javaguru.java2.jg_entertainment.restaurant.web_ui.controllers.rest;

import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.users.AddUserRequest;
import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.users.GetUserRequest;
import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.users.RemoveUserRequest;
import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.users.UpdateUserRequest;
import lv.javaguru.java2.jg_entertainment.restaurant.core.responses.users.AddUsersResponse;
import lv.javaguru.java2.jg_entertainment.restaurant.core.responses.users.GetUserResponse;
import lv.javaguru.java2.jg_entertainment.restaurant.core.responses.users.RemoveUserResponse;
import lv.javaguru.java2.jg_entertainment.restaurant.core.responses.users.UpdateUserResponse;
import lv.javaguru.java2.jg_entertainment.restaurant.core.services.services_users.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired private GetUserService getUserService;
    @Autowired private AddAllUsersService addUsersService;
    @Autowired private UpdateUserService updateUserService;
    @Autowired private RemoveUserIdService deleteUsersService;

    @GetMapping(path = "/{userId}",
            produces = "application/json")//поиск
    public GetUserResponse getUser(@PathVariable Long userId) {
        GetUserRequest request = new GetUserRequest(userId);
        return getUserService.execute(request);
    }

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")//добавление
    public AddUsersResponse addUser(@RequestBody AddUserRequest request) {
        return addUsersService.execute(request);
    }

    @PutMapping(path = "/{userId}",
            consumes = "application/json",
            produces = "application/json")//обновление
    public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request){
        return updateUserService.execute(request);
    }

    @DeleteMapping(path = "/{id}",
            produces = "application/json")//delete Id
    public RemoveUserResponse deleteUser(@PathVariable Long id) {
        RemoveUserRequest request = new RemoveUserRequest(id);
        return deleteUsersService.execute(request);
    }
}
