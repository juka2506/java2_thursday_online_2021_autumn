package lv.javaguru.java2.jg_entertainment.restaurant.console_ui_visitors;

public class UIActionExit implements RestaurantUIAction {
    @Override
    public void execute() {
        System.out.println("You finished! Thank a lot, have a good day !");
        System.exit(0);
    }
}