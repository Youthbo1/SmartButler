package com.example.administrator.smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.smartbutler.R;

/**
 * 项目名：  SmartButler
 * 包名：    com.example.administrator.smartbutler.fragment
 * 文件名:   UserFragment
 * 创建者:   LGL
 * 创建时间:  2017/11/3 14:33
 * 描述：    TODO
 */

public class UserFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        findView(view);
        return view;
    }

    private void findView(View view) {
    }
}