/** @file TDSetting.java
 *
 * @author marco corvi
 * @date jan 2014
 *
 * @brief TopoDroid application settings (preferenceces)
 * --------------------------------------------------------
 *  Copyright This sowftare is distributed under GPL-3.0 or later
 *  See the file COPYING.
 * --------------------------------------------------------
 */
package com.topodroid.DistoX;

import android.content.Context;
import android.provider.Settings.Secure;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.util.Log;

class TDSetting
{

  // ---------------------------------------------------------
  // PREFERENCES KEYS

  final static int NR_PRIMARY_PREFS = 12;

  static final String[] key = { // prefs keys
    // ------------------------- PRIMARY PREFS
    "DISTOX_EXTRA_BUTTONS",       //  0 TODO move to general options
    "DISTOX_SIZE_BUTTONS",        // "DISTOX_BUTTON_SIZE",         //  1
    "DISTOX_TEXT_SIZE",           //  2
    "DISTOX_MKEYBOARD",           //  3
    "DISTOX_TEAM",                //  4
    "DISTOX_COSURVEY",            //  5
    "DISTOX_INIT_STATION",        //  6 default initial station for sketches
    "DISTOX_AZIMUTH_MANUAL",      //  7

    "DISTOX_DEVICE",              //  8 N.B. indexKeyDeviceName - USED by TopoDroidApp to store the device
    "DISTOX_BLUETOOTH",           //  9

    "DISTOX_LOCALE",              // 10
    "DISTOX_CWD",                 // 11 CWD must be the last of primary preferences

    // ----------------------- DEVICE PREFERNCES 
    "DISTOX_SOCK_TYPE",           // 11
    "DISTOX_COMM_RETRY",          // 12
    "DISTOX_WAIT_LASER",
    "DISTOX_WAIT_SHOT",
    "DISTOX_WAIT_DATA",
    "DISTOX_Z6_WORKAROUND",       // 13
    "DISTOX_CONN_MODE",           // 14
    "DISTOX_AUTO_PAIR",           // 15
    "DISTOX_SOCKET_DELAY",        // 16
    "DISTOX_AUTO_RECONNECT",      // 17

    // ------------------- SURVEY PREFERENCES
    "DISTOX_CLOSE_DISTANCE",      // 18
    "DISTOX_EXTEND_THR2",         // 19
    "DISTOX_VTHRESHOLD",          // 20 LRUD vertical threshold
    "DISTOX_SURVEY_STATION",      // 21 DISTOX_SURVEY_STATIONS must not be used
    "DISTOX_UNIT_LENGTH",         // 22
    "DISTOX_UNIT_ANGLE",          // 23
    "DISTOX_ACCEL_PERCENT",           // 24 shot quality thresholds
    "DISTOX_MAG_PERCENT",
    "DISTOX_DIP_THR",             // 26
    "DISTOX_LOOP_CLOSURE",        // 27 whether to close loop
    "DISTOX_CHECK_ATTACHED",      // 28
    "DISTOX_PREV_NEXT",         

    "DISTOX_UNIT_LOCATION",       // 29 
    "DISTOX_CRS",                 // 30

    "DISTOX_GROUP_BY",            // 31
    "DISTOX_GROUP_DISTANCE",      // 32
    "DISTOX_CALIB_EPS",           // 33
    "DISTOX_CALIB_MAX_IT",        // 34
    "DISTOX_RAW_DATA",            // 35
    "DISTOX_CALIB_ALGO",          // 36

    "DISTOX_AUTO_STATIONS",       // 37
    "DISTOX_CLOSENESS",           // 38
    "DISTOX_ERASENESS",           // 38
    "DISTOX_MIN_SHIFT",          
    "DISTOX_POINTING",
    "DISTOX_LINE_SEGMENT",
    "DISTOX_LINE_ACCURACY",
    "DISTOX_LINE_CORNER",         // 41
    "DISTOX_LINE_STYLE",          // 42
    "DISTOX_DRAWING_UNIT",        // 43
    "DISTOX_PICKER_TYPE",         // 44
    "DISTOX_HTHRESHOLD",          // UNUSED
    "DISTOX_STATION_SIZE",        // 46
    "DISTOX_LABEL_SIZE",          // 47
    "DISTOX_LINE_THICKNESS",      // 48
    "DISTOX_AUTO_SECTION_PT",     // 49

    "DISTOX_SHOT_TIMER",          // 50 // bearing-clino timer
    "DISTOX_BEEP_VOLUME",         // 51
    "DISTOX_LEG_SHOTS",           // 52 nr. of shots to make a leg

    "DISTOX_SKETCH_LINE_STEP",    // 53
    "DISTOX_DELTA_EXTRUDE",       // 54
    "DISTOX_COMPASS_READINGS",    // 55

    "DISTOX_SPLAY_EXTEND",        // 56 whether to set extend to splay shots
    "DISTOX_BITMAP_SCALE",        // 57
    "DISTOX_THUMBNAIL",           // 58
    "DISTOX_DOT_RADIUS",          // 59
    "DISTOX_FIXED_THICKNESS",     // 60
    "DISTOX_ARROW_LENGTH",        // 61
    "DISTOX_EXPORT_SHOTS",        // 62
    "DISTOX_EXPORT_PLOT",        // 63
    "DISTOX_THERION_MAPS",

    "DISTOX_SPLAY_VERT_THRS",     // 64 over mSplayVertThrs splays are not displayed in plan view
    "DISTOX_BACKSIGHT",           // 65
    "DISTOX_MAG_ANOMALY",         // 66 whether to compensate magnetic anomaly
    "DISTOX_VERT_SPLAY",          // 68 over this splay are shown with dashed line
    "DISTOX_STATION_PREFIX",      // 69 whether to add cave-name prefix to stations (cSurvey)
    "DISTOX_STATION_NAMES",
    "DISTOX_ZOOM_CTRL",           // 71
    "DISTOX_SIDE_DRAG",           // 72 whether to enable side-drag
    "DISTOX_DXF_SCALE", 
    "DISTOX_ACAD_VERSION",
    "DISTOX_BITMAP_BGCOLOR",      // 75
    "DISTOX_SURVEX_EOL",          // 76 survex end of line
    "DISTOX_SURVEX_SPLAY",
    "DISTOX_SURVEX_LRUD",         // 78
    "DISTOX_UNSCALED_POINTS",     // 79 unscaled drawing point items
    "DISTOX_UNIT_GRID",           // 80
    // "DISTOX_XTHERION_AREAS",      // 81 save areas a-la xtherion
    "DISTOX_THERION_SPLAYS",
    "DISTOX_RECENT_NR",           // 82 number of most recent items (item picker)
    "DISTOX_AREA_BORDER",         // 83 area border visibility
    "DISTOX_ORTHO_LRUD",          // 86 orthogonal LRUD ( >=1 disable, min 0 )
    "DISTOX_SECTION_STATIONS",    //

    "DISTOX_WALLS_TYPE",          // 87
    "DISTOX_WALLS_PLAN_THR",      // 88
    "DISTOX_WALLS_EXTENDED_THR",  // 89
    "DISTOX_WALLS_XCLOSE",        // 90
    "DISTOX_WALLS_XSTEP",         // 91
    "DISTOX_WALLS_CONCAVE",       // 92

    // "DISTOX_SKETCH_USES_SPLAYS",  // 
    // "DISTOX_SKETCH_BERDER_STEP",
    // "DISTOX_SKETCH_SECTION_STEP", // 

    "DISTOX_ALGO_MIN_ALPHA",
    "DISTOX_ALGO_MIN_BETA",
    "DISTOX_ALGO_MIN_GAMMA",
    "DISTOX_ALGO_MIN_DELTA",
  };

  static float mAlgoMinAlpha = 0.1f;
  static float mAlgoMinBeta  = 4.0f;
  static float mAlgoMinGamma = 1.0f;
  static float mAlgoMinDelta = 1.0f;

  static String keyDeviceName() { return "DISTOX_DEVICE"; }

  // static final  String EXPORT_TYPE    = "th";    // DISTOX_EXPORT_TH

  // prefs default values
  static String  mDefaultTeam = "";

  static final int LEVEL_BASIC        = 0;
  static final int LEVEL_NORMAL       = 1;
  static final int LEVEL_ADVANCED     = 2;
  static final int LEVEL_EXPERIMENTAL = 3;
  static final int LEVEL_COMPLETE     = 4;
  static int mActivityLevel = 1;
  static boolean mLevelOverBasic        = true;
  static boolean mLevelOverNormal       = false;
  static boolean mLevelOverAdvanced     = false;
  static boolean mLevelOverExperimental = false;

  static int mSizeButtons     = 42;      // action bar buttons scale (either 1 or 2)
  static int mTextSize        = 16;     // list text size 
  static boolean mKeyboard    = true;

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // IMPORT EXPORT
  static boolean mLRExtend           = true;   // whether to extend LR or not (Compass/VisualTopo input)

  static String mSurvexEol           = "\n";
  static boolean mSurvexSplay        = false;
  static boolean mSurvexLRUD         = false;
  static boolean mOrthogonalLRUD     = false; // whether angle > 0 
  static float mOrthogonalLRUDAngle  = 0;     // angle
  static float mOrthogonalLRUDCosine = 1;     // cosine of the angle

