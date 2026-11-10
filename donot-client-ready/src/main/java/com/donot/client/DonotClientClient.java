package com.donot.client;

import com.donot.client.gui.ClientMenuScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class DonotClientClient implements ClientModInitializer {

    private static KeyBinding menuKeyBinding;

    @Override
    public void onInitializeClient() {
        // Binds Right Shift to open the client menu
        menuKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.donotclient.open_menu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.donotclient.general"
        ));

        // Opens the client menu when Right Shift is pressed
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (menuKeyBinding.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(new ClientMenuScreen(Text.translatable("gui.donotclient.menu.title")));
                }
            }
        });
    }
}
