package com.ebapps.inventoryhelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class RenderGuiHandler {
    private String SuggestedConfigurationFile = "";
    public RenderGuiHandler(String _SuggestedConfigurationFile) {
        SuggestedConfigurationFile = _SuggestedConfigurationFile;
    }



    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        try {
            if (event.type != ElementType.EXPERIENCE)
            return;
            
            new GuiNotif(Minecraft.getMinecraft(), SuggestedConfigurationFile);    
        } catch (Exception e) {
            Error.SaveErrorMessage("onRenderGui: " + e.getLocalizedMessage() + " / " + e.getStackTrace() );
        }
        
    }
}