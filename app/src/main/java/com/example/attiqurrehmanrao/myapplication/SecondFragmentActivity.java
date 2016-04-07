package com.example.attiqurrehmanrao.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.attiqrao.systems.tree.holder.IconTreeItemHolder;
import com.attiqrao.systems.tree.model.TreeNode;
import com.attiqrao.systems.tree.view.AndroidTreeView;

/**
 * Updated by Attiq ur Rehman on 04/05/2016
 */
public class SecondFragmentActivity extends BaseFragmentActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    TextView tvName, tvEmail;
    FirstFragment fragP;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerList;
    private AndroidTreeView androidTreeView;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_second_fragment;
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
        mDrawerList = (RelativeLayout) findViewById(R.id.left_drawer);

        addRoots(mDrawerList);
//        imgNavi = (ImageView) findViewById(R.id.navi);
        //set adapter for drawerlist
        setListHeader();

        DrawerAdpater drawerAdpater = new DrawerAdpater(navMenuTitles, navMenuDrawer);
//        mDrawerList.setAdapter(drawerAdpater);
//
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item, navMenuTitles));

//        setListHeader();

//        mDrawerList.setAdapter(new DrawarListAdapter(this, new ArrayList<String>(Arrays.asList(navMenuTitles))));

        //set the lists's click listener
//        mDrawerList.setOnItemClickListener(this);
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

    private void addRoots(RelativeLayout layout) {
        TreeNode root = TreeNode.root();
        TreeNode irrigation = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_irrigation, "Irrigation"));
        TreeNode development = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_development, "Development"));
        TreeNode flood = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_flood, "Flood"));
        TreeNode drainage = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_drainage, "Drainage"));

        TreeNode bahawalpurZone = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur Zone"));
        TreeNode lahoreZone = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Lahore Zone"));
        TreeNode faislabadZone = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Faisalabad Zone"));
        TreeNode multanZone = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Multan Zone"));
        TreeNode sargodhaZone = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Sargodha Zone"));

        TreeNode bahawalpurCircle = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur"));
        TreeNode bahawalnagarCircle = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalnagar"));
        TreeNode rahimyarKhanCircle = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Rahimyar Khan"));
        TreeNode developmentCircleCircle = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Development Circle"));

        TreeNode bahawalpurDivision =new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur"));
        TreeNode ahmedpurDivision = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Ahmedpur"));
        TreeNode punjnad_headworksDivision = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Punjnad Headworks"));
        TreeNode mailsi_syphonDivision = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Mailsi Syphon"));
        TreeNode development_division_bahawalpurDivision = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Development Division"));

        TreeNode abbasiaSubDivision =new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur"));
        TreeNode ahmedpurSubDivision = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Ahmedpur"));
        TreeNode kotaMusaKhanSubDivision = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Punjnad Headworks"));

        TreeNode chanigarhSection =new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur"));
        TreeNode ferozaSection = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Ahmedpur"));
        TreeNode liaqatpurSection = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Punjnad Headworks"));
        TreeNode metlaSection =new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur"));
        TreeNode qasimwalaSection = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Ahmedpur"));

        abbasiaSubDivision.addChildren(chanigarhSection, ferozaSection, liaqatpurSection, metlaSection, qasimwalaSection);
        bahawalpurDivision.addChildren(abbasiaSubDivision, ahmedpurSubDivision, kotaMusaKhanSubDivision);
        bahawalpurCircle.addChildren(bahawalpurDivision, ahmedpurDivision, punjnad_headworksDivision, mailsi_syphonDivision, development_division_bahawalpurDivision);
        bahawalpurZone.addChildren(bahawalpurCircle, bahawalnagarCircle, rahimyarKhanCircle, developmentCircleCircle);
        irrigation.addChildren(bahawalpurZone, lahoreZone, faislabadZone, multanZone, sargodhaZone);
        root.addChildren(irrigation, development, flood, drainage);

        androidTreeView = new AndroidTreeView(this, root);
        androidTreeView.setDefaultAnimation(true);
        androidTreeView.setDefaultContainerStyle(R.style.TreeNodeStyleCustom);
        androidTreeView.setDefaultViewHolder(IconTreeItemHolder.class);
        androidTreeView.setDefaultNodeClickListener(nodeClickListener);

        layout.addView(androidTreeView.getView());
    }

