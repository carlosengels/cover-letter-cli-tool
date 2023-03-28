package app;

public class Main {
    public static void main(String[] args) {
        final Settings settings = new Settings();
        final Generator generator = new Generator(settings);
        final UI ui = new UI(generator, true);


        ui.run();
    }
}