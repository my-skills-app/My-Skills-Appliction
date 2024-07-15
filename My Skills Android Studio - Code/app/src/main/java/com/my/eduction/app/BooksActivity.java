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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
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


public class BooksActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double limit = 0;
	private String key = "";
	
	private ArrayList<HashMap<String, Object>> map_list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout top_bg;
	private LinearLayout linear59;
	private LinearLayout bottam_navigation;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout surch_back;
	private TextView textview3;
	private LinearLayout linear52;
	private ImageView imageview1;
	private ListView Listview1;
	private ShimmerFrameLayout shimi;
	private ShimmerFrameLayout shimi2;
	private ShimmerFrameLayout shimi3;
	private CardView cardview2;
	private LinearLayout linear8;
	private TextView Title;
	private TextView Discrimination;
	private LinearLayout linear9;
	private TextView textview9;
	private TextView ul;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextView textview11;
	private CardView cardview3;
	private LinearLayout linear65;
	private TextView textview12;
	private TextView textview13;
	private LinearLayout linear66;
	private TextView textview14;
	private TextView textview15;
	private LinearLayout linear67;
	private LinearLayout linear68;
	private TextView textview16;
	private CardView cardview4;
	private LinearLayout linear70;
	private TextView textview17;
	private TextView textview18;
	private LinearLayout linear71;
	private TextView textview19;
	private TextView textview20;
	private LinearLayout linear72;
	private LinearLayout linear73;
	private TextView textview21;
	private LinearLayout linear61;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private ImageView imageview3;
	private TextView textview4;
	private ImageView imageview2;
	private ImageView imageview4;
	
	private Intent intent = new Intent();
	private DatabaseReference html = _firebase.getReference("video/html");
	private ChildEventListener _html_child_listener;
	private Vibrator vi;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.books);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		top_bg = findViewById(R.id.top_bg);
		linear59 = findViewById(R.id.linear59);
		bottam_navigation = findViewById(R.id.bottam_navigation);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		surch_back = findViewById(R.id.surch_back);
		textview3 = findViewById(R.id.textview3);
		linear52 = findViewById(R.id.linear52);
		imageview1 = findViewById(R.id.imageview1);
		Listview1 = findViewById(R.id.Listview1);
		shimi = findViewById(R.id.shimi);
		shimi2 = findViewById(R.id.shimi2);
		shimi3 = findViewById(R.id.shimi3);
		cardview2 = findViewById(R.id.cardview2);
		linear8 = findViewById(R.id.linear8);
		Title = findViewById(R.id.Title);
		Discrimination = findViewById(R.id.Discrimination);
		linear9 = findViewById(R.id.linear9);
		textview9 = findViewById(R.id.textview9);
		ul = findViewById(R.id.ul);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		textview11 = findViewById(R.id.textview11);
		cardview3 = findViewById(R.id.cardview3);
		linear65 = findViewById(R.id.linear65);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		linear66 = findViewById(R.id.linear66);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		linear67 = findViewById(R.id.linear67);
		linear68 = findViewById(R.id.linear68);
		textview16 = findViewById(R.id.textview16);
		cardview4 = findViewById(R.id.cardview4);
		linear70 = findViewById(R.id.linear70);
		textview17 = findViewById(R.id.textview17);
		textview18 = findViewById(R.id.textview18);
		linear71 = findViewById(R.id.linear71);
		textview19 = findViewById(R.id.textview19);
		textview20 = findViewById(R.id.textview20);
		linear72 = findViewById(R.id.linear72);
		linear73 = findViewById(R.id.linear73);
		textview21 = findViewById(R.id.textview21);
		linear61 = findViewById(R.id.linear61);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		imageview3 = findViewById(R.id.imageview3);
		textview4 = findViewById(R.id.textview4);
		imageview2 = findViewById(R.id.imageview2);
		imageview4 = findViewById(R.id.imageview4);
		vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		Listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				intent.putExtra("git", map_list.get((int)_position).get("video_git_url").toString());
				overridePendingTransition(android.
				R.anim.fade_in,
				android.R.anim.fade_out);
				vi.vibrate((long)(40));
				intent.setClass(getApplicationContext(), PdfVeiwerActivity.class);
				startActivity(intent);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vi.vibrate((long)(50));
				intent.setClass(getApplicationContext(), HomeActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vi.vibrate((long)(50));
				intent.setClass(getApplicationContext(), ProfileSectionActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		_html_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				html.addListenerForSingleValueEvent(new ValueEventListener() {
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
						Listview1.setAdapter(new Listview1Adapter(map_list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Listview1.setVisibility(View.VISIBLE);
				shimi.setVisibility(View.GONE);
				shimi2.setVisibility(View.GONE);
				shimi3.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				html.addListenerForSingleValueEvent(new ValueEventListener() {
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
						Listview1.setAdapter(new Listview1Adapter(map_list));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				Listview1.setVisibility(View.VISIBLE);
				shimi.setVisibility(View.GONE);
				shimi2.setVisibility(View.GONE);
				shimi3.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				html.addListenerForSingleValueEvent(new ValueEventListener() {
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
						Listview1.setAdapter(new Listview1Adapter(map_list));
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
		html.addChildEventListener(_html_child_listener);
	}
	
	private void initializeLogic() {
		_Uix();
		Listview1.setVisibility(View.GONE);
		shimi.setVisibility(View.VISIBLE);
		shimi2.setVisibility(View.VISIBLE);
		shimi3.setVisibility(View.VISIBLE);
		shimi.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFE0E0E0));
		shimi2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFE0E0E0));
		shimi3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFE0E0E0));
	}
	
	
	@Override
	public void onBackPressed() {
		vi.vibrate((long)(50));
		intent.setClass(getApplicationContext(), HomeActivity.class);
		intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent);
	}
	public void _Uix() {
		_removeScollBar(Listview1);
		_set_radius(top_bg, "#FF3500A5", 0, 0, 40, 40);
		surch_back.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 1);
		_set_radius(bottam_navigation, "#FF3500A5", 40, 40, 0, 0);
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#FF3500A5")); }
		
		
	}
	
	
	public void _set_radius(final View _view, final String _color, final double _left, final double _right, final double _bottom_left, final double _bottom_right) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadii(new float[] { (int)_left, (int)_left, (int)_right, (int)_right, (int)_bottom_right, (int)_bottom_right, (int)_bottom_left, (int)_bottom_left });
		_view.setBackground(gd);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
				_view = _inflater.inflate(R.layout.book_data, null);
			}
			
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final ImageView url = _view.findViewById(R.id.url);
			final TextView Title = _view.findViewById(R.id.Title);
			final TextView Discrimination = _view.findViewById(R.id.Discrimination);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView textview9 = _view.findViewById(R.id.textview9);
			final TextView ul = _view.findViewById(R.id.ul);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final TextView textview11 = _view.findViewById(R.id.textview11);
			
			linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)18, 0xFF3500A5));
			Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(300); linear11.startAnimation(animation); animation = null;
			if (map_list.get((int)_position).containsKey("Title_Book")) {
				Title.setText(map_list.get((int)_position).get("Title_Book").toString());
			}
			if (map_list.get((int)_position).containsKey("Image_url_Book")) {
				Glide.with(getApplicationContext()).load(Uri.parse(map_list.get((int)_position).get("Image_url_Book").toString())).into(url);
			}
			if (map_list.get((int)_position).containsKey("discription")) {
				Discrimination.setText(map_list.get((int)_position).get("discription").toString());
			}
			
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