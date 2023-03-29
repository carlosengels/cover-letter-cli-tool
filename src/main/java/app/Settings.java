package app;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Paths;

public class Settings {


    private boolean defaultProfile = true;

    private String fullName = "FIRST NAME & LAST NAME";
    private String settingsSaveFile = "src/main/resources/settings/settings.json";

    public Settings() {
    }

    public boolean loadSettings() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(settingsSaveFile)) {
            Settings settings = gson.fromJson(reader, Settings.class);
            if (settings == null) {
                System.out.println("No local save file found.");
                return true;
            }
            this.fullName = settings.getFullName();
            System.out.println("Hello " + fullName);
            return settings.isDefaultProfile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveSettings() {
        //TODO replace with GSON
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

    public void setSettingsSaveFile(String settingsSaveFile) {
        this.settingsSaveFile = settingsSaveFile;
    }
}
