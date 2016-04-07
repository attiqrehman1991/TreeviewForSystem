package com.example.attiqurrehmanrao.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by Attiq ur Rehman on 5/1/2016
 */
public abstract class BaseFragmentActivity extends AppCompatActivity implements
        BaseFragment.FragmentNavigationHelper, BaseFragment.OnFragmentInteractionListener {
    private static final long HIDE_DELAY = 3000;
    public boolean isSkip = false;
    public BaseFragment mCurrentFragment;
    public Toolbar toolbar;
    Runnable callback = new Runnable() {
        public void run() {
//            hideMessageBar();
        }
    };
    //    public Stack<BaseFragment> mFragments = new Stack<BaseFragment>();
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onViewClicked(v);
        }
    };
    View.OnClickListener onClickBack = new View.OnClickListener() {
        public void onClick(View v) {
            onBack();
            intiHeader(mCurrentFragment);
        }
    };
    private SharedPreferences prefs;
    private boolean menuOpened;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = getLayoutInflater();
        View contentView = inflater.inflate(getLayoutId(), null);

        setContentView(contentView);
        initComponent();
    }

    void initHeader(String fragName) {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        Drawable mDrawable = this.getResources().getDrawable(R.drawable.ic_drawer);
        mDrawable.setColorFilter(new
                PorterDuffColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY));

//        getSupportActionBar().setIcon(mDrawable);
        getSupportActionBar().setTitle(fragName);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // enable back button
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getActionBar().setHomeButtonEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
        }

    }

    public abstract int getLayoutId();

    abstract void initComponent();

    public void addFragment(BaseFragment f, String name1, String clearBackStack) {

        getSupportActionBar().setTitle(name1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager
                .beginTransaction();
        transaction.add(R.id.fragment_container, f);
        transaction.addToBackStack(clearBackStack);
        transaction.commit();

        mCurrentFragment = f;
//        mFragments.push(f);

    }

    @Override
    public void setFragmentTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void replaceFragment(BaseFragment f, String name,
                                String clearBackStack) {

//        try {
//            FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1);
//            String str = backEntry.getName();
//
//            if (clearBackStack.equals(str)) {
//                FragmentManager fm = getSupportFragmentManager();
//                fm.popBackStack();
//            }
////            if(clearBackStack.equals("Profile")) {
////                FragmentManager fm = getSupportFragmentManager();
//////                while(fm.getBackStackEntryCount()>1)
//////                    fm.popBackStack();
////                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        getSupportActionBar().setTitle(name);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, f);
        transaction.addToBackStack(clearBackStack);
        transaction.commit();

        mCurrentFragment = f;
//        mFragments.push(f);
    }

    public void onBack() {

        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
            return;
        }
        getSupportFragmentManager().popBackStack();
//        mFragments.pop();
//        mCurrentFragment = mFragments.isEmpty() ? null : mFragments.peek();
    }

    public void clearFragmentBackStack() {
//        FragmentManager fm = getSupportFragmentManager();
//        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
//            boolean done = fm.popBackStackImmediate();
//            Log.d("STATUS POP BACK", done+"");
//        }

        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            getSupportFragmentManager().popBackStack();
            int size = fm.getBackStackEntryCount();
            Log.d("fragment stack size", size + "");
        }

		/*
         * if(!mFragments.isEmpty()) { BaseFragment homeFragment =
		 * mFragments.get(0); mFragments.clear(); mFragments.push(homeFragment);
		 * }
		 */
    }

    public void refreshFragment() {
        if (mCurrentFragment != null) {
            mCurrentFragment.onRefresh();
        }
    }

    protected abstract void resetFragment();

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            if (isDrawerOpen()) {
//                closeDrawer();
//                return true;
//            } else {
//                ParseUser user = ParseUser.getCurrentUser();
//                List<String> sports = user.getList("sports");
//                if (mCurrentFragment instanceof ProfileEditFragment && (sports == null || sports.size() == 0)) {
//                    return super.onKeyDown(keyCode, event);
//                } else if (sports == null || sports.size() == 0) {
//                    ViewUtils.showSportCloseAlert(this);
//                } else {
//                    boolean flag = false;
//                    if (mCurrentFragment != null) {
//                        flag = mCurrentFragment.onKeyDown(keyCode, event);
//                    }
//                    if (flag) {
//                        return flag;
//                    }
//                    if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
//                        if (mCurrentFragment instanceof FragmentProfileMe || mCurrentFragment instanceof FragmentSearch || mCurrentFragment instanceof FragmentRankTables) {
//                            clearFragmentBackStack();
//
//                            resetFragment();
////                            FragmentUserInvites frag = new FragmentUserInvites();
////                            frag.setTargetFragment(mCurrentFragment, 17);
////                            addFragment(frag, "Invites", mCurrentFragment.getTag());
//                            return true;
//                        } else if(mCurrentFragment instanceof FragmentUserInvites){
//                            ViewUtils.showCloseAlert(this);
//                            return true;
//                        } else {
//                            return true;
//                        }
//                    } else {
//                        onBack();
////                updateHeader(null);
//                        intiHeader(mCurrentFragment);
//                        return true;
//                    }
//                }
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    public void updateHeader(String text) {

    }

    public void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public BaseFragment getCurrentFragment() {
        return mCurrentFragment;
    }

    public void setCurrentFragment(BaseFragment mCurrentFragment) {
        this.mCurrentFragment = mCurrentFragment;
    }

    // @Override
    // public void shareToTwitter(String path, String message) {
    // /*Intent intent = new Intent(this, TwitterOAuthActivity.class);
    // intent.putExtra("path", path);
    // intent.putExtra("message", message);
    // startActivity(intent);*/
    // }
    //
    // @Override
    // public void shareToEmail(String subject, String body) {
    // Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
    // sharingIntent.setType("text/plain");
    // sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    // sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
    // startActivity(Intent.createChooser(sharingIntent,
    // getResources().getString(R.string.app_name)));
    // }

    public SharedPreferences getPrefs() {
        return prefs;
    }

    public boolean isMenuOpened() {
        return menuOpened;
    }

    public void setMenuOpened(boolean menuOpened) {
        this.menuOpened = menuOpened;
    }

    protected abstract void closeDrawer();

    protected abstract boolean isDrawerOpen();

    @Override
    public void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

//        SnackBar snackbar = (SnackBar )findViewById(R.id.snackbar);
//        UtilsDialog.showToastLine(snackbar, msg);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mCurrentFragment != null) {
//            if()
            mCurrentFragment.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void onViewClicked(View v) {
    }

    public void intiHeader(BaseFragment fragment) {
        try {

//            findViewById(R.id.header).setVisibility(View.VISIBLE);
            backButtonEnable(true);

//            if(fragment instanceof FragmentLogin){
//                backButtonEnable(false);
//            }
//            else if(fragment instanceof FragmentSlidingTabsDisease || fragment instanceof FragmentDiseaseDetail) {
//                findViewById(R.id.img_right).setVisibility(View.VISIBLE);
//                ((ImageView)findViewById(R.id.img_right)).setImageResource(R.drawable.ic_add_trial);
//            }

        } catch (Exception e) {

            Log.e("", "");
        }
    }

    private void backButtonEnable(boolean flag) {
//        if(flag) {
//            findViewById(R.id.back).setVisibility(View.VISIBLE);
//            findViewById(R.id.back).setOnClickListener(onClickBack);
//        }else
//        {
//            findViewById(R.id.back).setVisibility(View.GONE);
//        }
    }

}
