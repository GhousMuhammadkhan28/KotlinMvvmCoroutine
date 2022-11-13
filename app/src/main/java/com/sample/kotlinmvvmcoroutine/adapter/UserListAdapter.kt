package com.databinding.kotlinmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.kotlinmvvmcoroutine.R
import com.sample.kotlinmvvmcoroutine.User
import com.sample.kotlinmvvmcoroutine.databinding.RowUserBinding

class UserListAdapter(var context: Context, var list: List<User>) :
    RecyclerView.Adapter<UserListAdapter.UserRow>() {
    class UserRow(view: View) : RecyclerView.ViewHolder(view) {
        var rowContactBinding: RowUserBinding? = DataBindingUtil.bind(view)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRow {
        var row = LayoutInflater.from(context).inflate(R.layout.row_user, null)
        return UserRow(row)
    }
    override fun onBindViewHolder(holder: UserRow, position: Int) {
        holder.rowContactBinding?.data = list.get(position)
    }
    override fun getItemCount(): Int {
        return list.size
    }
}