package ru.startandroid.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentAuthorization extends Fragment {

    OnActionListener mListener;
    private Unbinder unbinder;
    private View view;

    @OnClick(R.id.imageButton3)
    public void onClickSocialVk() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com")));
    }

    @OnClick(R.id.imageButton4)
    public void onClickSocialFaceBook() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com")));
    }

    @OnClick(R.id.imageButton5)
    public void onClickSocialGoogle() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")));
    }

    @OnClick(R.id.button1)
    public void onClickResume() {
        mListener.onAction("second");
    }

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

        view = inflater.inflate(R.layout.fragment_authoritation, container, false);
        return view;
    }

    @Override
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