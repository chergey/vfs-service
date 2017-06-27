package vfs.impl;

import vfs.*;

import java.util.*;
import java.util.stream.Collectors;

public class VfsDirectoryImpl extends VfsEntity implements VfsDirectory {

    private List<VfsEntity> entities = new ArrayList<>();

    public VfsDirectoryImpl(String name, VfsDirectory parent) {
        super(name, parent);
    }


    @Override
    public VfsFile createFile(String name) {
        if (entities.stream().anyMatch(f -> f.getName().equals(name))) {
            throw new VfsException(VfsExceptionType.OBJECT_ALREADY_EXISTS, name);
        }
        VfsFile file = new VfsFileImpl(name, this);
        entities.add((VfsEntity) file);
        return file;
    }


    @Override
    public VfsDirectory createSubDir(String name) {

        if (entities.stream().anyMatch(f -> f.getName().equals(name))) {
            throw new VfsException(VfsExceptionType.OBJECT_ALREADY_EXISTS, name);
        }
        VfsDirectoryImpl dir = new VfsDirectoryImpl(name, this);
        entities.add(dir);

        return dir;
    }


    /**
     * Finds first directory in the paths
     *
     * @param name
     * @return
     */
    public Optional<VfsEntity> findFirst(String name) {
        return entities.stream().filter(f -> f.getName().equals(name)).findFirst();
    }


    public void deleteEntity(VfsEntity entity) {
        if (entity instanceof VfsDirectory) {
            ((VfsDirectory) entity).checkLocks();
            ((VfsDirectory) entity).checkSubDirs();
        } else {
            if (((VfsFileImpl) entity).isLocked(null)) {
                throw new VfsException(VfsExceptionType.FILE_LOCKED, entity.getName());
            }
        }

        entities.remove(entity);

    }



    @Override
    public void checkSubDirs() {
        Optional<VfsDirectory> dir = entities.stream().filter(f -> f instanceof VfsDirectory)
                .map(f -> (VfsDirectory) f).findFirst();
        if (dir.isPresent()) {
            throw new VfsException(VfsExceptionType.DIR_CONTAINS_SUBDIRS, getName());
        }

    }

    @Override
    public void checkLocks() {

        Optional<VfsFile> file = entities.stream().filter(f -> f instanceof VfsFile)
                .map(f -> (VfsFile) f).findFirst();

        if (file.isPresent()) {
            if (file.get().isLocked(null))
                throw new VfsException(VfsExceptionType.DIR_CONTAINS_LOCKED_FILES, getName());
        }

        entities.stream().filter(f -> f instanceof VfsDirectory)
                .map(f -> (VfsDirectory) f).forEach(VfsDirectory::checkLocks);


    }


    public boolean contains(String name) {
        return entities.stream().anyMatch(f -> f.getName().equals(name));
    }


    @Override
    public void clean() {
        entities.clear();

    }


}

