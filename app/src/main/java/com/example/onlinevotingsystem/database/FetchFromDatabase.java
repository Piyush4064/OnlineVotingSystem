package com.example.onlinevotingsystem.database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.onlinevotingsystem.classes.Candidate;
import com.example.onlinevotingsystem.classes.Officer;
import com.example.onlinevotingsystem.classes.Poll;
import com.example.onlinevotingsystem.constants.ConnectionConstants;
import com.example.onlinevotingsystem.constants.HashMapConstants;
import com.example.onlinevotingsystem.constants.TableKeys;
import com.example.onlinevotingsystem.queries.AdminQuery;
import com.example.onlinevotingsystem.queries.CandidateQuery;
import com.example.onlinevotingsystem.queries.OfficerPollNumQuery;
import com.example.onlinevotingsystem.queries.OfficerQuery;
import com.example.onlinevotingsystem.queries.PollAddressQuery;
import com.example.onlinevotingsystem.queries.PollQuery;
import com.example.onlinevotingsystem.queries.VotersQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        HashMap<String,Object> resultHashMap=new HashMap<>();
        resultHashMap.put(HashMapConstants.FETCH_RESULT_TYPE_KEY,inputHashMap.get(HashMapConstants.FETCH_PARAM_TYPE_KEY));
        try {
            Class.forName(ConnectionConstants.JDBC_CLASS_NAME).newInstance();
            String TAG = "MySqlDataFetch";
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
                case HashMapConstants.FETCH_TYPE_VERIFY_PHONE_NUM:{
                    String voterId, phoneNum;

                    voterId=inputHashMap.get(HashMapConstants.FETCH_PARAM_VERIFY_PHONE_NUM_VOTER_ID_KEY).toString();
                    phoneNum=inputHashMap.get(HashMapConstants.FETCH_PARAM_VERIFY_PHONE_NUM_NUMBER_KEY).toString();

                    Log.d(TAG,"Verifying Phone Number for "+voterId+" with Number "+phoneNum);

                    ResultSet resultSet=statement.executeQuery(VotersQuery.GetVerifyPhoneNumQuery(voterId,phoneNum));

                    Log.d(TAG,"Phone Verification Status for "+voterId+" - "+resultSet.first());

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                    resultHashMap.put(HashMapConstants.FETCH_RESULT_VERIFY_PHONE_NUM_KEY,resultSet.first());

                    if(resultSet.first()){
                        boolean isRegistered= resultSet.getInt(TableKeys.KEY_VOTERS_IS_MOBILE_REGISTERED) == 1;
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_VERIFY_PHONE_NUM_IS_REG_KEY,isRegistered);
                    }

                    break;
                }
                case HashMapConstants.FETCH_TYPE_POLL_LIST:{
                    Log.d(TAG,"Fetching the Details of Each Poll");
                    ResultSet resultSet=statement.executeQuery(PollQuery.GetPollListQuery());
                    Log.d(TAG,"List Fetched Successfully");

                    ArrayList<Poll> pollArrayList=new ArrayList<>();
                    if(resultSet.first()){
                        int pollNum=resultSet.getInt(TableKeys.KEY_POLL_NUMBER);
                        int numOfCandidates=resultSet.getInt(TableKeys.KEY_POLL_NO_CANDIDATES);
                        int numOfVoters=resultSet.getInt(TableKeys.KEY_POLL_NO_VOTERS);
                        long electionStartTime=Long.parseLong(resultSet.getString(TableKeys.KEY_POLL_ELEC_START_TIME));
                        long electionEndTime=Long.parseLong(resultSet.getString(TableKeys.KEY_POLL_ELEC_END_TIME));
                        int numOfCastedVotes=resultSet.getInt(TableKeys.KEY_POLL_NO_VOTES_CASTED);

                        Poll poll=new Poll(pollNum,numOfCandidates,numOfVoters,electionStartTime,electionEndTime,numOfCastedVotes);

                        ResultSet addressResult=statement.executeQuery(PollAddressQuery.GetPollDetailsQuery(pollNum));
                        if(addressResult.first())
                            poll.setAddress(addressResult.getString(TableKeys.KEY_POLL_ADDRESS_ADDRESS));

                        ResultSet officerResult=statement.executeQuery(OfficerPollNumQuery.GetPollDetailsQuery(pollNum));
                        if(officerResult.first())
                            poll.setOfficerUsername(officerResult.getString(TableKeys.KEY_OFFICER_POLL_NO_USERNAME));

                        ResultSet candidateListResult=statement.executeQuery(CandidateQuery.GetPollWiseCandidateQuery(pollNum));

                        ArrayList<Candidate> candidateArrayList=new ArrayList<>();

                        if(candidateListResult.first()){

                            String name=candidateListResult.getString(TableKeys.KEY_CANDIDATE_NAME);
                            String id=candidateListResult.getString(TableKeys.KEY_CANDIDATE_CAND_ID);
                            String phoneNum=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHONE_NO);
                            Long dob=Long.parseLong(candidateListResult.getString(TableKeys.KEY_CANDIDATE_DOB));
                            String photoUrl=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHOTO_URL);
                            String symbolName=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_NAME);
                            String symbolPhoto=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_PHOTO);
                            int numOfVotes=candidateListResult.getInt(TableKeys.KEY_CANDIDATE_NO_VOTES);

                            Candidate candidate=new Candidate(id,name,dob,photoUrl,phoneNum,symbolName,symbolPhoto,pollNum,numOfVotes);
                            candidateArrayList.add(candidate);

                            while (candidateListResult.next()){
                                name=candidateListResult.getString(TableKeys.KEY_CANDIDATE_NAME);
                                id=candidateListResult.getString(TableKeys.KEY_CANDIDATE_CAND_ID);
                                phoneNum=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHONE_NO);
                                dob=Long.parseLong(candidateListResult.getString(TableKeys.KEY_CANDIDATE_DOB));
                                photoUrl=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHOTO_URL);
                                symbolName=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_NAME);
                                symbolPhoto=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_PHOTO);
                                numOfVotes=candidateListResult.getInt(TableKeys.KEY_CANDIDATE_NO_VOTES);

                                candidate=new Candidate(id,name,dob,photoUrl,phoneNum,symbolName,symbolPhoto,pollNum,numOfVotes);
                                candidateArrayList.add(candidate);
                            }
                        }

                        poll.setCandidateList(candidateArrayList);

                        pollArrayList.add(poll);

                        while (resultSet.next()){
                            pollNum=resultSet.getInt(TableKeys.KEY_POLL_NUMBER);
                            numOfCandidates=resultSet.getInt(TableKeys.KEY_POLL_NO_CANDIDATES);
                            numOfVoters=resultSet.getInt(TableKeys.KEY_POLL_NO_VOTERS);
                            electionStartTime=Long.parseLong(resultSet.getString(TableKeys.KEY_POLL_ELEC_START_TIME));
                            electionEndTime=Long.parseLong(resultSet.getString(TableKeys.KEY_POLL_ELEC_END_TIME));
                            numOfCastedVotes=resultSet.getInt(TableKeys.KEY_POLL_NO_VOTES_CASTED);

                            poll=new Poll(pollNum,numOfCandidates,numOfVoters,electionStartTime,electionEndTime,numOfCastedVotes);

                            addressResult=statement.executeQuery(PollAddressQuery.GetPollDetailsQuery(pollNum));
                            if(addressResult.first())
                                poll.setAddress(addressResult.getString(TableKeys.KEY_POLL_ADDRESS_ADDRESS));

                            officerResult=statement.executeQuery(OfficerPollNumQuery.GetPollDetailsQuery(pollNum));
                            if(officerResult.first())
                                poll.setOfficerUsername(officerResult.getString(TableKeys.KEY_OFFICER_POLL_NO_USERNAME));

                            candidateListResult=statement.executeQuery(CandidateQuery.GetPollWiseCandidateQuery(pollNum));

                            candidateArrayList=new ArrayList<>();

                            if(candidateListResult.first()){

                                String name=candidateListResult.getString(TableKeys.KEY_CANDIDATE_NAME);
                                String id=candidateListResult.getString(TableKeys.KEY_CANDIDATE_CAND_ID);
                                String phoneNum=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHONE_NO);
                                Long dob=Long.parseLong(candidateListResult.getString(TableKeys.KEY_CANDIDATE_DOB));
                                String photoUrl=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHOTO_URL);
                                String symbolName=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_NAME);
                                String symbolPhoto=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_PHOTO);
                                int numOfVotes=candidateListResult.getInt(TableKeys.KEY_CANDIDATE_NO_VOTES);

                                Candidate candidate=new Candidate(id,name,dob,photoUrl,phoneNum,symbolName,symbolPhoto,pollNum,numOfVotes);
                                candidateArrayList.add(candidate);

                                while (candidateListResult.next()){
                                    name=candidateListResult.getString(TableKeys.KEY_CANDIDATE_NAME);
                                    id=candidateListResult.getString(TableKeys.KEY_CANDIDATE_CAND_ID);
                                    phoneNum=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHONE_NO);
                                    dob=Long.parseLong(candidateListResult.getString(TableKeys.KEY_CANDIDATE_DOB));
                                    photoUrl=candidateListResult.getString(TableKeys.KEY_CANDIDATE_PHOTO_URL);
                                    symbolName=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_NAME);
                                    symbolPhoto=candidateListResult.getString(TableKeys.KEY_CANDIDATE_ELEC_SYMBOL_PHOTO);
                                    numOfVotes=candidateListResult.getInt(TableKeys.KEY_CANDIDATE_NO_VOTES);

                                    candidate=new Candidate(id,name,dob,photoUrl,phoneNum,symbolName,symbolPhoto,pollNum,numOfVotes);
                                    candidateArrayList.add(candidate);
                                }
                            }

                            poll.setCandidateList(candidateArrayList);

                            pollArrayList.add(poll);
                        }
                    }

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                    resultHashMap.put(HashMapConstants.FETCH_RESULT_POLL_LIST_KEY,pollArrayList);

                    break;
                }
                case HashMapConstants.FETCH_TYPE_CHECK_VOTER_ID:{
                    String voterId=inputHashMap.get(HashMapConstants.FETCH_PARAM_CHECK_VOTER_ID_KEY).toString();

                    Log.d(TAG,"Checking If Voter ID Exists or not for id "+voterId);

                    ResultSet resultSet=statement.executeQuery(VotersQuery.GetCheckVoterIdQuery(voterId));

                    Log.d(TAG,"Verification Completed, Status - "+resultSet.first());

                    resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                    resultHashMap.put(HashMapConstants.FETCH_RESULT_CHECK_VOTER_ID_EXISTS_KEY,resultSet.first());
                    break;
                }
                case HashMapConstants.FETCH_TYPE_EXISTING_DATA_FROM_ID:{
                    String voterId=inputHashMap.get(HashMapConstants.FETCH_PARAM_EXISTING_DATA_FROM_ID_KEY).toString();

                    ResultSet resultSet=statement.executeQuery(VotersQuery.GetVoterIdDataQuery(voterId));

                    if(resultSet.first()){

                        String name=resultSet.getString(TableKeys.KEY_VOTERS_NAME);
                        String voterID=resultSet.getString(TableKeys.KEY_VOTERS_ID);


                    }
                    else {

                    }

                    break;
                }
                case HashMapConstants.FETCH_TYPE_OFFICER_DETAILS:{
                    String username=inputHashMap.get(HashMapConstants.FETCH_PARAM_OFFICER_DETAILS_USERNAME_KEY).toString();

                    ResultSet resultSet=statement.executeQuery(OfficerQuery.GetOfficerDataQuery(username));

                    if(resultSet.first()){
                        String name=resultSet.getString(TableKeys.KEY_OFFICER_NAME);
                        String photoUrl=resultSet.getString(TableKeys.KEY_OFFICER_PHOTO_URL);

                        ResultSet pollResult=statement.executeQuery(OfficerPollNumQuery.GetUserNamePollNoQuery(username));

                        int pollNum;
                        if(pollResult.first())
                            pollNum=pollResult.getInt(TableKeys.KEY_OFFICER_POLL_NO_POLL_NO);
                        else
                            pollNum=0;

                        Officer officer=new Officer(username,name,photoUrl,pollNum);
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_SUCCESS_KEY,true);
                        resultHashMap.put(HashMapConstants.FETCH_RESULT_OFFICER_DETAILS_KEY,officer);
                    }
                    else {

                    }

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
