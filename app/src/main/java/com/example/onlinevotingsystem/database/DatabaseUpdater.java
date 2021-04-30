package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.constants.ConnectionConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseUpdater extends AsyncTask<Void,Void,Boolean> {

    public interface DatabaseUpdateInterface{
        void onDataUpdated(boolean result, String error);
    }

    private final HashMap<String,Object> inputHashMap;
    private final DatabaseUpdateInterface updateInterface;
    private String error;

    public DatabaseUpdater(HashMap<String, Object> inputHashMap, DatabaseUpdateInterface updateInterface) {
        super();
        this.inputHashMap = inputHashMap;
        this.updateInterface = updateInterface;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        try {
            Class.forName(ConnectionConstants.JDBC_CLASS_NAME).newInstance();
            String TAG = "DatabaseUpdater";
            Log.d(TAG,"Class Loaded");

            Connection connection=DriverManager.getConnection(ConnectionConstants.SERVER_URL,ConnectionConstants.USERNAME,ConnectionConstants.PASSWORD);
            Log.d(TAG,"Connection Successful");



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
            updateInterface.onDataUpdated(true,null);
        else
            updateInterface.onDataUpdated(false,error);
    }
}
