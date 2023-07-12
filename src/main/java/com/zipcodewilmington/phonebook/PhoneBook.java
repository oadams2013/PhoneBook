package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }
    //nullary constructor ser this object to a Treemap when no parameters are provided

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            phonebook.get(name).add(phoneNumber);

        } else {
            phonebook.put(name, new ArrayList<>());
            phonebook.get(name).add(phoneNumber);

        }

    }

    public void addAll(String name, String... phoneNumbers) {
        for (String s : phoneNumbers) {
            add(name, s);
        }

        }

        public void remove (String name){
        phonebook.remove(name); // this is to remove the name from the phonebook
        }

        public Boolean hasEntry (String name){

            return phonebook.containsKey(name) ;
        }

        public Boolean hasEntry (String name, String phoneNumber){
            if (phonebook.containsKey(name) &&
                    phonebook.get(name).contains(phoneNumber)) {
                return true;
            }
            return false ;
        }


        public List<String> lookup (String name){
            return phonebook.get(name);
        }

        public String reverseLookup (String phoneNumber) {
            for (String key : phonebook.keySet()) {
                //              if(phonebook.get(key).equals(phoneNumber))
                //                 return key;
                //         }
                if (hasEntry(key, phoneNumber)) {
                    return key;
                }
            }
                return null;
            }


        public List<String> getAllContactNames () {
        ArrayList b = new ArrayList<>();
        for (String n : phonebook.keySet()){
            b.add(n);
        }

            return b ;
        }

        public Map<String, List<String>> getMap () {
            return new HashMap(phonebook);
        }

    }
