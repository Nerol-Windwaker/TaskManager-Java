package com.company.Task;

public interface ITask
{
    String ShowStatus();
    String ShowName();
    String ShowDescription();
    String ShowDate();
    void ChangeStatusToReady();
    void ChangeStatusToNowInWork();
    void ChangeStatusToNotReady();
    void ChangeName(String newName);
    boolean ChangeData(String newDate);
    void ChangeDescription(String newDescription);
}