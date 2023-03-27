package app;

import java.util.Scanner;

public class UI {

    private Generator generator;
    private final String MAIN_MENU = "Cover Letter CLI Generator 1.0.";
    private final String SET_COMPANY = "\nWhat company are you applying for?";
    private final String SET_POSITION = "\nWhat position are you applying to?";
    private boolean run;

    public UI(Generator generator, boolean run) {
        this.generator = generator;
        this.run = run;
    }

    public void run() {
        while(run) {
            System.out.println(MAIN_MENU);

            Scanner scanner = new Scanner(System.in);
            System.out.println(SET_COMPANY);
            generator.setCompany(scanner.nextLine());
            System.out.println("Company has been set to " + generator.getCompany());

            System.out.println(SET_POSITION);
            generator.setPosition(scanner.nextLine());
            System.out.println("Position has been set to " + generator.getPosition());

            System.out.println("Generating cover letter . . . ");
            generator.generateCoverLetter();
            System.out.println("Cover letter has been saved in the folder " + generator.getOUTPUT_FILE_DIRECTORY());

            run = false;
        }
        System.out.println("Goodbye!");
    }
}
