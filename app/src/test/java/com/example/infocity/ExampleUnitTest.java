package com.example.infocity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.infocity.Model.DatabaseOpenHelper;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
   /* @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }*/
   Context context;
    SQLiteOpenHelper openHelper;

    @Test
    public void testIsCorrectNumberLine() {

        openHelper = new DatabaseOpenHelper(RuntimeEnvironment.application);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM cities",null);
        assertThat(res.getCount(),is(272128));
        db.close();
    }
}