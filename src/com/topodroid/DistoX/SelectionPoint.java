/** @file SelectionPoint.java
 *
 * @author marco corvi
 * @date feb 2013
 *
 * @brief a point in the selection set
 * --------------------------------------------------------
 *  Copyright This sowftare is distributed under GPL-3.0 or later
 *  See the file COPYING.
 * --------------------------------------------------------
 */
package com.topodroid.DistoX;

// import android.util.Log;

class SelectionPoint
{
  // scene coord (x, y )
  // for DrawingStationName (x,y) = st.(mX,mY)
  // for DrawingPath        (x,y) = (cx,cy)
  // for DrawingStationPath (x,y) = path.(mXpos,mYpos)
  // for DrawingPointPath   (x,y) = path.(mXpos,mYpos)
  // for DrawingLinePath    (x.y) = midpoint between each two line points
  // for DrawingAreaPath    (x,y) = midpoint between each two border points

  float mDistance;
  DrawingPath mItem;
  LinePoint   mPoint;
  private int mMin; // whether to shift the point (0) or a CP (1 or 2)
  SelectionBucket mBucket = null;

  int type() { return mItem.mType; }
  // DRAWING_PATH_FIXED   = 0; // leg
  // DRAWING_PATH_SPLAY   = 1; // splay
  // DRAWING_PATH_GRID    = 2; // grid
  // DRAWING_PATH_STATION = 3; // station point
  // DRAWING_PATH_POINT   = 4; // drawing point
  // DRAWING_PATH_LINE    = 5;
  // DRAWING_PATH_AREA    = 6;
  // DRAWING_PATH_NAME    = 7; // station name
  // DRAWING_PATH_NORTH   = 8

  boolean isReferenceType() { return DrawingPath.isReferenceType( mItem.mType ); }

  boolean isDrawingType() { return DrawingPath.isDrawingType( mItem.mType ); }

  SelectionPoint( DrawingPath it, LinePoint pt, SelectionBucket bucket )
  {
    mItem = it;
    mPoint = pt;
    mDistance = 0.0f;
    mMin = 0;
    setBucket( bucket );
  }

  String name()
  {
    if ( mItem.mBlock != null ) {
      return mItem.mBlock.mFrom + " " + mItem.mBlock.mTo + " " + X() + " " + Y();
    } else {
      return X() + " " + Y();
    }
  }


  float X() { return ( mPoint != null )? mPoint.mX : mItem.cx; }
  float Y() { return ( mPoint != null )? mPoint.mY : mItem.cy; }

  // distance from a scene point (xx, yy)
  float distance( float xx, float yy )
  {
    mMin = 0; // index of the point that has achived the min distance
    if ( mPoint != null ) {
      float d = mPoint.distance( xx, yy );
      if ( mPoint.has_cp ) {
        float d1 = mPoint.distanceCP1( xx, yy );
        float d2 = mPoint.distanceCP2( xx, yy );
        if ( d <= d1 ) {
          if ( d <= d2 ) {
            return d;
          } 
          mMin = 2;
          return d2;
        }
        if ( d1 < d2 ) {
          mMin = 1;
          return d1;
        }
        mMin = 2;
        return d2;
      }
      return d;
    }
    return mItem.distanceToPoint( xx, yy );
  }

  void shiftBy( float dx, float dy )
  {
    if ( mPoint != null ) {
      switch ( mMin ) {
        case 1 : mPoint.shiftCP1By( dx, dy ); break;
        case 2 : mPoint.shiftCP2By( dx, dy ); break;
        default: mPoint.shiftBy( dx, dy ); break;
      }
      DrawingPointLinePath item = (DrawingPointLinePath)mItem;
      item.retracePath();
    } else if ( mItem.mType == DrawingPath.DRAWING_PATH_POINT ) {
      mItem.shiftBy( dx, dy );
    }
  }

  void shiftSelectionBy( float dx, float dy )
  {
    if ( mPoint != null ) {
      // switch ( mMin ) {
      //  case 1 : mPoint.shiftCP1By( dx, dy ); break;
      //  case 2 : mPoint.shiftCP2By( dx, dy ); break;
      //  default: mPoint.shiftBy( dx, dy ); break;
      // }
      mPoint.shiftBy( dx, dy ); 
      DrawingPointLinePath item = (DrawingPointLinePath)mItem;
      item.retracePath();
    } else if ( mItem.mType == DrawingPath.DRAWING_PATH_POINT ) {
      mItem.shiftBy( dx, dy );
    }
  }
 
  void setBucket( SelectionBucket bucket )
  {
    if ( mBucket == bucket ) return;
    if ( mBucket != null ) mBucket.removePoint( this );
    mBucket = bucket;
    if ( mBucket != null ) mBucket.addPoint( this );
  }

}
