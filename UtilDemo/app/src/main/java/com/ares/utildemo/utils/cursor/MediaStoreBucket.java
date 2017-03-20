package com.ares.utildemo.utils.cursor;

/**
 * 本地图库相册类
 * Created by Yan Cui on 2017/3/17/017.
 */

public class MediaStoreBucket {

    /**  id */
    private String id;
    /**  相册类型 */
    private String mime_type;
    /**  相册id */
    private String bucket_id;
    /**  相册名 */
    private String bucket_display_name;
    /**  相册封面路径 */
    private String data;
    /**  相册包含图片数量 */
    private int num;

    public MediaStoreBucket(String id, String mime_type, String bucket_id, String bucket_display_name, String data, int num) {
        this.id = id;
        this.mime_type = mime_type;
        this.bucket_id = bucket_id;
        this.bucket_display_name = bucket_display_name;
        this.data = data;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getBucket_id() {
        return bucket_id;
    }

    public void setBucket_id(String bucket_id) {
        this.bucket_id = bucket_id;
    }

    public String getBucket_display_name() {
        return bucket_display_name;
    }

    public void setBucket_display_name(String bucket_display_name) {
        this.bucket_display_name = bucket_display_name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
