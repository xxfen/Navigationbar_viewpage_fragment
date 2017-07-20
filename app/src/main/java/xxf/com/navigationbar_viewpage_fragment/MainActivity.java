package xxf.com.navigationbar_viewpage_fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import xxf.com.navigationbar_viewpageframent.Frage_vpage_bottomnavigationbar_view;

public class MainActivity extends AppCompatActivity {
    private frament_activity_home f_home;
    private frament_activity_my f_my;
    private frament_activity_center f_center;
    private List<Fragment> fgtList;
    private List<BottomNavigationItem> bniList;
    private Frage_vpage_bottomnavigationbar_view fvb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fvb = (Frage_vpage_bottomnavigationbar_view) findViewById(R.id.nvf);
        indate();
        fvb.setFrage_vpage_bottomnavigationbar_view(getSupportFragmentManager(), fgtList, 1, bniList,R.color.colorAccent);
    }
    private void indate() {
        fgtList = new ArrayList<>();
        fgtList.add(new frament_activity_home());
        fgtList.add(new frament_activity_center());
        fgtList.add(new frament_activity_my());
        bniList = new ArrayList<>();
        bniList.add(new BottomNavigationItem(R.drawable.ic_android_black_24dp, "消息"));
        bniList.add(new BottomNavigationItem(R.drawable.ic_android_black_24dp, "主页"));
        bniList.add(new BottomNavigationItem(R.drawable.ic_android_black_24dp, "我的"));
    }

}
