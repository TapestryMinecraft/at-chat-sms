package io.github.tapestryminecraft.atchat.atchatsms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;

import io.github.tapestryminecraft.atchat.AtChatChannel;

public class SMSChannel extends AtChatChannel{
	private Player sender;
	private String number;
	
	public SMSChannel(Player sender, String number) {
		this.sender = sender;
		// TODO set number
		this.number = number;
	}

	public Collection<MessageReceiver> getMembers() {
		Set<MessageReceiver> members = new HashSet<MessageReceiver>();
		members.add(this.sender);
		return members;
	}

	@Override
	protected String getChannelString() {
		return "sms " + this.number;
	}

	@Override
	protected Player getSender() {
		return this.sender;
	}
	
	@Override
	public void sendMessage(Text message) {
		this.send(message);
		this.sendSMS(message);
	}
	
	private void sendSMS(Text message) {
		// TODO use Textbelt
		System.out.println("ATCHAT SMS: sending sms to " + this.number);
		return;
	}
}
