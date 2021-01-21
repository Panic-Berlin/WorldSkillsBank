package ru.arsik.a12012021.ui.dialog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DialogViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DialogViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Диалоговая страница");
    }

    public LiveData<String> getText() {
        return mText;
    }
}