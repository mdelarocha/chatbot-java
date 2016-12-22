# chatbot-java
Chatbot Program that Utilizes Twitter and Openweather APIs in real time in a freenode chat server. 

*You will need to havea a twitter account, login into dev.twitter.com and get your personal consumer and access keys. As well, subscribe to openweather.org for a free API key. 

1) Go to the following link: https://webchat.freenode.net

2) Set a unique nickname in the server and connect to a channel of your choice, that is set by you in the Project2main.java of the folder.

3) Run the Java Program and wait for the bot to connect to the channel, nicknamed "MyTerminator". All jar files (gson.jar, 

   twitter4j-core-4.0.4 and pircbot.jar) must be added to the project as external libraries in order to run, 
   
   that is done by building a path from the project to the .jar files attached.
   
4) When the command "weather" (any case) is typed into the chat with a zipcode (i.e. 75080), 

   the bot will respond with the current temperature (°C) and the high and low provided by the openweathermap.org API. 
   
5) Example commands: "What's the weather in 75080?" , "Weather 75056", "10001 weather".

6) When running a command with the word 'trend', the chatbot will also respond with the top 10 trending tags on Twitter USA with

   the twitter API. 
   
7) Example commands: "Top trends", "Trending", "Trends USA". 
