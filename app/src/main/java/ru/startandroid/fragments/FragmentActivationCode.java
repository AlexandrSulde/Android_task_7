package ru.startandroid.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentActivationCode extends Fragment {
    OnActionListener mListener;
    private Unbinder unbinder;
    private View view;
    private int mCounter = 0;

    @OnClick(R.id.button2)
    public void onClickEnter() {
        Snackbar snack = Snackbar.make(view, "Я молодец!", Snackbar.LENGTH_LONG);
        View snackbarView1 = snack.getView();
        snackbarView1.setBackgroundColor(Color.BLUE);
        TextView snackTextView1 = snackbarView1.findViewById(android.support.design.R.id.snackbar_text);
        snackTextView1.setTextColor(Color.BLACK);
        snackTextView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        snack.setDuration(2000);
        snack.addCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                mListener.onAction("third");
            }
        }).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", mCounter);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_phone_code, container, false);
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnActionListener");
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }
}
