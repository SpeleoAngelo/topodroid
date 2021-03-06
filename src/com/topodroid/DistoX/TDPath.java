/** @file TDPath.java
 *
 * @author marco corvi
 * @date jan 2015 
 *
 * @brief TopoDroid application paths
 * --------------------------------------------------------
 *  Copyright This sowftare is distributed under GPL-3.0 or later
 *  See the file COPYING.
 * --------------------------------------------------------
 */
package com.topodroid.DistoX;

import java.io.File;
import java.io.FileFilter;
// import java.io.IOException;
// import java.io.FileNotFoundException;

import java.util.List;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

// import android.util.Log;

public class TDPath
{
  final static int NR_BACKUP = 3;
  final static String BCK_SUFFIX = ".bck";

  final static String CSV = ".csv";
  final static String CSX = ".csx";
  final static String CAVE = ".cave";
  final static String CAV = ".cav";
  final static String DAT = ".dat";
  final static String DXF = ".dxf";
  final static String KML = ".kml";
  final static String PLT = ".plt";
  final static String PNG = ".png";
  final static String SRV = ".srv";
  final static String SVG = ".svg";
  final static String SVX = ".svx";
  final static String TDR = ".tdr";
  final static String TH  = ".th";
  final static String TH2 = ".th2";
  final static String TH3 = ".th3";
  final static String TMP = ".tmp";
  final static String TOP = ".top";
  final static String TRO = ".tro";
  final static String TXT = ".txt";
  final static String ZIP = ".zip";
    

  // ------------------------------------------------------------
  // PATHS

  static String EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath(); // app base path
  private static String PATH_DEFAULT = EXTERNAL_STORAGE_PATH + "/TopoDroid/";
  private static String PATH_BASE = PATH_DEFAULT;

  private static String PATH_BIN    = PATH_DEFAULT + "bin/";    // Firmwares  
  private static String PATH_CCSV   = PATH_DEFAULT + "ccsv/";  // calib CSV text
  // private static String PATH_MAN = PATH_DEFAULT + "man/"; // User Manual

  static String APP_SYMBOL_PATH = PATH_DEFAULT + "symbol/";
  static String APP_POINT_PATH  = APP_SYMBOL_PATH + "point/";
  static String APP_LINE_PATH   = APP_SYMBOL_PATH + "line/";
  static String APP_AREA_PATH   = APP_SYMBOL_PATH + "area/";
  static String APP_SYMBOL_SAVE_PATH = APP_SYMBOL_PATH + "save/";
  static String APP_SAVE_POINT_PATH  = APP_SYMBOL_SAVE_PATH + "point/";
  static String APP_SAVE_LINE_PATH   = APP_SYMBOL_SAVE_PATH + "line/";
  static String APP_SAVE_AREA_PATH   = APP_SYMBOL_SAVE_PATH + "area/";

  private static String PATH_CAVE;   //  = PATH_BASE + "cave/";  // Polygon
  private static String PATH_CAV;    //  = PATH_BASE + "cav/";   // Topo
  private static String PATH_CSV;    //  = PATH_BASE + "csv/";   // CSV text
  private static String PATH_CSX;    //  = PATH_BASE + "csx/";   // cSurvey
  private static String PATH_DAT;    //  = PATH_BASE + "dat/";   // Compass
  private static String PATH_DUMP;   //  = PATH_BASE + "dump/";  // DistoX memory dumps
  private static String PATH_DXF;    //  = PATH_BASE + "dxf/";
  private static String PATH_KML;    //  = PATH_BASE + "kml/";
  private static String PATH_PLT;    //  = PATH_BASE + "plt/";
  private static String APP_FOTO_PATH;   //  = PATH_BASE + "photo/";
  private static String PATH_IMPORT; //  = PATH_BASE + "import/";
  private static String APP_NOTE_PATH;   //  = PATH_BASE + "note/";
  private static String PATH_PNG;    //  = PATH_BASE + "png/";
  private static String PATH_SRV;    //  = PATH_BASE + "srv/";
  private static String PATH_SVG;    //  = PATH_BASE + "svg/";
  private static String PATH_SVX;    //  = PATH_BASE + "svx/";
  private static String PATH_TH;     //  = PATH_BASE + "th/";
  private static String PATH_TDR;    //  = PATH_BASE + "tdr/";
  private static String PATH_TH2;    //  = PATH_BASE + "th2/";
  private static String PATH_TH3;    //  = PATH_BASE + "th3/";
  private static String APP_TMP_PATH;    //  = PATH_BASE + "tmp/";
  private static String PATH_TOP;    //  = PATH_BASE + "top/";
  private static String PATH_TRO;    //  = PATH_BASE + "tro/";
  private static String PATH_ZIP;    //  = PATH_BASE + "zip/";
  // private static String APP_TLX_PATH ; //  = PATH_BASE + "tlx/";