//    private void addRoots(RelativeLayout layout) {
//        TreeNode root = TreeNode.root();
//        TreeNode irrigation = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_irrigation, "Irrigation")).setViewHolder(new ProfileHolder(this));
//        TreeNode development = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_development, "Development")).setViewHolder(new ProfileHolder(this));
//        TreeNode flood = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_flood, "Flood")).setViewHolder(new ProfileHolder(this));
//        TreeNode drainage = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_drainage, "Drainage")).setViewHolder(new ProfileHolder(this));
//        addZoneData(irrigation);
//
//        root.addChildren(irrigation, development, flood, drainage);
//        androidTreeView = new AndroidTreeView(this, root);
//        androidTreeView.setDefaultAnimation(true);
//        androidTreeView.setDefaultContainerStyle(R.style.TreeNodeStyleDivided, true);
//        androidTreeView.setDefaultNodeClickListener(nodeClickListener);
//        layout.addView(androidTreeView.getView());
//    }

    private TreeNode previousNode = null;
    private TreeNode.TreeNodeClickListener nodeClickListener = new TreeNode.TreeNodeClickListener() {
        @Override
        public void onClick(TreeNode node, Object value) {
            IconTreeItemHolder.IconTreeItem item = (IconTreeItemHolder.IconTreeItem) value;
            if(previousNode!=null && node.getParent() == previousNode.getParent()) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                FivthFragment fivthFragment= new FivthFragment();

                Bundle args = new Bundle();
                args.putString("name", item.text);
                fivthFragment.setArguments(args);

                clearFragmentBackStack();
                fragmentTransaction.add(R.id.fragment_container, fivthFragment);
                fragmentTransaction.commit();
                closeDrawer();
            }
            previousNode = node;
//            Toast.makeText(SecondFragmentActivity.this, item.text, Toast.LENGTH_SHORT).show();
        }
    };

//    private void addZoneData(TreeNode domain) {
//        TreeNode bahawalpur = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur Zone")).setViewHolder(new HeaderHolder(this));
//        TreeNode lahore = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Lahore Zone")).setViewHolder(new HeaderHolder(this));
//        TreeNode faislabad = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Faisalabad Zone")).setViewHolder(new HeaderHolder(this));
//        TreeNode multan = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Multan Zone")).setViewHolder(new HeaderHolder(this));
//        TreeNode sargodha = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Sargodha Zone")).setViewHolder(new HeaderHolder(this));
//        addCircleData(bahawalpur);
//
//        domain.addChildren(bahawalpur, lahore, faislabad, multan, sargodha);
//    }
//
//    private void addCircleData(TreeNode zone) {
//        TreeNode bahawalpur = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur")).setViewHolder(new HeaderHolder(this));
//        TreeNode bahawalnagar = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalnagar")).setViewHolder(new HeaderHolder(this));
//        TreeNode rahimyarKhan = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Rahimyar Khan")).setViewHolder(new HeaderHolder(this));
//        TreeNode developmentCircle = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Development Circle")).setViewHolder(new HeaderHolder(this));
//        addDivisionData(bahawalpur);
//
//        zone.addChildren(bahawalpur, bahawalnagar, rahimyarKhan, developmentCircle);
//    }
//
//    private void addDivisionData(TreeNode circle) {
//        TreeNode bahawalpur =new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Bahawalpur")).setViewHolder(new HeaderHolder(this));
//        TreeNode ahmedpur = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Ahmedpur")).setViewHolder(new HeaderHolder(this));
//        TreeNode punjnad_headworks = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Punjnad Headworks")).setViewHolder(new HeaderHolder(this));
//        TreeNode mailsi_syphon = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Mailsi Syphon")).setViewHolder(new HeaderHolder(this));
//        TreeNode development_division_bahawalpur = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, "Development Division")).setViewHolder(new HeaderHolder(this));
//        addSubDivisionData(bahawalpur);
//
//        circle.addChildren(bahawalpur, ahmedpur, punjnad_headworks, mailsi_syphon, development_division_bahawalpur);
//    }
//
//    private void addSubDivisionData(TreeNode division) {
//        TreeNode abbasia = new TreeNode("Abbasia").setViewHolder(new SelectableItemHolder(this));
//        TreeNode ahmedpur = new TreeNode("Ahmedpur").setViewHolder(new SelectableItemHolder(this));
//        TreeNode kotlaMusaKhan = new TreeNode("Kotla Musa Khan").setViewHolder(new SelectableItemHolder(this));
//        division.addChildren(abbasia, ahmedpur, kotlaMusaKhan);
//    }

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
//        mDrawerList.performItemClick(
//                mDrawerList.getChildAt(1),
//                1,
//                mDrawerList.getAdapter().getItemId(1));
//        clearFragmentBackStack();
//        FragmentProfileMe frag = new FragmentProfileMe();
//        addFragment(frag, "Profile", "Profile");

    }

    @Override
    public void setSearchFragment() {
//        mDrawerList.performItemClick(mDrawerList.getAdapter().getView(0, null, null), 2, mDrawerList.getItemIdAtPosition(2));
//        mDrawerList.performItemClick(
//                mDrawerList.getChildAt(3),
//                3,
//                mDrawerList.getAdapter().getItemId(3));
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
//        mDrawerList.performItemClick(
//                mDrawerList.getChildAt(1),
//                1,
//                mDrawerList.getAdapter().getItemId(1));
//        clearFragmentBackStack();
//        FragmentProfileMe frag = new FragmentProfileMe();
//        addFragment(frag, "Profile", "Profile");

    }

    private void setListHeader() {
        View view = LayoutInflater.from(this).inflate(R.layout.drawar_header, null);
//        try {
//            mDrawerList.addHeaderView(view);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

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
            ViewUtils.showLogoutAlert(SecondFragmentActivity.this);
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
            context = SecondFragmentActivity.this;
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
