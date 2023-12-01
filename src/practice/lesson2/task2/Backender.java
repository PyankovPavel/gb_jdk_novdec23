package practice.lesson2.task2;

public class Backender extends Developer implements BackendAction{
    @Override
    public void back() {
        System.out.println("Backend works");
    }

    @Override
    public void developGUI() {
        System.out.println("BackEnder GUI method");
    }
}