  static String mTherionLock = new String("Therion Lock");

  static String getDatabase() { return getDirFile( "distox14.sqlite" ); }
  static String getDeviceDatabase() { return PATH_DEFAULT + "device10.sqlite"; }
  
  static void checkBasePath( String path )
  {
    String cwd = EXTERNAL_STORAGE_PATH + "/" + path;
    File dir = new File( cwd );
    if ( ! dir.exists() ) dir.mkdir();
  }

  // FIXME BASEPATH 
  // remove comments when ready to swicth to new Android app path system
  //
  static void setPaths( String path )
  {
    File dir = null;
    if ( path != null ) {
      String cwd = EXTERNAL_STORAGE_PATH + "/" + path;
      dir = new File( cwd );
      if ( ! dir.exists() ) dir.mkdirs();
      if ( dir.isDirectory() && dir.canWrite() ) PATH_BASE = cwd + "/";
    }
    dir = new File( PATH_BASE );
    if ( ! dir.exists() ) {
      if ( ! dir.mkdir() ) {
        TDLog.Error( "failed mkdir " + PATH_BASE );
        PATH_BASE = PATH_DEFAULT;
      }
    }
    // Log.v(TAG, "Base Path \"" + PATH_BASE + "\"" );

    // APP_TLX_PATH = PATH_BASE + "tlx/";
    // checkDirs( APP_TLX_PATH );

    PATH_CAV = PATH_BASE + "cav/";
    // FIXME checkDirs( PATH_CAV );

    PATH_DAT = PATH_BASE + "dat/";
    // FIXME checkDirs( PATH_DAT );

    PATH_CAVE = PATH_BASE + "cave/";
    // FIXME checkDirs( PATH_CAVE );

    PATH_SRV = PATH_BASE + "srv/";
    // FIXME checkDirs( PATH_SRV );

    PATH_SVX = PATH_BASE + "svx/";
    // FIXME checkDirs( PATH_SVX );

    PATH_CSV = PATH_BASE + "csv/";
    // FIXME checkDirs( PATH_CSV );

    PATH_CSX = PATH_BASE + "csx/";
    // FIXME checkDirs( PATH_CSX );

    PATH_DUMP = PATH_DEFAULT + "dump/";
    // FIXME checkDirs( PATH_DUMP );

    PATH_TOP  = PATH_BASE + "top/";
    // FIXME checkDirs( PATH_TOP );

    PATH_TH  = PATH_BASE + "th/";
    // FIXME checkDirs( PATH_TH );

    PATH_TDR = PATH_BASE + "tdr/";
    checkDirs( PATH_TDR );

    PATH_TH2 = PATH_BASE + "th2/";
    checkDirs( PATH_TH2 );

    PATH_TH3 = PATH_BASE + "th3/";
    checkDirs( PATH_TH3 );

    APP_TMP_PATH = PATH_BASE + "tmp/";
    checkDirs( APP_TMP_PATH );

    PATH_DXF = PATH_BASE + "dxf/";
    // FIXME checkDirs( PATH_DXF );

    PATH_KML = PATH_BASE + "kml/";
    // FIXME checkDirs( PATH_KML );

    PATH_PLT = PATH_BASE + "plt/";
    // FIXME checkDirs( PATH_PLT );

    PATH_SVG = PATH_BASE + "svg/";
    // FIXME checkDirs( PATH_SVG );

    PATH_TRO = PATH_BASE + "tro/";
    // FIXME checkDirs( PATH_TRO );

    PATH_PNG = PATH_BASE + "png/";
    // FIXME checkDirs( PATH_PNG );

    APP_NOTE_PATH = PATH_BASE + "note/";
    checkDirs( APP_NOTE_PATH );

    APP_FOTO_PATH = PATH_BASE + "photo/";
    checkDirs( APP_FOTO_PATH );

    PATH_IMPORT = PATH_BASE + "import/";
    checkDirs( PATH_IMPORT );

    PATH_ZIP = PATH_BASE + "zip/";
    checkDirs( PATH_ZIP );
  }

