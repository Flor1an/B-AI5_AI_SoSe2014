package main.dispatcher.webservice;

import java.util.TimerTask;

public class SayAllive extends TimerTask {

	@Override
	public void run() {
		System.out.println("DISPATCHER ALIVE");
	}
}
