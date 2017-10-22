package com.ebapps.inventoryhelper;

import java.io.File;
import net.minecraftforge.common.config.Configuration;


public class ConfigManager {

    private String SuggestedConfigurationFile = "";
    public ConfigManager(String _SuggestedConfigurationFile) {
        SuggestedConfigurationFile = _SuggestedConfigurationFile;
    }

    public enum Category {
        FullStacks, 
        Stacks, 
        EmptySlots
    }

    public enum Property {
        Visibility, 
        Name, 
        X_Position,
        Y_Position,
        Farbe
    }

    public void InitConfiguration() {
        Configuration config = new Configuration(new File(SuggestedConfigurationFile));
        config.load();

        config.get(
            GetCategoryName(Category.FullStacks), 
            GetPropertyName(Property.Visibility), 
            true).getBoolean();
        config.get(
            GetCategoryName(Category.Stacks), 
            GetPropertyName(Property.Visibility), 
            true).getBoolean();
        config.get(
            GetCategoryName(Category.EmptySlots), 
            GetPropertyName(Property.Visibility), 
            true).getBoolean();

        config.get(
            GetCategoryName(Category.FullStacks), 
            GetPropertyName(Property.Name), 
            "+ Slots: ").getString();
        config.get(
            GetCategoryName(Category.Stacks), 
            GetPropertyName(Property.Name), 
            "/ Slots: ").getString();
        config.get(
            GetCategoryName(Category.EmptySlots), 
            GetPropertyName(Property.Name), 
            "- Slots: ").getString();

        config.get(
            GetCategoryName(Category.FullStacks), 
            GetPropertyName(Property.X_Position), 
            10).getInt();
        config.get(
            GetCategoryName(Category.Stacks), 
            GetPropertyName(Property.X_Position), 
            10).getInt();
        config.get(
            GetCategoryName(Category.EmptySlots), 
            GetPropertyName(Property.X_Position), 
            10).getInt();

        config.get(
            GetCategoryName(Category.FullStacks), 
            GetPropertyName(Property.Y_Position), 
            10).getInt();
        config.get(
            GetCategoryName(Category.Stacks), 
            GetPropertyName(Property.Y_Position), 
            20).getInt();
        config.get(
            GetCategoryName(Category.EmptySlots), 
            GetPropertyName(Property.Y_Position), 
            30).getInt();

        config.get(
            GetCategoryName(Category.FullStacks), 
            GetPropertyName(Property.Farbe), 
            "FF0000").getString();
        config.get(
            GetCategoryName(Category.Stacks), 
            GetPropertyName(Property.Farbe), 
            "FFFF00").getString();
        config.get(
            GetCategoryName(Category.EmptySlots), 
            GetPropertyName(Property.Farbe), 
            "00FF00").getString();

        config.save();
    }

    public String GetCategoryName(Category category) {
        String ReturnValue = "";
        switch (category) {
            case FullStacks:
            ReturnValue = "FullStacks";
                break;
            case Stacks:
            ReturnValue = "Stacks";
                break;
            case EmptySlots:
            ReturnValue = "EmptySlots";
                break;
            default:
            ReturnValue = "";
                break;
        }
        return ReturnValue;
    }

    public String GetPropertyName(Property property) {
        String ReturnValue = "";
        switch (property) {
            case Visibility:
                ReturnValue = "Visibility";
                break;
            case Name:
                ReturnValue = "Name";
                break;
            case X_Position:
                ReturnValue = "X-Position";
                break;
            case Y_Position:
                ReturnValue = "Y-Position";
                break;
            case Farbe:
                ReturnValue = "Farbe";
                break;
            default:
                ReturnValue = "";
                break;
        }
        return ReturnValue;
    }

    public Boolean GetVisibility(Category category) {
        Configuration config = new Configuration(new File(SuggestedConfigurationFile));
        Boolean bVisibility = false;
        config.load();
        bVisibility = config.get(
            GetCategoryName(category), 
            GetPropertyName(Property.Visibility), 
            true).getBoolean();
        config.save();
        return bVisibility;
    }

    public String GetName(Category category) {
        Configuration config = new Configuration(new File(SuggestedConfigurationFile));
        String sName = "";
        config.load();
        sName = config.get(
            GetCategoryName(category), 
            GetPropertyName(Property.Name), 
            "").getString();
        config.save();
        return sName;
    }

    public int GetX_Position(Category category) {
        Configuration config = new Configuration(new File(SuggestedConfigurationFile));
        int iPosition = 0;
        config.load();
        iPosition = config.get(
            GetCategoryName(category), 
            GetPropertyName(Property.X_Position), 
            "").getInt();
        config.save();
        return iPosition;
    }

    public int GetY_Position(Category category) {
        Configuration config = new Configuration(new File(SuggestedConfigurationFile));
        int iPosition = 0;
        config.load();
        iPosition = config.get(
            GetCategoryName(category), 
            GetPropertyName(Property.Y_Position), 
            "").getInt();
        config.save();
        return iPosition;
    }

    public String GetFarbe(Category category) {
        Configuration config = new Configuration(new File(SuggestedConfigurationFile));
        String sColor = "";
        config.load();
        sColor = config.get(
            GetCategoryName(category), 
            GetPropertyName(Property.Farbe), 
            "").getString();
        config.save();
        return sColor;
    }
}    