  static void setDefaultPaths()
  {
    PATH_BIN = PATH_DEFAULT + "bin/";
    checkDirs( PATH_BIN );

    // PATH_MAN = PATH_DEFAULT + "man/";
    // checkDirs( PATH_MAN );

    PATH_CCSV = PATH_DEFAULT + "ccsv/";
    // FIXME checkDirs( PATH_CCSV );

    APP_SYMBOL_PATH  = PATH_DEFAULT + "symbol/";
    APP_SYMBOL_SAVE_PATH  = APP_SYMBOL_PATH + "save/";
    APP_POINT_PATH  = APP_SYMBOL_PATH + "point/";
    APP_LINE_PATH   = APP_SYMBOL_PATH + "line/";
    APP_AREA_PATH   = APP_SYMBOL_PATH + "area/";
    APP_SAVE_POINT_PATH  = APP_SYMBOL_SAVE_PATH + "point/";
    APP_SAVE_LINE_PATH   = APP_SYMBOL_SAVE_PATH + "line/";
    APP_SAVE_AREA_PATH   = APP_SYMBOL_SAVE_PATH + "area/";
    symbolsCheckDirs();
  }

  static String noSpaces( String s )
  {
    return ( s == null )? null 
      : s.trim().replaceAll("\\s+", "_").replaceAll("/", "-").replaceAll("\\*", "+").replaceAll("\\\\", "");
  }

  static void checkPath( String filename )
  {
    if ( filename == null ) return;
    File fp = new File( filename );
    checkPath( new File( filename ) );
  }

  static void checkPath( File fp ) 
  {
    if ( fp == null || fp.exists() ) return;
    File fpp = fp.getParentFile();
    if ( fpp.exists() ) return;
    fpp.mkdirs(); // return boolean : must check ?
  }

  static String getLogFilename()
  {
    return PATH_DEFAULT + "log.txt";
  }

  static File getLogFile()
  {
    File logfile = new File( PATH_DEFAULT + "log.txt" );
    checkPath( logfile );
    return logfile;
  }

  // ------------------------------------------------------------------
  // FILE NAMES

  public static String getSqlFile() { return PATH_BASE + "survey.sql"; }

  public static String getManifestFile() { return PATH_BASE + "manifest"; }

  static String getSymbolFile( String name ) { return APP_SYMBOL_PATH + name; }
  static String getSymbolSaveFile( String name ) { return APP_SYMBOL_SAVE_PATH + name; }

  static boolean hasTdrDir() { return (new File( PATH_TDR )).exists(); }
  static boolean hasTh2Dir() { return (new File( PATH_TH2 )).exists(); }
  static boolean hasTh3Dir() { return (new File( PATH_TH3 )).exists(); }
  static boolean hasPngDir() { return (new File( PATH_PNG )).exists(); }
  static boolean hasDxfDir() { return (new File( PATH_DXF )).exists(); }
  static boolean hasKmlDir() { return (new File( PATH_KML )).exists(); }
  static boolean hasPltDir() { return (new File( PATH_PLT )).exists(); }
  static boolean hasSvgDir() { return (new File( PATH_SVG )).exists(); }

  static String getDirFile( String name )    { return PATH_BASE + name; }
  static String getImportFile( String name ) { return PATH_IMPORT + name; }
  static String getZipFile( String name )    { return PATH_ZIP + name; }
  static String getTdrFile( String name )    { return PATH_TDR + name; }
  static String getTh2File( String name )    { return PATH_TH2 + name; }
  static String getTh3File( String name )    { return PATH_TH3 + name; }

