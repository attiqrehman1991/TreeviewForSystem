package com.example.attiqurrehmanrao.myapplication;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Updated by Attiq ur Rehman on 04/05/2016
 */
public class HomeFragmentActivity extends BaseFragmentActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    TextView tvName, tvEmail;
    FirstFragment fragP;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_fragment;
    }

    //    ImageView imgNavi;
    @Override
    void initComponent() {
        initHeader("ONE");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_drawer));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isShown()) {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
//                    Toast.makeText(getBaseContext(), "Click", Toast.LENGTH_SHORT).show();
//                Log.d("cek", "home selected");
            }
        });

        String[] navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        int[] navMenuDrawer = {R.drawable.ic_invite, R.drawable.ic_ranking, R.drawable.ic_search, R.drawable.ic_profile, R.drawable.ic_logout};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

//        imgNavi = (ImageView) findViewById(R.id.navi);
        //set adapter for drawerlist
        setListHeader();

        DrawerAdpater drawerAdpater = new DrawerAdpater(navMenuTitles, navMenuDrawer);
        mDrawerList.setAdapter(drawerAdpater);
//
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item, navMenuTitles));

//        setListHeader();

//        mDrawerList.setAdapter(new DrawarListAdapter(this, new ArrayList<String>(Arrays.asList(navMenuTitles))));

        //set the lists's click listener
        mDrawerList.setOnItemClickListener(this);
//        setListHeader();

        gotoProfileMeFragment();

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                BaseFragment f = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (f != null) {
                    f.onBackStackUpdate();
                }
            }
        });


        //Define Xml
//        locationText = (TextView) findViewById(R.id.userProfileLocation);
//        genderProfile = (TextView) findViewById(R.id.userProfileGender);
//        nameText = (TextView) findViewById(R.id.userProfileName);
//        sportsPlayed = (TextView) findViewById(R.id.userProfileSports);

//        profilePicture = (com.github.siyamed.shapeimageview.CircularImageView) findViewById(R.id.image_profile_main);

//        imgNavi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if(mDrawerLayout.isShown())
//                    mDrawerLayout.openDrawer(mDrawerList);
//            }
//        });
        resetFragment();
    }

    protected boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        List<String> sports = user.getList("sports");
//        if (sports == null || sports.size() == 0) {
//            ProfileEditFragment profileEditFragment = new ProfileEditFragment();
//            profileEditFragment.setTargetFragment(fragP, 12);
//            addFragment(profileEditFragment, "Edit profile", "Profile");
//        }
//    }

    protected void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void resetFragments() {
        mDrawerList.performItemClick(
                mDrawerList.getChildAt(1),
                1,
                mDrawerList.getAdapter().getItemId(1));
//        clearFragmentBackStack();
//        FragmentProfileMe frag = new FragmentProfileMe();
//        addFragment(frag, "Profile", "Profile");

    }

    @Override
    public void setSearchFragment() {
//        mDrawerList.performItemClick(mDrawerList.getAdapter().getView(0, null, null), 2, mDrawerList.getItemIdAtPosition(2));
        mDrawerList.performItemClick(
                mDrawerList.getChildAt(3),
                3,
                mDrawerList.getAdapter().getItemId(3));
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        List<String> sports = user.getList("sports");
//        //converting to array list
//        if (sports != null) {
//            //saving list to db
//            TinyDB tinydb = new TinyDB(this);
//            ArrayList<String> mySports = new ArrayList<String>(sports);
//            tinydb.putListString("sports", mySports);
//        }
//        MyResources.currentUserSports = sports;
//        //Get current Useres Id from Parse
//        userId = user.getObjectId();
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.menu_main_profile, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//
//                case android.R.id.home:
//                    mDrawerLayout.openDrawer(mDrawerList);
//                    //NavUtils.navigateUpFromSameTask(this);
//                    return true;
////                default:
////                    return super.onOptionsItemSelected(item);
////            }
//
//            case R.id.action_edit:
//                ProfileEditFragment frag = new ProfileEditFragment();
//                replaceFragment(frag, "Edit profile", "Profile");
//
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    public void resetFragment() {
        mDrawerList.performItemClick(
                mDrawerList.getChildAt(1),
                1,
                mDrawerList.getAdapter().getItemId(1));
//        clearFragmentBackStack();
//        FragmentProfileMe frag = new FragmentProfileMe();
//        addFragment(frag, "Profile", "Profile");

    }

    private void setListHeader() {
        View view = LayoutInflater.from(this).inflate(R.layout.drawar_header, null);
        try {
            mDrawerList.addHeaderView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

        tvName = (TextView) view.findViewById(R.id.tvName);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            selectItem(((TextView) view.findViewById(R.id.text1)).getText().toString());
        } catch (Exception e) {
        }

    }

    @Override
    public void onClick(View v) {

    }

    void gotoProfileMeFragment() {
        fragP = new FirstFragment();
        addFragment(fragP, "ONE", "ONE");
    }

    private void selectItem(String title) {
//        String title = "Profile";//navMenuTitles[position];
        if (title.equals("TWO")) {
//            Intent i = new Intent(this, FragmentRankTables.class);
//            startActivity(i);
            clearFragmentBackStack();
            SecondFragment frag = new SecondFragment();
            addFragment(frag, title, "TWO");
//            addFragment(frag, title, true);

        } else if (title.equals("ONE")) {
//            Intent i = new Intent(this, UserInvitesFragment.class);
//            startActivity(i);
            clearFragmentBackStack();
            FirstFragment frag = new FirstFragment();
            addFragment(frag, title, "ONE");
//            addFragment(frag, title, true);
        } else if (title.equals("THREE")) {
//            Intent i = new Intent(this, FragmentProfileMe.class);
//            startActivity(i);
            clearFragmentBackStack();
            ThirdFragment frag = new ThirdFragment();
            addFragment(frag, title, "THREE");
//            addFragment(frag, title, true);

        } else if (title.equals("FIVE")) {
            ViewUtils.showLogoutAlert(HomeFragmentActivity.this);
        } else {
            clearFragmentBackStack();
            FourthFragment frag = new FourthFragment();
//            addFragment(frag, title, true);
            addFragment(frag, title, "FOUR");
        }

        mDrawerLayout.closeDrawers();
    }

    /**
     * Custom adapter for drawer list
     */
    class DrawerAdpater extends BaseAdapter {
        String[] result;
        Context context;
        int[] imageId;
        LayoutInflater inflater = null;

        public DrawerAdpater(String[] prgmNameList, int[] prgmImages) {
            // TODO Auto-generated constructor stub
            result = prgmNameList;
            context = HomeFragmentActivity.this;
            imageId = prgmImages;
            inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Holder holder = new Holder();
            View rowView;
            rowView = inflater.inflate(R.layout.drawer_layout, null);
            holder.tv = (TextView) rowView.findViewById(R.id.text1);
            holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
            holder.tv.setText(result[position]);
            holder.img.setImageResource(imageId[position]);
            return rowView;
        }

        public class Holder {
            TextView tv;
            ImageView img;
        }

    }

}
