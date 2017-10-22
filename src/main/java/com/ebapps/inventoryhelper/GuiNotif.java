package com.ebapps.inventoryhelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
// import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;

public class GuiNotif extends Gui
{
    public GuiNotif(Minecraft mc, String SuggestedConfigurationFile)
    {
        try {
            // ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
            // int width = scaled.getScaledWidth();
            // int height = scaled.getScaledHeight();
    
            int Stacks = 0;
            int FullStacks = 0;
            for(int slot = 0; slot < mc.thePlayer.inventory.getSizeInventory(); slot++)
            {
                ItemStack itemStack = mc.thePlayer.inventory.getStackInSlot(slot);
                if (itemStack != null)
                {
                    Stacks += 1;
                    
                    if (!itemStack.isStackable())
                    {
                        FullStacks += 1;
                    }
                    else 
                    {
                        if (itemStack.stackSize == itemStack.getMaxStackSize())
                        {
                            FullStacks += 1;
                        }
                    }

                }   
            }

            // float Percentage = Helper.GetAsFloat(Stacks) / Helper.GetAsFloat(mc.thePlayer.inventory.getSizeInventory()) * Helper.GetAsFloat(100);
            // float FullPercentage = Helper.GetAsFloat(FullStacks) / Helper.GetAsFloat(mc.thePlayer.inventory.getSizeInventory()) * Helper.GetAsFloat(100);

            int EmptySlots = 0;
            EmptySlots = mc.thePlayer.inventory.getSizeInventory() - Stacks;
            

            ConfigManager cManager = new ConfigManager(SuggestedConfigurationFile);

            if (cManager.GetVisibility(ConfigManager.Category.FullStacks))
            {
                drawString(
                    mc.fontRenderer, 
                    cManager.GetName(ConfigManager.Category.FullStacks) + FullStacks, 
                    cManager.GetX_Position(ConfigManager.Category.FullStacks), 
                    cManager.GetY_Position(ConfigManager.Category.FullStacks), 
                    Integer.parseInt(cManager.GetFarbe(ConfigManager.Category.FullStacks), 16));
            }

            if (cManager.GetVisibility(ConfigManager.Category.Stacks))
            {
                drawString(
                    mc.fontRenderer, 
                    cManager.GetName(ConfigManager.Category.Stacks) + Stacks, 
                    cManager.GetX_Position(ConfigManager.Category.Stacks), 
                    cManager.GetY_Position(ConfigManager.Category.Stacks), 
                    Integer.parseInt(cManager.GetFarbe(ConfigManager.Category.Stacks), 16));
            }

            if (cManager.GetVisibility(ConfigManager.Category.EmptySlots))
            {
                drawString(
                    mc.fontRenderer, 
                    cManager.GetName(ConfigManager.Category.EmptySlots) + EmptySlots, 
                    cManager.GetX_Position(ConfigManager.Category.EmptySlots), 
                    cManager.GetY_Position(ConfigManager.Category.EmptySlots), 
                    Integer.parseInt(cManager.GetFarbe(ConfigManager.Category.EmptySlots), 16));
            }
            

        } catch (Exception e) {
            Error.SaveErrorMessage("GuiNotif(): " + e.getLocalizedMessage() + " / " + e.getStackTrace() );
        }

        
    }
}