  static boolean mExportStationsPrefix = false;  // whether to prepend cave name to station in cSurvey export

  // static boolean mXTherionAreas = false;
  static boolean mAutoStations = true; // whether to add stations automatically to scrap therion files
  static boolean mTherionSplays = true; // whether to add splay segments to auto stations

  static float mBitmapScale = 1.5f;
  static float mDxfScale = 1.0f;
  static int mBitmapBgcolor = 0x000000;

  static int mAcadVersion              = 9;      // AutoCAD version 9, or 13

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // LOCATION
  static String mCRS = "Long-Lat";    // default coord ref systen 
  // static final  String UNIT_LOCATION  = "ddmmss";
  static int mUnitLocation = 0; // 0 dec-degree, 1 ddmmss

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // CALIBRATION

  // static final String GROUP_DISTANCE = "40";
  static float mGroupDistance = 40;

  static final float DISTOX_MAX_EPS  = 0.01f; // hard limit
  static final String CALIB_EPS      = "0.000001";
  static float mCalibEps = 0.000001f; // calibartion epsilon

  static int   mCalibMaxIt = 200;     // calibration max nr of iterations

  // calibration data grouping policies
  static final int GROUP_BY_DISTANCE = 0;
  static final int GROUP_BY_FOUR     = 1;
  static final int GROUP_BY_ONLY_16  = 2;
  // static final String GROUP_BY  = "1";     // GROUP_BY_FOUR
  static int mGroupBy = GROUP_BY_FOUR;  // how to group calib data

  static boolean mRawData = false;   // whether to display calibration raw data as well
  static int   mCalibAlgo = 0;   // calibration algorithm: 0 auto, 1 linear, 2 non-linear

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // DEVICE
  final static int CONN_MODE_BATCH      = 0;      // DistoX connection mode
  final static int CONN_MODE_CONTINUOUS = 1;
  static int mConnectionMode    = CONN_MODE_BATCH; 
  static boolean mZ6Workaround  = true;

  static boolean mAutoReconnect = false;
  static boolean mAutoPair      = true;
  static int mConnectSocketDelay = 0; // wait time if not paired [0.1 sec]

  // static final boolean CHECK_BT = true;
  static int mCheckBT = 1;        // BT: 0 disabled, 1 check on start, 2 enabled

  static final int TOPODROID_SOCK_DEFAULT      = 0;    // BT socket type
  static final int TOPODROID_SOCK_INSEC        = 1;
  static final int TOPODROID_SOCK_PORT         = 2;
  static final int TOPODROID_SOCK_INSEC_PORT   = 3;
  // static final int TOPODROID_SOCK_INSEC_INVOKE = 4;
  static int mSockType = TOPODROID_SOCK_DEFAULT; // FIXME static

  static int mCommRetry = 1; 
  static int mCommType  = 0; // 0: on-demand, 1: continuous

  static int mWaitLaser = 1000;
  static int mWaitShot  = 4000;
  static int mWaitData  =  500;

  static boolean mCheckAttached = false;    // whether to check is there are shots non-attached
  static boolean mPrevNext = true;    // whether to display prev-next buttons in shot dialog

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // SHOTS
  static float mVThreshold = 80f;   // verticality threshold (LRUD)
  static float mHThreshold;         // horizontal plot threshold

  static int mExportShotsFormat = -1; // DISTOX_EXPORT_NONE
  static int mExportPlotFormat  = -1; // DISTOX_EXPORT_NONE
  static boolean mTherionMaps   = false;

  static int     mSurveyStations  = 1;     // automatic survey stations: 0 no, 1 forward-after-splay, 2 backward-after-splay
  static boolean mShotAfterSplays = true;  //                            3 forward-before-splay, 4 backward-before-splay
  static boolean isSurveyForward()  { return (mSurveyStations%2) == 1; }
  static boolean isSurveyBackward() { return mSurveyStations>0 && (mSurveyStations%2) == 0; }

  // static int mScreenTimeout = 60000; // 60 secs
  static int mTimerCount       = 10;    // Acc/Mag timer countdown (secs)
  static int mBeepVolume       = 50;    // beep volume
  static int mCompassReadings  = 4;     // number of compass readings to average

  // static final String CLOSE_DISTANCE = "0.05"; // 50 cm / 1000 cm
  static float   mCloseDistance = 0.05f; 
  static int     mMinNrLegShots = 3;
  static String  mInitStation   = "0";
  static boolean mBacksight     = false;    // whether to check backsight
  static boolean mBacksightShot = false;    // backsight shooting policy
  static boolean mTripodShot    = false;    // tripod shooting policy
  static boolean mMagAnomaly    = false;    // local magnetic anomaly survey
  static float   mSplayVertThrs = 80;
  static boolean mAzimuthManual = false;    // whether to manually set extend / or use reference azimuth
  static float   mVertSplay     = 50;
  static int     mStationNames  = 0;        // type of station names (0: alpha, 1: number)


  static boolean mLoopClosure = false;      // whether to do loop closure
  
  static final  String UNIT_LENGTH         = "meters";
  static final  String UNIT_ANGLE          = "degrees";
  // static final  String UNIT_ANGLE_GRADS = "grads";
  // static final  String UNIT_ANGLE_SLOPE = "slope";
  // conversion factor from internal units (m) to user units
  static float mUnitLength = 1;
  static float mUnitAngle  = 1;
  static String mUnitLengthStr = "m";    // N.B. Therion syntax: "m", "ft"
  static String mUnitAngleStr  = "deg";  // N.B. Therion syntax: "deg", "grad"

  // static final String EXTEND_THR = "10"; 
  static float mExtendThr = 10;             // extend vertically splays in [90-30, 90+30] of the leg

  static int mThumbSize = 200;               // thumbnail size

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // SKETCH DRAWING

  // static boolean mZoomControls = false;
  static int mZoomCtrl = 1;
  static boolean mSideDrag = false;

  static float mUnit = 1.4f; // drawing unit

  // selection_radius = cutoff + closeness / zoom
  static final float mCloseCutoff = 0.01f; // minimum selection radius

  static float mCloseness = 24f;             // selection radius
  static float mEraseness = 36f;             // eraser radius
  static int mMinShift = 60;
  static int mPointingRadius = 16;

  // static final String LINE_SHIFT = "20.0";
  static float mUnitGrid  = 1;         // 1: meter, 0.9... yard

  static final int PICKER_RECENT = 0; // Drawing-tools picker type
  static final int PICKER_LIST   = 1; 
  static final int PICKER_GRID   = 2;
  static final int PICKER_GRID_3 = 3;
  static int mPickerType = PICKER_RECENT;
  static int mRecentNr    = 4;        // nr. most recent symbols

  static final int LINE_STYLE_BEZIER = 0;  // drawing line styles
  static final int LINE_STYLE_ONE    = 1;
  static final int LINE_STYLE_TWO    = 2;
  static final int LINE_STYLE_THREE  = 3;
  static final String LINE_STYLE     = "2";     // LINE_STYLE_TWO NORMAL
  static int   mLineStyle = LINE_STYLE_BEZIER;    
  static int   mLineType;        // line type:  1       1     2    3
  static int   mLineSegment   = 10;
  static int   mLineSegment2  = 100;   // square of mLineSegment
  static float mLineAccuracy  = 1f;
  static float mLineCorner    = 20;    // corner threshold

  static float mStationSize    = 20;   // size of station names [pt]
  static float mLabelSize      = 24;   // size of labels [pt]
  static float mFixedThickness = 1;    // width of fixed lines
  static float mLineThickness  = 1;    // witdh of drawing lines
  static boolean mAutoSectionPt = false;
  static float mDotRadius      = 5;
  static float mArrowLength    = 8;

  static int mSectionStations = 3; // 1: From, 2: To, 3: both

  static boolean mUnscaledPoints = false;
  static boolean mAreaBorder     = true;

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // 3D
  static float mSketchSideSize;
  static float mDeltaExtrude;
  // static boolean mSketchUsesSplays; // whether 3D models surfaces use splays
  // static float mSketchBorderStep;
  // static float mSketchSectionStep;

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // DATA ACCURACY
  static float mAccelerationThr = 1; // acceleration threshold (shot quality)
  static float mMagneticThr     = 1; // magnetic threshold
  static float mDipThr          = 2; // dip threshold
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
  // WALLS

  static final int WALLS_NONE    = 0;
  static final int WALLS_CONVEX  = 1;
  static final int WALLS_LAST    = 1; // placeholder
  static int   mWallsType        = WALLS_NONE;
  static float mWallsPlanThr     = 70;
  static float mWallsExtendedThr = 45;
  static float mWallsXClose      = 0.1f;
  static float mWallsXStep       = 1.0f;
  static float mWallsConcave     = 0.1f;

  // ------------------------------------------------------------------
  // static void setZoomControls( boolean ctrl )
  // {
  //   mZoomControls = ctrl;
  //   // FIXME forward setting to DrawingActivity
  // }
  static void setZoomControls( String ctrl, boolean is_multitouch )
  {
    try {
      int i = Integer.parseInt( ctrl );
      if ( i >= 0 && i <= 2 ) mZoomCtrl = i;
      if ( mZoomCtrl == 0 && ! is_multitouch ) mZoomCtrl = 1;
    } catch ( NumberFormatException e ) { }
  }

