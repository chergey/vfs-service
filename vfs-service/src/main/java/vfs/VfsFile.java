package vfs;

/**
 * Created by sech0617 on 23.06.2017.
 */
public interface VfsFile  {

    void lock(String userName);

    void unlock(String userName);

    byte[] getFileContents();

    void writeFile(byte[] data);

    boolean isLocked(String userName);



}
