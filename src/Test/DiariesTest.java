package Test;

import Diary.Diaries;
import Diary.Diary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiariesTest {
    @Test public void testThatNewDiaryCanBeAdded(){
        Diaries myDiary = new Diaries();
       myDiary.add("MyDiary","myPassword");
       assertEquals(1,myDiary.getTotalDiaries());
    }
    @Test public void testThatMoreThanOneDairyCanBeAdded(){
        Diaries myDiary = new Diaries();
        myDiary.add("MyDiary","myPassword");
        myDiary.add("MySecondDiary","MyPassword");
        assertEquals(2,myDiary.getTotalDiaries());
    }
    @Test public void testThatUserDiaryCanBeFoundIfUserNameIsInputted(){
        Diaries myDiary = new Diaries();
        myDiary.add("MyDiary","myPassword");
        Diary diary = myDiary.findByUsername("1");
        assertEquals(diary,myDiary.findByUsername("1"));

    }
    @Test public void testThatUserDiaryCanBeFoundIfUserNameIsInputtedEvenWhenUserAreMoreThanOne(){
        Diaries myDiary = new Diaries();
        myDiary.add("MyDiary","myPassword");
        myDiary.add("MySecondDiary","mySecPassword");
        myDiary.add("MyThirdDiary","myThirdPassword");
        Diary diary = myDiary.findByUsername("1");
        Diary diary1 = myDiary.findByUsername("2");
        Diary diary2 = myDiary.findByUsername("3");
        assertEquals(diary,myDiary.findByUsername("1"));
        assertEquals(diary1,myDiary.findByUsername("2"));
        assertEquals(diary2,myDiary.findByUsername("3"));
    }
    @Test public void testThatDiaryCanBeDeleted(){
        Diaries myDiary = new Diaries();
        myDiary.add("MyDiary","myPassword");
        myDiary.add("MySecondDiary","mySecPassword");
        myDiary.delete("MyDiary","myPassword");
        assertEquals(1,myDiary.getTotalDiaries());
    }

}