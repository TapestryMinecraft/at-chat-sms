package io.github.tapestryminecraft.atchat.atchatsms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;

import com.goebl.david.Response;
import com.goebl.david.Webb;

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
		System.out.println("ATCHAT SMS: sending sms to " + this.number);
		Webb webb = Webb.create();
		Response<JSONObject> response = webb
			.post("http://textbelt.com/text")
			.param("number", this.number)
			.param("message", message.toPlain())
			.asJsonObject();
		System.out.println(response.toString());
	}
}
