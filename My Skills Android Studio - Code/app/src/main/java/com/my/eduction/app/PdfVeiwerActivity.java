package com.my.eduction.app;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aghajari.waveanimation.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.facebook.shimmer.*;
import com.github.barteksc.pdfviewer.*;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.smarteist.autoimageslider.*;
import com.unity3d.ads.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import okhttp3.*;
import org.jetbrains.kotlin.*;
import org.json.*;

import com.github.barteksc.pdfviewer.PDFView;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class PdfVeiwerActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String pdfurl = "";
	
	private PDFView pdfView;
	private AdView adview1;
	
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private TimerTask tt;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pdf_veiwer);
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
		pdfView = findViewById(R.id.pdfView);
		adview1 = findViewById(R.id.adview1);
		net = new RequestNetwork(this);
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		
		
		pdfurl = getIntent().getStringExtra("git");
		/*
Glide.with(getApplicationContext()).load(Uri.parse("dont touch me")).into(dont touch me);
*/
		new RetrivePDFfromUrl().execute(pdfurl);
		{
			AdRequest adRequest = new AdRequest.Builder().build();
			adview1.loadAd(adRequest);
		}
	}
	
	
	@Override
	public void onBackPressed() {
		
		intent.setClass(getApplicationContext(), BooksActivity.class);
		startActivity(intent);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (adview1 != null) {
			adview1.destroy();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (adview1 != null) {
			adview1.pause();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (adview1 != null) {
			adview1.resume();
		}
	}
	public void _extra() {
	}
	class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
		
		        @Override
		        protected InputStream doInBackground(String... strings) {
			            //we are using inputstream for getting out PDF.
			            InputStream inputStream = null;
			            try {
				                URL url = new URL(strings[0]);
				                // below is the step where we are creating our connection.
				                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
				                if (urlConnection.getResponseCode() == 200) {
					                    //response is success.
					                    //we are getting input stream from url and storing it in our variable.
					                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
					
					                }
				
				            } catch (IOException e) {
				                //this is the method to handle errors.
				                e.printStackTrace();
				                return null;
				            }
			
			            return inputStream;
			        }
		
		        @Override
		        protected void onPostExecute(InputStream inputStream) {
			            // after the execution of our async task we are loading our pdf in our pdf view.
			            pdfView.fromStream(inputStream).load();
			
			        }
		    }
		
		
		public static class SliderData {
		
		    //image url is used to store the url of image
		    private String imgUrl;
		
		    //Constructor method.
		    public SliderData(String imgUrl) {
			        this.imgUrl = imgUrl;
			    }
		    //Getter method
		    public String getImgUrl() {
			        return imgUrl;
			    }
		    //Setter method
		    public void setImgUrl(String imgUrl) {
			        this.imgUrl = imgUrl;
			    }
	}
	
		public static class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {
		    //list for storing urls of images.
		    private final List<SliderData> mSliderItems;
		    //Constructor
		    public SliderAdapter(Context context, ArrayList<SliderData> sliderDataArrayList) {
			        this.mSliderItems = sliderDataArrayList;
			    }
		
		    //We are inflating the slider_layout inside on Create View Holder method.
		    @Override
		    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
			        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
			        return new SliderAdapterViewHolder(inflate);
			    }
		
		    //Inside on bind view holder we will set data to item of Slider View.
		    @Override
		    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
			
			        final SliderData sliderItem = mSliderItems.get(position);
			
			        //Glide is use to load image from url in your imageview.
			        Glide.with(viewHolder.itemView)
			                .load(sliderItem.getImgUrl())
			                .fitCenter()
			                .into(viewHolder.imageViewBackground);
			
			
			    }
		
		    //this method will return the count of our list.
		    @Override
		    public int getCount() {
			        return mSliderItems.size();
			    }
		
		    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
			        //Adapter class for initializing the views of our slider view.
			        View itemView;
			        ImageView imageViewBackground;
			
			        public SliderAdapterViewHolder(View itemView) {
				            super(itemView);
				            imageViewBackground = itemView.findViewById(R.id.myimage);
				            this.itemView = itemView;
				        }
			    }
	}
	    
	
		
		
	{
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
			gd.setColor(Color.parseColor("#FFFFFF")); /* color */
			gd.setCornerRadius(45); /* radius */
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
	
	
	public void _unity_add() {
		
		
		
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