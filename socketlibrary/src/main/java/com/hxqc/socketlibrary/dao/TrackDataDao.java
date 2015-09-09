package com.hxqc.socketlibrary.dao;

import android.content.Context;
import android.util.Log;

import com.hxqc.socketlibrary.bean.TrackData;
import com.hxqc.socketlibrary.database.DatabaseHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Author:廖贵龙
 * Date:2015-07-22
 * FIXME
 * Todo
 */
public class TrackDataDao {
    private Context context;
    private Dao<TrackData, Integer> trackDaoOpe;
    private DatabaseHelper helper;

    public TrackDataDao(Context context)
    {
        this.context = context;
        try
        {
            helper = DatabaseHelper.getHelper(context);
            trackDaoOpe = helper.getDao(TrackData.class);
        } catch (SQLException e)
        {
            Log.e("TrackDataDao():Error",e.getMessage());
        }
    }

    /**
     *  增加一条轨迹数据
     * @param track
     * @return 0失败，1成功
     */
    public int  addTrack(TrackData track)
    {
        int result=0;
        try
        {
            result=trackDaoOpe.create(track);
           return result;
        } catch (SQLException e)
        {
            Log.e("addTrack():Error", e.getMessage());
        }
        return result;
    }

    /**
     * 根据ID获取一条轨迹数据
     * @param id
     * @return 轨迹实体
     */
    public TrackData getTrackDataByID(int id){
        TrackData trackdata=null;
        try
        {
            trackdata=trackDaoOpe.queryForId(id);
            return  trackdata;
        } catch (SQLException e)
        {
            Log.e("GetTrackDataByID()", e.getMessage());
        }
        return  trackdata;
    }

    /**
     * 修改轨迹
     * @param trackData 轨迹实体
     */
    public int updateTrackData(TrackData trackData){
        int result=0;
        try
        {
            result=trackDaoOpe.update(trackData);
            return result;
        } catch (SQLException e)
        {
            Log.e("UpdateTDStateByID()", e.getMessage());
        }
        return result;
    }

    /**
     * 根据状态获取轨迹点集合
     * @param isupload 上传标识
     * @return
     */
    public List<TrackData> getTrackDatasByState(boolean isupload){
        List<TrackData> listTrackData=null;
        try{
            listTrackData=trackDaoOpe.queryBuilder().where().eq("is_upload", isupload).query();
            return listTrackData;
        }catch (SQLException e)
        {
            Log.e("GetTrackDatasByState()", e.getMessage());
        }
        return  listTrackData;
    }

    public void close(){
        helper.close();
    }

}