  static String getThFile( String name )     { return PATH_TH + name; }
  static String getCaveFile( String name )   { return PATH_CAVE + name; }
  static String getCavFile( String name )    { return PATH_CAV + name; }
  static String getDatFile( String name )    { return PATH_DAT + name; }
  static String getDxfFile( String name )    { return PATH_DXF + name; }
  static String getKmlFile( String name )    { return PATH_KML + name; }
  static String getPltFile( String name )    { return PATH_PLT + name; }
  static String getSrvFile( String name )    { return PATH_SRV + name; }
  static String getSvgFile( String name )    { return PATH_SVG + name; }
  static String getSvxFile( String name )    { return PATH_SVX + name; }
  static String getCsvFile( String name )    { return PATH_CSV + name; }
  static String getCsxFile( String name )    { return PATH_CSX + name; }
  static String getDumpFile( String name )   { return PATH_DUMP + name; }
  static String getTopFile( String name )    { return PATH_TOP + name; }
  static String getTroFile( String name )    { return PATH_TRO + name; }
  static String getPngFile( String name )    { return PATH_PNG + name; }

  static String getBinFile( String name )    { return PATH_BIN + name; }
  static String getCCsvFile( String name )   { return PATH_CCSV + name; }
  // static String getManFile( String name )    { return PATH_MAN + name; }

  static String getNoteFile( String name )   { return APP_NOTE_PATH + name; }

  static String getJpgDir( String dir ) { return APP_FOTO_PATH + dir; }
  static String getJpgFile( String dir, String name ) { return APP_FOTO_PATH + dir + "/" + name; }

  static String getSurveyPlotDxfFile( String survey, String name ) { return PATH_DXF + survey + "-" + name + DXF ; }
  static String getSurveyPlotSvgFile( String survey, String name ) { return PATH_SVG + survey + "-" + name + SVG ; }
  static String getSurveyPlotTdrFile( String survey, String name ) { return PATH_TDR + survey + "-" + name + TDR ; }
  static String getSurveyPlotTh2File( String survey, String name ) { return PATH_TH2 + survey + "-" + name + TH2 ; }
  static String getSurveyPlotPngFile( String survey, String name ) { return PATH_PNG + survey + "-" + name + PNG ; }
  static String getSurveyPlotCsxFile( String survey, String name ) { return PATH_CSX + survey + "-" + name + CSX ; }

  static String getSurveySketchFile( String survey, String name ) { return PATH_TH3 + survey + "-" + name + TH3 ; }

  private static String getFile( String directory, String name, String ext ) 
  {
    checkDirs( directory );
    return directory + name + ext;
  }

  static File getTmpDir() { return new File( APP_TMP_PATH ); }

  static String getSurveyNoteFile( String title ) { return getFile( APP_NOTE_PATH, title, TXT ); }
  static String getTmpFileWithExt( String name ) { return getFile( APP_TMP_PATH, name, TMP ); }
  static String getTdrFileWithExt( String name ) { return getFile( PATH_TDR, name, TDR ); }
  static String getTh2FileWithExt( String name ) { return getFile( PATH_TH2, name, TH2 ); }
  static String getTh3FileWithExt( String name ) { return getFile( PATH_TH3, name, TH3 ); }
  static String getDxfFileWithExt( String name ) { return getFile( PATH_DXF, name, DXF ); }
  static String getSvgFileWithExt( String name ) { return getFile( PATH_SVG, name, SVG ); }
  static String getPngFileWithExt( String name ) { return getFile( PATH_PNG, name, PNG ); }

  static String getSurveyZipFile( String survey ) { return getFile( PATH_ZIP, survey, ZIP ); }

  // static String getSurveyTlxFile( String survey ) { return getFile( APP_TLX_PATH, survey, TLX ); }
  static String getSurveyThFile( String survey ) { return getFile( PATH_TH, survey, TH ); }
  static String getSurveyCsvFile( String survey ) { return getFile( PATH_CSV, survey, CSV ); }
  static String getSurveyCsxFile( String survey ) { return getFile( PATH_CSX, survey, CSX ); }
  static String getSurveyCsxFile( String survey, String name ) { return getFile( PATH_CSX, survey + "-" + name, CSX ); }
  static String getSurveyCaveFile( String survey ) { return getFile( PATH_CAVE, survey, CAVE ); }
  static String getSurveyCavFile( String survey ) { return getFile( PATH_CAV, survey, CAV ); }
  static String getSurveyDatFile( String survey ) { return getFile( PATH_DAT, survey, DAT ); }
  static String getSurveyDxfFile( String survey ) { return getFile( PATH_DXF, survey, DXF ); }
  static String getSurveyKmlFile( String survey ) { return getFile( PATH_KML, survey, KML ); }
  static String getSurveyPltFile( String survey ) { return getFile( PATH_PLT, survey, PLT ); }
  static String getSurveySrvFile( String survey ) { return getFile( PATH_SRV, survey, SRV ); }
  static String getSurveySvxFile( String survey ) { return getFile( PATH_SVX, survey, SVX ); }
  static String getSurveyTopFile( String survey ) { return getFile( PATH_TOP, survey, TOP ); }
  static String getSurveyTroFile( String survey ) { return getFile( PATH_TRO, survey, TRO ); }

