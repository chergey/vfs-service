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
    void createFile(String path) throws VfsException;

    @WebMethod
    void createDirectory(String path) throws VfsException;

    @WebMethod
    void deleteDirectory(String path) throws VfsException;

    @WebMethod
    void deleteFile(String path) throws VfsException;

    @WebMethod
    void copy(String srcPath, String destPath) throws VfsException;

    @WebMethod
    void move(String srcPath, String destPath) throws VfsException;

    @WebMethod
    void getContents(String path) throws VfsException;
}
