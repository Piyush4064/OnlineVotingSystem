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

                case HashMapConstants.FETCH_TYPE_LOGIN_USER:{

                    String username=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_USERNAME_KEY).toString();
                    String password=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_PASSWORD_KEY).toString();

                    Log.d(TAG,"Authenticating for User with Username "+username);

                    ResultSet resultSet=statement.executeQuery(GetSqlRegisteredUserQuery.GetAuthenticateQuery(username,password));

                    if(resultSet.first()){
                        String voterID=resultSet.getString(TableKeys.KEY_REGISTERED_USER_VOTER_ID);
                        String photoURl=resultSet.getString(TableKeys.KEY_REGISTERED_USER_PHOTO_URL);
                        boolean hasVoted = resultSet.getInt(TableKeys.KEY_REGISTERED_USER_HAS_VOTED) == 1;
                        long timeOfReg = Long.parseLong(resultSet.getString(TableKeys.KEY_REGISTERED_USER_REG_TIME));

                        ResultSet existingResultSet=statement.executeQuery(GetSqlExistingVoterQuery.GetCheckVoterIdQuery(voterID));

                        if(existingResultSet.first()){

                            Log.d(TAG,"Authentication Successful!");

                            resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                            resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,true);

                            String name=existingResultSet.getString(TableKeys.KEY_EXISTING_VOTERS_NAME);
                            String phoneNum=existingResultSet.getString(TableKeys.KEY_EXISTING_VOTERS_PHONE_NUM);
                            long dob = Long.parseLong(existingResultSet.getString(TableKeys.KEY_EXISTING_VOTERS_DOB));
                            int pollNum=existingResultSet.getInt(TableKeys.KEY_EXISTING_VOTERS_POLL_NUM);

                            User user = new User(voterID,username,name,phoneNum,pollNum,dob,timeOfReg,photoURl,hasVoted);

                            resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_USER_KEY,user);
                        }
                        else {

                            Log.d(TAG,"Error - Invalid Voter ID");

                            resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,false);
                            resultHashMap.put(HashMapConstants.FETCH_RESULT_ERROR,"Invalid Voter ID");
                        }
                        return resultHashMap;

                    }
                    else {
                        Log.d(TAG,"Wrong Credentials");
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,false);
                    }

                    break;
                }

                case HashMapConstants.FETCH_TYPE_LOGIN_ADMIN:{

                    String username=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_USERNAME_KEY).toString();
                    String password=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_PASSWORD_KEY).toString();

                    ResultSet resultSet=statement.executeQuery(GetSqlAdminQuery.GetAuthenticateQuery(username,password));

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);

                    if(resultSet.first()){
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,true);

                        String name = resultSet.getString(TableKeys.KEY_ADMIN_NAME);
                        String photoUrl = resultSet.getString(TableKeys.KEY_ADMIN_PHOTO_URL);

                        Admin admin=new Admin(username,name,photoUrl);
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_ADMIN_KEY,admin);
                        return resultHashMap;
                    }
                    else {
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,false);
                    }

                    break;
                }
                case HashMapConstants.FETCH_TYPE_LOGIN_OFFICER:{

                    String username=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_USERNAME_KEY).toString();
                    String password=inputHashMap.get(HashMapConstants.FETCH_PARAM_LOGIN_PASSWORD_KEY).toString();

                    ResultSet resultSet=statement.executeQuery(GetSqlOfficerQuery.GetAuthenticateQuery(username,password));

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);

                    if(resultSet.first()) {
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY, true);

                        String name = resultSet.getString(TableKeys.KEY_OFFICER_NAME);
                        String photoUrl = resultSet.getString(TableKeys.KEY_OFFICER_PHOTO_URL);
                        int pollNum = resultSet.getInt(TableKeys.KEY_OFFICER_POLL_NO);

                        Officer officer=new Officer(username,name,photoUrl,pollNum);
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_OFFICER_KEY,officer);
                        return resultHashMap;
                    }
                    else {
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY,false);
                    }
                    break;
                }
            }

            return resultHashMap;

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
            resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,false);
            resultHashMap.put(HashMapConstants.FETCH_RESULT_ERROR,e.getMessage());
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
