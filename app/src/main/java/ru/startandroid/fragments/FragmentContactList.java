package ru.startandroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentContactList extends Fragment {

    OnActionListener mListener;
    private View view;
    private Unbinder unbinder;
    private List<Person> contacts = new ArrayList<>();

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnActionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contacts, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        CreateObjects();
        recyclerView.setAdapter(new myAdapter(getContext(), contacts));
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private void CreateObjects() {
        for (int i = 0; i <= 30; i++) {
            contacts.add(new Person(R.drawable.phone_book, 11));
        }
    }
}
