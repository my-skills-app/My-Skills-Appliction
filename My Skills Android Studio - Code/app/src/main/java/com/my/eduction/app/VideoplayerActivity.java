package com.my.eduction.app;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.aghajari.waveanimation.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.facebook.shimmer.*;
import com.github.barteksc.pdfviewer.*;
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
import java.util.concurrent.TimeUnit;

public class VideoplayerActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean open = false;
	private boolean fr = false;
	private boolean pr = false;
	private boolean rota = false;
	private double length = 0;
	private double sec = 0;
	private double min = 0;
	private double length2 = 0;
	private double sec2 = 0;
	private double min2 = 0;
	private double seek = 0;
	private double forwardskip = 0;
	private double backwordskip = 0;
	private double resumes = 0;
	private double zoom = 0;
	private double current = 0;
	private double cur = 0;
	private double mps = 0;
	private String url = "";
	private String type = "";
	private String secs = "";
	private double con = 0;
	private double forwordskip = 0;
	private String playingstatus = "";
	private String ssssss = "";
	private String k5 = "";
	private String touching = "";
	private double oo9 = 0;
	private boolean lock = false;
	private boolean p = false;
	private double Cmtl = 0;
	private String srt = "";
	
	private RelativeLayout linear9;
	private LinearLayout vidview;
	private LinearLayout controlss;
	private TextView zoomtype;
	private VideoView videoview1;
	private LinearLayout linear6;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private ImageView imageview12;
	private TextView love;
	private TextView cuple;
	private TextView textview1;
	private ImageView imageview13;
	private ImageView cast;
	private ImageView imageview14;
	private LinearLayout linear16;
	private LinearLayout linear13;
	private LinearLayout skipprev;
	private LinearLayout linear14;
	private LinearLayout skipforw;
	private LinearLayout linear15;
	private LinearLayout linear2;
	private SeekBar seekbar3;
	private ImageView rotate;
	private LinearLayout backsec;
	private ImageView imageview10;
	private TextView textview6;
	private ProgressBar progressbar1;
	private ImageView playpause;
	private LinearLayout forsec;
	private ImageView imageview11;
	private TextView textview5;
	private ImageView pip;
	private SeekBar seekbar2;
	private TextView textview2;
	private SeekBar seekbar1;
	private TextView textview3;
	private ImageView zooom;
	
	private TimerTask showtimer;
	private TimerTask prog;
	private TimerTask cooldown;
	private TimerTask timer;
	private TimerTask zooms;
	private TimerTask loading;
	private Intent intent = new Intent();
	private SharedPreferences Sp;
	private TimerTask Timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.videoplayer);
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
		linear9 = findViewById(R.id.linear9);
		vidview = findViewById(R.id.vidview);
		controlss = findViewById(R.id.controlss);
		zoomtype = findViewById(R.id.zoomtype);
		videoview1 = findViewById(R.id.videoview1);
		MediaController videoview1_controller = new MediaController(this);
		videoview1.setMediaController(videoview1_controller);
		linear6 = findViewById(R.id.linear6);
		linear12 = findViewById(R.id.linear12);
		linear11 = findViewById(R.id.linear11);
		imageview12 = findViewById(R.id.imageview12);
		love = findViewById(R.id.love);
		cuple = findViewById(R.id.cuple);
		textview1 = findViewById(R.id.textview1);
		imageview13 = findViewById(R.id.imageview13);
		cast = findViewById(R.id.cast);
		imageview14 = findViewById(R.id.imageview14);
		linear16 = findViewById(R.id.linear16);
		linear13 = findViewById(R.id.linear13);
		skipprev = findViewById(R.id.skipprev);
		linear14 = findViewById(R.id.linear14);
		skipforw = findViewById(R.id.skipforw);
		linear15 = findViewById(R.id.linear15);
		linear2 = findViewById(R.id.linear2);
		seekbar3 = findViewById(R.id.seekbar3);
		rotate = findViewById(R.id.rotate);
		backsec = findViewById(R.id.backsec);
		imageview10 = findViewById(R.id.imageview10);
		textview6 = findViewById(R.id.textview6);
		progressbar1 = findViewById(R.id.progressbar1);
		playpause = findViewById(R.id.playpause);
		forsec = findViewById(R.id.forsec);
		imageview11 = findViewById(R.id.imageview11);
		textview5 = findViewById(R.id.textview5);
		pip = findViewById(R.id.pip);
		seekbar2 = findViewById(R.id.seekbar2);
		textview2 = findViewById(R.id.textview2);
		seekbar1 = findViewById(R.id.seekbar1);
		textview3 = findViewById(R.id.textview3);
		zooom = findViewById(R.id.zooom);
		Sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		videoview1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer _mediaPlayer) {
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				pr = false;
				fr = false;
				seekbar1.setMax((int)videoview1.getDuration());
				length = videoview1.getDuration();
				long milliseconds = (int)length;
				 
				
				        // This method uses this formula :minutes =
				
				        // (milliseconds / 1000) / 60;
				
				        long minutes
				
				            = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
				 
				
				        // This method uses this formula seconds =
				
				        // (milliseconds / 1000);
				
				        long seconds
				
				            = (TimeUnit.MILLISECONDS.toSeconds(milliseconds)
				
				               % 60);
				
				String secondsStr = Long.toString(seconds);
				    String secs;
				    if (secondsStr.length() >= 2) {
					        secs = secondsStr.substring(0, 2);
					    } else {
					        secs = "0" + secondsStr;
					    }
				
				min = (int)minutes;
				textview3.setText(String.valueOf((long)(min)).concat(":".concat(secs)));
				prog = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								seekbar1.setProgress((int)videoview1.getCurrentPosition());
								length2 = videoview1.getCurrentPosition();
								long milliseconds = (int)length2;
								 
								
								        // This method uses this formula :minutes =
								
								        // (milliseconds / 1000) / 60;
								
								        long minutes
								
								            = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
								 
								
								        // This method uses this formula seconds =
								
								        // (milliseconds / 1000);
								
								        long seconds
								
								            = (TimeUnit.MILLISECONDS.toSeconds(milliseconds)
								
								               % 60);
								String secondsStr = Long.toString(seconds);
								    String secs;
								    if (secondsStr.length() >= 2) {
									        secs = secondsStr.substring(0, 2);
									    } else {
									        secs = "0" + secondsStr;
									    }
								
								min2 = (int)minutes;
								textview2.setText(String.valueOf((long)(min2)).concat(":".concat(secs)));
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(prog, (int)(0), (int)(100));
				forsec.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						forwordskip = length2 + 10000;
						videoview1.seekTo((int)forwordskip);
					}
				});
				backsec.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						backwordskip = length2 - 10000;
						videoview1.seekTo((int)backwordskip);
					}
				});
				playpause.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						if (videoview1.isPlaying()) {
							videoview1.pause();
							playpause.setImageResource(R.drawable.default_image);
						}
						else {
							videoview1.start();
							playpause.setImageResource(R.drawable.new_feed_pause_icon);
						}
					}
				});
				Cmtl = 1;
				playpause.setVisibility(View.VISIBLE);
				showtimer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								controlss.setVisibility(View.INVISIBLE);
								open = false;
							}
						});
					}
				};
				_timer.schedule(showtimer, (int)(4000));
				_loading();
			}
		});
		
		videoview1.setOnErrorListener(new MediaPlayer.OnErrorListener() {
			@Override
			public boolean onError(MediaPlayer _mediaPlayer, int _what, int _extra) {
				
				return true;
			}
		});
		
		videoview1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer _mediaPlayer) {
				playpause.setImageResource(R.drawable.default_image);
			}
		});
		
		imageview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Download(getIntent().getStringExtra("Url"), "/VideoPlayer Pro/");
			}
		});
		
		cast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent(android.provider.Settings.ACTION_CAST_SETTINGS);
				startActivityForResult(intent, 0);
				
				//Hansdev
			}
		});
		
		imageview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (lock) {
					lock = false;
					linear11.setBackgroundResource(R.drawable.shaderbottom);
					linear6.setBackgroundResource(R.drawable.shadertop);
					imageview14.setImageResource(R.drawable.ic_lock_open_white);
					imageview12.setVisibility(View.VISIBLE);
					imageview13.setVisibility(View.VISIBLE);
					textview1.setVisibility(View.VISIBLE);
					linear12.setVisibility(View.VISIBLE);
					linear11.setVisibility(View.VISIBLE);
					cast.setVisibility(View.VISIBLE);
				}
				else {
					lock = true;
					linear11.setBackgroundResource(0);
					linear6.setBackgroundResource(0);
					imageview14.setImageResource(R.drawable.default_image);
					imageview12.setVisibility(View.INVISIBLE);
					imageview13.setVisibility(View.INVISIBLE);
					textview1.setVisibility(View.INVISIBLE);
					linear12.setVisibility(View.INVISIBLE);
					linear11.setVisibility(View.INVISIBLE);
					cast.setVisibility(View.INVISIBLE);
				}
			}
		});
		
		seekbar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (_progressValue == 0) { 
										WindowManager.LayoutParams layout = getWindow().getAttributes();
										layout.screenBrightness = 0.0F ; getWindow().setAttributes(layout); 
								} 
								else { 
										if (_progressValue == 1) { 
												WindowManager.LayoutParams layout = getWindow().getAttributes();
												layout.screenBrightness = 0.1F ; getWindow().setAttributes(layout); 
										} 
										else { 
												if (_progressValue == 2) { 
														WindowManager.LayoutParams layout = getWindow().getAttributes();
														layout.screenBrightness = 0.2F ; getWindow().setAttributes(layout); 
												} 
												else { 
														if (_progressValue == 3) { 
																WindowManager.LayoutParams layout = getWindow().getAttributes();
																layout.screenBrightness = 0.3F ; getWindow().setAttributes(layout); 
														} 
														else { 
																if (_progressValue == 4) { 
																		WindowManager.LayoutParams layout = getWindow().getAttributes();
																		layout.screenBrightness = 0.4F ; getWindow().setAttributes(layout); 
																} 
																else { 
																		if (_progressValue == 5) { 
																				WindowManager.LayoutParams layout = getWindow().getAttributes();
																				layout.screenBrightness = 0.5F ; getWindow().setAttributes(layout); 
																		} 
																		else { 
																				if (_progressValue == 6) { 
																						WindowManager.LayoutParams layout = getWindow().getAttributes();
																						layout.screenBrightness = 0.6F ; getWindow().setAttributes(layout); 
																				} 
																				else { 
																						if (_progressValue == 7) { 
																								WindowManager.LayoutParams layout = getWindow().getAttributes();
																								layout.screenBrightness = 0.7F ; getWindow().setAttributes(layout); 
																						} 
																						else { 
																								if (_progressValue == 8) { 
																										WindowManager.LayoutParams layout = getWindow().getAttributes();
																										layout.screenBrightness = 0.8F ; getWindow().setAttributes(layout); 
																								} 
																								else { 
																										if (_progressValue == 9) { 
																												WindowManager.LayoutParams layout = getWindow().getAttributes();
																												layout.screenBrightness = 0.9F ; getWindow().setAttributes(layout); 
																										} 
																										else { 
																												if (_progressValue == 10) { 
																														WindowManager.LayoutParams layout = getWindow().getAttributes();
																														layout.screenBrightness = 1.0F ; getWindow().setAttributes(layout);
																	 			}
																	 		}
																	}
														}
													}
												}
											 }
										 }
						}
					}
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		rotate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (rota) {
					rota = false;
					setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
				else {
					rota = true;
					setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
		
		pip.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Adapt the code to your activity 
				
				             if (android.os.Build.VERSION.SDK_INT >= 26) {
					                //Trigger PiP mode
					                try {
						                    Rational rational = new Rational(videoview1.getWidth(), videoview1.getHeight());
						            
						                    PictureInPictureParams mParams =
						                            new PictureInPictureParams.Builder()
						                                    .setAspectRatio(rational)
						                                    .build();
						
						                    enterPictureInPictureMode(mParams);
						                } catch (IllegalStateException e) {
						                    e.printStackTrace();
						                }
					            } else {
					                Toast.makeText(VideoplayerActivity.this, "Background player not supported on your device", Toast.LENGTH_SHORT).show();
					finish();
					            }
			}
		});
		
		seekbar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, _progressValue, 0);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				seek = _progressValue;
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				videoview1.seekTo((int)seek);
			}
		});
		
		zooom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				zoom++;
				zoomtype.setVisibility(View.VISIBLE);
				zooms = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								zoomtype.setVisibility(View.GONE);
								zooms.cancel();
							}
						});
					}
				};
				_timer.schedule(zooms, (int)(1000));
				if (zoom == 1) {
					videoview1.setLayoutParams(new LinearLayout.LayoutParams(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()) + 200, SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) + 200));
					zoomtype.setText("10%");
				}
				if (zoom == 2) {
					videoview1.setLayoutParams(new LinearLayout.LayoutParams(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()) + 500, SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) + 500));
					zoomtype.setText("50%");
				}
				if (zoom == 3) {
					videoview1.setLayoutParams(new LinearLayout.LayoutParams(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()) + 1000, SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) + 1000));
					zoomtype.setText("CROP");
				}
				if (zoom == 4) {
					videoview1.setLayoutParams(new LinearLayout.LayoutParams(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()) + 2000, SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) + 2000));
					zoomtype.setText("200%");
				}
				if (zoom == 5) {
					videoview1.setLayoutParams(new LinearLayout.LayoutParams(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()) + 400, SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) + 400));
					zoomtype.setText("RELACIÓN DE ASPECTO");
				}
				if (zoom == 5) {
					zoom = 1;
					videoview1.setLayoutParams(new LinearLayout.LayoutParams(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()), SketchwareUtil.getDisplayHeightPixels(getApplicationContext())));
					zoomtype.setText("AJUSTAR A LA PANTALLA");
				}
			}
		});
	}
	
	private void initializeLogic() {
		zoom = 1;
		Cmtl = 0;
		zoomtype.setVisibility(View.GONE);
		linear13.setVisibility(View.INVISIBLE);
		playpause.setVisibility(View.GONE);
		rota = false;
		lock = false;
		p = true;
		videoview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Cmtl == 1) {
					if (open) {
						controlss.setVisibility(View.INVISIBLE);
						open = false;
						showtimer.cancel();
					}
					else {
						if (lock) {
							linear11.setBackgroundResource(0);
							linear6.setBackgroundResource(0);
							imageview12.setVisibility(View.INVISIBLE);
							imageview13.setVisibility(View.INVISIBLE);
							textview1.setVisibility(View.INVISIBLE);
							controlss.setVisibility(View.VISIBLE);
							linear12.setVisibility(View.INVISIBLE);
							linear11.setVisibility(View.INVISIBLE);
							cast.setVisibility(View.INVISIBLE);
						}
						else {
							linear11.setBackgroundResource(R.drawable.shaderbottom);
							linear6.setBackgroundResource(R.drawable.shadertop);
							controlss.setVisibility(View.VISIBLE);
						}
						open = true;
						showtimer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										controlss.setVisibility(View.INVISIBLE);
										open = false;
										showtimer.cancel();
									}
								});
							}
						};
						_timer.schedule(showtimer, (int)(4000));
					}
				}
			}
		});
		url = getIntent().getStringExtra("url");
		videoview1.setMediaController(null);
		textview1.setText(getIntent().getStringExtra("Name"));
		srt = "https://html5multimedia.com/code/ch8/elephants-dream-subtitles-en.vtt";
		videoview1.setVideoURI(Uri.parse(getIntent().getStringExtra("url")));
		videoview1.start();
		open = true;
		setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE); seekbar2.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		
	}
	
	AudioManager audioManager;
	{
		_loading();
	}
	
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		Timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						getWindow().getDecorView() .setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY );
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(Timer, (int)(0), (int)(720));
	}
	public void _play(final String _url) {
		url = getIntent().getStringExtra("Video");
		videoview1.setMediaController(null);
		textview1.setText(getIntent().getStringExtra("Name"));
		videoview1.setVideoURI(Uri.parse(getIntent().getStringExtra("Video")));
		videoview1.start();
		open = true;
		showtimer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						controlss.setVisibility(View.INVISIBLE);
						open = false;
					}
				});
			}
		};
		_timer.schedule(showtimer, (int)(3000));
	}
	
	
	public void _loading() {
		loading = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
						if (textview2.getText().toString().equals(textview3.getText().toString())) {
							
						}
						else {
							if (playingstatus.equals("")) {
								oo9 = 0;
								progressbar1.setVisibility(View.GONE);
								playpause.setVisibility(View.VISIBLE);
							}
							else {
								ssssss = love.getText().toString();
								loading = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												if (love.getText().toString().equals(ssssss)) {
													oo9++;
													playpause.setVisibility(View.GONE);
													progressbar1.setVisibility(View.VISIBLE);
												}
												else {
													oo9 = 0;
													progressbar1.setVisibility(View.GONE);
													playpause.setVisibility(View.VISIBLE);
													showtimer = new TimerTask() {
														@Override
														public void run() {
															runOnUiThread(new Runnable() {
																@Override
																public void run() {
																	if (k5.equals("")) {
																		controlss.setVisibility(View.GONE);
																		k5 = "pronto";
																		touching = "";
																	}
																}
															});
														}
													};
													_timer.schedule(showtimer, (int)(100));
												}
											}
										});
									}
								};
								_timer.schedule(loading, (int)(5));
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(loading, (int)(0), (int)(55));
	}
	
	
	public void _Download(final String _url, final String _path) {
		try{
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse( _url)); 
			request.setMimeType(This.getContentResolver().getType(Uri.parse(_url))); 
			String cookies = CookieManager.getInstance().getCookie(_url); 
			request.addRequestHeader("cookie", cookies); 
			//request.addRequestHeader("User-Agent", tab.getSettings().getUserAgentString());
			request.setDescription("Downloading..."); 
			request.setTitle(URLUtil.guessFileName(_url,"",""));
			request.allowScanningByMediaScanner(); 
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); 
			request.setDestinationInExternalPublicDir( _path.equals("")?Environment.DIRECTORY_DOWNLOADS:_path, URLUtil.guessFileName(_url,"","")); 
			DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE); dm.enqueue(request);
			Toast.makeText(getApplicationContext(), "Downloading", Toast.LENGTH_LONG).show();
		}catch(Exception e){showMessage(e.toString());}
	}final Context This = this; void nothing(){
		
		
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