

package com.ebapps.inventoryhelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(
    modid = InventoryHelper.MOD_ID, 
    version = InventoryHelper.MOD_VERSION, 
    useMetadata = true)
public class InventoryHelper
{
    public static final String MOD_ID = "InventoryHelperMod";
    public static final String MOD_VERSION = "1.2";
    private String SuggestedConfigurationFile = "";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        SuggestedConfigurationFile = event.getSuggestedConfigurationFile().getPath();
        ConfigManager cManager = new ConfigManager(SuggestedConfigurationFile);
        cManager.InitConfiguration();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        // Error.SaveErrorMessage("Das FMLInitializationEvent wird aufgerufen wenn Minecraft lädt.");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        try {
            MinecraftForge.EVENT_BUS.register(new RenderGuiHandler(SuggestedConfigurationFile));
        } catch (Exception e) {
            Error.SaveErrorMessage("EVENT_BUS konnte nicht registriert werden: " + e.getLocalizedMessage() + " / " + e.getStackTrace() );
        }
    }
    
    // public static void main(String[] arguments) {
    //     Error.SaveErrorMessage("Hallo dtfsdfs");
    // }
}