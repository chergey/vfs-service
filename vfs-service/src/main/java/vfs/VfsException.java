package vfs;

/**
 * Created by sech0617 on 23.06.2017.
 */
public class VfsException extends RuntimeException {

    private VfsExceptionType type;

    public VfsException( VfsExceptionType type , Object... parameters) {

        super(String.format(type.getText(), parameters));
        this.type=type;


    }

    public VfsExceptionType getType()
    {
        return type;
    }
}
