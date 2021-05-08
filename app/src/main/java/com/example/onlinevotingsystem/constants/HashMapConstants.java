package com.example.onlinevotingsystem.constants;

public class HashMapConstants {

    public static final String FETCH_PARAM_TYPE_KEY="FetchType";
    public static final String FETCH_RESULT_TYPE_KEY="ResultType";

    //For Authentication of User, Admin and Officer
    public static final String FETCH_TYPE_LOGIN_USER="LoginUser";
    public static final String FETCH_TYPE_LOGIN_ADMIN="LoginAdmin";
    public static final String FETCH_TYPE_LOGIN_OFFICER="LoginOfficer";

    public static final String FETCH_PARAM_LOGIN_USERNAME_KEY="Username";
    public static final String FETCH_PARAM_LOGIN_PASSWORD_KEY="Password";

    public static final String FETCH_RESULT_LOGIN_IS_SUCCESSFUL_KEY="IsLoginSuccessful";

    //For Checking if Voter ID Exists or Not
    public static final String FETCH_TYPE_CHECK_VOTER_ID="CheckVoterID";

    public static final String FETCH_PARAM_CHECK_VOTER_ID_KEY="VoterID";

    public static final String FETCH_RESULT_CHECK_VOTER_ID_EXISTS_KEY="VoterIdExists";

    //For Fetching Data of a User with a Particular Voter ID
    public static final String FETCH_TYPE_EXISTING_DATA_FROM_ID="ExistingDataFromVoterID";

    public static final String FETCH_PARAM_EXISTING_DATA_FROM_ID_KEY="VoterID";

    public static final String FETCH_RESULT_EXISTING_DATA_FROM_ID_IS_SUCCESS_KEY="IsExistingDataFetchSuccessful";
    public static final String FETCH_RESULT_EXISTING_DATA_FROM_ID_USER_KEY="ResultExistingDataUser";

    //For Checking If Username is Unique or Not
    public static final String FETCH_TYPE_USER_CHECK_UNIQUE_USERNAME="CheckUserUniqueUsername";
    public static final String FETCH_TYPE_ADMIN_CHECK_UNIQUE_USERNAME="CheckAdminUniqueUsername";
    public static final String FETCH_TYPE_OFFICER_CHECK_UNIQUE_USERNAME="CheckOfficerUniqueUsername";

    public static final String FETCH_PARAM_CHECK_UNIQUE_USERNAME_KEY="UniqueUsername";

    public static final String FETCH_RESULT_CHECK_UNIQUE_USERNAME_KEY="IsUsernameUnique";

    //For Fetching List of Officers
    public static final String FETCH_TYPE_OFFICER_LIST="GetOfficersList";

    public static final String FETCH_RESULT_OFFICERS_LIST_KEY="OfficersList";

    //For Fetching List of Polls
    public static final String FETCH_TYPE_POLL_LIST="GetPollList";

    public static final String FETCH_RESULT_POLL_LIST_KEY="PollList";

    //For Fetching Details of a Particular Poll
    public static final String FETCH_TYPE_POLL_DETAILS="GetPollDetailsFromNumber";

    public static final String FETCH_PARAM_POLL_DETAILS_POLL_NUM_KEY="PollNumber";

    public static final String FETCH_RESULT_POLL_DETAILS_KEY="PollDetails";

    //For Fetching List of Candidates
    public static final String FETCH_TYPE_CANDIDATE_LIST="GetCandidateList";

    public static final String FETCH_RESULT_CANDIDATE_LIST_KEY="AllCandidatesList";

    //For Fetching List of Candidates of a Particular Ward
    public static final String FETCH_TYPE_WARD_CANDIDATE_LIST="GetWardCandidateList";

    public static final String FETCH_PARAM_WARD_CANDIDATE_LIST_WARD_NUM_KEY="WardNumber";

    public static final String FETCH_RESULT_WARD_CANDIDATE_LIST_KEY="WardCandidatesList";

    //For Fetching List of Mobile Registered Voters of a Particular Ward
    public static final String FETCH_TYPE_WARD_REGISTERED_USERS_LIST="GetWardRegisteredUsersList";

    public static final String FETCH_PARAM_WARD_REGISTERED_USERS_LIST_KEY="WardNumber";

    public static final String FETCH_RESULT_WARD_REGISTERED_USERS_LIST_KEY="WardRegisteredUsersList";

    public static final String FETCH_RESULT_SUCCESS_KEY="IsFetchSuccess";
    public static final String FETCH_RESULT_ERROR_KEY="ResultError";

}
