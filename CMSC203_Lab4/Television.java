/** 

 * The purpose of this class is to model a television 

 * Nicholas Baker   2/20/2020 

 * @author Nicholas Baker 

 * 

 */ 

public class Television { 

	private final String MANUFACTURER; 

	private final int SCREEN_SIZE; 

	boolean powerOn; 

	private int channel; 

	private int volume; 



	/** 

	 * Constructor for Television. 

	 * Takes manufacturer name and screen size 

	 * @param manufacturer 

	 * @param size 

	 */ 

	public Television(String manufacturer, int size) { 

		MANUFACTURER = manufacturer; 

		SCREEN_SIZE = size; 

		powerOn = false; 

		channel = 2; 

		volume = 20; 

	} 



	/** 

	 * Returns the current channel of the Television 

	 * @return 

	 */ 

	public int getChannel() { 

		return channel; 

	} 



	/** 

	 * Sets the channel of the Television to channel 

	 * @param channel 

	 */ 

	public void setChannel(int channel) { 

		this.channel = channel; 

	} 



	/** 

	 * Returns the manufacturer of the Television 

	 * @return 

	 */ 

	public String getManufacturer() { 

		return MANUFACTURER; 

	} 



	/** 

	 * Returns the screen size for the Television 

	 * @return 

	 */ 

	public int getScreenSize() { 

		return SCREEN_SIZE; 

	} 



	/** 

	 * Returns the current volume of the Television 

	 * @return 

	 */ 

	public int getVolume() { 

		return volume; 

	} 



	/** 

	 * Increases the volume of the Television by one 

	 */ 

	public void increaseVolume() { 

		volume++; 

	} 



	/** 

	 * Decreases the volume of the Television by one 

	 */ 

	public void decreaseVolume() { 

		if(volume > 0) volume--; 

	} 



	/** 

	 * Sets the powerOn boolean to the opposite setting 

	 * to represent the Television being powered on or off 

	 */ 

	public void power() { 

		if(powerOn) powerOn = !powerOn; 

		else powerOn = true; 

	} 



} 