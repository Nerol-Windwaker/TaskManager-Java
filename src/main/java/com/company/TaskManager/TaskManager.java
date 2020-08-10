package com.company.TaskManager;

import com.company.Task.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager implements ITaskManager
{
    public ArrayList<Task> tasks;
    transient Scanner scan;
    transient Scanner scan2;

    public TaskManager()
    {
        tasks = new ArrayList<Task>();
        scan = new Scanner(System.in);
        scan2 = new Scanner(System.in);
    }
    public void CreateTask(String taskName,String description)
    {
        tasks.add(new Task(taskName,description));
    }
    public void ShowAll()
    {
        if(tasks.size() == 0) {
            System.out.println("-------------------------");
            System.out.println("No Tasks");
            System.out.println("-------------------------");
        }
        else {
            System.out.println("-------------------------");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ") " + "Name: " + tasks.get(i).ShowName());
                System.out.println("Status: " + tasks.get(i).ShowStatus());
                System.out.println("Date: " + tasks.get(i).ShowDate());
                System.out.println("-------------------------");
            }
        }
    }
    public boolean ShowTask(int number)
    {
        if(number<0 || number >= tasks.size())
        {
            System.out.println("!!!!!Wrong Number!!!!!");
            return false;
        }
        else
        {
            System.out.println("************************");
            System.out.println("Name: " + tasks.get(number).ShowName());
            System.out.println("Status: " + tasks.get(number).ShowStatus());
            System.out.println("Date: " + tasks.get(number).ShowDate());
            System.out.println("Description: " + tasks.get(number).ShowDescription());
            System.out.println("************************");
            return true;
        }
    }
    public void ChangeTask(int number)
    {
        if(ShowTask(number))
        {
            System.out.println("What do you want to change?");
            System.out.println("1)Name");
            System.out.println("2)Status");
            System.out.println("3)Date");
            System.out.println("4)Description");
            System.out.println("5)Return back to menu");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Write new Task`s name");
                    tasks.get(number).ChangeName(scan2.nextLine());
                    break;
                case 2:
                    System.out.println("1)Ready");
                    System.out.println("2)NowInWork");
                    System.out.println("3)NotReady");
                    switch (scan.nextInt()) {
                        case 1:
                            tasks.get(number).ChangeStatusToReady();
                            break;
                        case 2:
                            tasks.get(number).ChangeStatusToNowInWork();
                            break;
                        case 3:
                            tasks.get(number).ChangeStatusToNotReady();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Write Date in dd-MM-yyyy format (dd - day, MM - month, yyyy - year");
                    if(!tasks.get(number).ChangeData(scan2.nextLine())) System.out.println("!!!!!!!Wrong Date/Format!!!!!!");
                    break;
                case 4:
                    System.out.println("Write new Task`s description");
                    tasks.get(number).ChangeDescription(scan2.nextLine());
                    break;
                default:
                    break;
            }
        }
    }
    public void DeleteTask(int number)
    {
        if(number<0 || number >= tasks.size())
        {
            System.out.println("!!!!!Wrong Number!!!!!");
        }
        else
        {
            tasks.remove(number);
        }
    }

}
