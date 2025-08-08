package com.euller.mybooks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.euller.mybooks.entity.BookEntity
import com.euller.mybooks.repositore.BookRepository

class DetailsViewModel : ViewModel() {

    private val repository: BookRepository = BookRepository.getInstance()

    private val _book = MutableLiveData<BookEntity>()
    val book: LiveData<BookEntity> = _book

    private val _bookRemoval = MutableLiveData<Boolean>()
    val bookRemoval: LiveData<Boolean> = _bookRemoval

    fun getBookById(id: Int) {
        _book.value = repository.getBookById(id)
    }

    fun deleteBook(id: Int) {
        _bookRemoval.value = repository.deleteBook(id)
    }

    fun favorite(id: Int) {
        repository.toggleFavoriteStatus(id)
    }

}