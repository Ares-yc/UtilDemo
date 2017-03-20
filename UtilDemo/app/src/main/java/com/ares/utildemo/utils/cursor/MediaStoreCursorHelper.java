package com.ares.utildemo.utils.cursor;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 媒体库Cursor工具类
 * Created by Yan Cui on 2017/3/17/017.
 */

public class MediaStoreCursorHelper {

    private static final String[] PHOTOS_PROJECTION = {
            MediaStore.Images.Media._ID,                //图片Id
            MediaStore.Images.Media.DATA,               //图片路径
            MediaStore.Images.Media.SIZE,               //图片大小
            MediaStore.Images.Media.DISPLAY_NAME,       //图片名称
            MediaStore.Images.Media.TITLE,              //图片标题
            MediaStore.Images.Media.MIME_TYPE,          //图片格式
            MediaStore.Images.Media.DATE_ADDED,         //图片添加时间
            MediaStore.Images.Media.DATE_MODIFIED,      //图片修改时间
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,//图片所在文件夹名称
            MediaStore.Images.Media.BUCKET_ID,          //图片所在文件夹Id
            MediaStore.Images.Media.HEIGHT,             //图片高
            MediaStore.Images.Media.WIDTH,              //图片宽
            "count(*) as num"                           //图片总数
    };
    private static final String[] VIDEOS_PROJECTION = {
            MediaStore.Video.Media._ID,                 //视频Id
            MediaStore.Video.Media.DATA,                //视频路径
            MediaStore.Video.Media.SIZE,                //视频大小
            MediaStore.Video.Media.DISPLAY_NAME,        //视频名称
            MediaStore.Video.Media.TITLE,               //视频标题
            MediaStore.Video.Media.MIME_TYPE,           //视频格式
            MediaStore.Video.Media.DATE_ADDED,          //视频添加时间
            MediaStore.Video.Media.DATE_MODIFIED,       //视频修改时间
            MediaStore.Video.Media.BUCKET_DISPLAY_NAME, //视频所在文件夹名称
            MediaStore.Video.Media.BUCKET_ID,           //视频所在文件夹Id
            "count(*) as num"                           //视频总数
    };

    private static final String PHOTOS_ORDER_BY = MediaStore.Images.Media.DATE_ADDED + " desc";
    private static final String VIDEOS_ORDER_BY = MediaStore.Video.Media.DATE_ADDED + " desc";

    private static final Uri PHOTOS_MEDIA_STORE_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    private static final Uri VIDEOS_MEDIA_STORE_CONTENT_URI = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    /**
     * 禁止实例化
     * 该类所有方法都是静态方法
     */
    private MediaStoreCursorHelper(){
        throw new UnsupportedOperationException("This Class can't be Instanced");
    }

    public static void videosCursorToBucketList(Cursor cursor, ArrayList<MediaStoreBucket> items){
        final HashSet<String> bucketIds = new HashSet<String>();


    }

    public static void photosCursorToBucketList(Cursor cursor, ArrayList<MediaStoreBucket> items) {
        final HashSet<String> bucketIds = new HashSet<String>();

        final int idColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns._ID);
        final int mimeTypeColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.MIME_TYPE);
        final int bucket_id = cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_ID);
        final int bucketDisplayNameColumn = cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME);


    }

    /**
     * 打开系统媒体库
     * 图片数据表
     * @param context       上下文
     * @param selection     筛选条件
     * @param selectionArgs 筛选条件参数
     * @return              系统图片数据表游标
     */
    private static Cursor openPhotoCursor(Context context,String selection,String[] selectionArgs){
        return context.getContentResolver().query(PHOTOS_MEDIA_STORE_CONTENT_URI,PHOTOS_PROJECTION,selection,selectionArgs,PHOTOS_ORDER_BY);
    }

    /**
     * 打开系统媒体库
     * 视频数据表
     * @param context       上下文
     * @param selection     筛选条件
     * @param selectionArgs 筛选条件参数
     * @return              系统图片数据表游标
     */
    private static Cursor openVideosCursor(Context context,String selection,String[] selectionArgs){
        return context.getContentResolver().query(VIDEOS_MEDIA_STORE_CONTENT_URI,VIDEOS_PROJECTION,selection,selectionArgs,VIDEOS_ORDER_BY);
    }

}
