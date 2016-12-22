// Chat bot Class
import java.io.IOException;
import java.text.DecimalFormat;

import org.jibble.pircbot.*;

public class ChatBot extends PircBot {
	// Set the communications between the Bot and Fetcher
	
	public Double [] temps = new Double[3];
	public String city, zipCode;
	public WeatherFetcher cFetcher;
	public TwitterFetcher cTwitter;
	
	public ChatBot(WeatherFetcher fetcher, TwitterFetcher twitter) {
		this.setName("MyTerminator");
		cFetcher = fetcher;
		cTwitter = twitter;
	}
	
	// Function to respond to the keywords
	public void onMessage(String channel, String sender, 
			String login, String hostname, String message)
	{
		// Set the keyword to search for weather
		String keywords[] = {"weather", "trend"};
		StringBuilder key = new StringBuilder();
		
		// Find the keyword in the message and respond appropriately
		if(message.toLowerCase().indexOf(keywords[0].toLowerCase()) != -1) {
			
			// Check for a zipcode in the message
			for(int i = 0; i < message.length(); i++)
			{
				// If the message has digits, then get it as it is the zipcode
				if(Character.isDigit(message.charAt(i)))
					key.append(message.charAt(i));
			}
			
			// Handle the case of StringBuilder to string
			try {
				temps = cFetcher.getWeather(key.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Format the weather information
			for(int i = 0; i < 3; i++)
				temps[i] = Double.parseDouble(new DecimalFormat("##.#").format(temps[i]));
			
			// Send message to the channel
			sendMessage(channel, sender + ": The weather is " + temps[0]
					+ "°C with a high of " + temps[1] + "°C and a low of " + temps[2] + "°C.");
		}
		else if(message.toLowerCase().indexOf(keywords[1].toLowerCase()) != -1)
		{
			String topTrends[] = new String[10];
			topTrends = cTwitter.getTop10();
			sendMessage(channel, sender + ": Top 10 trends on Twitter USA: ");
			for(int i = 0; i < 10; i++)
				sendMessage(channel, sender + ": '" + topTrends[i] + "'\n");
		}
	}
}
