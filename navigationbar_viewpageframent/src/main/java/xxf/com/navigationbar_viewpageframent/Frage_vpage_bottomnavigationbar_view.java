package xxf.com.navigationbar_viewpageframent;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.List;

/**
 * Created by xxf on 2017/7/20.
 */

public class Frage_vpage_bottomnavigationbar_view extends RelativeLayout implements BottomNavigationBar.OnTabSelectedListener {

    private ViewPager pager;
    private BottomNavigationBar bottomNavigationBar;

    public Frage_vpage_bottomnavigationbar_view(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.btnnavbar_viewpg, this, true);
        pager = (ViewPager) findViewById(R.id.pager_item);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_container_item);
    }

    public Frage_vpage_bottomnavigationbar_view(Context context){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.btnnavbar_viewpg, this, true);
        pager = (ViewPager) findViewById(R.id.pager_item);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_container_item);
    }


    public void setFrage_vpage_bottomnavigationbar_view(FragmentManager fm, List<Fragment> fgtList, int position, List<BottomNavigationItem> bniList,int ActiveColorResource) {
        setPagerManagerFragment(fm, fgtList);
        setpagerCurrentItem(position);
        setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.setFirstSelectedPosition(position).initialise();
                onTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        for (int i = 0; i < bniList.size(); i++) {
            bottomNavigationBar.addItem(bniList.get(i).setActiveColorResource(ActiveColorResource));
        }
        bottomNavigationBar.setFirstSelectedPosition(1);//设置默认
        bottomNavigationBar.initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    /**
     * 构造viewpage适配器
     *
     * @param fm      getSupportFragmentManager()
     * @param fgtList fragment集合
     */
    public void setPagerManagerFragment(FragmentManager fm, List<Fragment> fgtList) {
        pager.setAdapter(new  MyPagerAdapter(fm, fgtList));
    }

    /**
     * @param position
     */
    public void setpagerCurrentItem(int position) {
        pager.setCurrentItem(position);
    }

    /**
     * viewpage设置翻页监听
     *
     * @param listener
     */
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        pager.setOnPageChangeListener(listener);
    }

    @Override
    public void onTabSelected(int position) {
        pager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    class MyPagerAdapter extends FragmentPagerAdapter {


        private List<Fragment> fgtList;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> fgtList) {
            super(fm);

            this.fgtList = fgtList;
        }

        @Override
        public int getCount() {
            return fgtList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fgtList.get(position);
        }
    }
}
