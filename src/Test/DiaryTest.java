package Test;

import Diary.Diary;
import Diary.Entry;
import Diary.InvalidPasswordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {

    @Test public void thatDiaryIsLocked(){
        Diary diary =  new Diary("MyUsername","MyPassword");
        diary.unlock("MyPassword");
        boolean check = diary.isLocked();
        assertFalse(check);
    }
    @Test public void whenPasswordIsNotCorrect(){
        Diary diary = new Diary("MyUsername","MyPassword");
        assertThrows(InvalidPasswordException.class,()->diary.unlock("Mypassword"));
    }
    @Test public void testThatDiaryIsLocked(){
        Diary  diary = new Diary("MyUsername","MyPassword");
        diary.lock();
        boolean check = diary.isLocked();
        assertTrue(check);
    }
    @Test public void testThatEntryCanBeCreated(){
        Diary  diary = new Diary("MyUsername","MyPassword");
        diary.createEntry("MyDiary","Semicolon");
        assertEquals(1,diary.totalNumberOfEntries());
    }

    @Test public void confirmThatWhenAnEntryIsDeletedSizeIsReducedByMinusOne(){
        Diary  diary = new Diary("MyUsername","MyPassword");
        diary.createEntry("MyDiary","Semicolon");
        diary.createEntry("MySecondDiary","Xplorers");
        assertEquals(2,diary.totalNumberOfEntries());
        diary.deleteEntry("1");
        assertEquals(1,diary.totalNumberOfEntries());
    }
    @Test public void whenAnEntryIdDeletedTheEntryAfterMaintainItsPosition(){
        Diary  diary = new Diary("MyUsername","MyPassword");
        diary.createEntry("MyDiary","Semicolon");
        diary.createEntry("MySecondDiary","Xplorers");
        assertEquals(2,diary.totalNumberOfEntries());
        diary.deleteEntry("1");
        assertEquals(1,diary.totalNumberOfEntries());
        assertEquals("MySecondDiary",diary.getTitle("2"));
    }

    @Test public void testThatEntryCanBeFindByItIdNumber(){
        Diary diary = new Diary("MyUsername","MyPassword");
        diary.createEntry("MyDiary","Semicolon");
        diary.createEntry("MySecondDiary","Xplorers");
        Entry entry = diary.findEntryById("1");
        Entry entry2 = diary.findEntryById("2");
        assertEquals(entry,diary.findEntryById("1"));
        assertEquals(entry2,diary.findEntryById("2"));


    }
    @Test public void testThatEntryCanBeUpdated(){
        Diary diary = new Diary("MyUsername","MyPassword");
        diary.createEntry("MyDiary","Semicolon");
        Entry entry = diary.findEntryById("1");
        assertEquals("Semicolon",entry.getBody());
        assertEquals("MyDiary",entry.getTitle());
        diary.updateEntry("1","newTitle","newBody");
        assertEquals("Semicolon newBody",entry.getBody());
        assertEquals("newTitle",entry.getTitle());

    }




}