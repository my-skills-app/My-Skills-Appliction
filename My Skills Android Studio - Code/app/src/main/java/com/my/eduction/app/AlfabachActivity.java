package com.my.eduction.app;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aghajari.waveanimation.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.facebook.shimmer.*;
import com.github.barteksc.pdfviewer.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.smarteist.autoimageslider.*;
import com.unity3d.ads.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class AlfabachActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private ArrayList<HashMap<String, Object>> map_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private LinearLayout main;
	private LinearLayout shimmer;
	private LinearLayout evolution;
	private LinearLayout line;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private ListView listview1;
	private LinearLayout linear4;
	private LinearLayout card;
	private LinearLayout linear8;
	private TextView title;
	private TextView textview1;
	private TextView user_name;
	private ImageView greentick;
	private TextView textview8;
	private ImageView imageview1;
	private LinearLayout box1;
	private LinearLayout box2;
	private LinearLayout box3;
	private LinearLayout box4;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout cardbener;
	private CardView cardview1;
	private ImageView url;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextView textview9;
	private TextView course_name;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private LinearLayout linear31;
	private ShimmerFrameLayout sh10;
	private ShimmerFrameLayout sh9;
	private ShimmerFrameLayout sh8;
	private LinearLayout linear32;
	private LinearLayout linear33;
	private ShimmerFrameLayout sh1;
	private TextView textview21;
	private ImageView imageview4;
	private ShimmerFrameLayout sh2;
	private ShimmerFrameLayout sh3;
	private ShimmerFrameLayout sh4;
	private ShimmerFrameLayout sh5;
	private ShimmerFrameLayout sh6;
	private ShimmerFrameLayout sh7;
	private LinearLayout linear41;
	
	private Intent i = new Intent();
	private Intent intent = new Intent();
	private Vibrator v;
	private TimerTask t;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private DatabaseReference courses = _firebase.getReference("Subjects");
	private ChildEventListener _courses_child_listener;
	private DatabaseReference datalist = _firebase.getReference("playlist_ditels");
	private ChildEventListener _datalist_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.alfabach);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		main = findViewById(R.id.main);
		shimmer = findViewById(R.id.shimmer);
		evolution = findViewById(R.id.evolution);
		line = findViewById(R.id.line);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear9 = findViewById(R.id.linear9);
		listview1 = findViewById(R.id.listview1);
		linear4 = findViewById(R.id.linear4);
		card = findViewById(R.id.card);
		linear8 = findViewById(R.id.linear8);
		title = findViewById(R.id.title);
		textview1 = findViewById(R.id.textview1);
		user_name = findViewById(R.id.user_name);
		greentick = findViewById(R.id.greentick);
		textview8 = findViewById(R.id.textview8);
		imageview1 = findViewById(R.id.imageview1);
		box1 = findViewById(R.id.box1);
		box2 = findViewById(R.id.box2);
		box3 = findViewById(R.id.box3);
		box4 = findViewById(R.id.box4);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		cardbener = findViewById(R.id.cardbener);
		cardview1 = findViewById(R.id.cardview1);
		url = findViewById(R.id.url);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		textview9 = findViewById(R.id.textview9);
		course_name = findViewById(R.id.course_name);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		linear29 = findViewById(R.id.linear29);
		linear30 = findViewById(R.id.linear30);
		linear31 = findViewById(R.id.linear31);
		sh10 = findViewById(R.id.sh10);
		sh9 = findViewById(R.id.sh9);
		sh8 = findViewById(R.id.sh8);
		linear32 = findViewById(R.id.linear32);
		linear33 = findViewById(R.id.linear33);
		sh1 = findViewById(R.id.sh1);
		textview21 = findViewById(R.id.textview21);
		imageview4 = findViewById(R.id.imageview4);
		sh2 = findViewById(R.id.sh2);
		sh3 = findViewById(R.id.sh3);
		sh4 = findViewById(R.id.sh4);
		sh5 = findViewById(R.id.sh5);
		sh6 = findViewById(R.id.sh6);
		sh7 = findViewById(R.id.sh7);
		linear41 = findViewById(R.id.linear41);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		auth = FirebaseAuth.getInstance();
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("Verified")) {
						if (_childValue.get("Verified").toString().equals("true")) {
							greentick.setVisibility(View.VISIBLE);
						}
						else {
							greentick.setVisibility(View.GONE);
						}
					}
					user_name.setText(_childValue.get("User_Name").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("Verified")) {
						if (_childValue.get("Verified").toString().equals("true")) {
							greentick.setVisibility(View.VISIBLE);
						}
						else {
							greentick.setVisibility(View.GONE);
						}
					}
					user_name.setText(_childValue.get("User_Name").toString());
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("Verified")) {
						if (_childValue.get("Verified").toString().equals("true")) {
							greentick.setVisibility(View.VISIBLE);
						}
						else {
							greentick.setVisibility(View.GONE);
						}
					}
					user_name.setText(_childValue.get("User_Name").toString());
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		user.addChildEventListener(_user_child_listener);
		
		_courses_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				courses.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listMap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listMap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						main.setVisibility(View.VISIBLE);
						shimmer.setVisibility(View.GONE);
						listview1.setAdapter(new Listview1Adapter(listMap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				courses.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listMap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listMap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						main.setVisibility(View.VISIBLE);
						shimmer.setVisibility(View.GONE);
						listview1.setAdapter(new Listview1Adapter(listMap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				courses.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listMap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listMap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						main.setVisibility(View.VISIBLE);
						shimmer.setVisibility(View.GONE);
						listview1.setAdapter(new Listview1Adapter(listMap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		courses.addChildEventListener(_courses_child_listener);
		
		_datalist_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("title")) {
					title.setText(_childValue.get("title").toString());
				}
				if (_childValue.containsKey("url")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("url").toString())).into(url);
				}
				if (_childValue.containsKey("course_name")) {
					course_name.setText(_childValue.get("course_name").toString());
				}
				if (_childValue.containsKey("course_d")) {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("title")) {
					title.setText(_childValue.get("title").toString());
				}
				if (_childValue.containsKey("url")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("url").toString())).into(url);
				}
				if (_childValue.containsKey("course_name")) {
					course_name.setText(_childValue.get("course_name").toString());
				}
				if (_childValue.containsKey("course_d")) {
					
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("title")) {
					title.setText(_childValue.get("title").toString());
				}
				if (_childValue.containsKey("url")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("url").toString())).into(url);
				}
				if (_childValue.containsKey("course_name")) {
					course_name.setText(_childValue.get("course_name").toString());
				}
				if (_childValue.containsKey("course_d")) {
					
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		datalist.addChildEventListener(_datalist_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_shimmert();
		_uix();
		//course_lounch/video_list1
		//playlist_ditels
		main.setVisibility(View.GONE);
		shimmer.setVisibility(View.VISIBLE);
	}
	
	public void _shimmert() {
		sh1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		sh10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _uix() {
		evolution.setElevation((int)3);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		card.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFF3500A5, 0xFFFFFFFF));
		box1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFFFFFFFF, 0xFF3500A5));
		box4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFF5C6BC0, 0xFFE8EAF6));
		box2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFF3500A5, 0xFFE8EAF6));
		box3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFF3500A5, 0xFFE8EAF6));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 0);
		title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 1);
		url.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFFFFFFF));
		cardbener.setElevation((int)10);
		url.setElevation((int)10);
		cardbener.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFFFFFFF));
		_removeScollBar(listview1);
	}
	
	
	public void _refreshList() {
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.video_list, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView url = _view.findViewById(R.id.url);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView title = _view.findViewById(R.id.title);
			final TextView dis = _view.findViewById(R.id.dis);
			
			Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(300); linear1.startAnimation(animation); animation = null;
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
			linear1.setElevation((int)5);
			title.setText(_data.get((int)_position).get("name").toString());
			dis.setText(_data.get((int)_position).get("icon").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					courses.child(_data.get((int)_position).get("key").toString()).removeValue();
					_refreshList();
				}
			});
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ChaperActivity.class);
					intent.putExtra("key", _data.get((int)_position).get("key").toString());
					startActivity(intent);
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}