package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.constants.ConnectionConstants;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.queries.AdminQuery;
import com.example.onlinevotingsystem.queries.OfficerQuery;
import com.example.onlinevotingsystem.queries.VotersQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        HashMap<String,Object> resultHashMap=new HashMap<>();
        resultHashMap.put(HashMapConstants.FETCH_RESULT_TYPE_KEY,inputHashMap.get(HashMapConstants.FETCH_PARAM_TYPE_KEY));
        try {
            Class.forName(ConnectionConstants.JDBC_CLASS_NAME).newInstance();
            Log.d(TAG,"Class Loaded");

            Connection connection= DriverManager.getConnection(ConnectionConstants.SERVER_URL,ConnectionConstants.USERNAME,ConnectionConstants.PASSWORD);
            Log.d(TAG,"Connection Successful");

            Statement statement=connection.createStatement();

            String fetchType=inputHashMap.get(HashMapConstants.FETCH_PARAM_TYPE_KEY).toString();
            Log.d(TAG,"Fetch Type - "+fetchType);

            switch (fetchType){
                case HashMapConstants.FETCH_TYPE_LOGIN_USER:{
                    String voterId,password;

                    voterId=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_USERNAME_KEY).toString();
                    password=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_PASSWORD_KEY).toString();

                    Log.d(TAG,"Authenticating User with Voter ID: "+voterId);

                    ResultSet resultSet=statement.executeQuery(VotersQuery.GetAuthenticateQuery(voterId,password));

                    Log.d(TAG,"Authentication Status for "+voterId+" - "+resultSet.first());

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                    resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,resultSet.first());
                    break;
                }
                case HashMapConstants.FETCH_TYPE_LOGIN_ADMIN:{
                    String username, password;

                    username=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_USERNAME_KEY).toString();
                    password=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_PASSWORD_KEY).toString();

                    Log.d(TAG,"Authenticating Admin with Username: "+username);

                    ResultSet resultSet=statement.executeQuery(AdminQuery.GetAuthenticateQuery(username,password));

                    Log.d(TAG,"Authentication Status for "+username+" - "+resultSet.first());

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                    resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,resultSet.first());
                    break;
                }
                case HashMapConstants.FETCH_TYPE_LOGIN_OFFICER:{
                    String username, password;

                    username=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_USERNAME_KEY).toString();
                    password=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_PASSWORD_KEY).toString();

                    Log.d(TAG,"Authenticating Officer with Username: "+username);

                    ResultSet resultSet=statement.executeQuery(OfficerQuery.GetAuthenticateQuery(username,password));

                    Log.d(TAG,"Authentication Status for "+username+" - "+resultSet.first());

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                    resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,resultSet.first());
                    break;
                }
            }

            return resultHashMap;

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,false);
            resultHashMap.put(HashMapConstants.FETCH_RESULT_ERROR_KEY,e.getLocalizedMessage());
            return resultHashMap;
        }
    }

    @Override
    protected void onPostExecute(HashMap<String, Object> hashMap) {
        super.onPostExecute(hashMap);
        fetchDbInterface.onFetchCompleted(hashMap);
    }
}
