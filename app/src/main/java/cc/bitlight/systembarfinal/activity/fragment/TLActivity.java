package cc.bitlight.systembarfinal.activity.fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import cc.bitlight.systembarfinal.R;

public class TLActivity extends AppCompatActivity {

    //    private Find_hotMonthFragment hotMonthFragment;                      //本月热榜fragment
//    private Find_hotToday hotToday;                                      //今日热榜fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tl);
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
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter fAdapter = new FindTabAdapter(fragmentManager, list_fragment, list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }
}
