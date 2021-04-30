package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.constants.ConnectionConstants;
import com.example.onlinevotingsystem.constants.HashMapConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class FetchFromDatabase extends AsyncTask<Void,Void, HashMap<String,Object>> {

    public interface FetchDbInterface{
        void onFetchCompleted(HashMap<String,Object> resultHashMap);
    }

    private final FetchDbInterface fetchDbInterface;
    private final HashMap<String,Object> inputHashMap;

    public FetchFromDatabase(FetchDbInterface fetchDbInterface, HashMap<String, Object> inputHashMap) {
        super();
        this.fetchDbInterface = fetchDbInterface;
        this.inputHashMap = inputHashMap;
    }

    @Override
    protected HashMap<String, Object> doInBackground(Void... voids) {
        String TAG="MySqlDataFetch";
        try {
            HashMap<String,Object> resultHashMap=new HashMap<>();
            Class.forName(ConnectionConstants.JDBC_CLASS_NAME).newInstance();
            Log.d(TAG,"Class Loaded");

            Connection connection= DriverManager.getConnection(ConnectionConstants.SERVER_URL,ConnectionConstants.USERNAME,ConnectionConstants.PASSWORD);
            Log.d(TAG,"Connection Successful");



        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            HashMap<String,Object> resultHashMap=new HashMap<>();
            
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(HashMap<String, Object> hashMap) {
        super.onPostExecute(hashMap);
        fetchDbInterface.onFetchCompleted(hashMap);
    }
}
