package designPattern.behavioralDesignPattern;
import java.util.*;
/* one object notifiy the other obects whenever change in that object
 */

import java.util.ArrayList;

interface Channel{
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifiySubscriber(String videoTitle);

}

interface Subscriber{
    void update(String videoTitle);
}

class YouTubeUser implements Subscriber{
     
    String userName;
    YouTubeUser(String userName){
       this.userName=userName;
    }
    @Override
    public void update(String videoTitle) {
       System.out.println(userName + " received notification: New video -  "+ videoTitle);
    }
    

}

class YoutubeChannel implements Channel{
    String channelName;
    List<Subscriber> l=new ArrayList<>();

    public YoutubeChannel(String channelName){
        this.channelName=channelName;
    }
    @Override
    public void subscribe(Subscriber subscriber) {
         l.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
       l.remove(subscriber);
    }

    @Override
    public void notifiySubscriber(String videoTitle) {
        for(Subscriber s:l){
            s.update(videoTitle);
        }
    }
    
    // buisnees logic 
    public void uploadVideo(String videoTitle){
        System.out.println(channelName+" uploaded  new  video " +videoTitle);
        notifiySubscriber(videoTitle);
    }
    
}
public class ObserverPattern {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel=new YoutubeChannel("Learn Code with Govind");
        YouTubeUser user1=new YouTubeUser("Govind");
        YouTubeUser user2=new YouTubeUser("Raju");
        YouTubeUser user3=new YouTubeUser("Shyaal");
        YouTubeUser user4=new YouTubeUser("Rama");
        youtubeChannel.subscribe(user1);
        youtubeChannel.subscribe(user2);
        youtubeChannel.subscribe(user3);
        youtubeChannel.subscribe(user4);

        youtubeChannel.uploadVideo("Behavioral Design pattern");
        System.out.println();
        youtubeChannel.unSubscribe(user3);
        youtubeChannel.uploadVideo("Creational Desing pattern");
        


    }

}
