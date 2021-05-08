package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.constants.ConnectionConstants;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.constants.TableKeys;
import com.example.onlinevotingsystem.queries.VotersQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

public class DatabaseUpdater extends AsyncTask<Void,Void,Boolean> {

    public interface DatabaseUpdateInterface{
        void onDataUpdated(String type, boolean result, String error);
    }

    private final HashMap<String,Object> inputHashMap;
    private final DatabaseUpdateInterface updateInterface;
    private String error, UpdateType;

    public DatabaseUpdater(HashMap<String, Object> inputHashMap, DatabaseUpdateInterface updateInterface) {
        super();
        this.inputHashMap = inputHashMap;
        this.updateInterface = updateInterface;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        String TAG = "DatabaseUpdater";
        UpdateType=inputHashMap.get(HashMapConstants.UPDATE_TYPE_KEY).toString();
        try {
            Class.forName(ConnectionConstants.JDBC_CLASS_NAME).newInstance();
            Log.d(TAG,"Class Loaded");

            Connection connection=DriverManager.getConnection(ConnectionConstants.SERVER_URL,ConnectionConstants.USERNAME,ConnectionConstants.PASSWORD);
            Log.d(TAG,"Connection Successful");

            Statement statement=connection.createStatement();

            switch (UpdateType){
                case HashMapConstants.UPDATE_TYPE_REGISTER_USER:{

                    String voterID, password, regTime;
                    voterID=inputHashMap.get(HashMapConstants.UPDATE_PARAM_REGISTER_USER_VOTER_ID).toString();
                    password=inputHashMap.get(HashMapConstants.UPDATE_PARAM_REGISTER_USER_PASSWORD).toString();
                    regTime=Long.toString(new Date().getTime());

                    Log.d(TAG,"Registering User "+voterID);

                    statement.execute(VotersQuery.GetUpdateMobileRegisteredQuery(voterID,password,regTime,"NULL"));

                    Log.d(TAG,"User " + voterID + " Registered Successfully");

                    break;
                }
            }


            return true;
        }
        catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            error=e.getLocalizedMessage();
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean)
            updateInterface.onDataUpdated(UpdateType,true,null);
        else
            updateInterface.onDataUpdated(UpdateType,false,error);
    }
}
