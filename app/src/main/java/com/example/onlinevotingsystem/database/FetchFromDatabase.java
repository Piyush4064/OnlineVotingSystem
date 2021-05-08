package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.classes.Admin;
import com.example.onlinevotingsystem.classes.Officer;
import com.example.onlinevotingsystem.classes.User;
import com.example.onlinevotingsystem.constants.ConnectionConstants;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.constants.TableKeys;
import com.example.onlinevotingsystem.utils.GetSqlAdminQuery;
import com.example.onlinevotingsystem.utils.GetSqlExistingVoterQuery;
import com.example.onlinevotingsystem.utils.GetSqlOfficerQuery;
import com.example.onlinevotingsystem.utils.GetSqlRegisteredUserQuery;

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

            }

            return resultHashMap;

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return resultHashMap;
        }
    }

    @Override
    protected void onPostExecute(HashMap<String, Object> hashMap) {
        super.onPostExecute(hashMap);
        fetchDbInterface.onFetchCompleted(hashMap);
    }
}
