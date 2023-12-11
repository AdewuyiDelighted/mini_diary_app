package Diary;

import java.util.ArrayList;

public class Diary {
    private String userName;
    private String password;
    private boolean isLocked = true;
    private ArrayList<Entry> entries = new ArrayList<Entry>();
    private int totalEntry;

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public void unlock(String password) {
        validatePassword(password);
        this.isLocked = false;
    }

    public void lock() {
        this.isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void createEntry(String title,String body) {
        totalEntry++;
        String id = generateId();
        Entry entry = new Entry(id, title, body);
        entries.add(entry);
    }

    public String generateId() {
        return totalEntry + "";
    }

    public int totalNumberOfEntries() {
        return totalEntry;
    }

    public void deleteEntry(String id) {
        Entry entry = findEntryById(id);
        entries.remove(entry);
        totalEntry--;

    }
    public String getTitle(String id){
        Entry entry = findEntryById(id);
        return entry.getTitle();
    }

    public Entry findEntryById(String id) {
        for (Entry entry : entries) {
            if (entry.getId().equals(id)){
                return entry;
            }else {
                throw new EntryNotFoundException("Entry not found");
            }

        }
        return null;
    }

    public void  updateEntry(String id, String newTitle, String newBody) {
        Entry entry = findEntryById(id);
         entry.setTitle(newTitle);
         entry.setBody(newBody);
    }

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    private  void validatePassword(String password){
        if(!this.password.equals(password)) throw new InvalidPasswordException("Incorrect password");
    }
}
