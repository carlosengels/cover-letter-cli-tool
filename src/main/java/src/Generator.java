package src;

public class Generator {

    private final String TEMPLATE_FILE_PATH = "/resources/template";
    private final String OUTPUT_FILE_PATH = "/resources";
    private String company = "company";
    private String position = "position";

    public Generator() {
    }

    public String getTEMPLATE_FILE_PATH() {
        return TEMPLATE_FILE_PATH;
    }

    public String getOUTPUT_FILE_PATH() {
        return OUTPUT_FILE_PATH;
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

    // TODO replaces keywords in given cover letter
    public void generateCoverLetter() {

    }
}
