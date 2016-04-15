package cc.bitlight.systembarfinal.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cc.bitlight.systembarfinal.R;
import cc.bitlight.systembarfinal.activity.fragment.FindTabAdapter;
import cc.bitlight.systembarfinal.activity.fragment.Find_hotCollectionFragment;
import cc.bitlight.systembarfinal.activity.fragment.Find_hotRecommendFragment;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle mActionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setTabLayout();
    }

    void setToolbar() {
        //Toolbar生成
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_base);
        toolbar.setTitle("主页");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        //侧划菜单生成
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.DrawerToggleOpen, R.string.DrawerToggleClose);
        drawerLayout.addDrawerListener(mActionBarDrawerToggle);
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setItemIconTintList(null);//设置菜单图标恢复本来的颜色
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.subitem_01) {
                    Toast.makeText(MainActivity.this, "sub item 01", Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.subitem_04) {
                    Toast.makeText(MainActivity.this, "sub item 04", Toast.LENGTH_SHORT).show();

                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    void setTabLayout() {
        TabLayout tab_FindFragment_title = (TabLayout) findViewById(R.id.tab_title);
        ViewPager vp_FindFragment_pager = (ViewPager) findViewById(R.id.vp_pager);
        //初始化各fragment
        Find_hotRecommendFragment hotRecommendFragment = new Find_hotRecommendFragment();
        Find_hotCollectionFragment hotCollectionFragment = new Find_hotCollectionFragment();
        //将fragment装进列表中
        List<Fragment> list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        List<String> list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().
                setText(list_title.get(0)
                ));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().
                setText(list_title.get(1)
                ));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter fAdapter = new FindTabAdapter(fragmentManager, list_fragment, list_title);
        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
