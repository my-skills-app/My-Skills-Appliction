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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

public class ProfileSectionActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private LinearLayout linear1;
	private LinearLayout top_bg;
	private LinearLayout linear59;
	private LinearLayout bottam_navigation;
	private LinearLayout shimmet;
	private ScrollView vscroll2;
	private LinearLayout linear77;
	private LinearLayout linear78;
	private ShimmerFrameLayout s6;
	private ShimmerFrameLayout s7;
	private ShimmerFrameLayout s8;
	private LinearLayout shimeruuu;
	private LinearLayout linear80;
	private LinearLayout coatd;
	private TextView textview41;
	private LinearLayout linear82;
	private ShimmerFrameLayout s3;
	private ShimmerFrameLayout s2;
	private ShimmerFrameLayout s1;
	private LinearLayout linear83;
	private ShimmerFrameLayout s4;
	private ShimmerFrameLayout s5;
	private CircleImageView circleimageview3;
	private LinearLayout linear9;
	private LinearLayout linear_bg2;
	private LinearLayout privicy;
	private LinearLayout teacher_contects;
	private LinearLayout freedback;
	private LinearLayout update;
	private LinearLayout nss;
	private LinearLayout devloped;
	private LinearLayout linear_bg;
	private LinearLayout linear52;
	private LinearLayout linear_t;
	private TextView textview20;
	private LinearLayout linear53;
	private TextView textview26;
	private TextView textview27;
	private TextView textview28;
	private LinearLayout linear51;
	private TextView textview18;
	private TextView textview19;
	private CircleImageView circleimageview1;
	private ImageView greentick;
	private ImageView imageview7;
	private TextView textview8;
	private ImageView imageview8;
	private TextView textview9;
	private ImageView imageview10;
	private TextView textview11;
	private ImageView imageview11;
	private TextView textview12;
	private ImageView imageview13;
	private TextView textview14;
	private LinearLayout linear22;
	private ImageView imageview12;
	private TextView textview13;
	private LinearLayout linear17;
	private LinearLayout linear61;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private ImageView imageview3;
	private ImageView imageview2;
	private ImageView imageview4;
	private TextView textview4;
	
	private Intent tom = new Intent();
	private Vibrator vab;
	private Intent intent = new Intent();
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
	
	private TimerTask tt;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile_section);
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
		shimmet = findViewById(R.id.shimmet);
		vscroll2 = findViewById(R.id.vscroll2);
		linear77 = findViewById(R.id.linear77);
		linear78 = findViewById(R.id.linear78);
		s6 = findViewById(R.id.s6);
		s7 = findViewById(R.id.s7);
		s8 = findViewById(R.id.s8);
		shimeruuu = findViewById(R.id.shimeruuu);
		linear80 = findViewById(R.id.linear80);
		coatd = findViewById(R.id.coatd);
		textview41 = findViewById(R.id.textview41);
		linear82 = findViewById(R.id.linear82);
		s3 = findViewById(R.id.s3);
		s2 = findViewById(R.id.s2);
		s1 = findViewById(R.id.s1);
		linear83 = findViewById(R.id.linear83);
		s4 = findViewById(R.id.s4);
		s5 = findViewById(R.id.s5);
		circleimageview3 = findViewById(R.id.circleimageview3);
		linear9 = findViewById(R.id.linear9);
		linear_bg2 = findViewById(R.id.linear_bg2);
		privicy = findViewById(R.id.privicy);
		teacher_contects = findViewById(R.id.teacher_contects);
		freedback = findViewById(R.id.freedback);
		update = findViewById(R.id.update);
		nss = findViewById(R.id.nss);
		devloped = findViewById(R.id.devloped);
		linear_bg = findViewById(R.id.linear_bg);
		linear52 = findViewById(R.id.linear52);
		linear_t = findViewById(R.id.linear_t);
		textview20 = findViewById(R.id.textview20);
		linear53 = findViewById(R.id.linear53);
		textview26 = findViewById(R.id.textview26);
		textview27 = findViewById(R.id.textview27);
		textview28 = findViewById(R.id.textview28);
		linear51 = findViewById(R.id.linear51);
		textview18 = findViewById(R.id.textview18);
		textview19 = findViewById(R.id.textview19);
		circleimageview1 = findViewById(R.id.circleimageview1);
		greentick = findViewById(R.id.greentick);
		imageview7 = findViewById(R.id.imageview7);
		textview8 = findViewById(R.id.textview8);
		imageview8 = findViewById(R.id.imageview8);
		textview9 = findViewById(R.id.textview9);
		imageview10 = findViewById(R.id.imageview10);
		textview11 = findViewById(R.id.textview11);
		imageview11 = findViewById(R.id.imageview11);
		textview12 = findViewById(R.id.textview12);
		imageview13 = findViewById(R.id.imageview13);
		textview14 = findViewById(R.id.textview14);
		linear22 = findViewById(R.id.linear22);
		imageview12 = findViewById(R.id.imageview12);
		textview13 = findViewById(R.id.textview13);
		linear17 = findViewById(R.id.linear17);
		linear61 = findViewById(R.id.linear61);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		imageview3 = findViewById(R.id.imageview3);
		imageview2 = findViewById(R.id.imageview2);
		imageview4 = findViewById(R.id.imageview4);
		textview4 = findViewById(R.id.textview4);
		vab = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		auth = FirebaseAuth.getInstance();
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vab.vibrate((long)(50));
				intent.setClass(getApplicationContext(), BooksActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vab.vibrate((long)(50));
				intent.setClass(getApplicationContext(), HomeActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					textview18.setText(_childValue.get("User_Name").toString());
				}
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("Verified")) {
						if (_childValue.get("Verified").toString().equals("true")) {
							greentick.setVisibility(View.VISIBLE);
						}
						else {
							greentick.setVisibility(View.GONE);
						}
					}
					textview19.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
				}
				tt = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								vab.vibrate((long)(50));
								vscroll2.setVisibility(View.VISIBLE);
								shimmet.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(tt, (int)(1000));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					textview18.setText(_childValue.get("User_Name").toString());
				}
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("Verified")) {
						if (_childValue.get("Verified").toString().equals("true")) {
							greentick.setVisibility(View.VISIBLE);
						}
						else {
							greentick.setVisibility(View.GONE);
						}
					}
					textview19.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
				}
				tt = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								vab.vibrate((long)(50));
								vscroll2.setVisibility(View.VISIBLE);
								shimmet.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(tt, (int)(1000));
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
		user.addChildEventListener(_user_child_listener);
		
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
		_Uix();
		_shimme();
		vscroll2.setVisibility(View.GONE);
		shimmet.setVisibility(View.VISIBLE);
	}
	
	@Override
	public void onBackPressed() {
		vab.vibrate((long)(50));
		intent.setClass(getApplicationContext(), HomeActivity.class);
		intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent);
	}
	public void _Uix() {
		_set_radius(linear_bg, "#FF3500A5", 0, 0, 40, 40);
		_set_radius(shimeruuu, "#FF3500A5", 0, 0, 40, 40);
		_set_radius(bottam_navigation, "#FF3500A5", 40, 40, 0, 0);
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#FF3500A5")); }
		
		
		textview26.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 1);
		_removeScollBar(vscroll2);
		linear_t.setElevation((int)5);
		linear_t.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		privicy.setElevation((int)5);
		privicy.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		teacher_contects.setElevation((int)5);
		teacher_contects.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		freedback.setElevation((int)5);
		freedback.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		update.setElevation((int)5);
		update.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		nss.setElevation((int)5);
		nss.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		devloped.setElevation((int)5);
		devloped.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
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
	
	
	public void _shimme() {
		s1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFC5CAE9));
		s2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF9FA8DA));
		s3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF9FA8DA));
		s4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		s5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		s6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		s7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		s8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		coatd.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
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