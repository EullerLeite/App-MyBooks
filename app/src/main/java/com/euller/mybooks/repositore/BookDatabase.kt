package com.euller.mybooks.repositore

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.db.SupportSQLiteDatabase
import com.euller.mybooks.entity.BookEntity

@Database(entities = [BookEntity::class], version = 1)
abstract class BookDatabase: RoomDatabase() {

    abstract fun bookDAO(): BookDAO


    companion object{
        private lateinit var instance: BookDatabase
        private const val DATABASE_NAME = "booksDB"

        fun getDatabase(context: Context): BookDatabase {
            if (!::instance.isInitialized) {
                synchronized(this) {
                    instance = Room.databaseBuilder(context, BookDatabase::class.java, DATABASE_NAME)
                        .addMigrations(Migrations.migrationFromV1ToV2)
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return instance
        }
    }

    private object Migrations {
        val migrationFromV1ToV2: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM Books")
            }
        }

    }

}