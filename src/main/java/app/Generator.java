package app;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Generator {

    private final Settings settings;
    private final String TEMPLATE_FILE_PATH = "src/main/resources/template/default.txt";
    private final String OUTPUT_FILE_DIRECTORY = "src/main/resources";
    private String company = "company";
    private String position = "position";
    private String hiringManager = "";

    public Generator(Settings settings) {
        this.settings = settings;
    }

    public String getTEMPLATE_FILE_PATH() {
        return TEMPLATE_FILE_PATH;
    }

    public String getOUTPUT_FILE_DIRECTORY() {
        return OUTPUT_FILE_DIRECTORY;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public void setHiringManager(String hiringManager) {
        if (!hiringManager.isBlank()) {
            this.hiringManager = hiringManager;
        } else {
            this.hiringManager = "Hiring Manager";
        }
    }

    public Settings getSettings() {
        return settings;
    }

    public void generateCoverLetter() {

        String newFileName = String.format(OUTPUT_FILE_DIRECTORY + "\\" + "%s-%s-%s-%s.txt",
                settings.getFullName().replaceAll(" ","-"),
                position.replaceAll(" ","-"),
                company.replaceAll(" ","-"),
                LocalDate.now());

        StringBuilder coverLetter = new StringBuilder();
        try {
            Path templatePath = Paths.get(TEMPLATE_FILE_PATH);
            List<String> allLines = Files.readAllLines(templatePath);
            for (String line : allLines) {
                coverLetter.append(line).append("\n");
            }
        } catch ( IOException e) {
            System.out.println("Error reading local template file.\n");
            throw new RuntimeException(e);
        }

        String editedCoverLetter = coverLetter.toString().replaceAll("COMPANY", company);
        editedCoverLetter = editedCoverLetter.replaceAll("POSITION", position);
        editedCoverLetter = editedCoverLetter.replaceAll("DATE", formattedDate());
        editedCoverLetter = editedCoverLetter.replaceAll("HIRING_MANAGER", hiringManager);
        editedCoverLetter = editedCoverLetter.replaceAll("FUlL_NAME", settings.getFullName());

        try {
            File file = new File(newFileName);
            if (file.createNewFile()) {
                System.out.println("Created new Cover Letter with given parameters.\n");
            } else {
                System.out.println("Cover letter already exists.\n");
            }
            FileWriter writer = new FileWriter(newFileName);
            writer.write(editedCoverLetter);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String formattedDate() {
        String month = LocalDate.now().getMonth().toString();
        month = month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase();
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        String dayOfMonthSuffix;
        switch (dayOfMonth % 10) {
            case 1: dayOfMonthSuffix = "st";
            case 2: dayOfMonthSuffix = "nd";
            case 3: dayOfMonthSuffix = "rd";
            default: dayOfMonthSuffix = "th";
        }
        String day = dayOfMonth + dayOfMonthSuffix;
        int year = LocalDate.now().getYear();
        return String.format("%s %s, %d",month, day, year);
    }
}
