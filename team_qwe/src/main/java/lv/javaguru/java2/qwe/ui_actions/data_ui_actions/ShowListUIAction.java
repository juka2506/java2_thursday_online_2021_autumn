package lv.javaguru.java2.qwe.ui_actions.data_ui_actions;

import lv.javaguru.java2.qwe.core.responses.ShowListResponse;
import lv.javaguru.java2.qwe.core.services.data_services.ShowListService;
import lv.javaguru.java2.qwe.ui_actions.UIAction;

public class ShowListUIAction implements UIAction {

    private final ShowListService showListService;

    public ShowListUIAction(ShowListService showListService) {
        this.showListService = showListService;
    }

    @Override
    public void execute() {
        ShowListResponse response = showListService.execute();
        response.getList().forEach(System.out::println);
        System.out.print("\n");
    }

}