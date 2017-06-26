package vfs;

import vfs.impl.VfsDirectoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Karl H on 25/06/2017.
 */


public class VfsSystem {


    public static final String SEPARATOR = "/";

    public static final String ROOT_NAME = "/";


    private static VfsDirectoryImpl ROOT = new VfsDirectoryImpl(ROOT_NAME, null);

    /**
     * Locks file
     *
     * @param path
     */
    public void lockFile(String path, boolean value, String userName) throws VfsException {

        VfsEntity supposedFile = findEntity(path);
        if (supposedFile instanceof VfsDirectory) {
            throw new VfsException(VfsExceptionType.COR_TO_DIR, path);
        }
        if (value) {
            ((VfsFile) supposedFile).lock(userName);
        } else {
            ((VfsFile) supposedFile).unlock(userName);
        }


    }

    private VfsEntity findEntity(String path) throws VfsException {
        return findEntity(ROOT, path);
    }

    private VfsEntity findEntity(VfsDirectory dir, String path) throws VfsException {
        if (IsSupposedDir(path)) {
            VfsDirectory subDir = findSubDir(dir, path);
            return findEntity(subDir, retrieveSubPath(path));
        } else {

            Optional<VfsEntity> entity = dir.findFirst(path);
            if (!entity.isPresent()) {
                throw new VfsException(VfsExceptionType.OBJ_NOT_EXISTS, path);
            }

            return entity.get();
        }

    }


    /**
     * Creates subdir
     *
     * @param path
     * @throws VfsException
     */
    public VfsDirectory createSubDir(String path) throws VfsException {

        return createSubDir(ROOT, path);
    }

    private VfsDirectory createSubDir(VfsDirectory dir, String path) throws VfsException {
        if (IsSupposedDir(path)) {
            VfsDirectory subDir = findSubDir(dir, path);
            return createSubDir(subDir, retrieveSubPath(path));
        } else {

            return dir.createSubDir(path);
        }

    }

    /**
     * Creates file
     *
     * @param path
     * @return
     * @throws VfsException
     */

    public VfsFile createFile(String path) throws VfsException {
        return createFile(ROOT, path);
    }


    private VfsFile createFile(VfsDirectory dir, String path) throws VfsException {
        if (IsSupposedDir(path)) {
            VfsDirectory subDir = findSubDir(dir, path);
            return createFile(subDir, retrieveSubPath(path));
        } else {
            return dir.createFile(path);
        }
    }

    /**
     * Gets subdirectory
     *
     * @param dir
     * @param path
     * @return
     * @throws VfsException
     */

    public VfsDirectory findSubDir(VfsDirectory dir, String path) throws VfsException {

        String firstDir = retrieveFirstDir(path);
        Optional<VfsEntity> supposedDir = dir.findFirst(firstDir);
        if (!supposedDir.isPresent()) {
            throw new VfsException(VfsExceptionType.DIR_NOT_EXISS, firstDir);
        }
        return (VfsDirectoryImpl) supposedDir.get();

    }

    /**
     * Returns true if path can't be found
     *
     * @param path path to search
     * @return true if
     * @throws VfsException if path is invalid
     */
    public boolean contains(String path) throws VfsException {
        return contains(ROOT, path);
    }

    private boolean contains(VfsDirectory dir, String path) throws VfsException {
        if (IsSupposedDir(path)) {
            VfsDirectory subDir = findSubDir(dir, path);
            return contains(subDir, retrieveSubPath(path));
        } else {
            return dir.contains(path);
        }
    }

    public void delete(String path) throws VfsException {

        VfsEntity entity = findEntity(path);
        entity.parent.deleteEntity(entity);


    }


    public void clean() {
        ROOT.clean();
    }


    //region Helpers

    private static String retrieveSubPath(String path) {
        List<String> dirs = new ArrayList<>(Arrays.asList(path.split(SEPARATOR)));
        dirs.remove(0);
        return String.join(SEPARATOR, dirs);
    }

    private static String retrieveFirstDir(String path) {
        List<String> dirs = new ArrayList<>(Arrays.asList(path.split(SEPARATOR)));
        return dirs.get(0);
    }

    private static String retrieveLastPathPart(String path) {
        List<String> dirs = new ArrayList<>(Arrays.asList(path.split(SEPARATOR)));
        return dirs.get(dirs.size() - 1);
    }


    private static boolean IsSupposedDir(String newPath) {
        return newPath.contains(SEPARATOR);
    }


    //endregion
}
