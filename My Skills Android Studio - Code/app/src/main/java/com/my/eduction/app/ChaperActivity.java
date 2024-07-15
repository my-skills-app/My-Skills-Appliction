package com.my.eduction.app;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aghajari.waveanimation.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.facebook.shimmer.*;
import com.github.barteksc.pdfviewer.*;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
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
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class ChaperActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String path = "";
	private String key2 = "";
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout shimmer;
	private LinearLayout evolution;
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
	
	private DatabaseReference course = _firebase.getReference("Chapters");
	private ChildEventListener _course_child_listener;
	private Intent in = new Intent();
	private Vibrator v;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chaper);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		shimmer = findViewById(R.id.shimmer);
		evolution = findViewById(R.id.evolution);
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
		
		_course_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				course.addListenerForSingleValueEvent(new ValueEventListener() {
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
						shimmer.setVisibility(View.GONE);
						linear1.setVisibility(View.VISIBLE);
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
				course.addListenerForSingleValueEvent(new ValueEventListener() {
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
						shimmer.setVisibility(View.GONE);
						linear1.setVisibility(View.VISIBLE);
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
				course.addListenerForSingleValueEvent(new ValueEventListener() {
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
						shimmer.setVisibility(View.GONE);
						linear1.setVisibility(View.VISIBLE);
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
		course.addChildEventListener(_course_child_listener);
	}
	
	private void initializeLogic() {
		linear1.setVisibility(View.VISIBLE);
		shimmer.setVisibility(View.GONE);
		_shimmert();
		path = "Chapters/".concat(getIntent().getStringExtra("key"));
		course.removeEventListener(_course_child_listener);
		course = _firebase.getReference(path);
		course.addChildEventListener(_course_child_listener);
		key2 = getIntent().getStringExtra("key");
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
				_view = _inflater.inflate(R.layout.chapter, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView utl = _view.findViewById(R.id.utl);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView title = _view.findViewById(R.id.title);
			final TextView dis = _view.findViewById(R.id.dis);
			
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
			linear1.setElevation((int)5);
			Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(300); linear1.startAnimation(animation); animation = null;
			title.setText(_data.get((int)_position).get("name").toString());
			dis.setText(_data.get((int)_position).get("dis").toString());
			utl.setText(_data.get((int)_position).get("url").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					in.putExtra("url", _data.get((int)_position).get("url").toString());
					in.putExtra("Name", _data.get((int)_position).get("name").toString());
					overridePendingTransition(android.
					R.anim.fade_in,
					android.R.anim.fade_out);
					v.vibrate((long)(50));
					in.setClass(getApplicationContext(), VideoplayerActivity.class);
					startActivity(in);
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