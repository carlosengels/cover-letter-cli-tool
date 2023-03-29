package app;

import java.util.Scanner;

public class UI {

    private Generator generator;
    private final String CHANGE_SETTINGS = "\nFull name has not been set yet. Enter your full name below: ";
    private final String MAIN_MENU = "\nCover Letter CLI Generator 1.0.";
    private final String SET_COMPANY = "\nWhat company are you applying for?";
    private final String SET_POSITION = "\nWhat position are you applying to?";
    private final String HIRING_MANAGER = "\nDo you know the name of the hiring manager? (Leave blank if not)";
    private boolean run;

    public UI(Generator generator, boolean run) {
        this.generator = generator;
        this.run = run;
    }

    /**
     * Main UI method checks if default settings are enabled to prompt user to change full name for
     * cover letter signature and file name.
     * Runs through rest of parameters before triggering a new cover letter.
    */
    public void run() {
        while(run) {
            System.out.println(MAIN_MENU);
            Scanner scanner = new Scanner(System.in);

            if (generator.getSettings().loadSettings()) {
                System.out.println(CHANGE_SETTINGS);
                generator.getSettings().setFullName(scanner.nextLine());
                generator.getSettings().setDefaultProfile(false);
            }

            System.out.println(SET_COMPANY);
            generator.setCompany(scanner.nextLine());
            System.out.println("Company has been set to " + generator.getCompany());

            System.out.println(SET_POSITION);
            generator.setPosition(scanner.nextLine());
            System.out.println("Position has been set to " + generator.getPosition());

            System.out.println(HIRING_MANAGER);
            generator.setHiringManager(scanner.nextLine());
            System.out.println("Hiring manager has been set to " + generator.getHiringManager());

            System.out.println("Generating cover letter . . . ");
            generator.generateCoverLetter();
            System.out.println("Cover letter has been saved in the folder " + generator.getOUTPUT_FILE_DIRECTORY());

            run = false;
        }
        System.out.println("\nGoodbye!");
    }
}
