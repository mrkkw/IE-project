package com.example.newgame;

import android.util.Log;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class callingAWSWS {

    public static String testAWS() {
        final String BASE_URL = "http://192.168.1.15:8080/";
        String methodPath = "getAlltopics";
        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";

        //Making HTTP request
        try {
            url = new URL(BASE_URL+methodPath);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();

            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);

            //set the connection method to GET
            conn.setRequestMethod("GET");

            //add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            //Read the response
            Scanner inStream = new Scanner(conn.getInputStream());

            //read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }

    //post the user information to node js server
    public static void createUser(String nickname,String gender,String age,String region,String topic){

        final String BASE_URL = "http://192.168.1.15:8080/";

        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        final String methodPath="getNewUserDetails/"+nickname+"/"+gender+"/"+age+"/"+region+"/"+topic;

        try {
            url = new URL(BASE_URL + methodPath);

            //open the connection
            conn = (HttpURLConnection) url.openConnection();

            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);

            //set the connection method to POST
            conn.setRequestMethod("POST");

            //set the output to true
            conn.setDoOutput(true);

            //Send the POST out
            PrintWriter out= new PrintWriter(conn.getOutputStream());
            out.close();
            Log.i("error",new Integer(conn.getResponseCode()).toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }

    public static String checkUserexist(String username) {
        final String BASE_URL = "http://192.168.1.15:8080/";
        String methodPath = "checkUserExists/";
        //initialise
        URL url = null;
        HttpURLConnection conn = null;
        String textResult = "";

        //Making HTTP request
        try {
            url = new URL(BASE_URL+methodPath+username);
            //open the connection
            conn = (HttpURLConnection) url.openConnection();

            //set the timeout
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);

            //set the connection method to GET
            conn.setRequestMethod("GET");

            //add http headers to set your response type to json
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            //Read the response
            Scanner inStream = new Scanner(conn.getInputStream());

            //read the input steream and store it as string
            while (inStream.hasNextLine()) {
                textResult += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return textResult;
    }


}

