package com.euller.mybooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.euller.mybooks.entity.BookEntity
import com.euller.mybooks.repositore.BookRepository

class FavoriteViewModel : ViewModel() {

    private val _books = MutableLiveData<List<BookEntity>>()
    val books: LiveData<List<BookEntity>> = _books

    private val repository = BookRepository.getInstance()

    fun getFavoriteBooks() {
        _books.value = repository.getFavoriteBooks()
    }

    fun favorite(id: Int) {
        repository.toggleFavoriteStatus(id)
    }
}