package com.company;

import java.util.Scanner;
import com.google.gson.*;
import com.company.TaskManager.*;
import com.company.WorkingVsJson.*;

public class Main
{

    public static void main(String[] args) throws Exception
    {

        Gson gson = new Gson();
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        WorkingVsJson writer = new WorkingVsJson("test.json");
        try
        {
            taskManager = gson.fromJson(writer.Read(), TaskManager.class);
        }
        catch (Exception e)
        {
            taskManager = new TaskManager();
            writer.Save(gson.toJson(taskManager));
        }

        System.out.println("Hello my friend!");
        while(true)
        {
            System.out.println("What you want to do?");
            System.out.println("1)Show All Tasks");
            System.out.println("2)Show Task");
            System.out.println("3)Create Task");
            System.out.println("4)Change Task");
            System.out.println("5)Delete Task");
            System.out.println("6)Exit");
            switch (scan.nextInt())
            {
                case 1:
                    taskManager.ShowAll();
                    break;
                case 2:
                    System.out.println("Write Task`s number");
                    taskManager.ShowTask(scan2.nextInt());
                    break;
                case 3:
                    System.out.println("Write Task Name");
                    String name = scan2.nextLine();
                    System.out.println("Write Task Description");
                    String description = scan2.nextLine();
                    taskManager.CreateTask(name,description);
                    break;
                case  4:
                    System.out.println("Write Task`s number");
                    taskManager.ChangeTask(scan2.nextInt());
                    break;
                case 5:
                    System.out.println("Write Task`s number");
                    taskManager.DeleteTask(scan2.nextInt());
                    break;
                case 6:
                    writer.Save(gson.toJson(taskManager));
                    return;
                default:
                    break;

            }

        }

    }

}
