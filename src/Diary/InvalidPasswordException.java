package Diary;

public class InvalidPasswordException extends RuntimeException{
    InvalidPasswordException(String message){
        super(message);
    }
}
