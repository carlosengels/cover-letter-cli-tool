package app;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class Settings {


    private boolean defaultProfile = true;

    private String fullName = "FIRST NAME & LAST NAME";
    private final String settingsSaveFile = "src/main/resources/settings/settings.json";

    public Settings() {
//        try {
//            Settings savedSettings = new ObjectMapper().readValue(new File(settingsSaveFile), Settings.class);
//            this.fullName = savedSettings.fullName;
//        } catch (JsonMappingException e) {
//            throw new RuntimeException(e);
//        } catch (JsonParseException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void saveSettings() {
        try {
            new ObjectMapper().writeValue(Paths.get(settingsSaveFile).toFile(), this);
        } catch (JsonProcessingException e) {
            System.out.println("Error setting up JSON components.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error saving settings to local save file.");
            throw new RuntimeException(e);
        }
    }

    public boolean isDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        setDefaultProfile(false);
        saveSettings();
    }

    public String getSettingsSaveFile() {
        return settingsSaveFile;
    }
}
