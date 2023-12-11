package Diary;

import java.util.ArrayList;

public class Diaries {
    private ArrayList<Diary> diaries = new ArrayList<>();
    private int totalDiaries;

    public void add(String username,String password){
        totalDiaries++;
        Diary diary = new Diary(username,password);
        diaries.add(diary);
    }
    public int getTotalDiaries(){
        return totalDiaries;
    }
    public Diary findByUsername(String username){
       for(Diary diary : diaries){
           if(diary.getUserName().equals(username));
           return diary;
       }
        return null;
    }

    public void delete(String username,String password){
        Diary diary = findByUsername(username);
        if(diary.getPassword().equals(password)){
            diaries.remove(diary);
            totalDiaries--;
        }
    }
}
