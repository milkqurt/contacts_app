package com.example.contactapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private MainActivity mainActivity;

    public ContactAdapter(ArrayList<Contact> contactArrayList, MainActivity mainActivity) {
        this.contactArrayList = contactArrayList;
        this.mainActivity = mainActivity;
    }

    public void setContactArrayList(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Contact contact = contactArrayList.get(position);
        holder.contactListItemBinding.setContact(contact);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.addAndEditContact(true, contact, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        private ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}
