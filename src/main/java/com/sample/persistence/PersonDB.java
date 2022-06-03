package com.sample.persistence;

import com.sample.data.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDB {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static  {
        persons.put(1, new Person(1, "F1", "L1", "email1@gmail.com"));
        persons.put(2, new Person(2, "F2", "L2", "email2@gmail.com"));
        persons.put(3, new Person(3, "F3", "L3", "email3@gmail.com"));
        persons.put(4, new Person(4, "F4", "L4", "email4@gmail.com"));
    }

    public static Person getById(int id){
        return persons.get(id);
    }

    public static List<Person> getAll(){
        List<Person> result = new ArrayList<Person>();
        for (Integer key : persons.keySet()){
            result.add(persons.get(key));
        }
        return result;
    }

    public static int getCount(){
        return persons.size();
    }

    public static void remove(){
        if(!persons.keySet().isEmpty()){
            persons.remove(persons.keySet().toArray()[0]);
        }
    }

    public static String save(Person person){
        String result = "";
        if(persons.get(person.getId()) != null){
            result = "Updated Person with id = " + person.getId();
        }else {
            result = "Updated Person with id = " + person.getId();
        }
        return result;
    }

}
