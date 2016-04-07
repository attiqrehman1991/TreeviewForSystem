package com.example.attiqurrehmanrao.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public abstract class BaseFragment extends Fragment {
    //	private ProgressDialog progressDialog;
    //	protected SmoothBluetooth mSmoothBluetooth;
    protected Context mContext;
    //	public FragmentNavigationHelper fragmentHelper;
//	public String countryCode;
//	private SharedPreferences prefs;
    private View view;
    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            getTargetFragment().setMenuVisibility(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void onBackStackUpdate();

    @Override
    public void onStop() {
        super.onStop();
        try {
            getTargetFragment().setMenuVisibility(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            hideKeyboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
//			fragmentHelper = (FragmentNavigationHelper) context;
            mListener = (OnFragmentInteractionListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		if(this.view == null)
//			view = inflater.inflate(getLayoutId(), container, false);
//		view.setClickable(true);
//
//		return view;
//	}

//	@Override
//	public void onViewCreated(View view, Bundle savedInstanceState) {
//		super.onViewCreated(view, savedInstanceState);
//		initViews(view, savedInstanceState);
//	}

//	public FragmentNavigationHelper getHelper() {
//		return this.fragmentHelper;
////	}

//	public View getParentView() {
//		return this.view;
//	}

//	public abstract int getLayoutId();


//	public void initViews(View parent, Bundle savedInstanceState) {
//	}

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        setTargetFragment(null, -1);
    }


//	public SharedPreferences getSharedPreferences() {
//		return prefs;
//	}
//
//	public boolean shouldApplyAutoFontChanger() {
//		return false;
//	}

    public void onRefresh() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hideKeyboard();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }
//
//	public void showKeyboard(View view) {
//		InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//		inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
//	}
//
//	public void hideKeyboard(EditText input) {
//		InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//		imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
//	}

//	public void loadImage(String url, ImageView imageView) {
//		Picasso.with(getActivity()).load(url).into(imageView);
//	}
//
//	public void loadResizedImage(String url, ImageView imageView, int reqWidth, int reqHeight) {
//		Picasso.with(getActivity()).load(url).resize(reqWidth, reqHeight).into(imageView);
//	}

//	public void loadImage(String url, ImageView imageView, int radius, int margin) {
//		if(url == null || url.length() == 0 || url.equals("null")) {
//			return;
//		}
//		Picasso.with(getActivity())
//		.load(url).transform(new RoundedTransformation(radius, margin))
//		.into(imageView);
//	}

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
    /*
        Interface implemented to communicate with BaseFragmentActivity
	 */

    /*
         Method to replace one fragment to another fragment as well
                to change the title of actionBar using OnFragmentInteractionListener interface
     */
    protected void replaceFragment(BaseFragment f, String title, String clearBackStack) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, f);
        transaction.addToBackStack(clearBackStack);
        transaction.commit();
        if (mListener != null) {
            mListener.setFragmentTitle(title);
        }
    }

    protected void setTitle(String title) {
        if (mListener != null) {
            mListener.setFragmentTitle(title);
        }
    }
    /*	This makes sure that the container activity has implemented
        the callback interface. If not, it throws an exception
	 */

    protected void setSearchFragment() {
        if (mListener != null) {
            mListener.setSearchFragment();
        }
    }

    /*
             Method to clear the fragment stack by calling setClearBackStack
                    if firstDrawerIndex = true --> it will select the first index (profile) using OnFragmentInteractionListener interface
         */
    protected void resetFragment(boolean firstDrawerIndex) {
        setClearBackStack(firstDrawerIndex);
    }

    /*
        Clearing the stack of all added stack
     */
    protected void setClearBackStack(boolean firstDrawerIndex) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount() - 1; i++) {
            getActivity().getSupportFragmentManager().popBackStack();
            int size = fm.getBackStackEntryCount();
            Log.d("fragment stack size", size + "");
        }


//        if (!firstDrawerIndex) {
//            getActivity().getSupportFragmentManager().popBackStack();
//            FragmentUserInvites frag = new FragmentUserInvites();
//            replaceFragment(frag, "Invites", "Invites");
//        }

//        if (firstDrawerIndex) {
//        FragmentUserInvites frag = new FragmentUserInvites();
//        replaceFragment(frag, "Invites", "Invites");
        if (firstDrawerIndex && mListener != null) {
            mListener.resetFragments();
        }
//        } else {
//            FragmentProfileMe frag = new FragmentProfileMe();
//            replaceFragment(frag, "Profile", "Invites");
//        }

//		fm.beginTransaction().commit();
//		fm.executePendingTransactions();
//		int size = fm.getBackStackEntryCount();
//		Log.d("fragment stack size", size + "");
//		SearchForLastActiveFragment();
    }

//	@Override
//	public void onPause() {
//		super.onPause();
//		hideKeyboard();
//	}

    private void SearchForLastActiveFragment() {
        try {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            int numberOfFragments = fragmentManager.getFragments().size();
            Fragment fragmnet = null;
            for (int i = numberOfFragments - 1; i > 0 && fragmnet == null; i--) {
                fragmnet = getActivity().getSupportFragmentManager().getFragments().get(i);
                getActivity().getSupportFragmentManager().beginTransaction().detach(fragmnet).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface FragmentNavigationHelper {
        public void addFragment(BaseFragment f, String name, String clearBackStack);

        public void replaceFragment(BaseFragment f, String name, String clearBackStack);

        public void onBack();

        public void intiHeader(BaseFragment fragment);

        public void showToast(String msg);

    }

    public interface OnFragmentInteractionListener {
        public void setFragmentTitle(String title);

        public void resetFragments();

        public void setSearchFragment();
    }


//	public int getThumbnailSize() {
//		if(isTablet) {
//			return THUMBNAIL_SIZE_TABLET;
//		}
//		return THUMBNAIL_SIZE_PHONE;
//	}

//	public enum TransactionType {
//		ADD, REPLACE
//	}
//	public View implementViewClickAssociation(final View parent, int viewResId) {
//		View view = parent.findViewById(viewResId);
//		view.setOnClickListener(onClickListener);
//
//		return view;
//	}

//	public View.OnClickListener onClickListener = new View.OnClickListener() {
//		@Override
//		public void onClick(View v) {
//			onViewClicked(v);
//		}
//	};

//	protected void onViewClicked(View v) {
//	}
//	public SmoothBluetooth getBlueToot() throws Exception {
//		if(getActivity() instanceof BluetoothActivity){
//			return ((BluetoothActivity) getActivity()).getmSmoothBluetooth();
//		}else{
//			throw new IllegalAccessException("Activity should be BluetoothActivity");
//		}
//	}

    /**
     * show wait dialog
     */
//	public void showWaitDialog() {
//		try{
//			progressDialog = ProgressDialog.show(mContext, getString(R.string.app_name), getString(R.string.loading));
//		} catch (Exception e)
//		{}
//	}

    /**
     * hide wait dialog that is already displaying
     */
//	public void hideWaitDialog() {
//		try
//		{
//			if (progressDialog != null && progressDialog.isShowing()){
//				progressDialog.dismiss();
//			}
//		} catch (Exception e)
//		{}
//	}
//	public void showToast(String message){
//		Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
//	}
//	public void showToast(int message){
//		Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
//	}

}