  static private void setMagAnomaly( boolean val )
  {
    mMagAnomaly = val;
    if ( mMagAnomaly && mSurveyStations > 0 ) {
      mBacksightShot   = true;
      mTripodShot      = false;
      mSurveyStations  = 1;
      mShotAfterSplays = true;
    }
  }

  // backgroind color RGB_565
  private static void setBitmapBgcolor( String color )
  {
    String[] vals = color.split("\\s+"); 
    if ( vals.length == 3 ) {
      try { 
        int r = Integer.parseInt( vals[0] );
        int g = Integer.parseInt( vals[1] );
        int b = Integer.parseInt( vals[2] );
        if ( r > 255 ) r = 255; if ( r < 0 ) r = 0;
        if ( g > 255 ) g = 255; if ( g < 0 ) g = 0;
        if ( b > 255 ) b = 255; if ( b < 0 ) b = 0;
        mBitmapBgcolor = 0xff000000 | ( r << 16 ) | ( g << 8 ) | b;
      } catch ( NumberFormatException e ) { }
    }
  }

  // ------------------------------------------------------------------
  static private float tryFloat( SharedPreferences prefs, String key, String def_value )
  {
    float f = 0;
    try { f = Float.parseFloat( prefs.getString( key, def_value ) ); } 
    catch ( NumberFormatException e ) {
      TDLog.Error("Integer Format Error. Key " + key + " " + e.getMessage() );
      f = Float.parseFloat(def_value);
      setPreference( prefs, key, def_value );
    }
    return f;
  }

  static private int tryInt( SharedPreferences prefs, String key, String def_value )
  {
    int i = 0;
    try { i = Integer.parseInt( prefs.getString( key, def_value ) ); }
    catch( NumberFormatException e ) { 
      TDLog.Error("Integer Format Error. Key " + key + " " + e.getMessage() );
      i = Integer.parseInt(def_value);
      setPreference( prefs, key, def_value );
    }
    return i;
  }

  // static private float tryFloat( SharedPreferences prefs, String key, String def_value, float cur_value )
  // {
  //   float f = cur_value;
  //   try {
  //     f = Float.parseFloat( prefs.getString( key, def_value ) );
  //   } catch ( NumberFormatException e ) { }
  //   setPreference( prefs, key, f );
  //   return f;
  // }

  // static private float tryFloat( SharedPreferences prefs, String key, String def_value, float cur_value, float min_value )
  // {
  //   float f = cur_value;
  //   try {
  //     f = Float.parseFloat( prefs.getString( key, def_value ) );
  //     if ( f < min_value ) f = min_value;
  //   } catch ( NumberFormatException e ) { }
  //   setPreference( prefs, key, f );
  //   return f;
  // }

  // static private float tryFloat( SharedPreferences prefs, String key, String def_value,
  //                                float cur_value, float min_value, float max_value )
  // {
  //   TDLog.Error("try float. def " + def_value + " cur " + cur_value + " min " + min_value + " max " + max_value );
  //   float f = cur_value;
  //   try {
  //     f = Float.parseFloat( prefs.getString( key, def_value ) );
  //     if ( f < min_value ) f = min_value;
  //     if ( f > max_value ) f = max_value;
  //   } catch ( NumberFormatException e ) { }
  //   setPreference( prefs, key, f );
  //   return f;
  // }

  // static private int tryInt( SharedPreferences prefs, String key, String def_value, int cur_value )
  // {
  //   int i = cur_value;
  //   try {
  //     i = Integer.parseInt( prefs.getString( key, def_value ) );
  //   } catch ( NumberFormatException e ) { }
  //   setPreference( prefs, key, i );
  //   return i;
  // }

  // static private int tryInt( SharedPreferences prefs, String key, String def_value, int cur_value, int min_value )
  // {
  //   int i = cur_value;
  //   try {
  //     i = Integer.parseInt( prefs.getString( key, def_value ) );
  //     if ( i < min_value ) i = min_value;
  //   } catch ( NumberFormatException e ) { }
  //   setPreference( prefs, key, i );
  //   return i;
  // }

  // static private int tryInt( SharedPreferences prefs, String key, String def_value,
  //                            int cur_value, int min_value, int max_value )
  // {
  //   int i = cur_value;
  //   try {
  //     i = Integer.parseInt( prefs.getString( key, def_value ) );
  //     if ( i < min_value ) i = min_value;
  //     if ( i > max_value ) i = max_value;
  //   } catch ( NumberFormatException e ) { }
  //   setPreference( prefs, key, i );
  //   return i;
  // }

  static private int getSizeButtons( int size )
  {
    switch ( size ) {
      case 0: return 36; // small
      case 1: return 42; // normal
      case 3: return 48; // medium
      case 4: return 64; // large
      case 2: return 84; // huge
    }
    return mSizeButtons;
  }

  static void loadPrimaryPreferences( TopoDroidApp app, SharedPreferences prefs )
  {
    // ------------------- GENERAL PREFERENCES
    int k = 0;

    mActivityLevel = Integer.parseInt( prefs.getString( key[k++], "1" ) ); // DISTOX_EXTRA_BUTTONS choice: 0, 1, 2, 3
    setActivityBooleans( app );

    mSizeButtons = getSizeButtons( tryInt( prefs, key[k++], "1" ) ); // choice: 1, 2, 3, 4  // DISTOX_BUTTON_SIZE
    mTextSize    = tryInt( prefs, key[k++], "16" );                // DISTOX_TEXT_SIZE
    mKeyboard    = prefs.getBoolean( key[k++], true );             // DISTOX_MKEYBOARD
    mDefaultTeam = prefs.getString( key[k++], "" );                // DISTOX_TEAM
    boolean co_survey = prefs.getBoolean( key[k++], false );       // DISTOX_COSURVEY 

    mInitStation = prefs.getString( key[k++], "0" ).replaceAll("\\s+", "");  // DISTOX_INIT_STATION 
    if ( mInitStation.length() == 0 ) mInitStation = "0";
    DistoXStationName.setInitialStation( mInitStation );

    mAzimuthManual = prefs.getBoolean( key[k++], false );   // DISTOX_AZIMUTH_MANUAL 
    TDAzimuth.mFixedExtend = ( TDSetting.mAzimuthManual )? 1L : 0L;
    // TDAzimuth.resetRefAzimuth( TDAzimuth.mRefAzimuth ); // BUG may call setRefAzimuthButton on non-UI thread
    
    // ------------------- DEVICE PREFERENCES -def--fallback--min-max
    k++;                                                     // DISTOX_DEVICE - UNUSED HERE
    mCheckBT        = tryInt( prefs, key[k++], "1" );        // DISTOX_BLUETOOTH choice: 0, 1, 2

    // TDLog.Profile("locale");
    app.setLocale( prefs.getString( key[k++], "" ), false );              // DISTOX_LOCALE

    // String cwd = prefs.getString( key[k++], "TopoDroid" );
    // if ( ! cwd.equals( mCWD ) ) {
    //   mCWD = cwd;
    //   TDPath.setPaths( mCWD );
    //   mData.openDatabase();
    // }
  }

