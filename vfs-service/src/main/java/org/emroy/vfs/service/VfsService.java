package org.emroy.vfs.service;

import vfs.VfsException;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by sech0617 on 23.06.2017.
 */

@WebService
public interface VfsService {

    @WebMethod
    void createFile(String path) ;

    @WebMethod
    void createDirectory(String path) ;

    @WebMethod
    void deleteDirectory(String path) ;

    @WebMethod
    void deleteFile(String path) ;

    @WebMethod
    void copy(String srcPath, String destPath) ;

    @WebMethod
    void move(String srcPath, String destPath) ;

    @WebMethod
    String getContents(String path) ;
}
