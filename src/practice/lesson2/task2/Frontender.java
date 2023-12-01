package practice.lesson2.task2;

public class Frontender extends Developer implements FrontendAction{
    @Override
    public void front() {
        System.out.println("Frontender works");
    }

    @Override
    protected void developGUI() {
        System.out.println("FrontEnder GUI method");
    }
}
