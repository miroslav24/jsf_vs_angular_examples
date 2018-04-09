package com.example.utils;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestUtils {

    public static final String MEDIA_TYPE_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

    /**
     *
     * @param status
     * @return response for no caching in browser
     */
    public static Response.ResponseBuilder getNoCacheResponseBuilder(Response.Status status ) {
        CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );

        return Response.status( status ).cacheControl( cc );
    }
}