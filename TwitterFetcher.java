// Class to fetch the top trends off twitter

import twitter4j.Twitter;
import twitter4j.Trends;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterFetcher {
	// Declare necessary variables for the class
	
	public String top10[] = new String[10];
	
	public TwitterFetcher() throws TwitterException {
		// Set up the configuration for the twitter fetcher with the necessary Keys
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("iZ4CmD3cO2076F3L0973P4IvW")
		.setOAuthConsumerSecret("1dbEHD0p2GpkTiyn0TDuxy11IuUV94Eq4WH0jIh42Ls7faLl6w")
		.setOAuthAccessToken("356514451-nbN0w6uL2isfWy1Sz5iYy75XIXPCM8R2eZBVVfHK")
		.setOAuthAccessTokenSecret("kS0KMcdEI4XiYCJ2CMVcXTE4EOiCnHcvGoLHj9dkMpugm");
		
		// Use TwitterFactory to build a Twitter object
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		// Get the Trends for the US with WOEID 23424977
		Trends trends = twitter.getPlaceTrends(23424977);
		
		for(int i = 0; i < trends.getTrends().length; i++) {
			if(i == 10)
				break;
			top10[i] = trends.getTrends()[i].getName();
		}
			
	}
	
	public String[] getTop10() {
		// Return the top 10 trends
		return top10;
	}
	
	
}
