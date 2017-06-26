package org.emroy.vfs.service;

import vfs.VfsSystem;
import vfs.VfsException;

import javax.jws.WebService;

/**
 * Created by sech0617 on 23.06.2017.
 */

@WebService(endpointInterface = "org.emroy.vfs.service.VfsService", serviceName = "VfsService")
public class VfsServiceImpl implements VfsService {

    public static VfsSystem vfs;

    @Override
    public void createFile(String path)  {
        vfs.createFile(path);
    }

    @Override
    public void createDirectory(String path) {
        vfs.createSubDir(path);
    }

    @Override
    public void deleteDirectory(String path)  {
        vfs.delete(path);
    }

    @Override
    public void deleteFile(String path)  {
        vfs.delete(path);
    }

    @Override
    public void copy(String srcPath, String destPath)  {

    }

    @Override
    public void move(String srcPath, String destPath)  throws VfsException {

    }

    @Override
    public String getContents(String path) throws VfsException {
            return null;
    }
}
