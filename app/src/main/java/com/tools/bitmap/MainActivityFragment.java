package com.tools.bitmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tools.bitmap.circle.CircleActivity;
import com.tools.bitmap.colorart.activity.ColorArtActivity;
import com.tools.bitmap.photoview.activity.LauncherActivity;
import com.tools.bitmap.pictest.PictestMainActivity;
import com.tools.bitmap.rounded.activity.ExampleActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    private View view;

    private ListView listView;

    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        init();
        return view;
    }

    private void init() {
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        adapter.add("拍照和相册选择图片裁剪后更换头像demo");
        adapter.add("git圆形的ImageView");
        adapter.add("git带圆角的ImageView");
        adapter.add("支持双击或双指缩放的ImageView，在ViewPager等Scrolling view中正常使用，相比上面的AndroidTouchGallery，不仅支持ViewPager，同时支持单个ImageView");
        adapter.add("根据图片的均色设置背景色显示文字和图片，类似itune11中效果");
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class<?> cls = null;
        switch (position) {
            case 0:
                cls = PictestMainActivity.class;
                break;
            case 1:
                cls = CircleActivity.class;
                break;
            case 2:
                cls = ExampleActivity.class;
                break;
            case 3:
                cls = LauncherActivity.class;
                break;
            case 4:
                cls = ColorArtActivity.class;
                break;
        }
        if (cls != null) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), cls);
            startActivity(intent);
        }
    }
}