  static void loadSecondaryPreferences( TopoDroidApp app, SharedPreferences prefs )
  {
    int k = NR_PRIMARY_PREFS;;

    // ------------------- DEVICE PREFERENCES
    mSockType       = tryInt( prefs, key[k++], "0" );        // DISTOX_SOCK_TYPE choice: 0, 1, (2, 3)
    mCommRetry      = tryInt( prefs, key[k++], "1" );        // DISTOX_COMM_RETRY
    mWaitLaser      = tryInt( prefs, key[k++], "1000" );     // DISTOX_WAIT_LASER
    mWaitShot       = tryInt( prefs, key[k++], "4000" );     // DISTOX_WAIT_SHOT
    mWaitData       = tryInt( prefs, key[k++], "500" );      // DISTOX_WAIT_DATA
    mZ6Workaround   = prefs.getBoolean( key[k++], true  );   // DISTOX_Z6_WORKAROUND
    mConnectionMode = tryInt( prefs, key[k++], "0" );        // DISTOX_CONN_MODE choice: 0, 1
    mAutoPair       = prefs.getBoolean( key[ k++ ], true );  // DISTOX_AUTO_PAIR
    mConnectSocketDelay = tryInt(prefs, key[ k++ ], "0" );   // DISTOX_SOCKET_DELAY
    mAutoReconnect     = prefs.getBoolean( key[k++], false ); // DISTOX_AUTO_RECONNECT

    // ------------------- SURVEY PREFERENCES
    mCloseDistance = tryFloat( prefs, key[k++], "0.05" ); // DISTOX_CLOSE_DISTANCE
    mExtendThr     = tryFloat( prefs, key[k++], "10"   ); // DISTOX_EXTEND_THR2
    mVThreshold    = tryFloat( prefs, key[k++], "80"   ); // DISTOX_VTHRESHOLD

    parseSurveyStations( prefs.getString( key[k++], "1" ) ); // DISTOX_SURVEY_STATIONS 

    if ( prefs.getString( key[k++], UNIT_LENGTH ).equals(UNIT_LENGTH) ) {
      mUnitLength = 1.0f;
      mUnitLengthStr = "m";
    } else {
      mUnitLength = TopoDroidUtil.M2FT;
      mUnitLengthStr = "ft";
    }
    if ( prefs.getString( key[k++], UNIT_ANGLE ).equals(UNIT_ANGLE) ) {
      mUnitAngle = 1.0f;
      mUnitAngleStr = "deg";
    } else {
      mUnitAngle = TopoDroidUtil.DEG2GRAD;
      mUnitAngleStr = "grad";
    }
  
    mAccelerationThr = tryFloat( prefs, key[k++], "1" );  // DISTOX_ACCEL_PERCENT
    mMagneticThr     = tryFloat( prefs, key[k++], "1" );  // DISTOX_MAG_PERCENT
    mDipThr          = tryFloat( prefs, key[k++], "2"   );  // DISTOX_DIP_THR

    mLoopClosure   = prefs.getBoolean( key[k++], false );   // DISTOX_LOOP_CLOSURE
    mCheckAttached = prefs.getBoolean( key[k++], false );   // DISTOX_CHECK_ATTACHED 13
    mPrevNext      = prefs.getBoolean( key[k++], true );    // DISTOX_PREV_NEXT

    mUnitLocation  = prefs.getString( key[k++], "ddmmss" ).equals("ddmmss") ? TDConst.DDMMSS  // choice
                                                                            : TDConst.DEGREE;
    mCRS           = prefs.getString( key[k++], "Long-Lat" );                 // DISTOX_CRS

    // ------------------- CALIBRATION PREFERENCES
    mGroupBy       = tryInt(   prefs, key[k++], "1" );       // DISTOX_GROUP_BY choice: 0, 1, 2
    mGroupDistance = tryFloat( prefs, key[k++], "40" );      // DISTOX_GROUP_DISTANCE
    mCalibEps      = tryFloat( prefs, key[k++], CALIB_EPS );
    mCalibMaxIt    = tryInt(   prefs, key[k++], "200"     ); // DISTOX_CALIB_MAX_IT

    mRawData       = prefs.getBoolean( key[k++], false );    // DISTOX_RAW_DATA 20
    mCalibAlgo     = tryInt( prefs, key[k++], "0" );         // choice: 0, 1, 2

    // -------------------  DRAWING PREFERENCES -def----fallback------min/max
    mAutoStations  = prefs.getBoolean( key[k++], true );            // DISTOX_AUTO_STATIONS 
    mCloseness     = tryFloat( prefs, key[k++], "24" );             // DISTOX_CLOSENESS
    mEraseness     = tryFloat( prefs, key[k++], "36" );             // DISTOX_ERASENESS
    mMinShift      = tryInt(   prefs, key[k++], "60" );             // DISTOX_MIN_SHIFT
    mPointingRadius= tryInt(   prefs, key[k++], "16" );             // DISTOX_POINTING
    mLineSegment   = tryInt(   prefs, key[k++], "10" );             // DISTOX_LINE_SEGMENT
    mLineSegment2  = mLineSegment * mLineSegment;
    mLineAccuracy  = tryFloat( prefs, key[k++], "1" );              // DISTOX_LINE_ACCURACY
    mLineCorner    = tryFloat( prefs, key[k++], "20"  );            // DISTOX_LINE_CORNER
    setLineStyleAndType( prefs.getString( key[k++], LINE_STYLE ) ); // DISTOX_LINE_STYLE
    mUnit          = tryFloat( prefs, key[k++], "1.4" );            // DISTOX_DRAWING_UNIT 
    mPickerType    = tryInt(   prefs, key[k++], "0" );              // DISTOX_PICKER_TYPE choice: 0, 1, 2
    mHThreshold    = tryFloat( prefs, key[k++], "70" );             // DISTOX_HTHRESHOLD
    mStationSize   = tryFloat( prefs, key[k++], "20" );             // DISTOX_STATION_SIZE
    mLabelSize     = tryFloat( prefs, key[k++], "24" );             // DISTOX_LABEL_SIZE
    mLineThickness = tryFloat( prefs, key[k++], "1"  );             // DISTOX_LINE_THICKNESS
    mAutoSectionPt = prefs.getBoolean( key[k++], false );           // DISTOX_AUTO_SECTION_PT

    mTimerCount    = tryInt(   prefs, key[k++], "10" );             // DISTOX_SHOT_TIMER
    mBeepVolume    = tryInt(   prefs, key[k++], "50" );             // DISTOX_BEEP_VOLUME
    mMinNrLegShots = tryInt(   prefs, key[k++], "3" );              // DISTOX_LEG_SHOTS choice: 2, 3, 4

    // ------------------- SKETCH PREFERENCES
    mSketchSideSize = tryFloat( prefs, key[k++], "0.5" );           // DISTOX_SKETCH_LINE_STEP
    mDeltaExtrude   = tryFloat( prefs, key[k++], "50"  );           // DISTOX_DELTA_EXTRUDE
    // mSketchUsesSplays  = prefs.getBoolean( key[k++], false );    
    // mSketchBorderStep  = Float.parseFloat( prefs.getString( key[k++], "0.2") );
    // mSketchSectionStep = Float.parseFloat( prefs.getString( key[k++], "0.5") );

    mCompassReadings   = tryInt(   prefs, key[k++], "4" );    // DISTOX_COMPASS_READING 
    mLRExtend          = prefs.getBoolean( key[k++], true );  // DISTOX_SPLAY_EXTEND
    mBitmapScale       = tryFloat( prefs, key[k++], "1.5" );  // DISTOX_BITMAP_SCALE 
    mThumbSize         = tryInt(   prefs, key[k++], "200" );  // DISTOX_THUMBNAIL
    mDotRadius         = tryFloat( prefs, key[k++], "5"   );  // DISTOX_DOT_RADIUS
    mFixedThickness    = tryFloat( prefs, key[k++], "1"   );  // DISTOX_FIXED_THICKNESS
    mArrowLength       = tryFloat( prefs, key[k++], "8"   );  // DISTOX_ARROW_LENGTH
    mExportShotsFormat = tryInt(   prefs, key[k++], "-1" );   // DISTOX_EXPORT_SHOTS choice: 
    mExportPlotFormat  = tryInt(   prefs, key[k++], "-1" );   // DISTOX_EXPORT_PLOT choice: 14, 2, 11, 12, 13
    mTherionMaps       = prefs.getBoolean( key[k++], false ); // DISTOX_THERION_MAPS
    mSplayVertThrs     = tryFloat( prefs, key[k++], "80"  );  // DISTOX_SPLAY_VERT_THRS

    mBacksight     = prefs.getBoolean( key[k++], false );   // DISTOX_BACKSIGHT
    setMagAnomaly(   prefs.getBoolean( key[k++], false ) ); // DISTOX_MAG_ANOMALY

    mVertSplay = tryFloat( prefs, key[k++], "50" );               // DISTOX_VERT_SPLAY
    mExportStationsPrefix =  prefs.getBoolean( key[k++], false ); // DISTOX_STATION_PREFIX
    mStationNames = (prefs.getString( key[k++], "alpha").equals("number"))? 1 : 0; // DISTOX_STATION_NAMES

    // setZoomControls( prefs.getBoolean( key[k++], false ) ); // DISTOX_ZOOM_CONTROLS
    setZoomControls( prefs.getString( key[k++], "1"), app.isMultitouch() ); // DISTOX_ZOOM_CTRL
    mSideDrag = prefs.getBoolean( key[k++], false );          // DISTOX_SIDE_DRAG

    mDxfScale    = tryFloat( prefs, key[k++], "1.0" );        // DISTOX_DXF_SCALE
    mAcadVersion = tryInt(   prefs, key[k++], "9" );          // DISTOX_ACAD_VERSION choice: 9, 13

    setBitmapBgcolor( prefs.getString( key[k++], "0 0 0" ) ); // DISTOX_BITMAP_BGCOLOR

    mSurvexEol    = ( prefs.getString(  key[k++], "LF" ).equals("LF") )? "\n" : "\r\n";  // DISTOX_SURVEX_EOL
    mSurvexSplay  =   prefs.getBoolean( key[k++], false );    // DISTOX_SURVEX_SPLAY
    mSurvexLRUD   =   prefs.getBoolean( key[k++], false );    // DISTOX_SURVEX_LRUD
    mUnscaledPoints = prefs.getBoolean( key[k++], false );    // DISTOX_UNSCALED_POINTS
    mUnitGrid       = tryFloat(  prefs, key[k++], "1" );      // DISTOX_UNIT_GRID
    // mXTherionAreas  = prefs.getBoolean( key[k++], false );    // DISTOX_XTHERION_AREAS
    mTherionSplays  = prefs.getBoolean( key[k++], false );    // DISTOX_THERION_SPLAYS

    mRecentNr   = tryInt( prefs, key[k++], "4" );               // DISTOX_RECENT_NR choice: 3, 4, 5, 6

    mAreaBorder = prefs.getBoolean( key[k++], true );         // DISTOX_AREA_BORDER

    mOrthogonalLRUDAngle  = tryFloat( prefs, key[k++], "0");  // DISTOX_ORTHO_LRUD
    mOrthogonalLRUDCosine = TDMath.cosd( mOrthogonalLRUDAngle );
    mOrthogonalLRUD       = ( mOrthogonalLRUDAngle > 0.000001f ); 

    mSectionStations  = tryInt( prefs, key[k++], "3");         // DISTOX_SECTION_STATIONS

    mWallsType        = tryInt(   prefs, key[k++], "0" );     // DISTOX_WALLS_TYPE choice: 0, 1
    mWallsPlanThr     = tryFloat( prefs, key[k++], "70"  );   // DISTOX_WALLS_PLAN_THR
    mWallsExtendedThr = tryFloat( prefs, key[k++], "45"  );   // DISTOX_WALLS_EXTENDED_THR
    mWallsXClose      = tryFloat( prefs, key[k++], "0.1" );   // DISTOX_WALLS_XCLOSE
    mWallsXStep       = tryFloat( prefs, key[k++], "1.0" );   // DISTOX_WALLS_XSTEP
    mWallsConcave     = tryFloat( prefs, key[k++], "0.1" );   // DISTOX_WALLS_CONCAVE

    mAlgoMinAlpha     = tryFloat( prefs, key[k++], "0.1" );   // DISTOX_ALGO_MIN_ALPHA
    mAlgoMinBeta      = tryFloat( prefs, key[k++], "4.0" );   // DISTOX_ALGO_MIN_BETA
    mAlgoMinGamma     = tryFloat( prefs, key[k++], "1.0" );   // DISTOX_ALGO_MIN_GAMMA
    mAlgoMinDelta     = tryFloat( prefs, key[k++], "1.0" );   // DISTOX_ALGO_MIN_DELTA
  }

