package com.euller.mybooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.euller.mybooks.entity.BookEntity
import com.euller.mybooks.repositore.BookRepository

class HomeViewModel : ViewModel() {

    private val _books = MutableLiveData<List<BookEntity>>()
    val books: LiveData<List<BookEntity>> = _books

    private val repository = BookRepository.getInstance()

    fun getAllBooks() {
        _books.value = repository.getAllBooks()
    }

    fun favorite(id: Int) {
        repository.toggleFavoriteStatus(id)
    }

}