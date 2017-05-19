package com.shark.http.api;

import com.shark.retrofit.http.core.HttpManager;
import com.shark.retrofit.http.header.IUserAgent;
import com.soaringcloud.kit.box.LogKit;


/**
 * Created by renyuxiang on 2015/12/7.
 */
public class VideoService {
////    public static final String SERVER_API = "http://114.215.89.173:8888/videosAPI/v1.0/";
////    测试
////    public static final String SERVER_API = "http://121.42.155.39:6666/videosAPI/v1.0/";
////    正式
//    public static final String SERVER_API = "http://114.215.89.173:9999/videosAPI/v1.0/";
//    private HttpManager httpManager;
//    private VideoAPI videoAPI;
//
//    public VideoService(IUserAgent userAgent) {
//        httpManager = new HttpManager(SERVER_API, userAgent);
//        init();
//    }
//
//    public void init() {
//        videoAPI = httpManager.createAPI(VideoAPI.class);
//    }
//
//    public void getVideoList(GetVideoListParam param, final OnVideoListReceivedListener listener) {
//        Call<MetaDataResponse<List<VideoJo>>> task = videoAPI.getVideoList(param.getOptionSearchKeyWord(), param.getVideoClassifyId(),param.getOrderBy(), param.getPageSize(),
//                param.getPageIndex());
//        task.enqueue(new Callback<MetaDataResponse<List<VideoJo>>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<List<VideoJo>>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getVideoList");
//                if (listener != null) {
//                    listener.onReceived(response.body().getData());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onReceived(null);
//                }
//            }
//        });
//    }
//
//    public void getVideoDetail(GetVideoDetailParam param, final OnVideoDetailReceivedListener listener) {
//        videoAPI.getVideoDetail(param.getVideoId()).enqueue(new Callback<MetaDataResponse<VideoJo>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<VideoJo>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getVideoDetail");
//                if (listener != null) {
//                    listener.onReceived(response.body().getData());
//                }-
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onReceived(null);
//                }
//            }
//        });
//    }
//
//    public void getVideoPlayRecord(GetVideoRecordParam param, final OnGetVideoRecordListener listener) {
//        videoAPI.getVideoRecordList(param.getVideoId()).enqueue(new Callback<MetaDataResponse<VideoRecordJo>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<VideoRecordJo>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getVideoPlayRecord");
//                if (listener != null) {
//                    listener.onReceived(response.body().getData());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onReceived(null);
//                }
//            }
//        });
//    }
//
//    public void postVideoPlayRecord(PostVideoRecordParam param, final OnPostCompleteListener listener) {
//        videoAPI.postVideoRecord(param).enqueue(new Callback<MetaDataResponse<ResultJo>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<ResultJo>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse postVideoPlayRecord");
//                if (listener != null) {
//                    listener.onCompleted(true);
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onCompleted(false);
//                }
//            }
//        });
//    }
//
//    public void getVideoMenuList(GetMenuListParam param, final OnMenuListReceivedListener listener) {
//        videoAPI.getMenuList(param.getVideoMenuId()).enqueue(new Callback<MetaDataResponse<List<VideoMenuItemJo>>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<List<VideoMenuItemJo>>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getVideoMenuList");
//                if (listener != null) {
//                    listener.onReceived(response.body().getData());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onReceived(null);
//                }
//            }
//        });
//    }
//    public void getRecommendVideoList(GetRecommendVideoListParam param, final OnVideoListReceivedListener listener){
//        Call<MetaDataResponse<List<VideoJo>>> task = videoAPI.getRecommendVideoList(param.getVideoId(), param.getPageSize(), param.getPageIndex());
//        task.enqueue(new Callback<MetaDataResponse<List<VideoJo>>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<List<VideoJo>>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getRecommendVideoList");
//                if (listener != null) {
//                    listener.onReceived(response.body().getData());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onReceived(null);
//                }
//            }
//        });
//
//    }
//
//    public void getVideoPlayRecordCount(GetVideoPlayRecordCountParam param, final OnVideoPlayRecordCountListener listener){
//        videoAPI.getVideoPlayRecordCount(param.getVideoId()).enqueue(new Callback<MetaDataResponse<VideoRecordCountJo>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<VideoRecordCountJo>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getVideoPlayRecordCount");
//                if (listener != null) {
//                    listener.onReceived(response.body().getData());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener != null) {
//                    listener.onReceived(null);
//                }
//            }
//        });
//    }
//
//    public void getVideoAppPlayCount(GetVideoPlayRecordCountParam param, final OnPostCompleteListener listener){
//        videoAPI.postVideoAppPlayCount(param).enqueue(new Callback<MetaDataResponse<ResultJo>>() {
//            @Override
//            public void onResponse(Response<MetaDataResponse<ResultJo>> response, Retrofit retrofit) {
//                LogKit.e(this,"onResponse getVideoAppPlayCount");
//                if (listener!=null){
//                    listener.onCompleted(true);
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                if (listener!=null){
//                    listener.onCompleted(false);
//                }
//            }
//        });
//    }
//
//    public void getRelativeVideoList(GetRecommendVideoListParam param, OnVideoListReceivedListener listener) {
//        videoAPI.getRecommendVideoList(param.getVideoId(), param.getPageSize(), param.getPageIndex());
//    }
}
