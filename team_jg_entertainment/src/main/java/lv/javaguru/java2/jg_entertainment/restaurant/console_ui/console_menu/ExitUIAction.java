package lv.javaguru.java2.jg_entertainment.restaurant.console_ui.console_menu;

public class ExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }
}
