package org.emroy.vfs.client;
/*
import org.emroy.VfsService;
import org.emroy.VfsStore;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.function.BiPredicate;




@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VfsClientTest {
    private static VfsService vfsClient;


    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(MavenImporter.class)
                .loadPomFromFile("../vfs-service/pom.xml")
                .importBuildOutput()
                .as(WebArchive.class);
    }

    @ArquillianResource
    static URL url;

    @BeforeAll
    public static void setUp() throws Exception
    {
        vfsClient=new VfsService(
                new URL(url,"VfsService?wsdl"),
                new QName("http://service.vfs.emroy.org/", "VfsService" ));



    }

    @Test
    public void testCreateDirectory()
    {
        VfsStore store=vfsClient.getVfsStoreImplPort();
        store.createDirectory("dir1");
    }

}

*/

