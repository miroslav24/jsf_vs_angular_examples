package com.example.rest;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CommonResponseFilter implements ContainerResponseFilter {

    @Inject
    private Logger logger;

    public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx ) throws IOException {

        logger.debug("Adding common headers to response" );

        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*");
    }
}