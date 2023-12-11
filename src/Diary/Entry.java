package Diary;

import java.time.LocalDateTime;

public class Entry {
    private  String id;
    private String title;
    private String body;
    private LocalDateTime dateCreated;

    public Entry(String id,String title,String body){
        this.id = id;
        this.title = title;
        this.body = body;

    }
    public String getId(){
        return id;
    }
    public void setTitle(String title){
        this.title = title;

    }
    public String getTitle(){
        return title;
    }
    public void setBody(String newBody){
        this.body += " " + newBody;
    }
    public String getBody(){
        return this.body;
    }
    public LocalDateTime getTime(){
        return dateCreated;
    }
    @Override
    public String toString(){
        return String.format("""
                Your entry id is : %s
                The time is made you entry is : %s
                The title of entry is: %s
                Your dairy body is : %s""",getId(), getTime(),getTitle(),getBody());
    }

}
