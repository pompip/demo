package com.hxqc.socketlibrary.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Author:廖贵龙
 * Date:2015-07-22
 * FIXME
 * Todo
 */
@DatabaseTable(tableName = "tb_trackdata")
public class TrackData {

    public TrackData(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean is_upload() {
        return is_upload;
    }

    public void setIs_upload(boolean is_upload) {
        this.is_upload = is_upload;
    }

    /**
     *主键ID
     */
    @DatabaseField(generatedId = true)
    private int id;

    /**
     * 经度
     */
    @DatabaseField(canBeNull = true)
    private double longitude;

    /**
     *纬度
     */
    @DatabaseField(canBeNull = true)
    private double latitude;


    /**
     * 生成时间
     */
    @DatabaseField(canBeNull = true)
    private String time;

    /**
     * 上传标识
     */
    @DatabaseField(canBeNull = true,defaultValue ="false")
    private boolean is_upload;
}
