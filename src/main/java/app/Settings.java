package app;

public class Settings {


    private static boolean defaultProfile = true;

    private static String fullName = "FIRST NAME & LAST NAME";

    public Settings() {
        //TODO initializing by reading variables from JSON settings
    }

    public static boolean isDefaultProfile() {
        return defaultProfile;
    }

    public static void setDefaultProfile(boolean defaultProfile) {
        defaultProfile = defaultProfile;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        fullName = fullName;
    }

    private void saveSettings() {

    }
}