  static private void setActivityBooleans( Context ctx )
  {
    mLevelOverBasic        = mActivityLevel > LEVEL_BASIC;
    mLevelOverNormal       = mActivityLevel > LEVEL_NORMAL;
    mLevelOverAdvanced     = mActivityLevel > LEVEL_ADVANCED;
    mLevelOverExperimental = mActivityLevel > LEVEL_EXPERIMENTAL;
    if ( mLevelOverAdvanced ) {
      String android_id = Secure.getString( ctx.getContentResolver(), Secure.ANDROID_ID );
      // Log.v("DistoX", "android_id <" + android_id + ">");
      if ( "e5582eda21cafac3".equals( android_id ) || "8c894b79b6dce351".equals( android_id ) ) {
        mLevelOverExperimental = true;
      }
    }
    if ( ! mLevelOverAdvanced ) {
      mMagAnomaly = false;
    }
  }

  static void checkPreference( SharedPreferences prefs, String k, TopoDroidActivity activity, TopoDroidApp app )
  {
    int nk = 0; // key index
    float f;
    // int i;
    // Log.v(TopoDroidApp.TAG, "onSharePreferenceChanged " + k );

    // ---------------- PRIMARY PREFERENCES ---------------------------
    if ( k.equals( key[ nk++ ] ) ) {                     // DISTOX_EXTRA_BUTTONS
      int level = tryInt( prefs, k, "1" );
      if ( level != mActivityLevel ) {
        mActivityLevel = level;
        setActivityBooleans( app );
        if ( activity != null ) {
          activity.resetButtonBar();
          activity.setMenuAdapter( app.getResources() );
        }  
      }
    } else if ( k.equals( key[ nk++ ] ) ) {              // DISTOX_BUTTON_SIZE
      int size = getSizeButtons( tryInt( prefs, k, "1" ) );
      if ( size != mSizeButtons ) {
        mSizeButtons = size;
        if ( activity != null ) activity.resetButtonBar();
      }
    } else if ( k.equals( key[ nk++ ] ) ) {              // DISTOX_TEXT_SIZE
      mTextSize = tryInt( prefs, k, "16" );
  
    } else if ( k.equals( key[ nk++ ] ) ) {
      mKeyboard = prefs.getBoolean( k, true );           // DISTOX_MKEYBOARD
    } else if ( k.equals( key[ nk++ ] ) ) {
      mDefaultTeam     = prefs.getString( k, "" );       // DISTOX_TEAM
    } else if ( k.equals( key[ nk++ ] ) ) {
      boolean co_survey = prefs.getBoolean( k, false );  // DISTOX_COSURVEY
      if ( co_survey != app.mCoSurveyServer ) {
        app.setCoSurvey( co_survey ); // set flag and start/stop server
      }
    } else if ( k.equals( key[ nk++ ] ) ) {              // DISTOX_INIT_STATION
      mInitStation = prefs.getString( k, "0" ).replaceAll("\\s+", "");
      if ( mInitStation.length() == 0 ) mInitStation = "0";
      DistoXStationName.setInitialStation( mInitStation );
    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_AZIMUTH_MANUAL
      mAzimuthManual = prefs.getBoolean( k, false ); 
      TDAzimuth.resetRefAzimuth( TDAzimuth.mRefAzimuth );

    } else if ( k.equals( key[ nk++ ] ) ) {
      // mDevice      = mData.getDevice( prefs.getString( k, "" ) );  // DISTOX_DEVICE - UNUSED HERE
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCheckBT        = tryInt( prefs, k, "1" );         // DISTOX_BLUETOOTH (choice)

    } else if ( k.equals( key[ nk++ ] ) ) {     // DISTOX_LOCALE
      app.setLocale( prefs.getString( k, "" ), true );
    } else if ( k.equals( key[ nk++ ] ) ) {     // DISTOX_CWD
      app.setCWD( prefs.getString( k, "TopoDroid" ) );

    // ---------------- SECOINDARY PREFERENCES ---------------------------
    } else if ( k.equals( key[ nk++ ] ) ) {
      mSockType       = tryInt( prefs, k, "0" );     // "DISTOX_SOCK_TYPE (choice)
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCommRetry      = tryInt( prefs, k, "1" );     // DISTOX_COMM_RETRY
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWaitLaser      = tryInt( prefs, k, "1000" );  // DISTOX_WAIT_LASER
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWaitShot       = tryInt( prefs, k, "4000" );  // DISTOX_WAIT_SHOT
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWaitData       = tryInt( prefs, k, "500" );   // DISTOX_WAIT_DATA
    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_Z6_WORKAROUND
      mZ6Workaround = prefs.getBoolean( k, true );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mConnectionMode = tryInt( prefs, k, "0" );     // DISTOX_CONN_MODE (choice)
    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_AUTO_PAIR
      mAutoPair = prefs.getBoolean( k, true );
      app.checkAutoPairing();
    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_SOCKET_DELAY
      mConnectSocketDelay = tryInt(prefs, k, "0" );  
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAutoReconnect = prefs.getBoolean( k, false ); // DISTOX_AUTO_RECONNECT
  

    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_CLOSE_DISTANCE
      mCloseDistance = tryFloat( prefs, k, "0.05" );
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mExtendThr     = tryFloat( prefs, k, "10" );   // DISTOX_EXTEND_THR2
    } else if ( k.equals( key[ nk++ ] ) ) {
      mVThreshold    = tryFloat( prefs, k, "80" );   // DISTOX_VTHRESHOLD
    } else if ( k.equals( key[ nk++ ] ) ) {
      parseSurveyStations( prefs.getString( k, "1" ) ); // DISTOX_SURVEY_STATION
    } else if ( k.equals( key[ nk++ ] ) ) {
      if ( prefs.getString( k, UNIT_LENGTH ).equals(UNIT_LENGTH) ) {
        mUnitLength = 1.0f;
        mUnitLengthStr = "m";
      } else {
        mUnitLength = TopoDroidUtil.M2FT;
        mUnitLengthStr = "ft";
      }
      // TDLog.Log( TDLog.LOG_UNITS, "mUnitLength changed " + mUnitLength );
    } else if ( k.equals( key[ nk++ ] ) ) {
      if ( prefs.getString( k, UNIT_ANGLE ).equals(UNIT_ANGLE) ) {
        mUnitAngle = 1.0f;
        mUnitAngleStr = "deg";
      } else {
        mUnitAngle = TopoDroidUtil.DEG2GRAD;
        mUnitAngleStr = "grad";
      }
      // TDLog.Log( TDLog.LOG_UNITS, "mUnitAngle changed " + mUnitAngle );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAccelerationThr = tryFloat( prefs, k, "1" );    // DISTOX_ACCEL_PERCENT 
    } else if ( k.equals( key[ nk++ ] ) ) {
      mMagneticThr     = tryFloat( prefs, k, "1" );    // DISTOX_MAG_PERCENT
    } else if ( k.equals( key[ nk++ ] ) ) {
      mDipThr          = tryFloat( prefs, k, "2" );      // DISTOX_DIP_THR
  
    } else if ( k.equals( key[ nk++ ] ) ) {              // DISTOX_LOOP_CLOSURE
      mLoopClosure   = prefs.getBoolean( k, false );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCheckAttached = prefs.getBoolean( k, false );
    } else if ( k.equals( key[ nk++ ] ) ) {              // DISTOX_PREV_NEXT
      mPrevNext = prefs.getBoolean( k, true );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mUnitLocation  = prefs.getString( k, "ddmmss" ).equals("ddmmss") ? TDConst.DDMMSS
                                                                       : TDConst.DEGREE;
      // TDLog.Log( TDLog.LOG_UNITS, "mUnitLocation changed " + mUnitLocation );
    // } else if ( k.equals( key[ nk++ ] ) ) {
    //   try {
    //     mAltitude = Integer.parseInt( prefs.getString( k, ALTITUDE ) ); // DISTOX_ALTITUDE 15
    //   } catch ( NumberFormatException e ) { mAltitude = _WGS84; }
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCRS = prefs.getString( k, "Long-Lat" );     // DISTOX_CRS

    } else if ( k.equals( key[ nk++ ] ) ) {
      mGroupBy       = tryInt(   prefs, k, "1" );  // DISTOX_GROUP_BY (choice)
    } else if ( k.equals( key[ nk++ ] ) ) {
      mGroupDistance = tryFloat( prefs, k, "40" );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCalibEps      = tryFloat( prefs, k, CALIB_EPS );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCalibMaxIt    = tryInt(   prefs, k, "200" );   // DISTOX_CALIB_MAX_IT
    } else if ( k.equals( key[ nk++ ] ) ) {
      mRawData       = prefs.getBoolean( k, false );  // DISTOX_RAW_DATA
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCalibAlgo     = tryInt( prefs, k, "0" );       // DISTOX_CALIB_ALGO

    } else if ( k.equals( key[ nk++ ] ) ) {
      mAutoStations = prefs.getBoolean( k, true );    // DISTOX_AUTO_STATIONS
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCloseness    = tryFloat( prefs, k, "24" );
    } else if ( k.equals( key[ nk++ ] ) ) {           // DISTOX_ERASENESS
      mEraseness    = tryFloat( prefs, k, "36" );
    } else if ( k.equals( key[ nk++ ] ) ) {           // DISTOX_MIN_SHIFT
      mMinShift     = tryInt(  prefs, k, "60" );
    } else if ( k.equals( key[ nk++ ] ) ) {           // DISTOX_POINTING
      mPointingRadius= tryInt(   prefs, k, "16" );
    } else if ( k.equals( key[ nk++ ] ) ) {           // DISTOX_LINE_SEGMENT
      mLineSegment  = tryInt(   prefs, k, "10" );
      mLineSegment2 = mLineSegment * mLineSegment;
    } else if ( k.equals( key[ nk++ ] ) ) {
      mLineAccuracy = tryFloat( prefs, k, "1" );
    } else if ( k.equals( key[ nk++ ] ) ) {           // DISTOX_LINE_CORNER
      mLineCorner   = tryFloat( prefs, k, "20" );
    } else if ( k.equals( key[ nk++ ] ) ) {                           // DISTOX_LINE_STYLE
      setLineStyleAndType( prefs.getString( k, LINE_STYLE ) );
    } else if ( k.equals( key[ nk++ ] ) ) {                           // DISTOX_DRAWING_UNIT
      try {
        f = Float.parseFloat( prefs.getString( k, "1.4" ) );
        if ( f > 0 && f != mUnit ) {
          mUnit = f;
          DrawingBrushPaths.reloadPointLibrary( app.getResources() );
        }
      } catch ( NumberFormatException e ) { }
    } else if ( k.equals( key[ nk++ ] ) ) {                          // DISTOX_PICKER_TYPE
      mPickerType = tryInt(   prefs, k, "0" );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mHThreshold = tryFloat( prefs, k, "70" );  // DISTOX_HTHRESHOLD
    } else if ( k.equals( key[ nk++ ] ) ) {
      try {
        f = Float.parseFloat( prefs.getString( k, "20" ) ); // DISTOX_STATION_SIZE
        if ( f >= 1 && f != mStationSize ) {
          mStationSize = f;
          DrawingBrushPaths.setTextSizes( );
        }
      } catch ( NumberFormatException e ) { }
    } else if ( k.equals( key[ nk++ ] ) ) {
      try {
        f = Float.parseFloat( prefs.getString( k, "24" ) ); // DISTOX_LABEL_SIZE
        if ( f >= 1 && f != mLabelSize ) {
          mLabelSize = f;
          DrawingBrushPaths.setTextSizes( );
        }
      } catch ( NumberFormatException e ) { }
      // FIXME changing label size affects only new labels
      //       not existing labels (until they are edited)
    } else if ( k.equals( key[ nk++ ] ) ) {
      try {
        f = Float.parseFloat( prefs.getString( k, "1" ) );  // DISTOX_LINE_THICKNESS
        if ( f >= 0.5f && f != mLineThickness ) {
          mLineThickness = f;
          DrawingBrushPaths.reloadLineLibrary( app.getResources() );
        }
      } catch ( NumberFormatException e ) { }
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAutoSectionPt = prefs.getBoolean( k, false ); // DISTOX_AUTO_SECTION_PT

    } else if ( k.equals( key[ nk++ ] ) ) {
      mTimerCount       = tryInt( prefs, k, "10" );  // DISTOX_SHOT_TIMER
    } else if ( k.equals( key[ nk++ ] ) ) {
      mBeepVolume       = tryInt( prefs, k, "50" );  // DISTOX_BEEP_VOLUME
    } else if ( k.equals( key[ nk++ ] ) ) {
      mMinNrLegShots    = tryInt( prefs, k, "3" );   // DISTOX_LEG_SHOTS (choice)

    } else if ( k.equals( key[ nk++ ] ) ) {
      mSketchSideSize = tryFloat( prefs, k, "0.5" );  // 0.5 meter // DISTOX_SKETCH_LINE_STEP
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mDeltaExtrude = tryFloat( prefs, k, "50" );     // DISTOX_DELTA_EXTRUDE
    } else if ( k.equals( key[ nk++ ] ) ) {
      mCompassReadings = tryInt( prefs, k, "4" );     // DISTOX_COMPASS_READINGS
    } else if ( k.equals( key[ nk++ ] ) ) {
      mLRExtend = prefs.getBoolean( k, true );        // DISTOX_SPLAY_EXTEND
    } else if ( k.equals( key[ nk++ ] ) ) {
      mBitmapScale = tryFloat( prefs, k, "1.5" );     // DISTOX_BITMAP_SCALE
    } else if ( k.equals( key[ nk++ ] ) ) {
      mThumbSize = tryInt( prefs, k, "200" );         // DISTOX_THUMBNAIL
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mDotRadius = tryFloat( prefs, k, "5" );         // DISTOX_DOT_RADIUS
    } else if ( k.equals( key[ nk++ ] ) ) { 
      try {
        f = Float.parseFloat( prefs.getString( k, "1" ) ); // DISTOX_FIXED_THICKNESS
        if ( f >= 0.5f && f <= 10 && f != mFixedThickness ) {
          mFixedThickness = f;
          DrawingBrushPaths.setStrokeWidths();
        }
      } catch ( NumberFormatException e ) { }
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mArrowLength = tryFloat( prefs, k, "8" );      // DISTOX_ARROW_LENGTH
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mExportShotsFormat = tryInt( prefs, k, "-1" ); // DISTOX_EXPORT_SHOTS (choice)
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mExportPlotFormat = tryInt( prefs, k, "-1" );  // DISTOX_EXPORT_PLOT (choice)
    } else if ( k.equals( key[ nk++ ] ) ) { 
      mTherionMaps = prefs.getBoolean( k, false );   // DISTOX_THERION_MAPS

    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_SPLAY_VERT_THRS
      mSplayVertThrs = tryFloat( prefs, k, "80" );
    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_BACKSIGHT
      mBacksight = prefs.getBoolean( k, false );
    } else if ( k.equals( key[ nk++ ] ) ) {          // DISTOX_MAG_ANOMALY
      setMagAnomaly( prefs.getBoolean( k, false ) );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mVertSplay = tryFloat( prefs, k, "50" );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mExportStationsPrefix =  prefs.getBoolean( k, false ); // DISTOX_STATION_PREFIX
    } else if ( k.equals( key[ nk++ ] ) ) {
      mStationNames = (prefs.getString( k, "alpha").equals("number"))? 1 : 0; // DISTOX_STATION_NAMES
    } else if ( k.equals( key[ nk++ ] ) ) {
      // setZoomControls( prefs.getBoolean( k, false ) ); // DISTOX_ZOOM_CONTROLS
      setZoomControls( prefs.getString( k, "1"), app.isMultitouch() ); // DISTOX_ZOOM_CTRL
    } else if ( k.equals( key[ nk++ ] ) ) {
      mSideDrag = prefs.getBoolean( k, false ); // DISTOX_SIDE_DRAG
    } else if ( k.equals( key[ nk++ ] ) ) {
      mDxfScale = tryFloat( prefs, k, "1" );   // DISTOX_DXF_SCALE
    } else if ( k.equals( key[ nk++ ] ) ) {
      try {
        mAcadVersion = Integer.parseInt( prefs.getString( k, "9") ); // DISTOX_ACAD_VERSION
      } catch ( NumberFormatException e) { }
    } else if ( k.equals( key[ nk++ ] ) ) {
      setBitmapBgcolor( prefs.getString( k, "0 0 0" ) ); // DISTOX_BITMAP_BGCOLOR
    } else if ( k.equals( key[ nk++ ] ) ) {
      mSurvexEol = ( prefs.getString( k, "LF" ).equals("LF") )? "\n" : "\r\n";  // DISTOX_SURVEX_EOL
    } else if ( k.equals( key[ nk++ ] ) ) {
      mSurvexSplay = prefs.getBoolean( k, false ); // DISTOX_SURVEX_SPLAY
    } else if ( k.equals( key[ nk++ ] ) ) {
      mSurvexLRUD = prefs.getBoolean( k, false ); // DISTOX_SURVEX_LRUD
    } else if ( k.equals( key[ nk++ ] ) ) {
      mUnscaledPoints = prefs.getBoolean( k, false ); // DISTOX_UNSCALED_POINTS
    } else if ( k.equals( key[ nk++ ] ) ) { // DISTOX_UNIT_GRID
      mUnitGrid = Float.parseFloat( prefs.getString( k, "1" ) ); 
    // } else if ( k.equals( key[ nk++ ] ) ) { // DISTOX_XTHERION_AREAS
    //   mXTherionAreas = prefs.getBoolean( k, false );   
    } else if ( k.equals( key[ nk++ ] ) ) { // DISTOX_THERION_SPLAYS
      mTherionSplays  = prefs.getBoolean( k, false );   
    } else if ( k.equals( key[ nk++ ] ) ) { // DISTOX_RECENT_NR
      mRecentNr = tryInt( prefs, k, "4" );

    } else if ( k.equals( key[ nk++ ] ) ) {
      mAreaBorder = prefs.getBoolean( k, true );  // DISTOX_AREA_BORDER

    } else if ( k.equals( key[ nk++ ] ) ) {       // DISTOX_ORTHO_LRUD
      mOrthogonalLRUDAngle  = tryFloat( prefs, k, "0");
      mOrthogonalLRUDCosine = TDMath.cosd( mOrthogonalLRUDAngle );
      mOrthogonalLRUD       = ( mOrthogonalLRUDAngle > 0.000001f ); 

    } else if ( k.equals( key[ nk++ ] ) ) {       // DISTOX_SECTION_STATIONS
      mSectionStations = tryInt( prefs, k, "3");

    } else if ( k.equals( key[ nk++ ] ) ) {       // DISTOX_WALLS_TYPE
      mWallsType = tryInt(prefs, k, "0" );
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWallsPlanThr = tryFloat( prefs, k, "70" ); // DISTOX_WALLS_PLAN_THR
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWallsExtendedThr = tryFloat( prefs, k, "45" ); // DISTOX_WALLS_EXTENDED_THR
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWallsXClose = tryFloat( prefs, k, "0.1" ); // DISTOX_WALLS_XCLOSE
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWallsXStep = tryFloat( prefs, k, "1.0" ); // DISTOX_WALLS_XSTEP
    } else if ( k.equals( key[ nk++ ] ) ) {
      mWallsConcave = tryFloat( prefs, k, "0.1" ); // DISTOX_WALLS_CONCAVE
 
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAlgoMinAlpha   = tryFloat( prefs, k, "0.1" );   // DISTOX_ALGO_MIN_ALPHA
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAlgoMinBeta    = tryFloat( prefs, k, "4.0" );   // DISTOX_ALGO_MIN_BETA
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAlgoMinGamma   = tryFloat( prefs, k, "1.0" );   // DISTOX_ALGO_MIN_GAMMA
    } else if ( k.equals( key[ nk++ ] ) ) {
      mAlgoMinDelta   = tryFloat( prefs, k, "1.0" );   // DISTOX_ALGO_MIN_DELTA

    // } else if ( k.equals( key[ nk++ ] ) ) {
    //   mSketchUsesSplays = prefs.getBoolean( k, false );
    // } else if ( k.equals( key[ nk++ ] ) ) {
    //   mSketchBorderStep  = Float.parseFloat( prefs.getString( k, "0.2") );
    // } else if ( k.equals( key[ nk++ ] ) ) {
    //   mSketchSectionStep = Float.parseFloat( prefs.getString( k, "0.5") );
    } else {
      TDLog.checkLogPreferences( prefs, k );
    }
  }

