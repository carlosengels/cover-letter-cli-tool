package app;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Generator {

    private final String TEMPLATE_FILE_PATH = "src/main/resources/template/default.txt";
    private final String OUTPUT_FILE_DIRECTORY = "src/main/resources";
    private String company = "company";
    private String position = "position";

    public Generator() {
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

    public void generateCoverLetter() {
        // 1. Load file from directory into String variable
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

        // 2.  a) replace company keywords
        String editedCoverLetter = coverLetter.toString().replaceAll("COMPANY", company);
        //     b) replace position keywords
        editedCoverLetter = editedCoverLetter.replaceAll("POSITION", position);
        //  c) replace date with current date
        editedCoverLetter = editedCoverLetter.replaceAll("DATE", LocalDate.now().toString());


        // DEBUG
        System.out.println("****************************** Cover Letter Test After Editing:\n");
        System.out.println(editedCoverLetter);

        // 3. create new file with string
        String newFileName = String.format(OUTPUT_FILE_DIRECTORY + "\\" + "%s-%s-%s-%s-%s.txt",
                "FIRSTNAME", "LASTNAME",position, company, LocalDate.now().toString());
//        Path newCoverLetter = Paths.get(newFileName);

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


//        try {
//            Files.createFile(newCoverLetter);
//        } catch (IOException e) {
//            System.out.println("Error creating new cover letter.");
//            throw new RuntimeException(e);
//        }
//
//        try {
//            FileWriter fileWriter = new FileWriter(newFileName);
//            fileWriter.write(editedCoverLetter);
//        } catch (IOException e) {
//            System.out.println("Error writing text to file.");
//            throw new RuntimeException(e);
//        }

    }
}
