package com.example.onlinevotingsystem.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlinevotingsystem.database.FetchFromDatabase;

import java.util.HashMap;

public class AdminViewModel extends ViewModel implements FetchFromDatabase.FetchDbInterface {

    private MutableLiveData<Boolean> IsDatabaseProcessPerformed;

    public LiveData<Boolean> CheckIsProcessPerformed(){
        if(IsDatabaseProcessPerformed==null){
            IsDatabaseProcessPerformed=new MutableLiveData<>();
            IsDatabaseProcessPerformed.setValue(false);
        }
        return IsDatabaseProcessPerformed;
    }

    public void SetDatabaseProcess(boolean process){
        if(IsDatabaseProcessPerformed==null)
            IsDatabaseProcessPerformed=new MutableLiveData<>();
        IsDatabaseProcessPerformed.setValue(process);
    }

    @Override
    public void onFetchCompleted(HashMap<String, Object> resultHashMap) {

    }
}
