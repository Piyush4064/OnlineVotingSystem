package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.classes.Admin;
import com.example.onlinevotingsystem.constants.ConnectionConstants;
import com.example.onlinevotingsystem.constants.TableKeys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionEstablisher extends AsyncTask<Void,Void,Boolean> {

    public interface ConnectionInterface{
        void onConnectionResult(boolean result, String error);

    }

    private final String ClassName,URL,Username,Password;
    private final ConnectionInterface connectionInterface;
    private String errorResult;

    public ConnectionEstablisher(ConnectionInterface connectionInterface) {
        super();
        ClassName=ConnectionConstants.JDBC_CLASS_NAME;
        URL=ConnectionConstants.SERVER_URL;
        Username=ConnectionConstants.USERNAME;
        Password=ConnectionConstants.PASSWORD;
        this.connectionInterface=connectionInterface;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        String TAG = "ConnectionEstablisher";
        try {
            Class.forName(ClassName).newInstance();
            Log.d(TAG,"Class " + ClassName + " Loaded Successfully!");
            DriverManager.getConnection(URL,Username,Password);
            Log.d(TAG,"Connection Successful!");
            return true;
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            errorResult=e.getLocalizedMessage();
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean)
            connectionInterface.onConnectionResult(aBoolean,null);
        else
            connectionInterface.onConnectionResult(aBoolean,errorResult);
    }
}
