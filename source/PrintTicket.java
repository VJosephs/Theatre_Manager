//
//import java.util.ArrayList;
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//public class PrintTicket
//{
//    public static void main( String[] args )
//    {
//        //First Employee
//        JSONObject ticketDetails = new JSONObject();
//        ticketDetails.put("firstName", "Lokesh");
//        ticketDetails.put("lastName", "Gupta");
//        ticketDetails.put("website", "howtodoinjava.com");
//
//        JSONObject ticketObject = new JSONObject();
//        ticketObject.put("tickets", ticketDetails);
//
//
//        //Add employees to list
//        JSONArray ticketList = new JSONArray();
//        ticketList.add(ticketObject);
//        //Write JSON file
//        try (FileWriter file = new FileWriter("tickets.json")) {
//
//            file.write(ticketList.toString());
//            file.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
