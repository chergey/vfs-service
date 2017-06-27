package vfs;

import java.util.Optional;

/**
 * Created by sech0617 on 23.06.2017.
 */
public interface VfsDirectory {

    /**
     * Creates file in current directory
     * @param name
     * @return
     * @throws VfsException
     */
    VfsFile createFile(String name) throws VfsException;

    /**
     * Creates directory in current directory
     * @param name
     * @return
     * @throws VfsException
     */
    VfsDirectory createSubDir(String name) throws VfsException;


    /**
     * Deletes file or directory with a given name
     *
     * @param entity entity to delete
     * @throws VfsException if can't delete file or directory
     */
    void deleteEntity(VfsEntity entity);


    /**
     * Checks if current dir contains entity
     *
     * @param name entity
     * @return
     */
    boolean contains(String name);

    Optional<VfsEntity> findFirst(String name);

    /**
     * Clears directory
     */
    void clean();

    /**
     * Throws exception if directory contains subdirectories
     */
    void checkSubDirs() ;

    /**
     * Throws exception if directory contains locked files
     */
    void checkLocks() ;
}
