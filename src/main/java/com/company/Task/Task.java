package com.company.Task;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import com.company.enums.*;

public class Task implements ITask
{
    public TaskStatus status;
    public String TaskName;
    public Date Date;
    public String Description;
    transient SimpleDateFormat formatter;

    public Task()
    {
        formatter = new SimpleDateFormat("dd-MM-yyyy");
    }

    public Task(String taskName,String description)
    {
        status = TaskStatus.NotReady;
        Date = new Date();
        TaskName = taskName;
        Description = description;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
    }

    public String ShowStatus()
    {
        return  status.toString();
    }
    public String ShowName()
    {
        return TaskName;
    }
    public String ShowDescription()
    {
        return Description;
    }
    public String ShowDate()
    {
        return formatter.format(Date);
    }

    public void ChangeStatusToReady()
    {
        status = TaskStatus.Ready;
    }
    public void ChangeStatusToNowInWork()
    {
        status = TaskStatus.NowInWork;
    }
    public void ChangeStatusToNotReady()
    {
        status = TaskStatus.NotReady;
    }
    public void ChangeName(String newName)
    {
        TaskName = newName;
    }
    public boolean ChangeData(String newDate)
    {
        try {
            Date = formatter.parse(newDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public void ChangeDescription(String newDescription)
    {
        Description = newDescription;
    }
}
