package io.github.tapestryminecraft.atchat.atchatsms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;

import io.github.tapestryminecraft.atchat.AtChatChannel;

public class SMSChannel extends AtChatChannel{
	private String number;
	
	public SMSChannel(Player sender, String channelString) {
		this.sender = sender;
		this.number = channelString;
	}

	public Collection<MessageReceiver> getMembers() {
		Set<MessageReceiver> members = new HashSet<MessageReceiver>();
		members.add(this.sender);
		return members;
	}

	@Override
	protected String channelString() {
		return this.number;
	}
	
	@Override
	public void sendMessage(Text message) {
		this.send(message);
		this.sendSMS(message);
	}
	
	private void sendSMS(Text message) {
		// TODO use Textbelt
		System.out.println("ATCHAT SMS: sending txt...");
		return;
	}
}