  private static void setLineStyleAndType( String style )
  {
    mLineStyle = LINE_STYLE_BEZIER; // default
    mLineType  = 1;
    if ( style.equals( "0" ) ) {
      mLineStyle = LINE_STYLE_BEZIER;
      mLineType  = 1;
    } else if ( style.equals( "1" ) ) {
      mLineStyle = LINE_STYLE_ONE;
      mLineType  = 1;
    } else if ( style.equals( "2" ) ) {
      mLineStyle = LINE_STYLE_TWO;
      mLineType  = 2;
    } else if ( style.equals( "3" ) ) {
      mLineStyle = LINE_STYLE_THREE;
      mLineType  = 3;
    }
  }

  private static void parseSurveyStations( String str ) 
  {
    try {
      mSurveyStations = Integer.parseInt( str );
    } catch ( NumberFormatException e ) {
      mSurveyStations = 1;
    }
    if ( mSurveyStations == 6 ) {  // TRIPOD
      mBacksightShot   = false;
      mTripodShot      = true;
      mSurveyStations  = 1;
      mShotAfterSplays = true;
    } else if ( mSurveyStations == 5 ) { // BACKSIGHT
      mBacksightShot   = true;
      mTripodShot      = false;
      mSurveyStations  = 1;
      mShotAfterSplays = true;
    } else {
      mBacksightShot   = false;
      mTripodShot      = false;
      mShotAfterSplays = ( mSurveyStations <= 2 );
      if ( mSurveyStations > 2 ) mSurveyStations -= 2;
    }
    // Log.v("DistoX", "mSurveyStations " + mSurveyStations + " mShotAfterSplays " + mShotAfterSplays );
  }

