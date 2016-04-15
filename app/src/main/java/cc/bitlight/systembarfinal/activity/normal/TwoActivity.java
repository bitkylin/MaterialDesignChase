package cc.bitlight.systembarfinal.activity.normal;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cc.bitlight.systembarfinal.R;

public class TwoActivity extends AppCompatActivity {
    private TabLayout tablayout;                            //定义TabLayout
    private ViewPager viewpager;                             //定义viewPager

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        tablayout = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        viewpager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);
        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.navigation_drawer_header, null);
        view2 = mInflater.inflate(R.layout.navigation_drawer_header, null);
        view3 = mInflater.inflate(R.layout.navigation_drawer_header, null);

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //添加页卡标题
        mTitleList.add("No:1");
        mTitleList.add("No:2");
        mTitleList.add("No:3");

        tablayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        tablayout.addTab(tablayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        tablayout.addTab(tablayout.newTab().setText(mTitleList.get(1)));
        tablayout.addTab(tablayout.newTab().setText(mTitleList.get(2)));

        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList,mTitleList);
        viewpager.setAdapter(mAdapter);//给ViewPager设置适配器
        tablayout.setupWithViewPager(viewpager);//将TabLayout和ViewPager关联起来。
        tablayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }
}
