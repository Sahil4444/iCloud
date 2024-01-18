package com.example.icloud.utils

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.icloud.databinding.EachToDoItemBinding
import com.example.icloud.databinding.FragmentAddPopUpBinding

class ToDoAdapter(private val list: MutableList<ToDoData>): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){
    private var listener: ToDoAdapterClicksInterface?=null
    fun setListener(listener: ToDoAdapterClicksInterface){
        this.listener = listener
    }
    inner class ToDoViewHolder(val binding: EachToDoItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = EachToDoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.todoTask.text = this.task

                binding.deleteTask.setOnClickListener {
                    listener?.onDeleteTaskBtnClick(this)
                }

                binding.editTask.setOnClickListener {
                    listener?.onEditTaskBtnClick(this)
                }
            }
        }
    }

    interface ToDoAdapterClicksInterface{
        fun onDeleteTaskBtnClick(toDoData: ToDoData)
        fun onEditTaskBtnClick(toDoData: ToDoData)
    }

}