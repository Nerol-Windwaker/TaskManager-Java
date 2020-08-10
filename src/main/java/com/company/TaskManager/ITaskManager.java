package com.company.TaskManager;

public interface ITaskManager
{
    void CreateTask(String taskName,String description);
    void ShowAll();
    boolean ShowTask(int number);
    void ChangeTask(int number);
    void DeleteTask(int number);

}
