package com.meko.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class MekoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        System.out.println("Meko Client Loaded!");

        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {

            MinecraftClient mc = MinecraftClient.getInstance();

            if (mc.player == null) return;

            mc.textRenderer.drawWithShadow(
                    matrices,
                    "Meko Client",
                    10,
                    10,
                    0x00FFAA
            );

            mc.textRenderer.drawWithShadow(
                    matrices,
                    "FPS: " + mc.getCurrentFps(),
                    10,
                    25,
                    0xFFFFFF
            );

            mc.textRenderer.drawWithShadow(
                    matrices,
                    "Health: " + mc.player.getHealth(),
                    10,
                    40,
                    0xFF5555
            );
        });
    }
}
