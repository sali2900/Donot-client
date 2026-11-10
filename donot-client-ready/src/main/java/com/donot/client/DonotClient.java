package com.donot.client;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DonotClient implements ModInitializer {
    public static final String MOD_ID = "donotclient";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("DoNot Client initialized successfully.");
    }
}
