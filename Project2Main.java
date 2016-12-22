// Main File

public class Project2Main {

	public static void main(String[] args) throws Exception {
		// Startup the Request
		WeatherFetcher fetcher = new WeatherFetcher();
		TwitterFetcher twitter = new TwitterFetcher();
		
		// Start the bot up
		ChatBot bot = new ChatBot(fetcher, twitter); 
		
		// Enable debugging output
		bot.setVerbose(true);
		
		// Connect to the IRC server
		bot.connect("irc.freenode.net");
		
		// Join the #pircbot channel. 
		bot.joinChannel("[#yourchannel]");
	}

}
