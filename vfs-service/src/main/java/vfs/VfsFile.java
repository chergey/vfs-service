package vfs;

/**
 * Created by sech0617 on 23.06.2017.
 */
public interface VfsFile  {

    /**
     * Locks file
     * @param userName
     */
    void lock(String userName);

    /**
     * Unlocks file
     * @param userName
     */
    void unlock(String userName);

    /**
     * Returns file contents
     * @return
     */
    byte[] getFileContents();

    /**
     * Writes data to file
     * @param data
     */
    void writeFile(byte[] data);

    /**
     * Returns true if file is locked
     * @param userName
     * @return
     */
    boolean isLocked(String userName);



}
