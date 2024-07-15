package com.my.eduction.app;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double slider_count = 0;
	private double position = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String package_name = "";
	private String ver = "";
	private String version = "";
	
	private ArrayList<HashMap<String, Object>> slidermap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> book = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> update_map = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout top_bg;
	private LinearLayout linear59;
	private LinearLayout bottam_navigation;
	private LinearLayout linear97;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private LinearLayout linear98;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout pro;
	private ImageView imageview15;
	private TextView textview66;
	private LinearLayout surch_back;
	private TextView textview3;
	private LinearLayout linear52;
	private ImageView imageview1;
	private LinearLayout linear4;
	private LinearLayout linear64;
	private ShimmerFrameLayout shimmer;
	private ViewPager viewpager1;
	private LinearLayout linear_dots;
	private LinearLayout dot1;
	private LinearLayout dot2;
	private LinearLayout dot3;
	private LinearLayout dot4;
	private LinearLayout dot5;
	private ScrollView vscroll1;
	private LinearLayout linear12;
	private LinearLayout shimi;
	private LinearLayout linear15;
	private LinearLayout itom_bg;
	private LinearLayout linear93;
	private LinearLayout scrol_noti;
	private LinearLayout linear14;
	private LinearLayout linear89;
	private LinearLayout linear90;
	private LinearLayout linear91;
	private LinearLayout linear92;
	private ShimmerFrameLayout shimer_box2;
	private ShimmerFrameLayout shimer_box1;
	private ShimmerFrameLayout shimer_box3;
	private TextView textview63;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout happy_box;
	private ImageView imageview5;
	private TextView trust;
	private TextView textview10;
	private LinearLayout member_box;
	private ImageView imageview6;
	private TextView teacher;
	private TextView textview11;
	private LinearLayout google_box;
	private ImageView imageview7;
	private TextView rate;
	private TextView textview12;
	private ShimmerFrameLayout linear94;
	private LinearLayout linear95;
	private LinearLayout linear96;
	private TextView textview64;
	private TextView textview65;
	private LinearLayout linear16;
	private LinearLayout linear19;
	private ImageView imageview8;
	private TextView manse_tech7;
	private TextView desh_techu;
	private LinearLayout linear34;
	private LinearLayout engn;
	private LinearLayout linear65;
	private LinearLayout linear86;
	private LinearLayout linear36;
	private LinearLayout linear51;
	private TextView collage_head;
	private LinearLayout linear87;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private LinearLayout paid;
	private ImageView imageview9;
	private TextView textview16;
	private LinearLayout demo_class;
	private ImageView imageview10;
	private TextView textview17;
	private LinearLayout test;
	private ImageView imageview11;
	private TextView textview18;
	private LinearLayout linear37;
	private LinearLayout linear38;
	private LinearLayout linear39;
	private LinearLayout study_m;
	private ImageView imageview12;
	private TextView textview13;
	private LinearLayout pyq;
	private ImageView imageview13;
	private TextView textview14;
	private LinearLayout vvi;
	private ImageView imageview14;
	private TextView textview15;
	private TextView textview21;
	private LinearLayout linear61;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private ImageView imageview3;
	private ImageView imageview2;
	private TextView textview4;
	private ImageView imageview4;
	
	private DatabaseReference slider = _firebase.getReference("other/slider");
	private ChildEventListener _slider_child_listener;
	private SharedPreferences data;
	private Intent intent = new Intent();
	private TimerTask slider_timer;
	private Intent inten = new Intent();
	private TimerTask t;
	private DatabaseReference db = _firebase.getReference("Dashboard/data");
	private ChildEventListener _db_child_listener;
	private Vibrator vabrat;
	private RequestNetwork rq;
	private RequestNetwork.RequestListener _rq_request_listener;
	private Intent i = new Intent();
	private SharedPreferences sp;
	private Intent in = new Intent();
	private DatabaseReference update = _firebase.getReference("update");
	private ChildEventListener _update_child_listener;
	private Intent update_intent = new Intent();
	private AlertDialog.Builder d;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		top_bg = findViewById(R.id.top_bg);
		linear59 = findViewById(R.id.linear59);
		bottam_navigation = findViewById(R.id.bottam_navigation);
		linear97 = findViewById(R.id.linear97);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		linear98 = findViewById(R.id.linear98);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		pro = findViewById(R.id.pro);
		imageview15 = findViewById(R.id.imageview15);
		textview66 = findViewById(R.id.textview66);
		surch_back = findViewById(R.id.surch_back);
		textview3 = findViewById(R.id.textview3);
		linear52 = findViewById(R.id.linear52);
		imageview1 = findViewById(R.id.imageview1);
		linear4 = findViewById(R.id.linear4);
		linear64 = findViewById(R.id.linear64);
		shimmer = findViewById(R.id.shimmer);
		viewpager1 = findViewById(R.id.viewpager1);
		linear_dots = findViewById(R.id.linear_dots);
		dot1 = findViewById(R.id.dot1);
		dot2 = findViewById(R.id.dot2);
		dot3 = findViewById(R.id.dot3);
		dot4 = findViewById(R.id.dot4);
		dot5 = findViewById(R.id.dot5);
		vscroll1 = findViewById(R.id.vscroll1);
		linear12 = findViewById(R.id.linear12);
		shimi = findViewById(R.id.shimi);
		linear15 = findViewById(R.id.linear15);
		itom_bg = findViewById(R.id.itom_bg);
		linear93 = findViewById(R.id.linear93);
		scrol_noti = findViewById(R.id.scrol_noti);
		linear14 = findViewById(R.id.linear14);
		linear89 = findViewById(R.id.linear89);
		linear90 = findViewById(R.id.linear90);
		linear91 = findViewById(R.id.linear91);
		linear92 = findViewById(R.id.linear92);
		shimer_box2 = findViewById(R.id.shimer_box2);
		shimer_box1 = findViewById(R.id.shimer_box1);
		shimer_box3 = findViewById(R.id.shimer_box3);
		textview63 = findViewById(R.id.textview63);
		linear25 = findViewById(R.id.linear25);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		happy_box = findViewById(R.id.happy_box);
		imageview5 = findViewById(R.id.imageview5);
		trust = findViewById(R.id.trust);
		textview10 = findViewById(R.id.textview10);
		member_box = findViewById(R.id.member_box);
		imageview6 = findViewById(R.id.imageview6);
		teacher = findViewById(R.id.teacher);
		textview11 = findViewById(R.id.textview11);
		google_box = findViewById(R.id.google_box);
		imageview7 = findViewById(R.id.imageview7);
		rate = findViewById(R.id.rate);
		textview12 = findViewById(R.id.textview12);
		linear94 = findViewById(R.id.linear94);
		linear95 = findViewById(R.id.linear95);
		linear96 = findViewById(R.id.linear96);
		textview64 = findViewById(R.id.textview64);
		textview65 = findViewById(R.id.textview65);
		linear16 = findViewById(R.id.linear16);
		linear19 = findViewById(R.id.linear19);
		imageview8 = findViewById(R.id.imageview8);
		manse_tech7 = findViewById(R.id.manse_tech7);
		desh_techu = findViewById(R.id.desh_techu);
		linear34 = findViewById(R.id.linear34);
		engn = findViewById(R.id.engn);
		linear65 = findViewById(R.id.linear65);
		linear86 = findViewById(R.id.linear86);
		linear36 = findViewById(R.id.linear36);
		linear51 = findViewById(R.id.linear51);
		collage_head = findViewById(R.id.collage_head);
		linear87 = findViewById(R.id.linear87);
		linear45 = findViewById(R.id.linear45);
		linear46 = findViewById(R.id.linear46);
		paid = findViewById(R.id.paid);
		imageview9 = findViewById(R.id.imageview9);
		textview16 = findViewById(R.id.textview16);
		demo_class = findViewById(R.id.demo_class);
		imageview10 = findViewById(R.id.imageview10);
		textview17 = findViewById(R.id.textview17);
		test = findViewById(R.id.test);
		imageview11 = findViewById(R.id.imageview11);
		textview18 = findViewById(R.id.textview18);
		linear37 = findViewById(R.id.linear37);
		linear38 = findViewById(R.id.linear38);
		linear39 = findViewById(R.id.linear39);
		study_m = findViewById(R.id.study_m);
		imageview12 = findViewById(R.id.imageview12);
		textview13 = findViewById(R.id.textview13);
		pyq = findViewById(R.id.pyq);
		imageview13 = findViewById(R.id.imageview13);
		textview14 = findViewById(R.id.textview14);
		vvi = findViewById(R.id.vvi);
		imageview14 = findViewById(R.id.imageview14);
		textview15 = findViewById(R.id.textview15);
		textview21 = findViewById(R.id.textview21);
		linear61 = findViewById(R.id.linear61);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		imageview3 = findViewById(R.id.imageview3);
		imageview2 = findViewById(R.id.imageview2);
		textview4 = findViewById(R.id.textview4);
		imageview4 = findViewById(R.id.imageview4);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		vabrat = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		rq = new RequestNetwork(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				if (_position == 0) {
					dot1.setAlpha((float)(1));
					dot2.setAlpha((float)(0.5d));
					dot3.setAlpha((float)(0.5d));
					dot4.setAlpha((float)(0.5d));
					dot5.setAlpha((float)(0.5d));
				}
				if (_position == 1) {
					dot1.setAlpha((float)(0.5d));
					dot2.setAlpha((float)(1));
					dot3.setAlpha((float)(0.5d));
					dot4.setAlpha((float)(0.5d));
					dot5.setAlpha((float)(0.5d));
				}
				if (_position == 2) {
					dot1.setAlpha((float)(0.5d));
					dot2.setAlpha((float)(0.5d));
					dot3.setAlpha((float)(1));
					dot4.setAlpha((float)(0.5d));
					dot5.setAlpha((float)(0.5d));
				}
				if (_position == 3) {
					dot1.setAlpha((float)(0.5d));
					dot2.setAlpha((float)(0.5d));
					dot3.setAlpha((float)(0.5d));
					dot4.setAlpha((float)(1));
					dot5.setAlpha((float)(0.5d));
				}
				if (_position == 4) {
					dot1.setAlpha((float)(0.5d));
					dot2.setAlpha((float)(0.5d));
					dot3.setAlpha((float)(0.5d));
					dot4.setAlpha((float)(0.5d));
					dot5.setAlpha((float)(1));
				}
				if (_position == 5) {
					dot1.setAlpha((float)(0.5d));
					dot2.setAlpha((float)(0.5d));
					dot3.setAlpha((float)(0.5d));
					dot4.setAlpha((float)(0.5d));
					dot5.setAlpha((float)(0.5d));
				}
			}
			
			@Override
			public void onPageSelected(int _position) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		happy_box.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(40));
				intent.setClass(getApplicationContext(), UnityActivity.class);
				startActivity(intent);
			}
		});
		
		member_box.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(40));
				intent.setClass(getApplicationContext(), ChatGptActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		paid.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(40));
				intent.setClass(getApplicationContext(), CoursePageActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		demo_class.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(50));
				intent.setClass(getApplicationContext(), PlaylistActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		test.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(50));
				intent.setClass(getApplicationContext(), TestActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(50));
				intent.setClass(getApplicationContext(), BooksActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vabrat.vibrate((long)(50));
				intent.setClass(getApplicationContext(), ProfileSectionActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		_slider_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("slider")) {
					if (_childValue.containsKey("slider1")) {
						data.edit().putString("img1", _childValue.get("slider1").toString()).commit();
					}
					if (_childValue.containsKey("slider2")) {
						data.edit().putString("img2", _childValue.get("slider2").toString()).commit();
					}
					if (_childValue.containsKey("slider3")) {
						data.edit().putString("img3", _childValue.get("slider3").toString()).commit();
					}
					if (_childValue.containsKey("slider4")) {
						data.edit().putString("img4", _childValue.get("slider4").toString()).commit();
					}
					if (_childValue.containsKey("slider5")) {
						data.edit().putString("img5", _childValue.get("slider5").toString()).commit();
					}
					if (_childValue.containsKey("slider6")) {
						data.edit().putString("img6", _childValue.get("slider6").toString()).commit();
					}
					if (_childValue.containsKey("icon1")) {
						data.edit().putString("icon1", _childValue.get("icon1").toString()).commit();
					}
					if (_childValue.containsKey("icon2")) {
						data.edit().putString("icon2", _childValue.get("icon2").toString()).commit();
					}
					if (_childValue.containsKey("icon3")) {
						data.edit().putString("icon3", _childValue.get("icon3").toString()).commit();
					}
					if (_childValue.containsKey("icon4")) {
						data.edit().putString("icon4", _childValue.get("icon4").toString()).commit();
					}
					if (_childValue.containsKey("icon5")) {
						data.edit().putString("icon5", _childValue.get("icon5").toString()).commit();
					}
					if (_childValue.containsKey("icon6")) {
						data.edit().putString("icon6", _childValue.get("icon6").toString()).commit();
					}
					if (_childValue.containsKey("title1")) {
						data.edit().putString("title1", _childValue.get("title1").toString()).commit();
					}
					if (_childValue.containsKey("title2")) {
						data.edit().putString("title2", _childValue.get("title2").toString()).commit();
					}
					if (_childValue.containsKey("title3")) {
						data.edit().putString("title3", _childValue.get("title3").toString()).commit();
					}
					if (_childValue.containsKey("title4")) {
						data.edit().putString("title4", _childValue.get("title4").toString()).commit();
					}
					if (_childValue.containsKey("title5")) {
						data.edit().putString("title5", _childValue.get("title5").toString()).commit();
					}
					if (_childValue.containsKey("title6")) {
						data.edit().putString("title6", _childValue.get("title6").toString()).commit();
					}
					shimmer.setVisibility(View.GONE);
					overridePendingTransition(android.
					R.anim.fade_in,
					android.R.anim.fade_out);
					viewpager1.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("slider")) {
					if (_childValue.containsKey("slider1")) {
						data.edit().putString("img1", _childValue.get("slider1").toString()).commit();
					}
					if (_childValue.containsKey("slider2")) {
						data.edit().putString("img2", _childValue.get("slider2").toString()).commit();
					}
					if (_childValue.containsKey("slider3")) {
						data.edit().putString("img3", _childValue.get("slider3").toString()).commit();
					}
					if (_childValue.containsKey("slider4")) {
						data.edit().putString("img4", _childValue.get("slider4").toString()).commit();
					}
					if (_childValue.containsKey("slider5")) {
						data.edit().putString("img5", _childValue.get("slider5").toString()).commit();
					}
					if (_childValue.containsKey("slider6")) {
						data.edit().putString("img6", _childValue.get("slider6").toString()).commit();
					}
					if (_childValue.containsKey("icon1")) {
						data.edit().putString("icon1", _childValue.get("icon1").toString()).commit();
					}
					if (_childValue.containsKey("icon2")) {
						data.edit().putString("icon2", _childValue.get("icon2").toString()).commit();
					}
					if (_childValue.containsKey("icon3")) {
						data.edit().putString("icon3", _childValue.get("icon3").toString()).commit();
					}
					if (_childValue.containsKey("icon4")) {
						data.edit().putString("icon4", _childValue.get("icon4").toString()).commit();
					}
					if (_childValue.containsKey("icon5")) {
						data.edit().putString("icon5", _childValue.get("icon5").toString()).commit();
					}
					if (_childValue.containsKey("icon6")) {
						data.edit().putString("icon6", _childValue.get("icon6").toString()).commit();
					}
					if (_childValue.containsKey("title1")) {
						data.edit().putString("title1", _childValue.get("title1").toString()).commit();
					}
					if (_childValue.containsKey("title2")) {
						data.edit().putString("title2", _childValue.get("title2").toString()).commit();
					}
					if (_childValue.containsKey("title3")) {
						data.edit().putString("title3", _childValue.get("title3").toString()).commit();
					}
					if (_childValue.containsKey("title4")) {
						data.edit().putString("title4", _childValue.get("title4").toString()).commit();
					}
					if (_childValue.containsKey("title5")) {
						data.edit().putString("title5", _childValue.get("title5").toString()).commit();
					}
					if (_childValue.containsKey("title6")) {
						data.edit().putString("title6", _childValue.get("title6").toString()).commit();
					}
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
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		slider.addChildEventListener(_slider_child_listener);
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("trust")) {
					trust.setText(_childValue.get("trust").toString());
				}
				if (_childValue.containsKey("employe")) {
					teacher.setText(_childValue.get("employe").toString());
				}
				if (_childValue.containsKey("ratting")) {
					rate.setText(_childValue.get("ratting").toString());
				}
				if (_childValue.containsKey("college_head")) {
					manse_tech7.setText(_childValue.get("college_head").toString());
				}
				if (_childValue.containsKey("college_discripltion")) {
					desh_techu.setText(_childValue.get("college_discripltion").toString());
				}
				shimi.setVisibility(View.GONE);
				overridePendingTransition(android.
				R.anim.fade_in,
				android.R.anim.fade_out);
				itom_bg.setVisibility(View.VISIBLE);
				scrol_noti.setVisibility(View.VISIBLE);
				linear94.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("trust")) {
					trust.setText(_childValue.get("trust").toString());
				}
				if (_childValue.containsKey("employe")) {
					teacher.setText(_childValue.get("employe").toString());
				}
				if (_childValue.containsKey("ratting")) {
					rate.setText(_childValue.get("ratting").toString());
				}
				if (_childValue.containsKey("college_head")) {
					manse_tech7.setText(_childValue.get("college_head").toString());
				}
				if (_childValue.containsKey("college_discripltion")) {
					desh_techu.setText(_childValue.get("college_discripltion").toString());
				}
				shimi.setVisibility(View.GONE);
				overridePendingTransition(android.
				R.anim.fade_in,
				android.R.anim.fade_out);
				itom_bg.setVisibility(View.VISIBLE);
				scrol_noti.setVisibility(View.VISIBLE);
				linear94.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
		_rq_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (isJSONValid(_response)){
					map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
					_Description("get version name");
					package_name = "com.my.eduction.app";
					try {
						android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo(package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
						ver = pinfo.versionName; }
					catch (Exception e){ showMessage(e.toString()); }
					if (map.get("Visibility").toString().equals("VISIBLE")) {
						if (!map.get("Version").toString().equals(ver)) {
							_ShowUpdateDialog(map.get("Title").toString(), map.get("Description").toString(), map.get("DownloadLink").toString(), map.get("MainTextButton").toString(), map.get("CancelButtonText").toString());
						}
					}
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_update_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				update.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						update_map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								update_map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (Double.parseDouble(version) == Double.parseDouble(update_map.get((int)0).get("recent_version").toString())) {
							/*test*/
							/*
 
*/
						}
						else {
							if (Double.parseDouble(version) < Double.parseDouble(update_map.get((int)0).get("recent_version").toString())) {
								d.setTitle(update_map.get((int)0).get("Tile").toString());
								d.setMessage(update_map.get((int)0).get("Description").toString());
								d.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
										
										new ProgDiagTask().execute(update_map.get((int)0).get("Link").toString());
									}
								});
								d.create().show();
							}
						}
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
				update.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						update_map = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								update_map.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (Double.parseDouble(version) == Double.parseDouble(update_map.get((int)0).get("recent_version").toString())) {
							/*test*/
							/*
 
*/
						}
						else {
							if (Double.parseDouble(version) < Double.parseDouble(update_map.get((int)0).get("recent_version").toString())) {
								d.setTitle(update_map.get((int)0).get("Tile").toString());
								d.setMessage(update_map.get((int)0).get("Description").toString());
								d.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
										
										new ProgDiagTask().execute(update_map.get((int)0).get("Link").toString());
									}
								});
								d.create().show();
							}
						}
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
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		update.addChildEventListener(_update_child_listener);
	}
	
	private void initializeLogic() {
		vabrat.vibrate((long)(50));
		package_name = "com.my.eduction.app";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		rq.startRequestNetwork(RequestNetworkController.GET, "https://raw.githubusercontent.com/aryan6205012057/My-Skills-App/main/My_Skilks_update.html", "a", _rq_request_listener);
		_Uix();
		_Design();
		_start();
		shimmer.setVisibility(View.VISIBLE);
		viewpager1.setVisibility(View.GONE);
		shimmer.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shimer_box2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shimer_box1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shimer_box3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shimi.setVisibility(View.VISIBLE);
		itom_bg.setVisibility(View.GONE);
		scrol_noti.setVisibility(View.GONE);
		linear94.setVisibility(View.VISIBLE);
		_Description("🔴 Create a repository in the GitHub, then create a file in the GitHub called an index.html or another name 🔴\n\nAnd put this Json code in your github file\n\n{\n  \"Visibility\": \"VISIBLE\",\n  \"Title\": \"Test\",\n  \"Description\": \"Test Message\",\n  \"MainTextButton\": \"Update\",\n  \"Cancelable\": \"true\",\n  \"CancelButtonText\": \"Cancel\",\n  \"DownloadLink\": \"www.example.com\",\n  \"Version\": \"1.1\"\n}\n\n\nBe sure to edit this code ");
		_Description("telegram : https://t.me/Explorer_broswer");
		_welcome();
	}
	
	public void _Uix() {
		_set_radius(top_bg, "#FF3500A5", 0, 0, 40, 40);
		_set_radius(bottam_navigation, "#FF3500A5", 40, 40, 0, 0);
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#FF3500A5")); }
		
		
		surch_back.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		linear94.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		_setBackgroundGradient(pro, "TL_BR", "#DA22FF", "#9733EE", 50);
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
	
	
	public void _Design() {
		_sliders();
		_rippleRoundStroke(dot1, "#FFFFFF", "#FFFFFF", 360, 0, "#FFFFFF");
		_rippleRoundStroke(dot2, "#FFFFFF", "#FFFFFF", 360, 0, "#FFFFFF");
		_rippleRoundStroke(dot3, "#FFFFFF", "#FFFFFF", 360, 0, "#FFFFFF");
		_rippleRoundStroke(dot4, "#FFFFFF", "#FFFFFF", 360, 0, "#FFFFFF");
		_rippleRoundStroke(dot5, "#FFFFFF", "#FFFFFF", 360, 0, "#FFFFFF");
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _sliders() {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("a", "b");
			slidermap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("c", "d");
			slidermap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("e", "f");
			slidermap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("g", "h");
			slidermap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("i", "j");
			slidermap.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("k", "l");
			slidermap.add(_item);
		}
		
		final float scaleFactor = 0.90f; viewpager1.setPageMargin(-30); viewpager1.setOffscreenPageLimit(2); viewpager1.setPageTransformer(false, new ViewPager.PageTransformer() { @Override public void transformPage(@NonNull View page1, float position) { page1.setScaleY((1 - Math.abs(position) * (1 - scaleFactor))); page1.setScaleX(scaleFactor + Math.abs(position) * (1 - scaleFactor)); } });
		viewpager1.setAdapter(new Viewpager1Adapter(slidermap));
		slider_timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						slider_count = viewpager1.getCurrentItem() + 1;
						if (slider_count > 5) {
							slider_count = 0;
							viewpager1.setCurrentItem((int)slider_count);
						}
						else {
							viewpager1.setCurrentItem((int)slider_count);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(slider_timer, (int)(4000), (int)(4000));
	}
	
	
	public void _round_corner_and_ripple(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _start() {
		engn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)35, 0xFF3500A5));
		scrol_noti.setElevation((int)2);
		happy_box.setElevation((int)2);
		member_box.setElevation((int)2);
		google_box.setElevation((int)2);
		collage_head.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 1);
		manse_tech7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 1);
		_removeScollBar(vscroll1);
		scrol_noti.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		happy_box.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		member_box.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		google_box.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		vvi.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		study_m.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		pyq.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		test.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		demo_class.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		paid.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
	}
	
	
	public void _extra() {
	}
	public boolean isJSONValid(String test) {
		    try {
			        new JSONObject(test);
			    } catch (JSONException ex) {
			        try {
				            new JSONArray(test);
				        } catch (JSONException ex1) {
				            return false;
				        }
			    }
		    return true;
		
	}
	
	
	public void _RoundAndBorder(final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	
	public void _ShowUpdateDialog(final String _title, final String _description, final String _link, final String _main_button, final String _cancel_button) {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(HomeActivity.this);
		// custom view name
		View bottomSheetView; bottomSheetView = 
		getLayoutInflater().inflate(R.layout.update,null );
		
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		_Description("define custom view widgets");
		TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
		
		TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
		
		TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
		
		TextView b2 = (TextView) bottomSheetView.findViewById(R.id.b2);
		
		TextView t3 = (TextView) bottomSheetView.findViewById(R.id.t3);
		
		TextView t4 = (TextView) bottomSheetView.findViewById(R.id.t4);
		
		ImageView i1 = (ImageView) bottomSheetView.findViewById(R.id.i1);
		
		LinearLayout bg1 = (LinearLayout) bottomSheetView.findViewById(R.id.bg1);
		
		LinearLayout bg2 = (LinearLayout) bottomSheetView.findViewById(R.id.bg2);
		
		LinearLayout card = (LinearLayout) bottomSheetView.findViewById(R.id.card);
		t1.setText(_title);
		t2.setText(_description);
		b1.setText(_main_button);
		b2.setText(_cancel_button);
		t4.setText("Version ".concat(map.get("Version").toString()));
		if (map.get("Cancelable").toString().equals("true")) {
			b2.setVisibility(View.VISIBLE);
		}
		else {
			b2.setVisibility(View.GONE);
		}
		_RoundAndBorder(bg1, "#FFFFFF", 0, "#000000", 20);
		_RoundAndBorder(bg2, "#FFFFFF", 0, "#000000", 20);
		_addCardView(card, 0, 20, 0, 0, true, "#FFFFFF");
		_rippleRoundStroke(b2, "#FFFFFF", "#E0E0E0", 20, 2.5d, "#EEEEEE");
		_rippleRoundStroke(b1, "#2196F3", "#E0E0E0", 20, 0, "#000000");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				if (Patterns.WEB_URL.matcher(_link).matches())
						{
								i.setAction(Intent.ACTION_VIEW);
								i.setData(Uri.parse(_link));
								startActivity(i);
						}
						else
						{
								showMessage("Please put a link in the download link section");
						}
			}
		});
		if (map.get("Cancelable").toString().equals("true")) {
			b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
					bottomSheetDialog.dismiss();
				}
			});
		}
		_Description("set Cancelable and show");
		bottomSheetDialog.setCancelable(false);
		bottomSheetDialog.show();
	}
	
	
	public void _addCardView(final View _layoutView, final double _margins, final double _cornerRadius, final double _cardElevation, final double _cardMaxElevation, final boolean _preventCornerOverlap, final String _backgroundColor) {
		androidx.cardview.widget.CardView cv = new androidx.cardview.widget.CardView(this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		int m = (int)_margins;
		lp.setMargins(m,m,m,m);
		cv.setLayoutParams(lp);
		int c = Color.parseColor(_backgroundColor);
		cv.setCardBackgroundColor(c);
		cv.setRadius((float)_cornerRadius);
		cv.setCardElevation((float)_cardElevation);
		cv.setMaxCardElevation((float)_cardMaxElevation);
		cv.setPreventCornerOverlap(_preventCornerOverlap);
		if(_layoutView.getParent() instanceof LinearLayout){
			ViewGroup vg = ((ViewGroup)_layoutView.getParent());
			vg.removeView(_layoutView);
			vg.removeAllViews();
			vg.addView(cv);
			cv.addView(_layoutView);
		}else{
			
		}
	}
	
	
	public void _Description(final String _ReadMe) {
		
	}
	
	
	public void _setBackgroundGradient(final View _view, final String _orientation, final String _start, final String _end, final double _radius) {
		setBackgroundGradient(_view, _orientation, _start, _end, (int) _radius);
	}
	
	
	public void _ImageGradientLib() {
	}
	public void setColorFilter(ImageView _view, String _orientation, String _start, String _end) {
			if (_orientation.equals("TOP_BOTTOM")) {
					final ImageView _image = _view;
					Bitmap myBitmap = ((BitmapDrawable) _image.getDrawable()).getBitmap();
					Bitmap newBitmap = addGradientTB(myBitmap, _start, _end);
					_image.setImageDrawable(new BitmapDrawable(getResources(), newBitmap));
			} else {
					if (_orientation.equals("BOTTOM_TOP")) {
							final ImageView _image = _view;
							Bitmap myBitmap = ((BitmapDrawable) _image.getDrawable()).getBitmap();
							Bitmap newBitmap = addGradientBT(myBitmap, _start, _end);
							_image.setImageDrawable(new BitmapDrawable(getResources(), newBitmap));
					} else {
							if (_orientation.equals("LEFT_RIGHT")) {
									final ImageView _image = _view;
									Bitmap myBitmap = ((BitmapDrawable) _image.getDrawable()).getBitmap();
									Bitmap newBitmap = addGradientLR(myBitmap, _start, _end);
									_image.setImageDrawable(new BitmapDrawable(getResources(), newBitmap));
							} else {
									if (_orientation.equals("RIGHT_LEFT")) {
											final ImageView _image = _view;
											Bitmap myBitmap = ((BitmapDrawable) _image.getDrawable()).getBitmap();
											Bitmap newBitmap = addGradientRL(myBitmap, _start, _end);
											_image.setImageDrawable(new BitmapDrawable(getResources(), newBitmap));
									} else {
											showMessage("Wrong Orientation seted!");
									}
							}
					}
			}
	}
	
	public Bitmap addGradientTB(Bitmap originalBitmap, String _start, String _end) {
			int width = originalBitmap.getWidth();
			int height = originalBitmap.getHeight();
			
			Bitmap updatedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(updatedBitmap);
			canvas.drawBitmap(originalBitmap, 0, 0, null);
			Paint paint = new Paint();
			
			LinearGradient shader = new LinearGradient(0, 0, 0, height, Color.parseColor(_start), Color.parseColor(_end), Shader.TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
			canvas.drawRect(0, 0, width, height, paint);
			
			return updatedBitmap;
	}
	
	public Bitmap addGradientBT(Bitmap originalBitmap, String _start, String _end) {
			int width = originalBitmap.getWidth();
			int height = originalBitmap.getHeight();
			
			Bitmap updatedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(updatedBitmap);
			canvas.drawBitmap(originalBitmap, 0, 0, null);
			Paint paint = new Paint();
			
			LinearGradient shader = new LinearGradient(0, height, 0, 0, Color.parseColor(_start), Color.parseColor(_end), Shader.TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
			canvas.drawRect(0, 0, width, height, paint);
			
			return updatedBitmap;
	}
	
	public Bitmap addGradientLR(Bitmap originalBitmap, String _start, String _end) {
			int width = originalBitmap.getWidth();
			int height = originalBitmap.getHeight();
			
			Bitmap updatedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(updatedBitmap);
			canvas.drawBitmap(originalBitmap, 0, 0, null);
			Paint paint = new Paint();
			
			LinearGradient shader = new LinearGradient(0, 0, width, 0, Color.parseColor(_start), Color.parseColor(_end), Shader.TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
			canvas.drawRect(0, 0, width, height, paint);
			
			return updatedBitmap;
	}
	
	public Bitmap addGradientRL(Bitmap originalBitmap, String _start, String _end) {
			int width = originalBitmap.getWidth();
			int height = originalBitmap.getHeight();
			
			Bitmap updatedBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(updatedBitmap);
			canvas.drawBitmap(originalBitmap, 0, 0, null);
			Paint paint = new Paint();
			
			LinearGradient shader = new LinearGradient(width, 0, 0, 0, Color.parseColor(_start), Color.parseColor(_end), Shader.TileMode.CLAMP);
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
			canvas.drawRect(0, 0, width, height, paint);
			
			return updatedBitmap;
	}
	
	{
	}
	
	
	public void _TextGradientLibary() {
	}
	private void setTextGradient(TextView view, String color1, String color2, String type) {
		
		if (!(type.equals("TOP_BOTTOM") || (type.equals("BOTTOM_TOP") || (type.equals("LEFT_RIGHT") || type.equals("RIGHT_LEFT"))))) {
				showMessage("Wrong Orientation");
		}
		
		if (type.equals("TOP_BOTTOM")) {
				Shader ts = new LinearGradient(
				0,
				0,
				0,
				view.getPaint().getTextSize(),
				new int[]{
						Color.parseColor(color1),
						Color.parseColor(color2)
				},
				new float[]{
						0,
						1
				}, Shader.TileMode.CLAMP);
				
				view.getPaint().setShader(ts);
		}
		
		if (type.equals("BOTTOM_TOP")) {
				Shader ts = new LinearGradient(
				0,
				0,
				0,
				view.getPaint().getTextSize(),
				new int[]{
						Color.parseColor(color2),
						Color.parseColor(color1)
				},
				new float[]{
						0,
						1
				}, Shader.TileMode.CLAMP);
				
				view.getPaint().setShader(ts);
		}
		
		if (type.equals("LEFT_RIGHT")) {
				TextPaint paint = view.getPaint();
				float width = paint.measureText(view.getText().toString());
				Shader ts = new LinearGradient(
				0,
				0,
				width,
				view.getPaint().getTextSize(),
				new int[]{
						Color.parseColor(color1),
						Color.parseColor(color2)
				},
				new float[]{
						0,
						1
				}, Shader.TileMode.CLAMP);
				
				view.getPaint().setShader(ts);
		}
		
		if (type.equals("RIGHT_LEFT")) {
				TextPaint paint = view.getPaint();
				float width = paint.measureText(view.getText().toString());
				Shader ts = new LinearGradient(
				0,
				0,
				width,
				view.getPaint().getTextSize(),
				new int[]{
						Color.parseColor(color2),
						Color.parseColor(color1)
				},
				new float[]{
						0,
						1
				}, Shader.TileMode.CLAMP);
				
				view.getPaint().setShader(ts);
		}
		return;
	}
	{
	}
	
	
	public void _setTextGradient(final TextView _view, final String _color1, final String _color2, final String _type) {
		setTextGradient(_view, _color1, _color2, _type);
	}
	
	
	public void _setColorFilter(final ImageView _view, final String _orientation, final String _start, final String _end) {
		setColorFilter(_view, _orientation, _start, _end);
	}
	
	
	public void _GradientLibary() {
	}
	private void setStatusGradient(String left, String right) {
			android.graphics.drawable.GradientDrawable sytstudioG = new android.graphics.drawable.GradientDrawable();
			int clrs [] = {
					Color.parseColor(left),
					Color.parseColor(right)
			};
			sytstudioG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT, clrs);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) { 
					Window w = this.getWindow();
					w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
					w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
					w.setStatusBarColor(Color.parseColor("#00000000"));
					w.setBackgroundDrawable(sytstudioG);
			}
	}
	
	private void setActionGradient(String left, String right) {
			android.graphics.drawable.GradientDrawable sytstudioG = new android.graphics.drawable.GradientDrawable();
			int clrs [] = {
					Color.parseColor(left),
					Color.parseColor(right)
			};
			sytstudioG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT, clrs);
			getSupportActionBar().setBackgroundDrawable(sytstudioG);
	}
	
	public void setBackgroundGradient(View view, String orientation, String col1, String col2, int radius) {
			if (orientation.equals("TOP_BOTTOM")) {
					int clrs [] = {
							Color.parseColor(col1),
							Color.parseColor(col2)
					};
					android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
					viewG.setCornerRadius((int)radius);
					view.setBackground(viewG);
			} else {
					if (orientation.equals("BOTTOM_TOP")) {
							int clrs [] = {
									Color.parseColor(col1),
									Color.parseColor(col2)
							};
							android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, clrs);
							viewG.setCornerRadius((int)radius);
							view.setBackground(viewG);
					} else {
							if (orientation.equals("LEFT_RIGHT")) {
									int clrs [] = {
											Color.parseColor(col1),
											Color.parseColor(col2)
									};
									android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT, clrs);
									viewG.setCornerRadius((int)radius);
									view.setBackground(viewG);
							} else {
									if (orientation.equals("RIGHT_LEFT")) {
											int clrs [] = {
													Color.parseColor(col1),
													Color.parseColor(col2)
											};
											android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT, clrs);
											viewG.setCornerRadius((int)radius);
											view.setBackground(viewG);
									} else {
											if (orientation.equals("TL_BR")) {
													int clrs [] = {
															Color.parseColor(col1),
															Color.parseColor(col2)
													};
													android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, clrs);
													viewG.setCornerRadius((int)radius);
													view.setBackground(viewG);
											} else {
													if (orientation.equals("TR_BL")) {
															int clrs [] = {
																	Color.parseColor(col1),
																	Color.parseColor(col2)
															};
															android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TR_BL, clrs);
															viewG.setCornerRadius((int)radius);
															view.setBackground(viewG);
													} else {
															if (orientation.equals("BL_TR")) {
																	int clrs [] = {
																			Color.parseColor(col1),
																			Color.parseColor(col2)
																	};
																	android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BL_TR, clrs);
																	viewG.setCornerRadius((int)radius);
																	view.setBackground(viewG);
															} else {
																	if (orientation.equals("BR_TL")) {
																			int clrs [] = {
																					Color.parseColor(col1),
																					Color.parseColor(col2)
																			};
																			android.graphics.drawable.GradientDrawable viewG = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BR_TL, clrs);
																			viewG.setCornerRadius((int)radius);
																			view.setBackground(viewG);
																	} else {
																			showMessage("Wrong Orientation Settet");
																	}
															}
													}
											}
									}
							}
					}
			}
	}
	
	{
	}
	
	
	public void _welcome() {
		if (sp.getString("show", "").equals("")) {
			_NewTapTarget(pro, "MySkills Pro ♥️", "Poviding for your premium content on your My Skills application this picture for available for paid member", "#0094FF");
			_NewTapTarget(member_box, "Chat with AI and problem solution with teachers", "solve your doubt solution with AI \nPoviding for your premium content on your My Skills application this picture for available for paid member", "#0094FF");
			_NewTapTarget(paid, "High quality course content available on bed members♥️", "solve your doubt solution with AI \nPoviding for your premium content on your My Skills application this picture for available for paid member", "#0094FF");
			sp.edit().putString("show", "no").commit();
		}
		else {
			//If user is new then he would already set shared pref show to no
		}
	}
	
	
	public void _NewTapTarget(final View _view, final String _title, final String _msg, final String _bgcolor) {
		TapTargetView.showFor(HomeActivity.this,
		TapTarget.forView(_view, _title, _msg)
		.outerCircleColorInt(Color.parseColor(_bgcolor))
		.outerCircleAlpha(0.96f)
		.targetCircleColorInt(Color.parseColor("#FFFFFF"))
		.titleTextSize(25)
		.titleTextColorInt(Color.parseColor("#FFFFFF"))
		.descriptionTextSize(18)
		.descriptionTextColor(android.R.color.white)
		.textColorInt(Color.parseColor("#FFFFFF"))
		.textTypeface(Typeface.SANS_SERIF)
		.dimColor(android.R.color.black)
		.drawShadow(true)
		.cancelable(true)
		.tintTarget(true)
		.transparentTarget(true)
		//.icon(Drawable)
		.targetRadius(60),
		
		//LISTENER//
		
		new TapTargetView.Listener() {
			@Override
			public void onTargetClick(TapTargetView view) {
				//ON CLICKED//
				super.onTargetClick(view);
			}
		});
		//Show the TapTarget
	}
	static class UiUtil {
		    UiUtil() {
			    }
		    static int dp(Context context, int val) {
			        return (int) TypedValue.applyDimension(
			                TypedValue.COMPLEX_UNIT_DIP, val, context.getResources().getDisplayMetrics());
			    }
		    static int sp(Context context, int val) {
			        return (int) TypedValue.applyDimension(
			                TypedValue.COMPLEX_UNIT_SP, val, context.getResources().getDisplayMetrics());
			    }
		    static int themeIntAttr(Context context, String attr) {
			        final android.content.res.Resources.Theme theme = context.getTheme();
			        if (theme == null) {
				            return -1;
				        }
			        final TypedValue value = new TypedValue();
			        final int id = context.getResources().getIdentifier(attr, "attr", context.getPackageName());
			
			        if (id == 0) {
				            // Not found
				            return -1;
				        }
			        theme.resolveAttribute(id, value, true);
			        return value.data;
			    }
		    static int setAlpha(int argb, float alpha) {
			        if (alpha > 1.0f) {
				            alpha = 1.0f;
				        } else if (alpha <= 0.0f) {
				            alpha = 0.0f;
				        }
			        return ((int) ((argb >>> 24) * alpha) << 24) | (argb & 0x00FFFFFF);
			    }
	}
	static class FloatValueAnimatorBuilder {
		
		    private final ValueAnimator animator;
		
		    private EndListener endListener;
		
		    interface UpdateListener {
			        void onUpdate(float lerpTime);
			    }
		    interface EndListener {
			        void onEnd();
			    }
		    protected FloatValueAnimatorBuilder() {
			        this(false);
			    }
		    FloatValueAnimatorBuilder(boolean reverse) {
			        if (reverse) {
				            this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
				        } else {
				            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
				        }
			    }
		    public FloatValueAnimatorBuilder delayBy(long millis) {
			        animator.setStartDelay(millis);
			        return this;
			    }
		    public FloatValueAnimatorBuilder duration(long millis) {
			        animator.setDuration(millis);
			        return this;
			    }
		    public FloatValueAnimatorBuilder interpolator(TimeInterpolator lerper) {
			        animator.setInterpolator(lerper);
			        return this;
			    }
		    public FloatValueAnimatorBuilder repeat(int times) {
			        animator.setRepeatCount(times);
			        return this;
			    }
		    public FloatValueAnimatorBuilder onUpdate(final UpdateListener listener) {
			        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				            @Override
				            public void onAnimationUpdate(ValueAnimator animation) {
					                listener.onUpdate((float) animation.getAnimatedValue());
					            }
				        });
			        return this;
			    }
		    public FloatValueAnimatorBuilder onEnd(final EndListener listener) {
			        this.endListener = listener;
			        return this;
			    }
		    public ValueAnimator build() {
			        if (endListener != null) {
				            animator.addListener(new AnimatorListenerAdapter() {
					                @Override
					                public void onAnimationEnd(Animator animation) {
						                    endListener.onEnd();
						                }
					            });
				        }
			        return animator;
			    }
	}
	
	static class ReflectUtil {
		    ReflectUtil() {
			    }
		    static Object getPrivateField(Object source, String fieldName)
		            throws NoSuchFieldException, IllegalAccessException {
			        final java.lang.reflect.Field objectField = source.getClass().getDeclaredField(fieldName);
			        objectField.setAccessible(true);
			        return objectField.get(source);
			    }
	}
	static class TapTarget extends Activity {
		    final CharSequence title;
		    final CharSequence description;
		    float outerCircleAlpha = 0.96f;
		    int targetRadius = 44;
		    Rect bounds;
		    android.graphics.drawable.Drawable icon;
		    Typeface titleTypeface;
		    Typeface descriptionTypeface;
		
		
		    private int outerCircleColorRes = -1;
		    private int targetCircleColorRes = -1;
		    private int dimColorRes = -1;
		    private int titleTextColorRes = -1;
		    private int descriptionTextColorRes = -1;
		
		    private Integer outerCircleColor = null;
		    private Integer targetCircleColor = null;
		    private Integer dimColor = null;
		    private Integer titleTextColor = null;
		    private Integer descriptionTextColor = null;
		
		    private int titleTextDimen = -1;
		    private int descriptionTextDimen = -1;
		    private int titleTextSize = 20;
		    private int descriptionTextSize = 18;
		    int id = -1;
		    boolean drawShadow = false;
		    boolean cancelable = true;
		    boolean tintTarget = true;
		    boolean transparentTarget = false;
		    float descriptionTextAlpha = 0.54f;
		public static TapTarget forView(View view, CharSequence title) {
			        return forView(view, title, null);
			    }
		    public static TapTarget forView(View view, CharSequence title, CharSequence description) {
			        return new ViewTapTarget(view, title, description);
			    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title) {
			        return forBounds(bounds, title, null);
			    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title,  CharSequence description) {
			        return new TapTarget(bounds, title, description);
			    }
		    protected TapTarget(Rect bounds, CharSequence title,  CharSequence description) {
			        this(title, description);
			        if (bounds == null) {
				            throw new IllegalArgumentException("Cannot pass null bounds or title");
				        }
			        this.bounds = bounds;
			    }
		    protected TapTarget(CharSequence title,  CharSequence description) {
			        if (title == null) {
				            throw new IllegalArgumentException("Cannot pass null title");
				        }
			        this.title = title;
			        this.description = description;
			    }
		    public TapTarget transparentTarget(boolean transparent) {
			        this.transparentTarget = transparent;
			        return this;
			    }
		    public TapTarget outerCircleColor( int color) {
			        this.outerCircleColorRes = color;
			        return this;
			    }
		    public TapTarget outerCircleColorInt( int color) {
			        this.outerCircleColor = color;
			        return this;
			    }
		    public TapTarget outerCircleAlpha(float alpha) {
			        if (alpha < 0.0f || alpha > 1.0f) {
				            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
				        }
			        this.outerCircleAlpha = alpha;
			        return this;
			    }
		    public TapTarget targetCircleColor( int color) {
			        this.targetCircleColorRes = color;
			        return this;
			    }
		    public TapTarget targetCircleColorInt( int color) {
			        this.targetCircleColor = color;
			        return this;
			    }
		    public TapTarget textColor( int color) {
			        this.titleTextColorRes = color;
			        this.descriptionTextColorRes = color;
			        return this;
			    }
		    public TapTarget textColorInt( int color) {
			        this.titleTextColor = color;
			        this.descriptionTextColor = color;
			        return this;
			    }
		    public TapTarget titleTextColor( int color) {
			        this.titleTextColorRes = color;
			        return this;
			    }
		    public TapTarget titleTextColorInt( int color) {
			        this.titleTextColor = color;
			        return this;
			    }
		    public TapTarget descriptionTextColor( int color) {
			        this.descriptionTextColorRes = color;
			        return this;
			    }
		    public TapTarget descriptionTextColorInt( int color) {
			        this.descriptionTextColor = color;
			        return this;
			    }
		    public TapTarget textTypeface(Typeface typeface) {
			        if (typeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        titleTypeface = typeface;
			        descriptionTypeface = typeface;
			        return this;
			    }
		    public TapTarget titleTypeface(Typeface titleTypeface) {
			        if (titleTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        this.titleTypeface = titleTypeface;
			        return this;
			    }
		    public TapTarget descriptionTypeface(Typeface descriptionTypeface) {
			        if (descriptionTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        this.descriptionTypeface = descriptionTypeface;
			        return this;
			    }
		    public TapTarget titleTextSize(int sp) {
			        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
			        this.titleTextSize = sp;
			        return this;
			    }
		    public TapTarget descriptionTextSize(int sp) {
			        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
			        this.descriptionTextSize = sp;
			        return this;
			    }
		    public TapTarget titleTextDimen( int dimen) {
			        this.titleTextDimen = dimen;
			        return this;
			    }
		    public TapTarget descriptionTextAlpha(float descriptionTextAlpha) {
			        if (descriptionTextAlpha < 0 || descriptionTextAlpha > 1f) {
				            throw new IllegalArgumentException("Given an invalid alpha value: " + descriptionTextAlpha);
				        }
			        this.descriptionTextAlpha = descriptionTextAlpha;
			        return this;
			    }
		    public TapTarget descriptionTextDimen( int dimen) {
			        this.descriptionTextDimen = dimen;
			        return this;
			    }
		    public TapTarget dimColor( int color) {
			        this.dimColorRes = color;
			        return this;
			    }
		    public TapTarget dimColorInt( int color) {
			        this.dimColor = color;
			        return this;
			    }
		    public TapTarget drawShadow(boolean draw) {
			        this.drawShadow = draw;
			        return this;
			    }
		    public TapTarget cancelable(boolean status) {
			        this.cancelable = status;
			        return this;
			    }
		    public TapTarget tintTarget(boolean tint) {
			        this.tintTarget = tint;
			        return this;
			    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon) {
			        return icon(icon, false);
			    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon, boolean hasSetBounds) {
			        if (icon == null) throw new IllegalArgumentException("Cannot use null drawable");
			        this.icon = icon;
			        if (!hasSetBounds) {
				            this.icon.setBounds(new Rect(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight()));
				        }
			        return this;
			    }
		    public TapTarget id(int id) {
			        this.id = id;
			        return this;
			    }
		    public TapTarget targetRadius(int targetRadius) {
			        this.targetRadius = targetRadius;
			        return this;
			    }
		    public int id() {
			        return id;
			    }
		    public void onReady(Runnable runnable) {
			        runnable.run();
			    }
		    public Rect bounds() {
			        if (bounds == null) {
				            throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
				        }
			        return bounds;
			    }
		    Integer outerCircleColorInt(Context context) {
			        return colorResOrInt(context, outerCircleColor, outerCircleColorRes);
			    }
		    Integer targetCircleColorInt(Context context) {
			        return colorResOrInt(context, targetCircleColor, targetCircleColorRes);
			    }
		    Integer dimColorInt(Context context) {
			        return colorResOrInt(context, dimColor, dimColorRes);
			    }
		    Integer titleTextColorInt(Context context) {
			        return colorResOrInt(context, titleTextColor, titleTextColorRes);
			    }
		
		    Integer descriptionTextColorInt(Context context) {
			        return colorResOrInt(context, descriptionTextColor, descriptionTextColorRes);
			    }
		    int titleTextSizePx(Context context) {
			        return dimenOrSize(context, titleTextSize, titleTextDimen);
			    }
		    int descriptionTextSizePx(Context context) {
			        return dimenOrSize(context, descriptionTextSize, descriptionTextDimen);
			    }
		
		    private Integer colorResOrInt(Context context, Integer value,  int resource) {
			        if (resource != -1) {
				            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					                return context.getColor(resource);
					            }
				        }
			        return value;
			    }
		    private int dimenOrSize(Context context, int size,  int dimen) {
			        if (dimen != -1) {
				            return context.getResources().getDimensionPixelSize(dimen);
				        }
			        return UiUtil.sp(context, size);
			    }
	}
	static class TapTargetView extends View {
		    private boolean isDismissed = false;
		    private boolean isDismissing = false;
		    private boolean isInteractable = true;
		
		    final int TARGET_PADDING;
		    final int TARGET_RADIUS;
		    final int TARGET_PULSE_RADIUS;
		    final int TEXT_PADDING;
		    final int TEXT_SPACING;
		    final int TEXT_MAX_WIDTH;
		    final int TEXT_POSITIONING_BIAS;
		    final int CIRCLE_PADDING;
		    final int GUTTER_DIM;
		    final int SHADOW_DIM;
		    final int SHADOW_JITTER_DIM;
		
		
		    final ViewGroup boundingParent;
		    final ViewManager parent;
		    final TapTarget target;
		    final Rect targetBounds;
		
		    final TextPaint titlePaint;
		    final TextPaint descriptionPaint;
		    final Paint outerCirclePaint;
		    final Paint outerCircleShadowPaint;
		    final Paint targetCirclePaint;
		    final Paint targetCirclePulsePaint;
		
		    CharSequence title;
		
		    StaticLayout titleLayout;
		
		    CharSequence description;
		
		    StaticLayout descriptionLayout;
		    boolean isDark;
		    boolean debug;
		    boolean shouldTintTarget;
		    boolean shouldDrawShadow;
		    boolean cancelable;
		    boolean visible;
		
		    // Debug related variables
		
		    SpannableStringBuilder debugStringBuilder;
		
		    DynamicLayout debugLayout;
		
		    TextPaint debugTextPaint;
		
		    Paint debugPaint;
		
		    // Drawing properties
		    Rect drawingBounds;
		    Rect textBounds;
		
		    Path outerCirclePath;
		    float outerCircleRadius;
		    int calculatedOuterCircleRadius;
		    int[] outerCircleCenter;
		    int outerCircleAlpha;
		
		    float targetCirclePulseRadius;
		    int targetCirclePulseAlpha;
		
		    float targetCircleRadius;
		    int targetCircleAlpha;
		
		    int textAlpha;
		    int dimColor;
		
		    float lastTouchX;
		    float lastTouchY;
		
		    int topBoundary;
		    int bottomBoundary;
		
		    Bitmap tintedTarget;
		
		    Listener listener;
		
		
		    ViewOutlineProvider outlineProvider;
		
		    public static TapTargetView showFor(Activity activity, TapTarget target) {
			        return showFor(activity, target, null);
			    }
		
		    public static TapTargetView showFor(Activity activity, TapTarget target, Listener listener) {
			        if (activity == null) throw new IllegalArgumentException("Activity is null");
			
			        final ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
			        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
			                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			        final ViewGroup content = (ViewGroup) decor.findViewById(android.R.id.content);
			        final TapTargetView tapTargetView = new TapTargetView(activity, decor, content, target, listener);
			        decor.addView(tapTargetView, layoutParams);
			
			        return tapTargetView;
			    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target) {
			        return showFor(dialog, target, null);
			    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target, Listener listener) {
			        if (dialog == null) throw new IllegalArgumentException("Dialog is null");
			
			        final Context context = dialog.getContext();
			        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
			        params.type = WindowManager.LayoutParams.TYPE_APPLICATION;
			        params.format = PixelFormat.RGBA_8888;
			        params.flags = 0;
			        params.gravity = Gravity.START | Gravity.TOP;
			        params.x = 0;
			        params.y = 0;
			        params.width = WindowManager.LayoutParams.MATCH_PARENT;
			        params.height = WindowManager.LayoutParams.MATCH_PARENT;
			
			        final TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, target, listener);
			        windowManager.addView(tapTargetView, params);
			
			        return tapTargetView;
			    }
		public static class Listener {
			        /** Signals that the user has clicked inside of the target **/
			        public void onTargetClick(TapTargetView view) {
				            view.dismiss(true);
				        }
			
			        /** Signals that the user has long clicked inside of the target **/
			        public void onTargetLongClick(TapTargetView view) {
				            onTargetClick(view);
				        }
			
			        /** If cancelable, signals that the user has clicked outside of the outer circle **/
			        public void onTargetCancel(TapTargetView view) {
				            view.dismiss(false);
				        }
			
			        /** Signals that the user clicked on the outer circle portion of the tap target **/
			        public void onOuterCircleClick(TapTargetView view) {
				            // no-op as default
				        }
			
			        /**
         * Signals that the tap target has been dismissed
         * @param userInitiated Whether the user caused this action
         *
         *
         */
			        public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
				        }
			    }
		
		    final FloatValueAnimatorBuilder.UpdateListener expandContractUpdateListener = new FloatValueAnimatorBuilder.UpdateListener() {
			        @Override
			        public void onUpdate(float lerpTime) {
				            final float newOuterCircleRadius = calculatedOuterCircleRadius * lerpTime;
				            final boolean expanding = newOuterCircleRadius > outerCircleRadius;
				            if (!expanding) {
					                // When contracting we need to invalidate the old drawing bounds. Otherwise
					                // you will see artifacts as the circle gets smaller
					                calculateDrawingBounds();
					            }
				
				            final float targetAlpha = target.outerCircleAlpha * 255;
				            outerCircleRadius = newOuterCircleRadius;
				            outerCircleAlpha = (int) Math.min(targetAlpha, (lerpTime * 1.5f * targetAlpha));
				            outerCirclePath.reset();
				            outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
				
				            targetCircleAlpha = (int) Math.min(255.0f, (lerpTime * 1.5f * 255.0f));
				
				            if (expanding) {
					                targetCircleRadius = TARGET_RADIUS * Math.min(1.0f, lerpTime * 1.5f);
					            } else {
					                targetCircleRadius = TARGET_RADIUS * lerpTime;
					                targetCirclePulseRadius *= lerpTime;
					            }
				
				            textAlpha = (int) (delayedLerp(lerpTime, 0.7f) * 255);
				
				            if (expanding) {
					                calculateDrawingBounds();
					            }
				
				            invalidateViewAndOutline(drawingBounds);
				        }
			    };
		
		    final ValueAnimator expandAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .delayBy(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    expandContractUpdateListener.onUpdate(lerpTime);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    pulseAnimation.start();
				                    isInteractable = true;
				                }
			            })
		            .build();
		
		    final ValueAnimator pulseAnimation = new FloatValueAnimatorBuilder()
		            .duration(1000)
		            .repeat(ValueAnimator.INFINITE)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    final float pulseLerp = delayedLerp(lerpTime, 0.5f);
				                    targetCirclePulseRadius = (1.0f + pulseLerp) * TARGET_RADIUS;
				                    targetCirclePulseAlpha = (int) ((1.0f - pulseLerp) * 255);
				                    targetCircleRadius = TARGET_RADIUS + halfwayLerp(lerpTime) * TARGET_PULSE_RADIUS;
				
				                    if (outerCircleRadius != calculatedOuterCircleRadius) {
					                        outerCircleRadius = calculatedOuterCircleRadius;
					                    }
				
				                    calculateDrawingBounds();
				                    invalidateViewAndOutline(drawingBounds);
				                }
			            })
		            .build();
		
		    final ValueAnimator dismissAnimation = new FloatValueAnimatorBuilder(true)
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    expandContractUpdateListener.onUpdate(lerpTime);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    onDismiss(true);
				                    ViewUtil.removeView(parent, TapTargetView.this);
				                }
			            })
		            .build();
		
		    private final ValueAnimator dismissConfirmAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    final float spedUpLerp = Math.min(1.0f, lerpTime * 2.0f);
				                    outerCircleRadius = calculatedOuterCircleRadius * (1.0f + (spedUpLerp * 0.2f));
				                    outerCircleAlpha = (int) ((1.0f - spedUpLerp) * target.outerCircleAlpha * 255.0f);
				                    outerCirclePath.reset();
				                    outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
				                    targetCircleRadius = (1.0f - lerpTime) * TARGET_RADIUS;
				                    targetCircleAlpha = (int) ((1.0f - lerpTime) * 255.0f);
				                    targetCirclePulseRadius = (1.0f + lerpTime) * TARGET_RADIUS;
				                    targetCirclePulseAlpha = (int) ((1.0f - lerpTime) * targetCirclePulseAlpha);
				                    textAlpha = (int) ((1.0f - spedUpLerp) * 255.0f);
				                    calculateDrawingBounds();
				                    invalidateViewAndOutline(drawingBounds);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    onDismiss(true);
				                    ViewUtil.removeView(parent, TapTargetView.this);
				                }
			            })
		            .build();
		
		    private ValueAnimator[] animators = new ValueAnimator[]
		            {expandAnimation, pulseAnimation, dismissConfirmAnimation, dismissAnimation};
		
		    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
		    public TapTargetView(final Context context,
		                         final ViewManager parent,
		                          final ViewGroup boundingParent,
		                         final TapTarget target,
		                          final Listener userListener) {
			        super(context);
			        if (target == null) throw new IllegalArgumentException("Target cannot be null");
			
			        this.target = target;
			        this.parent = parent;
			        this.boundingParent = boundingParent;
			        this.listener = userListener != null ? userListener : new Listener();
			        this.title = target.title;
			        this.description = target.description;
			
			        TARGET_PADDING = UiUtil.dp(context, 20);
			        CIRCLE_PADDING = UiUtil.dp(context, 40);
			        TARGET_RADIUS = UiUtil.dp(context, target.targetRadius);
			        TEXT_PADDING = UiUtil.dp(context, 40);
			        TEXT_SPACING = UiUtil.dp(context, 8);
			        TEXT_MAX_WIDTH = UiUtil.dp(context, 360);
			        TEXT_POSITIONING_BIAS = UiUtil.dp(context, 20);
			        GUTTER_DIM = UiUtil.dp(context, 88);
			        SHADOW_DIM = UiUtil.dp(context, 8);
			        SHADOW_JITTER_DIM = UiUtil.dp(context, 1);
			        TARGET_PULSE_RADIUS = (int) (0.1f * TARGET_RADIUS);
			
			        outerCirclePath = new Path();
			        targetBounds = new Rect();
			        drawingBounds = new Rect();
			
			        titlePaint = new TextPaint();
			        titlePaint.setTextSize(target.titleTextSizePx(context));
			        titlePaint.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
			        titlePaint.setAntiAlias(true);
			
			        descriptionPaint = new TextPaint();
			        descriptionPaint.setTextSize(target.descriptionTextSizePx(context));
			        descriptionPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
			        descriptionPaint.setAntiAlias(true);
			        descriptionPaint.setAlpha((int) (0.54f * 255.0f));
			
			        outerCirclePaint = new Paint();
			        outerCirclePaint.setAntiAlias(true);
			        outerCirclePaint.setAlpha((int) (target.outerCircleAlpha * 255.0f));
			
			        outerCircleShadowPaint = new Paint();
			        outerCircleShadowPaint.setAntiAlias(true);
			        outerCircleShadowPaint.setAlpha(50);
			        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
			        outerCircleShadowPaint.setStrokeWidth(SHADOW_JITTER_DIM);
			        outerCircleShadowPaint.setColor(Color.BLACK);
			
			        targetCirclePaint = new Paint();
			        targetCirclePaint.setAntiAlias(true);
			
			        targetCirclePulsePaint = new Paint();
			        targetCirclePulsePaint.setAntiAlias(true);
			
			        applyTargetOptions(context);
			
			        globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
				            @Override
				            public void onGlobalLayout() {
					                if (isDismissing) {
						                    return;
						                }
					                updateTextLayouts();
					                target.onReady(new Runnable() {
						                    @Override
						                    public void run() {
							                        final int[] offset = new int[2];
							
							                        targetBounds.set(target.bounds());
							
							                        getLocationOnScreen(offset);
							                        targetBounds.offset(-offset[0], -offset[1]);
							
							                        if (boundingParent != null) {
								                            final WindowManager windowManager
								                                    = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
								                            final DisplayMetrics displayMetrics = new DisplayMetrics();
								                            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
								
								                            final Rect rect = new Rect();
								                            boundingParent.getWindowVisibleDisplayFrame(rect);
								
								                            // We bound the boundaries to be within the screen's coordinates to
								                            // handle the case where the layout bounds do not match
								                            // (like when FLAG_LAYOUT_NO_LIMITS is specified)
								                            topBoundary = Math.max(0, rect.top);
								                            bottomBoundary = Math.min(rect.bottom, displayMetrics.heightPixels);
								                        }
							
							                        drawTintedTarget();
							                        requestFocus();
							                        calculateDimensions();
							
							                        startExpandAnimation();
							                    }
						                });
					            }
				        };
			
			        getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
			
			        setFocusableInTouchMode(true);
			        setClickable(true);
			        setOnClickListener(new OnClickListener() {
				            @Override
				            public void onClick(View v) {
					                if (listener == null || outerCircleCenter == null || !isInteractable) return;
					
					                final boolean clickedInTarget =
					                        distance(targetBounds.centerX(), targetBounds.centerY(), (int) lastTouchX, (int) lastTouchY) <= targetCircleRadius;
					                final double distanceToOuterCircleCenter = distance(outerCircleCenter[0], outerCircleCenter[1],
					                        (int) lastTouchX, (int) lastTouchY);
					                final boolean clickedInsideOfOuterCircle = distanceToOuterCircleCenter <= outerCircleRadius;
					
					                if (clickedInTarget) {
						                    isInteractable = false;
						                    listener.onTargetClick(TapTargetView.this);
						                } else if (clickedInsideOfOuterCircle) {
						                    listener.onOuterCircleClick(TapTargetView.this);
						                } else if (cancelable) {
						                    isInteractable = false;
						                    listener.onTargetCancel(TapTargetView.this);
						                }
					            }
				        });
			
			        setOnLongClickListener(new OnLongClickListener() {
				            @Override
				            public boolean onLongClick(View v) {
					                if (listener == null) return false;
					
					                if (targetBounds.contains((int) lastTouchX, (int) lastTouchY)) {
						                    listener.onTargetLongClick(TapTargetView.this);
						                    return true;
						                }
					
					                return false;
					            }
				        });
			    }
		
		    private void startExpandAnimation() {
			        if (!visible) {
				            isInteractable = false;
				            expandAnimation.start();
				            visible = true;
				        }
			    }
		
		    protected void applyTargetOptions(Context context) {
			        shouldTintTarget = target.tintTarget;
			        shouldDrawShadow = target.drawShadow;
			        cancelable = target.cancelable;
			
			        // We can't clip out portions of a view outline, so if the user specified a transparent
			        // target, we need to fallback to drawing a jittered shadow approximation
			        if (shouldDrawShadow && Build.VERSION.SDK_INT >= 21 && !target.transparentTarget) {
				            outlineProvider = new ViewOutlineProvider() {
					                @Override
					                public void getOutline(View view, Outline outline) {
						                    if (outerCircleCenter == null) return;
						                    outline.setOval(
						                            (int) (outerCircleCenter[0] - outerCircleRadius), (int) (outerCircleCenter[1] - outerCircleRadius),
						                            (int) (outerCircleCenter[0] + outerCircleRadius), (int) (outerCircleCenter[1] + outerCircleRadius));
						                    outline.setAlpha(outerCircleAlpha / 255.0f);
						                    if (Build.VERSION.SDK_INT >= 22) {
							                        outline.offset(0, SHADOW_DIM);
							                    }
						                }
					            };
				
				            setOutlineProvider(outlineProvider);
				            setElevation(SHADOW_DIM);
				        }
			
			        if (shouldDrawShadow && outlineProvider == null && Build.VERSION.SDK_INT < 18) {
				            setLayerType(LAYER_TYPE_SOFTWARE, null);
				        } else {
				            setLayerType(LAYER_TYPE_HARDWARE, null);
				        }
			
			        final android.content.res.Resources.Theme theme = context.getTheme();
			        isDark = UiUtil.themeIntAttr(context, "isLightTheme") == 0;
			
			        final Integer outerCircleColor = target.outerCircleColorInt(context);
			        if (outerCircleColor != null) {
				            outerCirclePaint.setColor(outerCircleColor);
				        } else if (theme != null) {
				            outerCirclePaint.setColor(UiUtil.themeIntAttr(context, "colorPrimary"));
				        } else {
				            outerCirclePaint.setColor(Color.WHITE);
				        }
			
			        final Integer targetCircleColor = target.targetCircleColorInt(context);
			        if (targetCircleColor != null) {
				            targetCirclePaint.setColor(targetCircleColor);
				        } else {
				            targetCirclePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
				        }
			
			        if (target.transparentTarget) {
				            targetCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
				        }
			
			        targetCirclePulsePaint.setColor(targetCirclePaint.getColor());
			
			        final Integer targetDimColor = target.dimColorInt(context);
			        if (targetDimColor != null) {
				            dimColor = UiUtil.setAlpha(targetDimColor, 0.3f);
				        } else {
				            dimColor = -1;
				        }
			
			        final Integer titleTextColor = target.titleTextColorInt(context);
			        if (titleTextColor != null) {
				            titlePaint.setColor(titleTextColor);
				        } else {
				            titlePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
				        }
			
			        final Integer descriptionTextColor = target.descriptionTextColorInt(context);
			        if (descriptionTextColor != null) {
				            descriptionPaint.setColor(descriptionTextColor);
				        } else {
				            descriptionPaint.setColor(titlePaint.getColor());
				        }
			
			        if (target.titleTypeface != null) {
				            titlePaint.setTypeface(target.titleTypeface);
				        }
			
			        if (target.descriptionTypeface != null) {
				            descriptionPaint.setTypeface(target.descriptionTypeface);
				        }
			    }
		
		    @Override
		    protected void onDetachedFromWindow() {
			        super.onDetachedFromWindow();
			        onDismiss(false);
			    }
		
		    void onDismiss(boolean userInitiated) {
			        if (isDismissed) return;
			
			        isDismissing = false;
			        isDismissed = true;
			
			        for (final ValueAnimator animator : animators) {
				            animator.cancel();
				            animator.removeAllUpdateListeners();
				        }
			        ViewUtil.removeOnGlobalLayoutListener(getViewTreeObserver(), globalLayoutListener);
			        visible = false;
			
			        if (listener != null) {
				            listener.onTargetDismissed(this, userInitiated);
				        }
			    }
		
		    @Override
		    protected void onDraw(Canvas c) {
			        if (isDismissed || outerCircleCenter == null) return;
			
			        if (topBoundary > 0 && bottomBoundary > 0) {
				            c.clipRect(0, topBoundary, getWidth(), bottomBoundary);
				        }
			
			        if (dimColor != -1) {
				            c.drawColor(dimColor);
				        }
			
			        int saveCount;
			        outerCirclePaint.setAlpha(outerCircleAlpha);
			        if (shouldDrawShadow && outlineProvider == null) {
				            saveCount = c.save();
				            {
					                c.clipPath(outerCirclePath, Region.Op.DIFFERENCE);
					                drawJitteredShadow(c);
					            }
				            c.restoreToCount(saveCount);
				        }
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, outerCirclePaint);
			
			        targetCirclePaint.setAlpha(targetCircleAlpha);
			        if (targetCirclePulseAlpha > 0) {
				            targetCirclePulsePaint.setAlpha(targetCirclePulseAlpha);
				            c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
				                    targetCirclePulseRadius, targetCirclePulsePaint);
				        }
			        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
			                targetCircleRadius, targetCirclePaint);
			
			        saveCount = c.save();
			        {
				            c.translate(textBounds.left, textBounds.top);
				            titlePaint.setAlpha(textAlpha);
				            if (titleLayout != null) {
					                titleLayout.draw(c);
					            }
				
				            if (descriptionLayout != null && titleLayout != null) {
					                c.translate(0, titleLayout.getHeight() + TEXT_SPACING);
					                descriptionPaint.setAlpha((int) (target.descriptionTextAlpha * textAlpha));
					                descriptionLayout.draw(c);
					            }
				        }
			        c.restoreToCount(saveCount);
			
			        saveCount = c.save();
			        {
				            if (tintedTarget != null) {
					                c.translate(targetBounds.centerX() - tintedTarget.getWidth() / 2,
					                        targetBounds.centerY() - tintedTarget.getHeight() / 2);
					                c.drawBitmap(tintedTarget, 0, 0, targetCirclePaint);
					            } else if (target.icon != null) {
					                c.translate(targetBounds.centerX() - target.icon.getBounds().width() / 2,
					                        targetBounds.centerY() - target.icon.getBounds().height() / 2);
					                target.icon.setAlpha(targetCirclePaint.getAlpha());
					                target.icon.draw(c);
					            }
				        }
			        c.restoreToCount(saveCount);
			
			        if (debug) {
				            drawDebugInformation(c);
				        }
			    }
		
		    @Override
		    public boolean onTouchEvent(MotionEvent e) {
			        lastTouchX = e.getX();
			        lastTouchY = e.getY();
			        return super.onTouchEvent(e);
			    }
		
		    @Override
		    public boolean onKeyDown(int keyCode, KeyEvent event) {
			        if (isVisible() && cancelable && keyCode == KeyEvent.KEYCODE_BACK) {
				            event.startTracking();
				            return true;
				        }
			
			        return false;
			    }
		
		    @Override
		    public boolean onKeyUp(int keyCode, KeyEvent event) {
			        if (isVisible() && isInteractable && cancelable
			                && keyCode == KeyEvent.KEYCODE_BACK && event.isTracking() && !event.isCanceled()) {
				            isInteractable = false;
				
				            if (listener != null) {
					                listener.onTargetCancel(this);
					            } else {
					                new Listener().onTargetCancel(this);
					            }
				
				            return true;
				        }
			
			        return false;
			    }
		
		    /**
     * Dismiss this view
     * @param tappedTarget If the user tapped the target or not
     *                     (results in different dismiss animations)
     */
		    public void dismiss(boolean tappedTarget) {
			        isDismissing = true;
			        pulseAnimation.cancel();
			        expandAnimation.cancel();
			        if (tappedTarget) {
				            dismissConfirmAnimation.start();
				        } else {
				            dismissAnimation.start();
				        }
			    }
		
		    /** Specify whether to draw a wireframe around the view, useful for debugging **/
		    public void setDrawDebug(boolean status) {
			        if (debug != status) {
				            debug = status;
				            postInvalidate();
				        }
			    }
		
		    /** Returns whether this view is visible or not **/
		    public boolean isVisible() {
			        return !isDismissed && visible;
			    }
		
		    void drawJitteredShadow(Canvas c) {
			        final float baseAlpha = 0.20f * outerCircleAlpha;
			        outerCircleShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			        outerCircleShadowPaint.setAlpha((int) baseAlpha);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM, outerCircleRadius, outerCircleShadowPaint);
			        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
			        final int numJitters = 7;
			        for (int i = numJitters - 1; i > 0; --i) {
				            outerCircleShadowPaint.setAlpha((int) ((i / (float) numJitters) * baseAlpha));
				            c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM ,
				                    outerCircleRadius + (numJitters - i) * SHADOW_JITTER_DIM , outerCircleShadowPaint);
				        }
			    }
		
		    void drawDebugInformation(Canvas c) {
			        if (debugPaint == null) {
				            debugPaint = new Paint();
				            debugPaint.setARGB(255, 255, 0, 0);
				            debugPaint.setStyle(Paint.Style.STROKE);
				            debugPaint.setStrokeWidth(UiUtil.dp(getContext(), 1));
				        }
			
			        if (debugTextPaint == null) {
				            debugTextPaint = new TextPaint();
				            debugTextPaint.setColor(0xFFFF0000);
				            debugTextPaint.setTextSize(UiUtil.sp(getContext(), 16));
				        }
			
			        // Draw wireframe
			        debugPaint.setStyle(Paint.Style.STROKE);
			        c.drawRect(textBounds, debugPaint);
			        c.drawRect(targetBounds, debugPaint);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], 10, debugPaint);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], calculatedOuterCircleRadius - CIRCLE_PADDING, debugPaint);
			        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(), TARGET_RADIUS + TARGET_PADDING, debugPaint);
			
			        // Draw positions and dimensions
			        debugPaint.setStyle(Paint.Style.FILL);
			        final String debugText =
			                "Text bounds: " + textBounds.toShortString() + "\n" + "Target bounds: " + targetBounds.toShortString() + "\n" + "Center: " + outerCircleCenter[0] + " " + outerCircleCenter[1] + "\n" + "View size: " + getWidth() + " " + getHeight() + "\n" + "Target bounds: " + targetBounds.toShortString();
			
			        if (debugStringBuilder == null) {
				            debugStringBuilder = new SpannableStringBuilder(debugText);
				        } else {
				            debugStringBuilder.clear();
				            debugStringBuilder.append(debugText);
				        }
			
			        if (debugLayout == null) {
				            debugLayout = new DynamicLayout(debugText, debugTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				        }
			
			        final int saveCount = c.save();
			        {
				            debugPaint.setARGB(220, 0, 0, 0);
				            c.translate(0.0f, topBoundary);
				            c.drawRect(0.0f, 0.0f, debugLayout.getWidth(), debugLayout.getHeight(), debugPaint);
				            debugPaint.setARGB(255, 255, 0, 0);
				            debugLayout.draw(c);
				        }
			        c.restoreToCount(saveCount);
			    }
		
		    void drawTintedTarget() {
			        final android.graphics.drawable.Drawable icon = target.icon;
			        if (!shouldTintTarget || icon == null) {
				            tintedTarget = null;
				            return;
				        }
			
			        if (tintedTarget != null) return;
			
			        tintedTarget = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(),
			                Bitmap.Config.ARGB_8888);
			        final Canvas canvas = new Canvas(tintedTarget);
			        icon.setColorFilter(new PorterDuffColorFilter(
			                outerCirclePaint.getColor(), PorterDuff.Mode.SRC_ATOP));
			        icon.draw(canvas);
			        icon.setColorFilter(null);
			    }
		
		    void updateTextLayouts() {
			        final int textWidth = Math.min(getWidth(), TEXT_MAX_WIDTH) - TEXT_PADDING * 2;
			        if (textWidth <= 0) {
				            return;
				        }
			
			        titleLayout = new StaticLayout(title, titlePaint, textWidth,
			                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
			
			        if (description != null) {
				            descriptionLayout = new StaticLayout(description, descriptionPaint, textWidth,
				                    Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				        } else {
				            descriptionLayout = null;
				        }
			    }
		
		    float halfwayLerp(float lerp) {
			        if (lerp < 0.5f) {
				            return lerp / 0.5f;
				        }
			
			        return (1.0f - lerp) / 0.5f;
			    }
		
		    float delayedLerp(float lerp, float threshold) {
			        if (lerp < threshold) {
				            return 0.0f;
				        }
			
			        return (lerp - threshold) / (1.0f - threshold);
			    }
		
		    void calculateDimensions() {
			        textBounds = getTextBounds();
			        outerCircleCenter = getOuterCircleCenterPoint();
			        calculatedOuterCircleRadius = getOuterCircleRadius(outerCircleCenter[0], outerCircleCenter[1], textBounds, targetBounds);
			    }
		
		    void calculateDrawingBounds() {
			        if (outerCircleCenter == null) {
				            // Called dismiss before we got a chance to display the tap target
				            // So we have no center -> cant determine the drawing bounds
				            return;
				        }
			        drawingBounds.left = (int) Math.max(0, outerCircleCenter[0] - outerCircleRadius);
			        drawingBounds.top = (int) Math.min(0, outerCircleCenter[1] - outerCircleRadius);
			        drawingBounds.right = (int) Math.min(getWidth(),
			                outerCircleCenter[0] + outerCircleRadius + CIRCLE_PADDING);
			        drawingBounds.bottom = (int) Math.min(getHeight(),
			                outerCircleCenter[1] + outerCircleRadius + CIRCLE_PADDING);
			    }
		
		    int getOuterCircleRadius(int centerX, int centerY, Rect textBounds, Rect targetBounds) {
			        final int targetCenterX = targetBounds.centerX();
			        final int targetCenterY = targetBounds.centerY();
			        final int expandedRadius = (int) (1.1f * TARGET_RADIUS);
			        final Rect expandedBounds = new Rect(targetCenterX, targetCenterY, targetCenterX, targetCenterY);
			        expandedBounds.inset(-expandedRadius, -expandedRadius);
			
			        final int textRadius = maxDistanceToPoints(centerX, centerY, textBounds);
			        final int targetRadius = maxDistanceToPoints(centerX, centerY, expandedBounds);
			        return Math.max(textRadius, targetRadius) + CIRCLE_PADDING;
			    }
		
		    Rect getTextBounds() {
			        final int totalTextHeight = getTotalTextHeight();
			        final int totalTextWidth = getTotalTextWidth();
			
			        final int possibleTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight;
			        final int top;
			        if (possibleTop > topBoundary) {
				            top = possibleTop;
				        } else {
				            top = targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING;
				        }
			
			        final int relativeCenterDistance = (getWidth() / 2) - targetBounds.centerX();
			        final int bias = relativeCenterDistance < 0 ? -TEXT_POSITIONING_BIAS : TEXT_POSITIONING_BIAS;
			        final int left = Math.max(TEXT_PADDING, targetBounds.centerX() - bias - totalTextWidth);
			        final int right = Math.min(getWidth() - TEXT_PADDING, left + totalTextWidth);
			        return new Rect(left, top, right, top + totalTextHeight);
			    }
		
		    int[] getOuterCircleCenterPoint() {
			        if (inGutter(targetBounds.centerY())) {
				            return new int[]{targetBounds.centerX(), targetBounds.centerY()};
				        }
			
			        final int targetRadius = Math.max(targetBounds.width(), targetBounds.height()) / 2 + TARGET_PADDING;
			        final int totalTextHeight = getTotalTextHeight();
			
			        final boolean onTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight > 0;
			
			        final int left = Math.min(textBounds.left, targetBounds.left - targetRadius);
			        final int right = Math.max(textBounds.right, targetBounds.right + targetRadius);
			        final int titleHeight = titleLayout == null ? 0 : titleLayout.getHeight();
			        final int centerY = onTop ?
			                targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight + titleHeight
			                :
			                targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING + titleHeight;
			
			        return new int[] { (left + right) / 2, centerY };
			    }
		
		    int getTotalTextHeight() {
			        if (titleLayout == null) {
				            return 0;
				        }
			
			        if (descriptionLayout == null) {
				            return titleLayout.getHeight() + TEXT_SPACING;
				        }
			
			        return titleLayout.getHeight() + descriptionLayout.getHeight() + TEXT_SPACING;
			    }
		
		    int getTotalTextWidth() {
			        if (titleLayout == null) {
				            return 0;
				        }
			
			        if (descriptionLayout == null) {
				            return titleLayout.getWidth();
				        }
			
			        return Math.max(titleLayout.getWidth(), descriptionLayout.getWidth());
			    }
		    boolean inGutter(int y) {
			        if (bottomBoundary > 0) {
				            return y < GUTTER_DIM || y > bottomBoundary - GUTTER_DIM;
				        } else {
				            return y < GUTTER_DIM || y > getHeight() - GUTTER_DIM;
				        }
			    }
		    int maxDistanceToPoints(int x1, int y1, Rect bounds) {
			        final double tl = distance(x1, y1, bounds.left, bounds.top);
			        final double tr = distance(x1, y1, bounds.right, bounds.top);
			        final double bl = distance(x1, y1, bounds.left, bounds.bottom);
			        final double br = distance(x1, y1, bounds.right, bounds.bottom);
			        return (int) Math.max(tl, Math.max(tr, Math.max(bl, br)));
			    }
		    double distance(int x1, int y1, int x2, int y2) {
			        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			    }
		    void invalidateViewAndOutline(Rect bounds) {
			        invalidate(bounds);
			        if (outlineProvider != null && Build.VERSION.SDK_INT >= 21) {
				            invalidateOutline();
				        }
			    }
	}
	
	static class ViewUtil {
		
		    ViewUtil() {}
		
		    private static boolean isLaidOut(View view) {
			        return true;
			    }
		    static void onLaidOut(final View view, final Runnable runnable) {
			        if (isLaidOut(view)) {
				            runnable.run();
				            return;
				        }
			        final ViewTreeObserver observer = view.getViewTreeObserver();
			        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				            @Override
				            public void onGlobalLayout() {
					                final ViewTreeObserver trueObserver;
					                if (observer.isAlive()) {
						                    trueObserver = observer;
						                } else {
						                    trueObserver = view.getViewTreeObserver();
						                }
					                removeOnGlobalLayoutListener(trueObserver, this);
					                runnable.run();
					            }
				        });
			    }
		    @SuppressWarnings("deprecation")
		    static void removeOnGlobalLayoutListener(ViewTreeObserver observer,
		                                             ViewTreeObserver.OnGlobalLayoutListener listener) {
			        if (Build.VERSION.SDK_INT >= 16) {
				            observer.removeOnGlobalLayoutListener(listener);
				        } else {
				            observer.removeGlobalOnLayoutListener(listener);
				        }
			    }
		    static void removeView(ViewManager parent, View child) {
			        if (parent == null || child == null) {
				            return;
				        }
			        try {
				            parent.removeView(child);
				        } catch (Exception ignored) {
				        }
			    }
	}
	
	static class ViewTapTarget extends TapTarget {
		    final View view;
		
		    ViewTapTarget(View view, CharSequence title,  CharSequence description) {
			        super(title, description);
			        if (view == null) {
				            throw new IllegalArgumentException("Given null view to target");
				        }
			        this.view = view;
			    }
		
		    @Override
		    public void onReady(final Runnable runnable) {
			        ViewUtil.onLaidOut(view, new Runnable() {
				            @Override
				            public void run() {
					                // Cache bounds
					                final int[] location = new int[2];
					                view.getLocationOnScreen(location);
					                bounds = new Rect(location[0], location[1],
					                        location[0] + view.getWidth(), location[1] + view.getHeight());
					
					                if (icon == null && view.getWidth() > 0 && view.getHeight() > 0) {
						                    final Bitmap viewBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
						                    final Canvas canvas = new Canvas(viewBitmap);
						                    view.draw(canvas);
						                    icon = new android.graphics.drawable.BitmapDrawable(view.getContext().getResources(), viewBitmap);
						                    icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
						                }
					
					                runnable.run();
					            }
				        });
			    }
	}
	
	
	public void _download() {
	}
	private class ProgDiagTask extends AsyncTask<String, Integer, String> {
			ProgressDialog prog;
			@Override
			protected void onPreExecute() {
					super.onPreExecute();
					prog = new ProgressDialog(HomeActivity.this);
					prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
									prog.setMax(100);
									prog.setIndeterminate(false);
									prog.setCancelable(false);
									prog.setCanceledOnTouchOutside(false);
					prog.setTitle("My Skills");
					prog.setMessage("Downloading...");
					prog.show();
			}
			
			String filename = "";
			String result = "";
			double size = 0;
			double sumCount = 0;
			
			@Override
			protected String doInBackground(String... address) {
					try {
							filename= URLUtil.guessFileName(address[0], null, null);
							prog.setMessage("\nDownloading: ".concat(filename));
							int resCode = -1;
							java.io.InputStream in = null;
							java.net.URL url = new java.net.URL(address[0]);
							java.net.URLConnection urlConn = url.openConnection();
							if (!(urlConn instanceof java.net.HttpURLConnection)) {
									throw new java.io.IOException("URL is not an Http URL"); }
							java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) urlConn; httpConn.setAllowUserInteraction(false); httpConn.setInstanceFollowRedirects(true); httpConn.setRequestMethod("GET"); httpConn.connect();
							resCode = httpConn.getResponseCode();
							if (resCode == java.net.HttpURLConnection.HTTP_OK) {
									in = httpConn.getInputStream();
									size = httpConn.getContentLength();
									
							} else { result = "There was an error"; }
							
							String path =FileUtil.getExternalStorageDir().concat("/Download/".concat(filename));
							
							java.io.File file = new java.io.File(path);
							
							java.io.OutputStream output = new java.io.FileOutputStream(file);
							try {
									int bytesRead;
									sumCount = 0;
									byte[] buffer = new byte[1024];
									while ((bytesRead = in.read(buffer)) != -1) {
											output.write(buffer, 0, bytesRead);
											sumCount += bytesRead;
											if (size > 0) {
													publishProgress((int)Math.round(sumCount*100 / size));
											}
									}
							} finally {
									output.close();
							}
							in.close();
					} catch (java.net.MalformedURLException e) {
							result = e.getMessage();
					} catch (java.io.IOException e) {
							result = e.getMessage();
					} catch (Exception e) {
							result = e.toString();
					}
					return result;
			}
			@Override
			protected void onProgressUpdate(Integer... values) {
					super.onProgressUpdate(values);
					prog.setProgress(values[values.length - 1]);
					double num = prog.getProgress();
					
			}
			@Override
			protected void onPostExecute(String s){
					if (filename.contains(".apk")) {
							_Install("/Download/".concat(filename));
					}
					prog.dismiss();
			}
	}
	
	
	public void _Install(final String _apk) {
		String PATH = Environment.getExternalStorageDirectory() + _apk;
		    java.io.File file = new java.io.File(PATH);
		    if(file.exists()) {
				        Intent intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(uriFromFile(getApplicationContext(), new java.io.File(PATH)), "application/vnd.android.package-archive");
				        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
				        try {
						            getApplicationContext().startActivity(intent);
						        } catch (ActivityNotFoundException e) {
						            e.printStackTrace();
						            Log.e("TAG", "Error in opening the file!");
						        }
				    }else{
				        Toast.makeText(getApplicationContext(),"installing",Toast.LENGTH_LONG).show();
				    }
	}
	Uri uriFromFile(Context context, java.io.File file) {
		    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
				        return androidx.core.content.FileProvider.getUriForFile(context,context.getApplicationContext().getPackageName() + ".provider", file); 
				    } else {
				        return Uri.fromFile(file);
				    }
	}
	
	public class Viewpager1Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.slider_cus, _container, false);
			
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear_custom = _view.findViewById(R.id.linear_custom);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final TextView title1 = _view.findViewById(R.id.title1);
			
			if (_position == 0) {
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("img1", ""))).into(imageview1);
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("icon1", ""))).into(imageview3);
				title1.setText(data.getString("title1", ""));
			}
			if (_position == 1) {
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("img2", ""))).into(imageview1);
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("icon2", ""))).into(imageview3);
				title1.setText(data.getString("title2", ""));
			}
			if (_position == 2) {
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("img3", ""))).into(imageview1);
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("icon3", ""))).into(imageview3);
				title1.setText(data.getString("title3", ""));
			}
			if (_position == 3) {
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("img4", ""))).into(imageview1);
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("icon4", ""))).into(imageview3);
				title1.setText(data.getString("title4", ""));
			}
			if (_position == 4) {
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("img5", ""))).into(imageview1);
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("icon5", ""))).into(imageview3);
				title1.setText(data.getString("title5", ""));
			}
			if (_position == 5) {
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("img6", ""))).into(imageview1);
				Glide.with(getApplicationContext()).load(Uri.parse(data.getString("icon6", ""))).into(imageview3);
				title1.setText(data.getString("title6", ""));
			}
			
			_container.addView(_view);
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