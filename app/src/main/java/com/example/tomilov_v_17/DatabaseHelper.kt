package com.example.tomilov_v_17

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserManager.db"
        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"

        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS)
        onCreate(db)
    }

    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_PASSWORD, password)
        val success = db.insert(TABLE_USERS, null, values)
        db.close()
        return success
    }

    fun checkUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(COLUMN_ID)
        val selection = "$COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null)
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        return cursorCount > 0
    }
}
