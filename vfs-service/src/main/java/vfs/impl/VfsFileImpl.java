package vfs.impl;

import vfs.VfsDirectory;
import vfs.VfsEntity;
import vfs.VfsFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sech0617 on 23.06.2017.
 */

public class VfsFileImpl extends VfsEntity implements VfsFile {

    private byte[] contents=new byte[0];

    private List<String> locks=new ArrayList<>();


    public VfsFileImpl(String name, VfsDirectory parent) {
       super(name, parent);
    }

    public synchronized void lock(String userName) {
        locks.add(userName);
    }

    public synchronized void unlock(String userName) {
        locks.remove(userName);
    }

    public synchronized byte[] getFileContents() {
        return  contents;
    }

    public synchronized void  writeFile(byte[] data) {
        contents=data;
    }

    @Override
    public synchronized boolean isLocked(String userName) {
        return userName==null ? !locks.isEmpty() : locks.contains(userName);
    }




}
