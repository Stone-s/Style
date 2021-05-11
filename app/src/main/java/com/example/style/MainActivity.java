package com.example.style;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.style.databinding.ActivityMainBinding;
import com.example.style.fragment.HomeFragment;
import com.example.style.fragment.MineFragment;
import com.example.style.fragment.RecommendFragment;

/**
 * @author 鑫宇
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mActivityMainBinding;
    private HomeFragment mHomeFragment;
    private RecommendFragment mRecommendFragment;
    private MineFragment mMineFragment;
//    当前选中的fragment,默认为空
    private Fragment  selectedFragment=new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(mActivityMainBinding.getRoot());
        initFragment();
        initListener();


    }

    private void initListener() {
        mActivityMainBinding.bngv.setOnNavigationItemSelectedListener(item -> {
//            默认启用下拉刷新
            mActivityMainBinding.refreshLayout.setEnableRefresh(true);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(mHomeFragment);
                    break;
                case R.id.navigation_recommend:
                    switchFragment(mRecommendFragment);
                    break;
                case R.id.navigation_mine:
                    switchFragment(mMineFragment);
//                    我的页面禁用下拉刷新
                    mActivityMainBinding.refreshLayout.setEnableRefresh(false);
                    break;
                default:
                    break;
            }
            return false;
        });
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mRecommendFragment = new RecommendFragment();
        mMineFragment = new MineFragment();
        switchFragment(mHomeFragment);
    }


    /**
     * @param target 要切换的fragment
     */
    private void switchFragment(Fragment target) {
        if (selectedFragment != target) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // 判断是否被add过
            if (!target.isAdded()) {
                // 隐藏当前的fragment，将下一个fragment 添加进去
                transaction.hide(selectedFragment).add(R.id.fl_container, target).commit();
            } else {
                // 隐藏当前的fragment，显示下一个fragment
                transaction.hide(selectedFragment).show(target).commit();
            }
            selectedFragment =  target;
        }

    }


}