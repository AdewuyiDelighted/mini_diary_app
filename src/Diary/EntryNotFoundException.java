package Diary;

public class EntryNotFoundException extends RuntimeException{
    EntryNotFoundException(String message){
        super(message);
    }

}
