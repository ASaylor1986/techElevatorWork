package com.techelevator;

public class Television {

	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	
	public Television() {
		
	}
	public boolean isOn() {
		return isOn;
	}
	public int getCurrentChannel() {
		return currentChannel;
	}
	public int getCurrentVolume() {
		return currentVolume;
	}
    public void turnOn() {
    	isOn = true;
    }
    public void turnOff() {
    	isOn = false;
    }
    public void changeChannel(int newChannel) {
    	if (isOn == true) {
    		currentChannel = newChannel;
    	}
    	
    }
    public void channelUp() {
    	if (isOn == true) {
    		currentChannel += 1;
    		if (currentChannel > 18) {
    			currentChannel = 3;
    		}
    	}

    	
    }
    public void channelDown() {
    	if (isOn == true) {
    		currentChannel -- ;
    		if (currentChannel < 3) {
    			currentChannel = 18;
    		}
    	}
    }
    public void raiseVolume() {
    	if (isOn == true) {
    		currentVolume++;
    	}
    }
    public void lowerVolume() {
    	if (isOn == true && currentVolume > 0) {
    			currentVolume--;
    	}
    }
}

