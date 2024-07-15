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
import com.google.android.material.snackbar.Snackbar;

public class CoursePageActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout linear53;
	private LinearLayout linear1;
	private LinearLayout visball;
	private LinearLayout linear55;
	private LinearLayout linear56;
	private ShimmerFrameLayout shimmer;
	private LinearLayout linear58;
	private LinearLayout linear59;
	private LinearLayout linear60;
	private LinearLayout linear61;
	private TextView textview19;
	private ImageView imageview9;
	private LinearLayout shimmerr;
	private LinearLayout shimu;
	private TextView textview24;
	private ShimmerFrameLayout shim1;
	private ShimmerFrameLayout shim2;
	private ShimmerFrameLayout shim3;
	private LinearLayout linear67;
	private LinearLayout linear68;
	private LinearLayout linear69;
	private LinearLayout linear70;
	private LinearLayout linear71;
	private LinearLayout linear72;
	private LinearLayout linear73;
	private LinearLayout linear74;
	private ShimmerFrameLayout shimbt;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear11;
	private LinearLayout corve;
	private LinearLayout linear13;
	private LinearLayout linear5;
	private TextView course_name;
	private ImageView imageview1;
	private TextView course_na;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private TextView course_dis;
	private TextView couse_ty;
	private TextView textview4;
	private TextView subje2;
	private LinearLayout linear16;
	private LinearLayout linear15;
	private LinearLayout linear14;
	private LinearLayout vid_box;
	private LinearLayout linear21;
	private ImageView imageview2;
	private TextView video_c;
	private TextView video_d;
	private LinearLayout pdf;
	private LinearLayout linear23;
	private ImageView imageview3;
	private LinearLayout linear26;
	private TextView pfd_c;
	private TextView pdf_d;
	private LinearLayout test;
	private LinearLayout linear25;
	private ImageView imageview4;
	private LinearLayout linear27;
	private TextView rs_c;
	private TextView rs_d;
	private LinearLayout linear18;
	private TextView price;
	private TextView pay;
	
	private DatabaseReference db = _firebase.getReference("course/intro_data");
	private ChildEventListener _db_child_listener;
	private Vibrator vi;
	private Intent in = new Intent();
	private TimerTask ti;
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
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.course_page);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear53 = findViewById(R.id.linear53);
		linear1 = findViewById(R.id.linear1);
		visball = findViewById(R.id.visball);
		linear55 = findViewById(R.id.linear55);
		linear56 = findViewById(R.id.linear56);
		shimmer = findViewById(R.id.shimmer);
		linear58 = findViewById(R.id.linear58);
		linear59 = findViewById(R.id.linear59);
		linear60 = findViewById(R.id.linear60);
		linear61 = findViewById(R.id.linear61);
		textview19 = findViewById(R.id.textview19);
		imageview9 = findViewById(R.id.imageview9);
		shimmerr = findViewById(R.id.shimmerr);
		shimu = findViewById(R.id.shimu);
		textview24 = findViewById(R.id.textview24);
		shim1 = findViewById(R.id.shim1);
		shim2 = findViewById(R.id.shim2);
		shim3 = findViewById(R.id.shim3);
		linear67 = findViewById(R.id.linear67);
		linear68 = findViewById(R.id.linear68);
		linear69 = findViewById(R.id.linear69);
		linear70 = findViewById(R.id.linear70);
		linear71 = findViewById(R.id.linear71);
		linear72 = findViewById(R.id.linear72);
		linear73 = findViewById(R.id.linear73);
		linear74 = findViewById(R.id.linear74);
		shimbt = findViewById(R.id.shimbt);
		linear2 = findViewById(R.id.linear2);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear11 = findViewById(R.id.linear11);
		corve = findViewById(R.id.corve);
		linear13 = findViewById(R.id.linear13);
		linear5 = findViewById(R.id.linear5);
		course_name = findViewById(R.id.course_name);
		imageview1 = findViewById(R.id.imageview1);
		course_na = findViewById(R.id.course_na);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		course_dis = findViewById(R.id.course_dis);
		couse_ty = findViewById(R.id.couse_ty);
		textview4 = findViewById(R.id.textview4);
		subje2 = findViewById(R.id.subje2);
		linear16 = findViewById(R.id.linear16);
		linear15 = findViewById(R.id.linear15);
		linear14 = findViewById(R.id.linear14);
		vid_box = findViewById(R.id.vid_box);
		linear21 = findViewById(R.id.linear21);
		imageview2 = findViewById(R.id.imageview2);
		video_c = findViewById(R.id.video_c);
		video_d = findViewById(R.id.video_d);
		pdf = findViewById(R.id.pdf);
		linear23 = findViewById(R.id.linear23);
		imageview3 = findViewById(R.id.imageview3);
		linear26 = findViewById(R.id.linear26);
		pfd_c = findViewById(R.id.pfd_c);
		pdf_d = findViewById(R.id.pdf_d);
		test = findViewById(R.id.test);
		linear25 = findViewById(R.id.linear25);
		imageview4 = findViewById(R.id.imageview4);
		linear27 = findViewById(R.id.linear27);
		rs_c = findViewById(R.id.rs_c);
		rs_d = findViewById(R.id.rs_d);
		linear18 = findViewById(R.id.linear18);
		price = findViewById(R.id.price);
		pay = findViewById(R.id.pay);
		vi = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		auth = FirebaseAuth.getInstance();
		
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vi.vibrate((long)(50));
				intent.setClass(getApplicationContext(), AlfabachActivity.class);
				intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("course_name")) {
					course_na.setText(_childValue.get("course_name").toString());
				}
				if (_childValue.containsKey("course_discription")) {
					course_dis.setText(_childValue.get("course_discription").toString());
				}
				if (_childValue.containsKey("course_type")) {
					couse_ty.setText(_childValue.get("course_type").toString());
				}
				if (_childValue.containsKey("video_c")) {
					video_c.setText(_childValue.get("video_c").toString());
				}
				if (_childValue.containsKey("video_d")) {
					video_d.setText(_childValue.get("video_d").toString());
				}
				if (_childValue.containsKey("pdf_c")) {
					pfd_c.setText(_childValue.get("pdf_c").toString());
				}
				if (_childValue.containsKey("pdf_d")) {
					pdf_d.setText(_childValue.get("pdf_d").toString());
				}
				if (_childValue.containsKey("recourse_c")) {
					rs_c.setText(_childValue.get("recourse_c").toString());
				}
				if (_childValue.containsKey("recourse_d")) {
					rs_d.setText(_childValue.get("recourse_d").toString());
				}
				if (_childValue.containsKey("pay")) {
					pay.setText(_childValue.get("pay").toString());
				}
				ti = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								vi.vibrate((long)(50));
								linear1.setVisibility(View.VISIBLE);
								linear53.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(ti, (int)(1000));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("course_name")) {
					course_na.setText(_childValue.get("course_name").toString());
				}
				if (_childValue.containsKey("course_discription")) {
					course_dis.setText(_childValue.get("course_discription").toString());
				}
				if (_childValue.containsKey("course_type")) {
					couse_ty.setText(_childValue.get("course_type").toString());
				}
				if (_childValue.containsKey("video_c")) {
					video_c.setText(_childValue.get("video_c").toString());
				}
				if (_childValue.containsKey("video_d")) {
					video_d.setText(_childValue.get("video_d").toString());
				}
				if (_childValue.containsKey("pdf_c")) {
					pfd_c.setText(_childValue.get("pdf_c").toString());
				}
				if (_childValue.containsKey("pdf_d")) {
					pdf_d.setText(_childValue.get("pdf_d").toString());
				}
				if (_childValue.containsKey("recourse_c")) {
					rs_c.setText(_childValue.get("recourse_c").toString());
				}
				if (_childValue.containsKey("recourse_d")) {
					rs_d.setText(_childValue.get("recourse_d").toString());
				}
				if (_childValue.containsKey("pay")) {
					pay.setText(_childValue.get("pay").toString());
				}
				ti = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								vi.vibrate((long)(50));
								linear1.setVisibility(View.VISIBLE);
								linear53.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(ti, (int)(1000));
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
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("Verified")) {
						if (_childValue.get("Verified").toString().equals("true")) {
							linear18.setVisibility(View.VISIBLE);
						}
						else {
							linear18.setVisibility(View.GONE);
						}
					}
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
							linear18.setVisibility(View.VISIBLE);
						}
						else {
							linear18.setVisibility(View.GONE);
						}
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
		_uix();
		_shimmery();
		linear1.setVisibility(View.GONE);
		linear53.setVisibility(View.VISIBLE);
	}
	
	
	@Override
	public void onBackPressed() {
		vi.vibrate((long)(40));
		intent.setClass(getApplicationContext(), HomeActivity.class);
		intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent);
	}
	public void _snacknar(final String _txt, final String _btn) {
		Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), _txt, Snackbar.LENGTH_LONG);
		snackbar.setAction(_btn, new View.OnClickListener() {
			    @Override
			    public void onClick(View view) {
				        // Do something when the button is clicked
				    }
		});
		snackbar.setActionTextColor(Color.parseColor("#f76969"));
		snackbar.show();
	}
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.loading);
			
			
			LinearLayout linear2 = (LinearLayout)coreprog.findViewById(R.id.linear2);
			
			LinearLayout back = (LinearLayout)coreprog.findViewById(R.id.background);
			
			LinearLayout layout_progress = (LinearLayout)coreprog.findViewById(R.id.layout_progress);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
			gd.setColor(Color.parseColor("#BDBDBD")); /* color */
			gd.setCornerRadius(40); /* radius */
			gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
			linear2.setBackground(gd);
			
			RadialProgressView progress = new RadialProgressView(this);
			layout_progress.addView(progress);
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _shape(final double _top1, final double _top2, final double _bottom2, final double _bottom1, final String _inside_color, final String _side_color, final double _side_size, final View _view) {
		Double tlr = _top1;
		Double trr = _top2;
		Double blr = _bottom2;
		Double brr = _bottom1;
		Double sw = _side_size;
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
		s.setCornerRadii(new float[] {tlr.floatValue(),tlr.floatValue(), trr.floatValue(),trr.floatValue(), blr.floatValue(),blr.floatValue(), brr.floatValue(),brr.floatValue()}); 
		
		s.setColor(Color.parseColor(_inside_color));
		s.setStroke(sw.intValue(), Color.parseColor(_side_color));
		_view.setBackground(s);
	}
	
	
	public void _uix() {
		linear18.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFF3500A5));
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 0);
		subje2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppins_medium.ttf"), 1);
		_shape(60, 60, 0, 0, "#ffffff", "#ffffff", 0, corve);
		test.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFFF44336, 0xFFFFFFFF));
		pdf.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFFFB8C00, 0xFFFFFFFF));
		vid_box.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)2, 0xFF4CAF50, 0xFFFFFFFF));
	}
	
	
	public void _shimmery() {
		shimmerr.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF7986CB));
		shim1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shim2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shim3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		shimbt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF7986CB));
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