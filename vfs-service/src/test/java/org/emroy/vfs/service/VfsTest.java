package org.emroy.vfs.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vfs.*;


public class VfsTest {

    private static VfsSystem vfs;

    @BeforeAll
    public static void setUp() {
        vfs = new VfsSystem();
    }

    @BeforeEach
    public void prepare() {
        vfs.clean();
    }

    @Test
    public void testCreateFile() throws VfsException {
        vfs.createFile("file1.txt");
        Assertions.assertTrue(vfs.contains("file1.txt"));

    }

    @Test
    public void testCreateDirectory() throws VfsException {
        vfs.createSubDir("dir1");
        Assertions.assertTrue(vfs.contains("dir1"));
    }

    @Test
    public void testCreateNestedDirectoriesAndFiles()  {
        VfsDirectory dir1 = vfs.createSubDir("dir1");
        dir1.createSubDir("dir2");

        vfs.createSubDir("dir1/dir2/dir3");
        vfs.createFile("dir1/dir2/dir3/file4.txt");
        vfs.createFile("dir1/dir2/dir3/file44.txt");

        Assertions.assertTrue(vfs.contains("dir1/dir2/dir3"));
        Assertions.assertTrue(vfs.contains("dir1/dir2/dir3/file4.txt"));
        Assertions.assertTrue(vfs.contains("dir1/dir2/dir3/file44.txt"));

    }


    @Test
    public void testLock()  {
        VfsDirectory dir = vfs.createSubDir("dir1");
        VfsFile file1 = dir.createFile("file1.txt");
        vfs.lockFile("dir1/file1.txt",true, "test");
        Assertions.assertTrue(file1.isLocked(null));


    }

    @Test
    public void testDelete()
    {
        VfsDirectory dir = vfs.createSubDir("dir1");
        VfsFile file1 = dir.createFile("file1.txt");
        vfs.lockFile("dir1/file1.txt",true, "test");
        vfs.createSubDir("dir1/dir2");
        ExceptionUtil.expectThrow(VfsException.class, ()-> vfs.delete("dir1/file1.txt"),
                "Locked file should not be deleted!", VfsExceptionType.FILE_LOCKED);

        ExceptionUtil.expectThrow(VfsException.class, ()-> vfs.delete("dir1"),
                "Directory with subdirectories should not be deleted!", VfsExceptionType.DIR_CONTAINS_LOCKED_FILES);



    }

    @Test
    public void testDeleteSubdirs()
    {
        VfsDirectory dir = vfs.createSubDir("dir1");
        vfs.createSubDir("dir1/dir2");

        ExceptionUtil.expectThrow(VfsException.class, ()-> vfs.delete("dir1"),
                "Directory with subdirectories should not be deleted!", VfsExceptionType.DIR_CONTAINS_SUBDIRS);



    }

    @Test
    public void testCopy() {


    }

    @Test
    public void testMove() {

    }

}
