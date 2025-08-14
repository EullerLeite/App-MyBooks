package com.euller.mybooks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.euller.mybooks.entity.BookEntity
import com.euller.mybooks.repositore.BookRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = BookRepository.getInstance(application.applicationContext)

    val books: LiveData<List<BookEntity>> =  repository.getAllBooks().asLiveData()






    fun favorite(id: Int) {
        repository.toggleFavoriteStatus(id)
    }

}