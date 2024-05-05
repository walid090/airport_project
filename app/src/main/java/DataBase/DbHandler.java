package DataBase;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import entity.User;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "airport";
    private static final String user_TABLE = "user";


    // Constructor
    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + user_TABLE + "("
                + "id" + " INTEGER PRIMARY KEY,"
                + "user_name" + " TEXT,"
                + "password" + " TEXT,"
                + "email" + " TEXT,"
                + "phone_number" + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
        //addUser(1,"admin","admin123","admin@gmail.com","12345678");
    }
    public void addUser(int id,String userName, String password, String email, String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("user_name", userName);
        values.put("password", password);
        values.put("email", email);
        values.put("phone_number", phoneNumber);

        // Inserting Row
        db.insert(user_TABLE, null, values);
        // Closing database connection
        db.close();
    }

    public int  Auth(String UserName, String Password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorUser = db.rawQuery("SELECT id FROM " + user_TABLE +
                " WHERE " + "user_name" + " = ? AND " + "password" + " = ?", new String[]{UserName, Password});
        int id=0;
        if (cursorUser != null && cursorUser.moveToFirst()) {
            id= cursorUser.getInt(cursorUser.getColumnIndexOrThrow("id"));
            db.close(); // Close the database
            return id;
        } else {
            if (cursorUser != null)
                cursorUser.close();
            db.close(); // Close the database
            return id;
        }
    }

    public void UpdateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("phone_number", user.getPhone_number());
        values.put("user_name", user.getUser_name());


        // Define the WHERE clause to specify which lesson to update based on the ID
        String whereClause = "id = ?";
        String[] whereArgs = { String.valueOf(user.getId()) };

        // Update the lesson in the database
        int numRowsUpdated = db.update("user", values, whereClause, whereArgs);

        // Check if the update was successful
        if (numRowsUpdated > 0) {
            Log.d("Database", "user updated successfully"); // Corrected log message
        } else {
            Log.d("Database", "user not updated");
        }

        db.close();
    }


    public ArrayList<User> readUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<User> usersList = new ArrayList<>();
        // We're creating a cursor with a query to read data from the database.
        Cursor cursorUsers = db.rawQuery("SELECT id, user_name, password, phone_number, email FROM user WHERE id = ?", new String[]{String.valueOf(id)});
        // We should use while loop instead of if condition to iterate through the cursor.
        while (cursorUsers.moveToNext()) {
            User user = new User(
                    cursorUsers.getInt(cursorUsers.getColumnIndexOrThrow("id")),
                    cursorUsers.getString(cursorUsers.getColumnIndexOrThrow("user_name")),
                    cursorUsers.getString(cursorUsers.getColumnIndexOrThrow("password")),
                    cursorUsers.getString(cursorUsers.getColumnIndexOrThrow("phone_number")),
                    cursorUsers.getString(cursorUsers.getColumnIndexOrThrow("email")));
            usersList.add(user);
        }
        cursorUsers.close();
        db.close();
        return usersList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + user_TABLE);

        // Create tables again
        onCreate(db);
    }
}
