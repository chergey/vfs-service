package vfs;

/**
 * Created by Karl H on 26/06/2017.
 */
public enum VfsExceptionType {

    DIR_NOT_EXISS("Directory does %s does not exist"),
    FILE_NOT_EXISTS("Directory does %s does not exist"),
    COR_TO_DIR("Object %s corresponds to a directory!"),
    OBJ_NOT_EXISTS("Object %s does not exist!"),
    OBJECT_ALREADY_EXISTS("Object with the name %s already exists!"),
    FILE_LOCKED("File %s is locked and can't be deleted!"),
    DIR_CONTAINS_SUBDIRS("Directory %s contains subdirectories!"),
    DIR_CONTAINS_LOCKED_FILES("Directory %s contains locked files")
    ;


    private String text;

    VfsExceptionType(String text) {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text=text;
    }


}
