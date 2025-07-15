package com.spring.XmlAndAnn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Variable injection
@Component(value = "myRCB")
public class RCB {

	@Value(value = "VK")
	String captainName;

	@Value(value = "RP")
	String viceCaptainName;

	public void play() {
		System.out.println("captain : " + captainName);
		System.out.println("viceCaptain : " + viceCaptainName);
		System.out.println("are playing bold");
	}
}
