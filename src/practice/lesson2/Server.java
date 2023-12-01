package practice.lesson2;

public class Server implements ServerListener {
    boolean isServerWorking;
    private final Listener LISTENER;

    public Server(Listener listener) {
        this.LISTENER = listener;
        this.isServerWorking = false;
    }

    public void start() {
        if (!isServerWorking) {
            isServerWorking = true;
            LISTENER.messageRes("Server status: " + isServerWorking);
        } else {
            LISTENER.messageRes("Server is running");
        }

    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            LISTENER.messageRes("Server status: " + isServerWorking);
        } else {
            LISTENER.messageRes("Server is not running");
        }

    }


    @Override
    public void serverListener(boolean status) {

        if (status) {
            start();
        } else {
            stop();
        }

    }
}