  private static File[] getFiles( String dirname, final String[] ext )
  {
    File dir = new File( dirname );
    if ( dir.exists() ) {
      return dir.listFiles( new FileFilter() {
          public boolean accept( File pathname ) { 
            int ne = ext.length;
            if ( pathname.isDirectory() ) return false;
            if ( ne == 0 ) return true;
            for ( int n = 0; n < ne; ++n ) {
              if ( pathname.getName().endsWith( ext[n] ) ) return true;
            }
            return false;
          }
        } );
    }
    return null;
  }

  static File[] getCalibFiles() { return getFiles( PATH_CCSV, new String[] {""} ); }

  static File[] getTopoDroidFiles( )
  {
    File dir = new File( EXTERNAL_STORAGE_PATH );
    return dir.listFiles( new FileFilter() {
      public boolean accept( File pathname ) { 
        if ( ! pathname.isDirectory() ) return false;
        if ( pathname.getName().toLowerCase().startsWith( "topodroid" ) ) return true;
        return false;
      }
    } );
  }

  // private static File[] getFiles( String dirname, final String extension )
  // {
  //   File dir = new File( dirname );
  //   if ( dir.exists() ) {
  //     return dir.listFiles( new FileFilter() {
  //         public boolean accept( File pathname ) { return pathname.getName().endsWith( extension ); }
  //       } );
  //   }
  //   return null;
  // }

  static File[] getImportFiles() 
  { 
    return getFiles( PATH_IMPORT, new String[] { TH, TOP, DAT, TRO } );
  }

  static File[] getZipFiles() { return getFiles( PATH_ZIP, new String[] { ZIP } ); }
  static File[] getBinFiles() { return getFiles( PATH_BIN, new String[] { } ); }

  // static String getSurveyPhotoFile( String survey, String name ) { return APP_FOTO_PATH + survey + "/" + name; }

  static String getSurveyPhotoDir( String survey ) { return APP_FOTO_PATH + survey; }

  static String getSurveyJpgFile( String survey, String id )
  {
    File imagedir = new File( APP_FOTO_PATH + survey + "/" );
    if ( ! ( imagedir.exists() ) ) {
      imagedir.mkdirs();
    }
    return APP_FOTO_PATH + survey + "/" + id + ".jpg";
  }

  static void checkDirs( String path )
  {
    File f1 = new File( path );
    if ( ! f1.exists() ) f1.mkdirs( );
  }

  static void symbolsCheckDirs()
  {
    checkDirs( APP_SYMBOL_PATH );
    checkDirs( APP_SYMBOL_SAVE_PATH );
    checkDirs( APP_POINT_PATH );
    checkDirs( APP_LINE_PATH );
    checkDirs( APP_AREA_PATH );
    checkDirs( APP_SAVE_POINT_PATH );
    checkDirs( APP_SAVE_LINE_PATH );
    checkDirs( APP_SAVE_AREA_PATH );
  }

  static void checkCCsvDir() { checkDirs( PATH_CCSV ); }
  static void checkBinDir()  { checkDirs( PATH_BIN ); }
  // static void checkManDir() { checkDirs( PATH_MAN ); }

