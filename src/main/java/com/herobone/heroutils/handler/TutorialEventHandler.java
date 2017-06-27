package com.herobone.heroutils.handler;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class TutorialEventHandler {

	@SubscribeEvent
	public void event(PlayerLoggedInEvent event) {
		event.player.addChatMessage(new TextComponentString("Hello " + event.player.getDisplayNameString()));
	}
	
}
