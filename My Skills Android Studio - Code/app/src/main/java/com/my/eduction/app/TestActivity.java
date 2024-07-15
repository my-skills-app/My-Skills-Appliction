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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class TestActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private ArrayList<HashMap<String, Object>> map_list = new ArrayList<>();
	
	private LinearLayout vis;
	private LinearLayout shim;
	private LinearLayout linear3;
	private ListView listview1;
	private TextView textview1;
	private LinearLayout linear4;
	private LinearLayout backs4ppp;
	private LinearLayout linear23sppp;
	private LinearLayout linear28pppppp;
	private TextView textview2;
	private ShimmerFrameLayout s1;
	private LinearLayout linear5;
	private ShimmerFrameLayout s2;
	private ShimmerFrameLayout s3;
	private ShimmerFrameLayout linear24s;
	private LinearLayout linear25;
	private ShimmerFrameLayout linear26s;
	private ShimmerFrameLayout linear27s;
	private ShimmerFrameLayout linear29s;
	private LinearLayout linear30;
	private ShimmerFrameLayout linear31s;
	private ShimmerFrameLayout linear32s;
	
	private DatabaseReference test = _firebase.getReference("Test/subject");
	private ChildEventListener _test_child_listener;
	private Intent intent = new Intent();
	private Vibrator v;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.test);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vis = findViewById(R.id.vis);
		shim = findViewById(R.id.shim);
		linear3 = findViewById(R.id.linear3);
		listview1 = findViewById(R.id.listview1);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		backs4ppp = findViewById(R.id.backs4ppp);
		linear23sppp = findViewById(R.id.linear23sppp);
		linear28pppppp = findViewById(R.id.linear28pppppp);
		textview2 = findViewById(R.id.textview2);
		s1 = findViewById(R.id.s1);
		linear5 = findViewById(R.id.linear5);
		s2 = findViewById(R.id.s2);
		s3 = findViewById(R.id.s3);
		linear24s = findViewById(R.id.linear24s);
		linear25 = findViewById(R.id.linear25);
		linear26s = findViewById(R.id.linear26s);
		linear27s = findViewById(R.id.linear27s);
		linear29s = findViewById(R.id.linear29s);
		linear30 = findViewById(R.id.linear30);
		linear31s = findViewById(R.id.linear31s);
		linear32s = findViewById(R.id.linear32s);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		_test_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				test.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(map_list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								v.vibrate((long)(50));
								vis.setVisibility(View.VISIBLE);
								shim.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(2000));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				test.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(map_list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								v.vibrate((long)(50));
								vis.setVisibility(View.VISIBLE);
								shim.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(2000));
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				test.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(map_list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				v.vibrate((long)(50));
				vis.setVisibility(View.VISIBLE);
				shim.setVisibility(View.GONE);
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		test.addChildEventListener(_test_child_listener);
	}
	
	private void initializeLogic() {
		_removeScollBar(listview1);
		_set_radius(linear3, "#FF3500A5", 0, 0, 40, 40);
		_set_radius(linear4, "#FF3500A5", 0, 0, 40, 40);
		vis.setVisibility(View.GONE);
		shim.setVisibility(View.VISIBLE);
		_shimr();
	}
	
	@Override
	public void onBackPressed() {
		v.vibrate((long)(50));
		intent.setClass(getApplicationContext(), HomeActivity.class);
		intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent);
	}
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _set_radius(final View _view, final String _color, final double _left, final double _right, final double _bottom_left, final double _bottom_right) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadii(new float[] { (int)_left, (int)_left, (int)_right, (int)_right, (int)_bottom_right, (int)_bottom_right, (int)_bottom_left, (int)_bottom_left });
		_view.setBackground(gd);
	}
	
	
	public void _shimr() {
		backs4ppp.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		backs4ppp.setElevation((int)5);
		linear23sppp.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		linear23sppp.setElevation((int)5);
		linear28pppppp.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		linear28pppppp.setElevation((int)5);
		s1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		s2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		s3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear24s.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear26s.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear27s.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear29s.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear31s.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear32s.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
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
				_view = _inflater.inflate(R.layout.test_data, null);
			}
			
			final LinearLayout back = _view.findViewById(R.id.back);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView title = _view.findViewById(R.id.title);
			final TextView subject = _view.findViewById(R.id.subject);
			final TextView dis = _view.findViewById(R.id.dis);
			final TextView date = _view.findViewById(R.id.date);
			
			back.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)21, 0xFFFFFFFF));
			back.setElevation((int)5);
			Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(300); back.startAnimation(animation); animation = null;
			if (map_list.get((int)_position).containsKey("subject")) {
				subject.setText(map_list.get((int)_position).get("subject").toString());
			}
			if (map_list.get((int)_position).containsKey("date")) {
				date.setText(map_list.get((int)_position).get("date").toString());
			}
			back.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.putExtra("url", map_list.get((int)_position).get("url").toString());
					overridePendingTransition(android.
					R.anim.fade_in,
					android.R.anim.fade_out);
					v.vibrate((long)(40));
					intent.setClass(getApplicationContext(), TestFilActivity.class);
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