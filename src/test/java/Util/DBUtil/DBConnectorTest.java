package Util.DBUtil;

import Objects.CurrentHuntResponse;
import Objects.FriendPageResponse;
import Serializer.Serializer;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


/**
 * Created by derekhsieh on 4/1/16.
 */
public class DBConnectorTest {
    private DBConnector connector = DBConnector.getInstance(dbProperties);
    private static final String dbProperties = "./src/test/resources/db.properties";
    private static Logger logger = Logger.getLogger(DBConnectorTest.class);

    @Test
    public void testLogin() throws Exception {
        boolean success = connector.login("test", "tester");
        logger.info(success);
    }

    @Test
    public void testAddUser() throws Exception {
        boolean success = connector.addUser("check", "checker", "check@check.com", "check", "O'checker");
        logger.info(success);
    }

    @Test
    public void testAddFriendRequest() {
        boolean success = connector.addFriendRequest("quiz", "test");
        logger.info(success);
    }

    @Test
    public void testGetFriendRequests() throws Exception {
        List<String> requests = connector.getFriendRequests("test");
        logger.info(Serializer.toJson(requests));
    }

    @Test
    public void testUpdateFriendRequests() throws Exception {
        boolean success = connector.updateFriendRequest("test", "quiz");
        logger.info(success);
    }

    @Test
    public void testGetNoFriendRequests() throws Exception {
        int numRequests = connector.getNoFriendRequests("test");
        logger.info(numRequests);
    }

    @Test
    public void testGetFriends() throws Exception {
        List<String> friends = connector.getFriends("test");
        logger.info(Serializer.toJson(friends));
    }

    @Test
    public void testAddFriend() throws Exception {
        boolean success = connector.addFriend("quiz", "test");
        logger.info("success");
    }

    @Test
    public void testSendPhoto() throws Exception {
        boolean success = connector.sendPhoto("test", "quiz", "/this/location", System.currentTimeMillis());
        logger.info(success);
    }

    @Test
    public void testGetPhoto() throws Exception {
        String location = connector.getPhoto("test", "quiz");
        logger.info(location);
    }

    @Test
    public void testGetTopic() throws Exception {
        String topic = connector.getTopic("test", "quiz");
        logger.info(topic);
    }

    @Test
    public void testGetRating() throws Exception {
        double rank = connector.getRating("test", "quiz");
        logger.info(rank);
    }

    @Test
    public void testAddRating(){
        boolean success = connector.addRating("test","quiz", 2, System.currentTimeMillis());
        logger.info(success);
    }

    @Test
    public void testUpdateHuntPlayedWithFriend(){
        boolean success = connector.updateHuntPlayedWithFriend("awk", "test", 2.3);
        logger.info(success);
    }

    @Test
    public void testFriendsToPlayWith(){
        List<String> friendsToPlayWith = connector.friendsToPlayWith("test");
        logger.info(friendsToPlayWith);
    }

    @Test
    public void testGetFriendPageInfo(){
        FriendPageResponse response = connector.getFriendPageInfo("test", "quiz");
        logger.info(response.getAvgHuntScore() + " " + response.getHuntsPlayed());
    }

    @Test
    public void testAddDeleteCurrentHunt(){
        boolean success = connector.addCurrentHunt("test", "quiz", "cat", System.currentTimeMillis());
        logger.info(success);
        success = connector.deleteHunt("test", "quiz");
        logger.info(success);
    }

    @Test
    public void testGetCurrentHunts(){
        CurrentHuntResponse response = connector.getCurrentHunts("test");
        logger.info(response.getToRate());
        logger.info(response.getToSend());
        logger.info(response.getToSee());
    }

}