package io.github.tapestryminecraft.atchat.atchatsms;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.plugin.Plugin;
import io.github.tapestryminecraft.atchat.AtChatChannel;
import io.github.tapestryminecraft.atchat.AtChatChannelController;
import io.github.tapestryminecraft.atchat.AtChatPlugin;

@Plugin(id = "atchatsms", name = "AtChatSMS", version = "0")
public class AtChatSMS extends AtChatPlugin{
	
	@Override
	protected void registerChannelController() {
		this.atChat.registerChannel(new AtChatChannelController(){

			@Override
			public String matcher() { return "sms|txt"; }

			@Override
			public AtChatChannel channel(Player sender, String channelString) {
				return new SMSChannel(sender, channelString);
			}
			
		});
	}
}
