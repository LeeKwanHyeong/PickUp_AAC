package com.example.pickup_aac.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickup_aac.module.Database
import kotlin.random.Random

class PickUpViewModel: ViewModel() {
    private val database: Database = Database()
    private var rand = Random
    var nowNum = -1

    companion object{
        var MaxNum = 101
    }

    private var _text: MutableLiveData<String> = MutableLiveData()
    val currentText: LiveData<String>
        get() = _text

    private fun updateText(int: Int){
        _text.value = int.toString()
    }

    init{
        _text.value = ""
    }

    fun getNum(){
        nowNum = rand.nextInt(MaxNum) + 1
        database.saveNumber(nowNum)
        updateText(nowNum)
    }

    fun setMaxNum(int: Int){
        MaxNum = int
    }

    fun showAllNum(){
        if(nowNum == -1) return
        _text.value = ""
        var array: ArrayList<Int> = ArrayList()
        array = database.getAllNumber()
        for(i in 0 until array.size){
            _text.value += array.get(i).toString() + " "
        }
    }

    fun deleteAllNum(){
        if(database.getAllNumber().size == 0) return
        else{
            database.removeNumber()
        }
    }




}