  // void clearPreferences()
  // {
  //   SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences( this );
  //   SharedPreferences.Editor editor = sp.edit();
  //   editor.clear();
  //   editor.commit();
  // }
  
  static void setPreference( SharedPreferences sp, String name, String value )
  {
    Editor editor = sp.edit();
    editor.putString( name, value );
    editor.commit();
  }

  // static void setPreference( SharedPreferences sp, String name, int val )
  // {
  //   Editor editor = sp.edit();
  //   editor.putString( name, Integer.toString(val) );
  //   editor.commit();
  // }

  // static void setPreference( SharedPreferences sp, String name, float val )
  // {
  //   Editor editor = sp.edit();
  //   editor.putString( name, Float.toString(val) );
  //   editor.commit();
  // }

  // ===================================================================
  // ENFORCE BOUNDS

  static private String parseIntValue( String value, int def, int min )
  {
    int i = def;
    try {
      i = Integer.parseInt( value ); 
      if ( i < min ) i = min;
    } catch ( NumberFormatException e ) { }
    return Integer.toString( i );
  }

  static private String parseIntValue( String value, int def, int min, int max )
  {
    int i = def;
    try {
      i = Integer.parseInt( value ); 
      if ( i < min ) i = min;
      if ( i > max ) i = max;
    } catch ( NumberFormatException e ) { }
    return Integer.toString( i );
  }

  static private String parseFloatValue( String value, float def, float min )
  {
    float i = def;
    try {
      i = (float)(Double.parseDouble( value )); 
      if ( i < min ) i = min;
    } catch ( NumberFormatException e ) {
      TDLog.Error("Parse Float Number exception. Value " + value );
    }
    return Float.toString( i );
  }

  static private String parseFloatValue( String value, float def, float min, float max )
  {
    // TDLog.Error("parse float " + value + " def " + def + " min " + min + " max " + max );
    float i = def;
    try {
      i = (float)(Double.parseDouble( value )); 
      if ( i < min ) i = min;
      if ( i > max ) i = max;
    } catch ( NumberFormatException e ) { 
      TDLog.Error("Parse Float Number exception. Value " + value );
    }
    // Log.v("DistoX", "parse float " + value + " def " + def + " min " + min + " max " + max + " return " + i );
    return Float.toString( i );
  }