  static void deleteSurveyFiles( String survey )
  {
    File imagedir = new File( getSurveyPhotoDir( survey ) );
    if ( imagedir.exists() ) {
      File[] fs = imagedir.listFiles();
      for ( File f : fs ) f.delete();
      imagedir.delete();
    }

    File t = new File( getSurveyNoteFile( survey ) ); if ( t.exists() ) t.delete();
    
    // t = new File( getSurveyTlxFile( survey ) ); if ( t.exists() ) t.delete();
    
    t = new File( getThFile(  survey + TH  ) ); if ( t.exists() ) t.delete();
    t = new File( getCsvFile( survey + CSV ) ); if ( t.exists() ) t.delete();
    t = new File( getCsxFile( survey + CSX ) ); if ( t.exists() ) t.delete();
    t = new File( getCaveFile( survey + CAVE ) ); if ( t.exists() ) t.delete();
    t = new File( getCavFile( survey + CAV ) ); if ( t.exists() ) t.delete();
    t = new File( getDatFile( survey + DAT ) ); if ( t.exists() ) t.delete();
    t = new File( getDxfFile( survey + DXF ) ); if ( t.exists() ) t.delete();
    t = new File( getKmlFile( survey + KML ) ); if ( t.exists() ) t.delete();
    t = new File( getPltFile( survey + PLT ) ); if ( t.exists() ) t.delete();
    t = new File( getSvxFile( survey + SVX ) ); if ( t.exists() ) t.delete();
    t = new File( getSrvFile( survey + SRV ) ); if ( t.exists() ) t.delete();
    t = new File( getTopFile( survey + TOP ) ); if ( t.exists() ) t.delete();
    t = new File( getTroFile( survey + TRO ) ); if ( t.exists() ) t.delete();
  }

  static void rotateBackups( String filename, int rotate ) // filename has suffix BCK_SUFFIX
  {
    File file2;
    File file1;
    for ( int i=rotate-1; i>0; --i ) { 
      file2 = new File( filename + Integer.toString(i) );
      file1 = new File( filename + Integer.toString(i-1) );
      if ( file1.exists() ) {
        file1.renameTo( file2 );
      }
    }
    file2 = new File( filename + "0" );
    file1 = new File( filename );
    if ( file1.exists() ) {
      file1.renameTo( file2 );
    }
  }

  static void deletePlotFileWithBackups( String filename )
  {
    File file = new File( filename );
    if ( file.exists() ) file.delete(); 

    String filepath = filename + TDPath.BCK_SUFFIX;
    file = new File( filepath );
    if ( file.exists() ) file.delete(); 
    for ( int i = 0; i < NR_BACKUP; ++i ) {
      filepath = filename + TDPath.BCK_SUFFIX + Integer.toString(i);
      file = new File( filepath );
      if ( file.exists() ) file.delete(); 
    }
  }

  static void deleteFile( String filename )
  {
    File file = new File( filename );
    if ( file.exists() ) file.delete(); 
  }

  static void deleteBackups( String filename ) // filename has suffix BCK_SUFFIX
  {
    File file = new File( filename );
    if ( file.exists() ) file.delete();
    for ( int i=NR_BACKUP-1; i>=0; --i ) { 
      file = new File( filename + Integer.toString(i) );
      if ( file.exists() ) file.delete();
    }
  }

  static void deleteSurveyPlotFiles( String survey, List<PlotInfo> plots )
  {
    File t;
    for ( PlotInfo p : plots ) {
      String filename = getSurveyPlotTh2File( survey, p.name );
      t = new File( filename ); if ( t.exists() ) t.delete();
      deleteBackups( filename + BCK_SUFFIX );
      filename = getSurveyPlotTdrFile( survey, p.name );
      t = new File( filename ); if ( t.exists() ) t.delete();
      deleteBackups( filename + BCK_SUFFIX );
      t = new File( getSurveyPlotPngFile( survey, p.name ) ); if ( t.exists() ) t.delete();
      t = new File( getSurveyPlotDxfFile( survey, p.name ) ); if ( t.exists() ) t.delete();
      t = new File( getSurveyPlotSvgFile( survey, p.name ) ); if ( t.exists() ) t.delete();
    }
  }

  static void deleteSurvey3dFiles( String survey, List< Sketch3dInfo > sketches )
  {
    if ( hasTh3Dir() ) {
      for ( Sketch3dInfo s : sketches ) {
        File t = new File( getTh3FileWithExt( survey + "-" + s.name + TH3 ) ); if ( t.exists() ) t.delete();
      }
    }
  }
}
