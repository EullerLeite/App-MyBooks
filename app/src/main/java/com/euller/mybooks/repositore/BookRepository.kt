package com.euller.mybooks.repositore

import android.content.Context
import com.euller.mybooks.entity.BookEntity
import kotlinx.coroutines.flow.Flow


class BookRepository private constructor(context: Context) {

    private var dataBase = BookDatabase.getDatabase(context).bookDAO()


    companion object {
        private lateinit var instance: BookRepository

        fun getInstance(context: Context): BookRepository {
            synchronized(this) {
                if (!::instance.isInitialized) {
                    instance = BookRepository(context)
                }
            }
            return instance
        }
    }





    fun getAllBooks(): Flow<List<BookEntity>> {
        return dataBase.getAllBooks()
    }


    fun getFavoriteBooks(): Flow<List<BookEntity>> {
        return dataBase.getFavoriteBooks()
    }


    fun getBookById(id: Int): BookEntity {
        return dataBase.getBookById(id)
    }

    fun deleteBook(id: Int): Boolean {
        return dataBase.delete(getBookById(id)) > 0
    }

    fun toggleFavoriteStatus(id: Int) {
        val book = getBookById(id)
        book.favorite = !book.favorite
        dataBase.update(book)
    }
}