  static String enforcePreferenceBounds( String name, String value )
  {
    // Log.v("DistoX", "enforce name " + name + " value <" + value + ">" );

    // if ( name.equals( "DISTOX_COSURVEY" )
    //S if ( name.equals( "DISTOX_INIT_STATION" )
    //B if ( name.equals( "DISTOX_AZIMUTH_MANUAL" )

    if ( name.equals( "DISTOX_TEXT_SIZE" ) ) return parseIntValue( value, mTextSize, 1 );
    if ( name.equals( "DISTOX_CLOSE_DISTANCE" ) ) return parseFloatValue( value, mCloseDistance, 0.0001f );
    if ( name.equals( "DISTOX_EXTEND_THR2"    ) ) return parseFloatValue( value, mExtendThr, 0, 90 );
    if ( name.equals( "DISTOX_VTHRESHOLD"     ) ) return parseFloatValue( value, mVThreshold, 0, 90 );
    //C if ( name.equals( "DISTOX_SURVEY_STATION" ) 
    //C if ( name.equals( "DISTOX_UNIT_LENGTH" )
    //C if ( name.equals( "DISTOX_UNIT_ANGLE" )
    if ( name.equals( "DISTOX_ACCEL_PERCENT"  ) ) return parseFloatValue( value, mAccelerationThr, 0 );
    if ( name.equals( "DISTOX_MAG_PERCENT"    ) ) return parseFloatValue( value, mMagneticThr, 0 );
    if ( name.equals( "DISTOX_DIP_THR"        ) ) return parseFloatValue( value, mDipThr, 0 );
    //B if ( name.equals( "DISTOX_LOOP_CLOSURE" ) 
    //B if ( name.equals( "DISTOX_CHECK_ATTACHED" )
    //B if ( name.equals( "DISTOX_PREV_NEXT" )

    //C if ( name.equals( "DISTOX_UNIT_LOCATION" )
    //S if ( name.equals( "DISTOX_CRS" )

    //C if ( name.equals( "DISTOX_GROUP_BY" )
    if ( name.equals( "DISTOX_GROUP_DISTANCE" ) ) return parseFloatValue( value, mGroupDistance, 0 );
    if ( name.equals( "DISTOX_CALIB_EPS"      ) ) return parseFloatValue( value, mCalibEps, 0.000001f );
    if ( name.equals( "DISTOX_CALIB_MAX_IT"   ) ) return parseIntValue( value, mCalibMaxIt, 10 );
    //B if ( name.equals( "DISTOX_RAW_DATA" )
    //C if ( name.equals( "DISTOX_CALIB_ALGO" )

    //S if ( name.equals( "DISTOX_DEVICE" )
    //C if ( name.equals( "DISTOX_BLUETOOTH" )
    //C if ( name.equals( "DISTOX_SOCK_TYPE" )
    if ( name.equals( "DISTOX_COMM_RETRY"    ) ) return parseIntValue( value, mCommRetry, 1, 5 );
    if ( name.equals( "DISTOX_WAIT_LASER"    ) ) return parseIntValue( value, mWaitLaser, 100,  5000 );
    if ( name.equals( "DISTOX_WAIT_SHOT"     ) ) return parseIntValue( value, mWaitShot,  100, 10000 );
    if ( name.equals( "DISTOX_WAIT_DATA"     ) ) return parseIntValue( value, mWaitData,  0,   2000 );
    //C if ( name.equals( "DISTOX_CONN_MODE" )

    // if ( name.equals( "DISTOX_AUTO_STATIONS" )
    if ( name.equals( "DISTOX_CLOSENESS"      ) ) return parseFloatValue( value, mCloseness,    1 );
    if ( name.equals( "DISTOX_ERASENESS"      ) ) return parseFloatValue( value, mEraseness,    1 );
    if ( name.equals( "DISTOX_MIN_SHIFT"      ) ) return parseIntValue( value, mMinShift,      10 );
    if ( name.equals( "DISTOX_POINTING"       ) ) return parseIntValue( value, mPointingRadius, 1 );
    if ( name.equals( "DISTOX_LINE_SEGMENT"   ) ) return parseIntValue( value, mLineSegment,    1 );
    if ( name.equals( "DISTOX_LINE_ACCURACY"  ) ) return parseFloatValue( value, mLineAccuracy, 0.1f );
    if ( name.equals( "DISTOX_LINE_CORNER"    ) ) return parseFloatValue( value, mLineCorner,   0.1f );
    // if ( name.equals( "DISTOX_LINE_STYLE" ) 
    // if ( name.equals( "DISTOX_DRAWING_UNIT" )
    // if ( name.equals( "DISTOX_PICKER_TYPE" )
    if ( name.equals( "DISTOX_HTHRESHOLD"     ) ) return parseFloatValue( value, mHThreshold,    0, 90 );
    if ( name.equals( "DISTOX_STATION_SIZE"   ) ) return parseFloatValue( value, mStationSize,   1 );
    if ( name.equals( "DISTOX_LABEL_SIZE"     ) ) return parseFloatValue( value, mLabelSize,     1 );
    if ( name.equals( "DISTOX_LINE_THICKNESS" ) ) return parseFloatValue( value, mLineThickness, 1, 10 );

    // if ( name.equals( "DISTOX_TEAM" )
    if ( name.equals( "DISTOX_SHOT_TIMER"     ) ) return parseIntValue( value, mTimerCount, 0 );
    if ( name.equals( "DISTOX_BEEP_VOLUME"    ) ) return parseIntValue( value, mBeepVolume, 10, 100 );
    // if ( name.equals( "DISTOX_LEG_SHOTS" )

    if ( name.equals( "DISTOX_SKETCH_LINE_STEP" ) ) return parseFloatValue( value, mSketchSideSize,  0.01f );
    if ( name.equals( "DISTOX_DELTA_EXTRUDE"    ) ) return parseFloatValue( value, mDeltaExtrude,    0.01f );
    if ( name.equals( "DISTOX_COMPASS_READINGS" ) ) return parseIntValue(   value, mCompassReadings, 1 );

    //B if ( name.equals( "DISTOX_SPLAY_EXTEND" )
    //B if ( name.equals( "DISTOX_AUTO_RECONNECT" )
    if ( name.equals( "DISTOX_BITMAP_SCALE"     ) ) return parseFloatValue( value, mBitmapScale,    0.5f, 10f );
    if ( name.equals( "DISTOX_THUMBNAIL"        ) ) return parseIntValue(   value, mThumbSize,      80,   400 );
    if ( name.equals( "DISTOX_DOT_RADIUS"       ) ) return parseFloatValue( value, mDotRadius,      1,    100 );
    if ( name.equals( "DISTOX_FIXED_THICKNESS"  ) ) return parseFloatValue( value, mFixedThickness, 1,    10 );
    if ( name.equals( "DISTOX_ARROW_LENGTH"     ) ) return parseFloatValue( value, mArrowLength,    1,    40 );
    //C if ( name.equals( "DISTOX_EXPORT_SHOTS" )
    //C if ( name.equals( "DISTOX_EXPORT_PLOT" )
    //B if ( name.equals( "DISTOX_THERION_MAPS" )

    if ( name.equals( "DISTOX_SPLAY_VERT_THRS"  ) ) return parseFloatValue( value, mSplayVertThrs, 0, 91 );
    //B if ( name.equals( "DISTOX_BACKSIGHT" )
    //B if ( name.equals( "DISTOX_Z6_WORKAROUND" )
    //B if ( name.equals( "DISTOX_MAG_ANOMALY" )
    if ( name.equals( "DISTOX_VERT_SPLAY"       ) ) return parseFloatValue( value, mVertSplay, 0, 91 );
    //B if ( name.equals( "DISTOX_STATION_PREFIX" )
    //C if ( name.equals( "DISTOX_STATION_NAMES" )
    //C if ( name.equals( "DISTOX_ZOOM_CTRL" )
    //B if ( name.equals( "DISTOX_SIDE_DRAG" )
    //B if ( name.equals( "DISTOX_MKEYBOARD" )
    if ( name.equals( "DISTOX_DXF_SCALE"    ) ) return parseFloatValue( value, mDxfScale, 0.1f, 10f );
    //C if ( name.equals( "DISTOX_ACAD_VERSION" )
    //X if ( name.equals( "DISTOX_BITMAP_BGCOLOR" )
    //B if ( name.equals( "DISTOX_AUTO_PAIR" )
    if ( name.equals( "DISTOX_SOCKET_DELAY"    ) ) return parseIntValue( value, mConnectSocketDelay, 0, 100 );
    //C if ( name.equals( "DISTOX_SURVEX_EOL" )
    //B if ( name.equals( "DISTOX_SURVEX_SPLAY" )
    //B if ( name.equals( "DISTOX_SURVEX_LRUD" )
    //B if ( name.equals( "DISTOX_UNSCALED_POINTS" )
    //C if ( name.equals( "DISTOX_UNIT_GRID" ) 
    //B if ( name.equals( "DISTOX_XTHERION_AREAS" )
    //B if ( name.equals( "DISTOX_THERION_SPLAYS" )
    //C if ( name.equals( "DISTOX_RECENT_NR" )
    //B if ( name.equals( "DISTOX_AREA_BORDER" )
    if ( name.equals( "DISTOX_ORTHO_LRUD" ) ) return parseFloatValue( value, mOrthogonalLRUDAngle, 0, 90 );

    // if ( name.equals( "DISTOX_WALLS_TYPE" )
    if ( name.equals( "DISTOX_WALLS_PLAN_THR"     ) ) return parseFloatValue( value, mWallsPlanThr, 0, 90 );
    if ( name.equals( "DISTOX_WALLS_EXTENDED_THR" ) ) return parseFloatValue( value, mWallsExtendedThr, 0, 90 );
    if ( name.equals( "DISTOX_WALLS_XCLOSE"       ) ) return parseFloatValue( value, mWallsXClose, 0 );
    if ( name.equals( "DISTOX_WALLS_XSTEP"        ) ) return parseFloatValue( value, mWallsXStep, 0 );
    if ( name.equals( "DISTOX_WALLS_CONCAVE"      ) ) return parseFloatValue( value, mWallsConcave, 0 );

    if ( name.equals( "DISTOX_ALGO_MIN_ALPHA"     ) ) return parseFloatValue( value, mAlgoMinAlpha, 0, 1 );
    if ( name.equals( "DISTOX_ALGO_MIN_BETA"      ) ) return parseFloatValue( value, mAlgoMinBeta,  0 );
    if ( name.equals( "DISTOX_ALGO_MIN_GAMMA"     ) ) return parseFloatValue( value, mAlgoMinGamma, 0 );
    if ( name.equals( "DISTOX_ALGO_MIN_DELTA"     ) ) return parseFloatValue( value, mAlgoMinDelta, -10 );

    //C if ( name.equals( "DISTOX_LOCALE" )
    //A if ( name.equals( "DISTOX_CWD"    )
    return value;
  }

}
