package app;

public class Main {
    public static void main(String[] args) {
        final Generator generator = new Generator();
        final UI ui = new UI(generator, true);

        ui.run();
    }
}