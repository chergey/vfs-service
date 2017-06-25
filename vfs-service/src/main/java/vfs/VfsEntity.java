package vfs;

import java.util.Date;

/**
 * Created by sech0617 on 23.06.2017.
 */
public abstract class VfsEntity {


    private String name;

    VfsDirectory parent;

    protected VfsEntity(String name, VfsDirectory parent)
    {
        this.name=name;
        dateCreated = dateAccessed = dateModified=new Date();
        this.parent=parent;
    }
     /*
     * @return entity name
     */
    public  String getName()
    {
        return name;
    }

    public Date dateCreated;

    public Date dateModified;

    public Date dateAccessed;

}
