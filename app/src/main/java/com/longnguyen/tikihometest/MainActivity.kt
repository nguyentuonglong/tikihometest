package com.longnguyen.tikihometest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.longnguyen.tikihometest.adapter.KeyWordAdapter
import com.longnguyen.tikihometest.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: KeyWordAdapter
    private val compositeDisposable = CompositeDisposable()
    private var apiService = ApiService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        fetchKeyWord()
    }

    private fun fetchKeyWord() {
        compositeDisposable.addAll(
            apiService.getKeywords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.updateData(it)
                }, {
                    Timber.e(it)
                })
        )
    }

    private fun init() {
        adapter = KeyWordAdapter()
        keyword_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        keyword_rv.adapter = adapter
    }
}
