package tn.ramzess.myapplication.dao;

import java.util.ArrayList;
import java.util.List;

import tn.ramzess.myapplication.business.Activity;


public final class Database {
    private static List<Activity> database = new ArrayList<>();

    public Database() {
        database.add(new Activity());
        database.add(new Activity());
        database.add(new Activity());
        database.add(new Activity());
        database.add(new Activity());
        database.add(new Activity());
        database.add(new Activity());
    }

    public Activity getActivity(int index)
    {
        if (index > database.size())
        {
            return null;
        }
        return database.get(index);
    }
}
