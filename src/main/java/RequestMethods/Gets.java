package RequestMethods;

import Objects.CurrentHuntResponse;
import Objects.FriendPageResponse;
import Utils.DbUtil.DBConnector;
import Serializer.Serializer;
import Utils.FileUtil.FileUtils;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * Created by derekhsieh on 10/5/15.
 * All of the HTTP GET methods are stored here
 */

public class Gets {
    private final static Logger logger = Logger.getLogger(Gets.class);
    private static DBConnector connector;
    private static FileUtils fileUtils;

    //Returns a specific user's friend requests
    public static List<String> GetFriendRequests(String username) {
        List<String> friendRequests = connector.getFriendRequests(username);
        if (friendRequests != null) {
            logger.info("Successfully got " + username + "'s friend requests");
        }
        return friendRequests;
    }

    //Get the list of friends
    public static List<String> GetFriends(String username) {
        List<String> friendList = connector.getFriends(username);
        return friendList;
    }

    //Get the number of friends of a user
    public static int GetNumberOfFriends(String username) {
        int friendCount = connector.getNoFriendRequests(username);
        return friendCount;
    }

    //Get the necessary information to populate a friend page activity
    public static FriendPageResponse GetFriendResponse(String username, String friend){
        return connector.getFriendPageInfo(username, friend);
    }

    //Returns a photo that was sent to the user by the friend
    public static String  GetPhoto(String user, String friend) {
        String photoLocation = connector.getPhoto(user, friend);
        byte[] photo = fileUtils.getPhoto(photoLocation);
        return Serializer.toJson(photo);
    }

    //Get the list of friends that do not have a hunt with username
    public static List<String> GetFriendsToPlayWith(String username){
        return connector.friendsToPlayWith(username);
    }

    //Get the topic sent by friend to username
    public static String GetTopic(String username, String friend){
        return connector.getTopic(username,friend);
    }

    public static CurrentHuntResponse GetCurrentHunts(String username){
        return connector.getCurrentHunts(username);
    }

    public static void setDBConnector(DBConnector dBconnector) {
        connector = dBconnector;
    }

    public static void setFileUtils(FileUtils utils) {
        fileUtils = utils;
    }

    public static void setFileUtils(String userDirectory){
        fileUtils = new FileUtils(userDirectory);
    }
}
